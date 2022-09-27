package service;

import model.InputData;
import model.Rate;

import java.util.List;

public class MortageCalculationServiceImpl implements  MortageCalculationService{

    private final PrintingService printingService;

    private final RateCalculationService rateCalculationService;

    public MortageCalculationServiceImpl(
            PrintingService printingService,
            RateCalculationService rateCalculationService
    ) {
        this.printingService = printingService;
        this.rateCalculationService = rateCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDataInfo(inputData);

        List<Rate> calculate = rateCalculationService.calculate(inputData);
    }
}
