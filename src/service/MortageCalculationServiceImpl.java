package service;

import model.InputData;

public class MortageCalculationServiceImpl implements  MortageCalculationService{

    private final PrintingService printingService;

    public MortageCalculationServiceImpl(PrintingService printingService) {
        this.printingService = printingService;
    }


    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDataInfo(inputData);
    }
}
