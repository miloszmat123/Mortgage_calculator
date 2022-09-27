import model.InputData;
import service.MortageCalculationService;
import service.MortageCalculationServiceImpl;
import service.PrintingService;
import service.PrintingServiceimpl;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withBankMarginPercent(new BigDecimal("1.6"))
                .withAmount(new BigDecimal("300000"))
                .withMonthsDuration(new BigDecimal("140"));

        PrintingService printingService = new PrintingServiceimpl();
        MortageCalculationService mortageCalculationService = new MortageCalculationServiceImpl(printingService);
        mortageCalculationService.calculate(inputData);
    }
}
