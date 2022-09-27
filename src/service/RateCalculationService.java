package service;

import model.InputData;
import model.Rate;

import java.util.List;

public interface RateCalculationService {

    List<Rate> calculate(final InputData inputData);
}
