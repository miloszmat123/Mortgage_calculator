package service;

import model.InputData;
import model.Timepoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimepointServiceImpl implements TimepointService {

    private static final BigDecimal YEAR = BigDecimal.valueOf(12);

    @Override
    public Timepoint calculate(BigDecimal rateNumber, InputData inputData) {
        LocalDate date = calculateDate(rateNumber, inputData);

        BigDecimal year = calculateYear(rateNumber);
        BigDecimal month = calculateMonth(rateNumber);

        return new Timepoint(date,year, month);
    }

    private LocalDate calculateDate(BigDecimal rateNumber, InputData inputData) {
        return inputData.getRepaymentStartDate().plus(rateNumber.subtract(BigDecimal.ONE).intValue(), ChronoUnit.MONTHS);
    }


    public BigDecimal calculateYear(final BigDecimal rateNumber){
        return rateNumber.divide(YEAR, RoundingMode.UP).max(BigDecimal.ONE);
    }

    public BigDecimal calculateMonth(final BigDecimal rateNumber){
        return BigDecimal.ZERO.equals(rateNumber.remainder(YEAR)) ? YEAR : rateNumber.remainder(YEAR);
    }
}
