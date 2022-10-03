package service;

import model.InputData;
import model.Overpayment;

import java.math.BigDecimal;

public interface OverPaymentCalculationService {


    Overpayment calculate(BigDecimal rateNUmber, InputData inputData);

}
