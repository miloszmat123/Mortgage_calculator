package model;

import java.math.BigDecimal;

public class Rate {

    private final BigDecimal rateNumber;

    private final Timepoint timepoint;

    private final RateAmounts rateAmounts;

    private final MortgageResidual mortgageResidual;

    private final MortgageReference mortgageReference;

    public Rate(
            BigDecimal rateNumber,
            Timepoint timepoint,
            RateAmounts rateAmounts,
            MortgageResidual mortgageResidual,
            MortgageReference mortgageReference) {
        this.rateNumber = rateNumber;
        this.timepoint = timepoint;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
        this.mortgageReference = mortgageReference;
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



}
