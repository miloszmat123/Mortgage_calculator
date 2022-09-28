package service;

import model.InputData;
import model.Rate;
import model.RateAmounts;

public interface AmountsCalculationService {

    RateAmounts calculate(InputData inputData);

    RateAmounts calculate(InputData inputData, Rate previousRate);
}
