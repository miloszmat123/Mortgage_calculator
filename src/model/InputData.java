package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InputData {
    private LocalDate repaymnetSstartDate = LocalDate.of(2022, 9, 6);

    private BigDecimal wiborPrecent = new BigDecimal("1.73");

    private BigDecimal amount = new BigDecimal("300000");

    private BigDecimal monthsDuration = new BigDecimal("180");

    private RateType rateType = RateType.CONSTANT;

    private BigDecimal bankMargin = new BigDecimal("1.9");


    public LocalDate getRepaymnetSstartDate() {
        return repaymnetSstartDate;
    }

    public BigDecimal getWiborPrecent() {
        return wiborPrecent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getMonthsDuration() {
        return monthsDuration;
    }

    public RateType getRateType() {
        return rateType;
    }

    public BigDecimal getBankMargin() {
        return bankMargin;
    }
}
