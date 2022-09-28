package service;

import model.InputData;
import model.Rate;
import model.RateAmounts;

public class AmountsCalculationServiceImpl implements AmountsCalculationService {
    @Override
    public RateAmounts calculate(InputData inputData) {
        return switch (inputData.getRateType()) {
            case CONSTANT -> calculateConstantRate(inputData);
            case DECREASING -> calculateDecreasingRate(inputData);
            default -> throw new RuntimeException("Case not handled");
        };
    }

    @Override
    public RateAmounts calculate(InputData inputData, Rate previousRate) {
        return switch (inputData.getRateType()) {
            case CONSTANT -> calculateConstantRate(inputData, previousRate);
            case DECREASING -> calculateDecreasingRate(inputData, previousRate);
            default -> throw new RuntimeException("Case not handled");
        };
    }

    private RateAmounts calculateConstantRate(InputData inputData) {
        return null;
    }

    private RateAmounts calculateConstantRate(InputData inputData, Rate previousRate) {
        return null;
    }

    private RateAmounts calculateDecreasingRate(InputData inputData) {
        return null;
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Rate previousRate) {
        return null;
    }
}
