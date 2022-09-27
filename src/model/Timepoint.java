package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Timepoint {

    final private LocalDate date;

    final private BigDecimal year;

    final private BigDecimal month;

    public Timepoint(LocalDate date, BigDecimal year, BigDecimal month) {
        this.date = date;
        this.year = year;
        this.month = month;
    }


    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getYear() {
        return year;
    }

    public BigDecimal getMonth() {
        return month;
    }
}
