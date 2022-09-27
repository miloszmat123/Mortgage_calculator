package model;

import java.math.BigDecimal;

public class MortageResidual {

    private final BigDecimal amount;

    private final BigDecimal duration;

    public MortageResidual(BigDecimal amount, BigDecimal duration) {
        this.amount = amount;
        this.duration = duration;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getDuration() {
        return duration;
    }
}
