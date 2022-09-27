import model.InputData;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test commit");
        InputData inputData = new InputData()
                .withBankMargin(new BigDecimal("1.6"))
                .withAmount(new BigDecimal("300000"));
    }
}
