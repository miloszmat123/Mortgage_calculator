package model;

import java.math.BigDecimal;

public class Rate {

    private final Timepoint timepoint;

    private final BigDecimal rateNumber;


    private final RateAmounts rateAmounts;

    private final MortgageResidual mortgageResidual;

    public Rate(BigDecimal rateNumber, Timepoint timepoint, RateAmounts rateAmounts, MortgageResidual mortgageResidual) {
        this.timepoint = timepoint;
        this.rateNumber = rateNumber;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
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

    public MortgageResidual getMortageResidual() {
        return mortgageResidual;
    }


    @Override
    public String toString() {
        return "Rate{" +
                "rateAmounts=" + rateAmounts +
                ", mortgageResidual=" + mortgageResidual +
                '}';
    }
}
