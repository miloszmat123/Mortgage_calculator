package model;

import java.math.BigDecimal;

public class Rate {

    private final Timepoint timepoint;

    private final BigDecimal rateNumber;


    private final RateAmounts rateAmounts;

    private final MortageResidual mortageResidual;

    public Rate(BigDecimal rateNumber, Timepoint timepoint, RateAmounts rateAmounts, MortageResidual mortageResidual) {
        this.timepoint = timepoint;
        this.rateNumber = rateNumber;
        this.rateAmounts = rateAmounts;
        this.mortageResidual = mortageResidual;
    }

    public Timepoint getTimepoint() {
        return timepoint;
    }

    public BigDecimal getRateNumber() {
        return rateNumber;
    }

    public RateAmounts getRateAmounts() {
        return rateAmounts;
    }

    public MortageResidual getMortageResidual() {
        return mortageResidual;
    }
}
