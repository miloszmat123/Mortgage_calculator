package service;

import model.InputData;
import model.Rate;
import model.Summary;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class PrintingServiceImpl implements PrintingService{


    @Override
    public void printInputDataInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getMonthsDuration()).append(MONTHS);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);
        msg.append(NEW_LINE);


        printMessage(msg);
    }

    public void printMessage(StringBuilder sb){
        System.out.println(sb);
    }


    @Override
    public void printRates(List<Rate> rates) {
        String format = "%4s %3s " +
                "%4s %3s  " +
                "%3s %2s  " +
                "%4s %2s  " +
                "%4s %6s  " +
                "%7s %6s  " +
                "%7s %7s  " +
                "%7s %10s  " +
                "%7s %3s  ";
        for (Rate rate : rates) {
            String msg = String.format(format,
                    RATE_NUMBER,   rate.getRateNumber(),
                    DATE, rate.getTimepoint().getDate(),
                    YEAR, rate.getTimepoint().getYear(),
                    MONTH, rate.getTimepoint().getMonth(),
                    RATE, rate.getRateAmounts().getRateAmount(),
                    INTEREST, rate.getRateAmounts().getInterestAmount(),
                    CAPITAL, rate.getRateAmounts().getCapitalAmount(),
                    LEFT_AMOUNT, rate.getMortageResidual().getAmount(),
                    LEFT_MONTHS, rate.getMortageResidual().getDuration()
            );
            printMessage(new StringBuilder(msg));
            if(rate.getRateNumber().remainder(BigDecimal.valueOf(12)).equals(BigDecimal.ZERO) ){
                System.out.println();
            }
        }
    }

    @Override
    public void printSummary(Summary summary) {
        StringBuilder msg = new StringBuilder(NEW_LINE);

        msg.append(INTEREST_SUM).append(summary.getInterestSummary()).append(NEW_LINE);
        msg.append(PROVISION_SUM).append(summary.getOverpaymentProvisionSummary());
        msg.append(NEW_LINE);
        msg.append(MONTHS_SAVED).append(summary.getMonthsSaved());

        printMessage(msg);

        System.out.println();
    }
}
