package model;

import java.math.BigDecimal;

public class Summary {

    private final BigDecimal interestSummary;

    private final BigDecimal overpaymentProvisionSummary;

    public Summary(BigDecimal interestSummary, BigDecimal overpaymentProvisionSummary) {
        this.interestSummary = interestSummary;
        this.overpaymentProvisionSummary = overpaymentProvisionSummary;
    }

    public BigDecimal getInterestSummary() {
        return interestSummary;
    }

    public BigDecimal getOverpaymentProvisionSummary() {
        return overpaymentProvisionSummary;
    }
}
