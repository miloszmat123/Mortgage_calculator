package service;

import model.InputData;
import model.MortgageResidual;
import model.Rate;
import model.RateAmounts;

import java.math.BigDecimal;

public class ResidualCalculationServiceImpl implements ResidualCalculationService {
    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData) {

        BigDecimal residualAmount = inputData.getAmount().subtract(rateAmounts.getCapitalAmount());
        BigDecimal residualDuration = inputData.getMonthsDuration().subtract(BigDecimal.ONE);

        return  new MortgageResidual(residualAmount, residualDuration);
    }

    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate) {
        BigDecimal residualAmount = previousRate.getMortageResidual().getAmount().subtract(rateAmounts.getCapitalAmount());
        BigDecimal residualDuration = previousRate.getMortageResidual().getDuration().subtract(BigDecimal.ONE);

        return  new MortgageResidual(residualAmount, residualDuration);
    }
}
