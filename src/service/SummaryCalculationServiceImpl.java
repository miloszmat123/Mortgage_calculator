package service;

import model.Rate;
import model.Summary;

import java.math.BigDecimal;
import java.util.List;

public class SummaryCalculationServiceImpl implements SummaryCalculationService{

    @Override
    public Summary calculate(List<Rate> rates) {

        BigDecimal interestSummary = BigDecimal.ZERO;

        for (Rate rate : rates) {
            interestSummary = interestSummary.add(rate.getRateAmounts().getInterestAmount());
        }

        return new Summary(interestSummary);
    }
}
