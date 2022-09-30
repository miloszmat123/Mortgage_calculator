package service;

import model.InputData;
import model.Rate;

import java.util.List;

public class MortgageCalculationServiceImpl implements MortgageCalculationService {

    private final PrintingService printingService;

    private final RateCalculationService rateCalculationService;

    private final SummaryCalculationService summaryCalculationService;

    public MortgageCalculationServiceImpl(
            PrintingService printingService,
            RateCalculationService rateCalculationService,
            SummaryCalculationService summaryCalculationService) {
        this.printingService = printingService;
        this.rateCalculationService = rateCalculationService;
        this.summaryCalculationService = summaryCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDataInfo(inputData);

        List<Rate> rateList = rateCalculationService.calculate(inputData);
        printingService.printRates(rateList);
        printingService.printSummary(summaryCalculationService.calculate(rateList));
    }
}
