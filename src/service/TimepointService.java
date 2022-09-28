package service;

import model.InputData;
import model.Timepoint;

import java.math.BigDecimal;

public interface TimepointService {

    Timepoint calculate(BigDecimal rateNumber, InputData inputData);
}
