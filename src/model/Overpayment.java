package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Overpayment {

    private final BigDecimal amount;

    private final BigDecimal provision;

    public Overpayment(BigDecimal amount, BigDecimal provision) {
        this.amount = amount;
        this.provision = provision;
    }

    public BigDecimal getAmount() {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getProvision() {
        return provision.setScale(2, RoundingMode.HALF_UP);
    }
}
