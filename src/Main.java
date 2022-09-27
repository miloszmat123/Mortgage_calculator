import model.InputData;
import model.Rate;
import service.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withBankMarginPercent(new BigDecimal("1.6"))
                .withAmount(new BigDecimal("300000"))
                .withMonthsDuration(new BigDecimal("140"));

        PrintingService printingService = new PrintingServiceimpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl();

        MortageCalculationService mortageCalculationService = new MortageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );
        mortageCalculationService.calculate(inputData);
    }
}
