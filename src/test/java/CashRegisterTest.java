import org.junit.Test;

import static org.junit.Assert.*;

public class CashRegisterTest {

    @Test
    public void cashRegisterContentsValueZero() throws Exception {

        CashRegister cashRegister = new CashRegister();
        assertEquals(0, cashRegister.getTotalRegisterValue());
    }

    @Test
    public void cashRegisterAddsDenominations() throws Exception {

        CashRegister cashRegister = new CashRegister();
        Denomination denominationToBeAdd = Denomination.ONE;
        cashRegister.add(denominationToBeAdd, 1);

        denominationToBeAdd = Denomination.FIVE;
        cashRegister.add(denominationToBeAdd, 2);

        assertEquals(11, cashRegister.getTotalRegisterValue());
    }
}