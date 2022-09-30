package model;

import java.math.BigDecimal;

public class Summary {

    private final BigDecimal interestSummary;

    public Summary(BigDecimal interestSummary) {
        this.interestSummary = interestSummary;
    }


    public BigDecimal getInterestSummary() {
        return interestSummary;
    }
}
