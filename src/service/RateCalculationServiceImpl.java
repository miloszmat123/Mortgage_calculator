package service;

import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class RateCalculationServiceImpl implements RateCalculationService {


    private final TimepointService timepointService;

    private final AmountsCalculationService amountsCalculationService;

    private final ResidualCalculationService residualCalculationService;

    private final OverPaymentCalculationService overPaymentCalculationService;

    private final ReferenceCalculationService referenceCalculationService;

    public RateCalculationServiceImpl(
            TimepointService timepointService,
            AmountsCalculationService amountsCalculationService,
            ResidualCalculationService residualCalculationService,
            OverPaymentCalculationService overPaymentCalculationService,
            ReferenceCalculationService referenceCalculationService
    ) {
        this.timepointService = timepointService;
        this.amountsCalculationService = amountsCalculationService;
        this.residualCalculationService = residualCalculationService;
        this.overPaymentCalculationService = overPaymentCalculationService;
        this.referenceCalculationService = referenceCalculationService;
    }

    @Override
    public List<Rate> calculate(InputData inputData) {
        List<Rate> rates = new LinkedList<>();

        BigDecimal rateNumber = BigDecimal.ONE;

        Rate  firstRate = calculateRate(rateNumber, inputData);

        rates.add(firstRate);

        Rate previousRate = firstRate;

        for(
                BigDecimal index = rateNumber.add(BigDecimal.ONE);
                index.compareTo(inputData.getMonthsDuration()) <= 0;
                 index = index.add(BigDecimal.ONE)
        ){
            Rate nextRate = calculateRate(index, inputData, previousRate);
            rates.add(nextRate);
            previousRate = nextRate;
            if (BigDecimal.ZERO.equals(nextRate.getMortageResidual().getAmount().setScale(0, RoundingMode.HALF_UP))){
                break;
            }

        }
        return rates;
    }

    private Rate calculateRate(BigDecimal rateNumber, InputData inputData) {

        Timepoint timepoint = timepointService.calculate(rateNumber, inputData);
        Overpayment overpayment = overPaymentCalculationService.calculate(rateNumber, inputData);
        RateAmounts rateAmounts = amountsCalculationService.calculate(inputData, overpayment);
        MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, inputData);
        MortgageReference mortgageReference = referenceCalculationService.calculate(inputData);

        return new Rate(rateNumber, timepoint, rateAmounts, mortgageResidual, mortgageReference);
    }

    private Rate calculateRate(BigDecimal rateNumber, InputData inputData, Rate previousRate) {
        Timepoint timepoint = timepointService.calculate(rateNumber, inputData);
        Overpayment overpayment = overPaymentCalculationService.calculate(rateNumber,  inputData);
        RateAmounts rateAmounts = amountsCalculationService.calculate(inputData, overpayment, previousRate);
        MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, previousRate);
        MortgageReference mortgageReference = referenceCalculationService.calculate(inputData);

        return new Rate(rateNumber, timepoint, rateAmounts, mortgageResidual, mortgageReference);
    }
}
