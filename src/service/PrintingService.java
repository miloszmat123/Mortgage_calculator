package service;

import model.InputData;
import model.Rate;
import model.Summary;

import java.util.List;

public interface PrintingService {

    String INTEREST_SUM = "SUMA ODSETEK: ";
    String PROVISION_SUM = "SUMA PROWIZJI: ";
    String RATE_NUMBER = "NR: ";
    String YEAR = "ROK: ";
    String MONTH = "MIESIAC: ";
    String DATE = "DATA: ";
    String MONTHS = " MIESIECY ";
    String RATE = "RATA: ";
    String INTEREST = "ODSETKI: ";
    String CAPITAL = "KAPITAL: ";
    String LEFT_AMOUNT = "POZOSTALA KWOTA:";
    String LEFT_MONTHS = "POZOSTALO MIESIECY:";
    String MORTGAGE_AMOUNT = "KWOTA KREDYTU: ";
    String MORTGAGE_PERIOD = "OKRES KREDYTOWANIA: ";

    String CURRENCY = " ZL ";
    String NEW_LINE = "\n";
    String PERCENT = "% ";

    void printInputDataInfo (final InputData inputData);

    void printRates(List<Rate> rates);

    void  printSummary(Summary summary);
}
