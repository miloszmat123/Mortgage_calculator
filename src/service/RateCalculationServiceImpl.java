package service;

import model.InputData;
import model.Rate;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class RateCalculationServiceImpl implements RateCalculationService {


    @Override
    public List<Rate> calculate(InputData inputData) {
        List<Rate> rates = new LinkedList<>();

        BigDecimal rateNumber = BigDecimal.ONE;

        Rate  firstRate = calculateFirstRate(rateNumber, inputData);

        rates.add(firstRate);

        Rate previousRate = firstRate;

        for(
                BigDecimal index = rateNumber.add(BigDecimal.ONE);
                index.compareTo(inputData.getMonthsDuration()) <= 0;
                 index = index.add(BigDecimal.ONE)
        ){
            Rate nextRate = calculateNextRate(index, inputData, previousRate);
            rates.add(nextRate);
            previousRate = nextRate;

        }
        return rates;
    }

    private Rate calculateFirstRate(BigDecimal rateNumber, InputData inputData) {
        return null;
    }

    private Rate calculateNextRate(BigDecimal index, InputData inputData, Rate previousRate) {
        return null;
    }
}
