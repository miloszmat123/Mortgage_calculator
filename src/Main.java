import model.InputData;
import service.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withBankMarginPercent(new BigDecimal("1.6"))
                .withAmount(new BigDecimal("300000"))
                .withMonthsDuration(new BigDecimal("140"));

        PrintingService printingService = new PrintingServiceimpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimepointServiceImpl(),
                new AmountsCalculationServiceImpl(),
                new ResidualCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );
        mortgageCalculationService.calculate(inputData);
    }
}
