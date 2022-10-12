package model;

import java.math.BigDecimal;

public class Summary {

    private final BigDecimal interestSummary;

    private final BigDecimal overpaymentProvisionSummary;

    private final BigDecimal monthsSaved;

    public Summary(BigDecimal interestSummary, BigDecimal overpaymentProvisionSummary, BigDecimal monthsSaved) {
        this.interestSummary = interestSummary;
        this.overpaymentProvisionSummary = overpaymentProvisionSummary;
        this.monthsSaved = monthsSaved;
    }

    public BigDecimal getInterestSummary() {
        return interestSummary;
    }

    public BigDecimal getOverpaymentProvisionSummary() {
        return overpaymentProvisionSummary;
    }

    public BigDecimal getMonthsSaved() {
        return monthsSaved;
    }
}
