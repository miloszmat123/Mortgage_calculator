package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

public class InputData {

    private static final BigDecimal PERCENT = BigDecimal.valueOf(100);

    private LocalDate repaymentStartDate = LocalDate.of(2022, 9, 6);

    private BigDecimal wiborPercent = new BigDecimal("1.73");

    private BigDecimal amount = new BigDecimal("300000");

    private BigDecimal monthsDuration = new BigDecimal("180");

    private RateType rateType = RateType.CONSTANT;

    private BigDecimal bankMarginPercent = new BigDecimal("1.9");

    private Map<Integer, BigDecimal> overpaymentSchema = Map.of(
            5, BigDecimal.valueOf(10000),
            6, BigDecimal.valueOf(10000),
            7, BigDecimal.valueOf(10000),
            8, BigDecimal.valueOf(10000)
    );

    private ReduceWay reduceWay = ReduceWay.REDUCE_RATE;

    private BigDecimal  overpaymentProvisionPercent = BigDecimal.valueOf(3);
    private BigDecimal  overpaymentProvisionMonths = BigDecimal.valueOf(36);

    public InputData withRepaymentStartDate(LocalDate repaymentStartDate){
        this.repaymentStartDate = repaymentStartDate;
        return this;
    }

    public InputData withWiborPercent(BigDecimal wiborPercent){
        this.wiborPercent = wiborPercent;
        return this;
    }
    public InputData withAmount(BigDecimal amount){
        this.amount = amount;
        return this;
    }
    public InputData withMonthsDuration(BigDecimal monthsDuration){
        this.monthsDuration = monthsDuration;
        return this;
    }
    public InputData withRateType(RateType rateType){
        this.rateType = rateType;
        return this;
    }
    public InputData withBankMarginPercent(BigDecimal bankMarginPercent){
        this.bankMarginPercent = bankMarginPercent;
        return this;
    }

    public InputData withReduceWay( ReduceWay reduceWay){
        this.reduceWay = reduceWay;
        return this;
    }
    public InputData withOverpaymentProvisionPercent( BigDecimal overpaymentProvisionPercent){
        this.overpaymentProvisionPercent = overpaymentProvisionPercent;
        return this;
    }
    public InputData withOverpaymentProvisionMonths( BigDecimal overpaymentProvisionMonths){
        this.overpaymentProvisionMonths = overpaymentProvisionMonths;
        return this;
    }

    public InputData withOverpaymentSchema(Map<Integer, BigDecimal> overpaymentSchema){
        this.overpaymentSchema = overpaymentSchema;
        return this;
    }

    public LocalDate getRepaymentStartDate() {
        return repaymentStartDate;
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

    public BigDecimal getInterestPercent(){
        return wiborPercent.add(bankMarginPercent).divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal getInterestDisplay(){
        return wiborPercent.add(bankMarginPercent).setScale(2, RoundingMode.HALF_UP);
    }

    public Map<Integer, BigDecimal> getOverpaymentSchema() {
        return overpaymentSchema;
    }

    public ReduceWay getReduceWay() {
        return reduceWay;
    }

    public BigDecimal getOverpaymentProvisionPercent() {
        return overpaymentProvisionPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal getOverpaymentProvisionMonths() {
        return overpaymentProvisionMonths;
    }
}
