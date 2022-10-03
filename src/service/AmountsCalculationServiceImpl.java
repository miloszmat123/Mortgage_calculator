package service;

import model.InputData;
import model.Overpayment;
import model.Rate;
import model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountsCalculationServiceImpl implements AmountsCalculationService {


    private static final BigDecimal YEAR = new BigDecimal("12");


    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment) {
        return switch (inputData.getRateType()) {
            case CONSTANT -> calculateConstantRate(inputData, overpayment);
            case DECREASING -> calculateDecreasingRate(inputData, overpayment);
        };
    }

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment,Rate previousRate) {
        return switch (inputData.getRateType()) {
            case CONSTANT -> calculateConstantRate(inputData, overpayment, previousRate);
            case DECREASING -> calculateDecreasingRate(inputData, overpayment, previousRate);
        };
    }

    private RateAmounts calculateConstantRate(InputData inputData, Overpayment overpayment) {

        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal q = calculateQ(interestPercent);
        BigDecimal monthsDuration = inputData.getMonthsDuration();

        BigDecimal rateAmount = calculateConstantRateAmount(q, residualAmount, monthsDuration);
        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount, interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private RateAmounts calculateConstantRate(InputData inputData, Overpayment overpayment, Rate previousRate) {

        BigDecimal residualAmount = previousRate.getMortageResidual().getAmount();
        BigDecimal mortgageAmount = inputData.getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal q = calculateQ(interestPercent);
        BigDecimal monthsDuration = inputData.getMonthsDuration();

        BigDecimal rateAmount = calculateConstantRateAmount(q, mortgageAmount, monthsDuration);
        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount, interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Overpayment overpayment) {

        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal monthsDuration = inputData.getMonthsDuration();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDecreasingCapitalAmount(residualAmount, monthsDuration);
        BigDecimal rateAmount = calculateDecreasingRateAmount(interestAmount, capitalAmount);


        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Overpayment overpayment, Rate previousRate) {

        BigDecimal mortgageAmount = inputData.getAmount();
        BigDecimal residualAmount = previousRate.getMortageResidual().getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal monthsDuration = inputData.getMonthsDuration();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDecreasingCapitalAmount(mortgageAmount, monthsDuration);
        BigDecimal rateAmount = calculateDecreasingRateAmount(interestAmount, capitalAmount);


        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private BigDecimal calculateInterestAmount(BigDecimal amount, BigDecimal interestPercent) {
        return amount.multiply(interestPercent).divide(YEAR, 50, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateConstantCapitalAmount(BigDecimal rateAmount, BigDecimal interestAmount) {
        return rateAmount.subtract(interestAmount);
    }

    private BigDecimal calculateConstantRateAmount(BigDecimal q, BigDecimal mortgageAmount, BigDecimal monthDuration) {
        return mortgageAmount
                .multiply(q.pow(monthDuration.intValue()))
                .multiply(q.subtract(BigDecimal.ONE))
                .divide(q.pow(monthDuration.intValue()).subtract(BigDecimal.ONE), 50, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateQ (BigDecimal interestPercent){
        return interestPercent.divide(YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    private BigDecimal calculateDecreasingCapitalAmount(BigDecimal residualAmount, BigDecimal monthsDuration) {
        return residualAmount.divide(monthsDuration, 50, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDecreasingRateAmount(BigDecimal interestAmount, BigDecimal capitalAmount) {
        return interestAmount.add(capitalAmount);
    }
}
