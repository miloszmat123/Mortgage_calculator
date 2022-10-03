package service;

import model.InputData;
import model.Overpayment;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class OverPaymentCalculationServiceImpl implements OverPaymentCalculationService{

    @Override
    public Overpayment calculate(BigDecimal rateNumber, InputData inputData) {

        BigDecimal overPaymentAmount = calculateAmount(rateNumber, inputData.getOverpaymentSchema())
                .orElse(BigDecimal.ZERO);
        BigDecimal overPaymentProvision = calculateProvision(rateNumber, overPaymentAmount, inputData);


        return new Overpayment(overPaymentAmount, overPaymentProvision);
    }

    private Optional<BigDecimal> calculateAmount(BigDecimal rateNumber, Map<Integer, BigDecimal> overpaymentSchema) {
        for (Map.Entry<Integer, BigDecimal> entry : overpaymentSchema.entrySet()) {
            if(rateNumber.equals(BigDecimal.valueOf(entry.getKey()))){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }


    private BigDecimal calculateProvision(BigDecimal rateNumber, BigDecimal overPaymentAmount, InputData inputData) {
        if(BigDecimal.ZERO.equals(overPaymentAmount)){
            return BigDecimal.ZERO;
        }
        else if (rateNumber.compareTo(inputData.getOverpaymentProvisionMonths()) > 0){
            return BigDecimal.ZERO;
        }
        else{
            return overPaymentAmount.multiply(inputData.getOverpaymentProvisionPercent());
        }
    }
}
