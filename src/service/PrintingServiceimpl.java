package service;

import model.InputData;

import javax.swing.*;

public class PrintingServiceimpl implements PrintingService{


    @Override
    public void printInputDataInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getMonthsDuration()).append(MONTHS);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);

        printMessage(msg);
    }

    public void printMessage(StringBuilder sb){
        System.out.println(sb);
    }
}
