import model.InputData;
import model.RateType;
import service.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal("298000"))
                .withMonthsDuration(new BigDecimal("400"))
                .withRateType(RateType.CONSTANT);


        PrintingService printingService = new PrintingServiceimpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimepointServiceImpl(),
                new AmountsCalculationServiceImpl(),
                new ResidualCalculationServiceImpl()
        );
        SummaryCalculationService summaryCalculationService = new SummaryCalculationServiceImpl();

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService,
                summaryCalculationService
        );
        mortgageCalculationService.calculate(inputData);
    }
}
