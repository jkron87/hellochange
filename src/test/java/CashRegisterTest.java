import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> billsToAdd = Arrays.asList(1, 1, 1, 1, 2);
        cashRegister.add(billsToAdd);

        assertEquals(39, cashRegister.getTotalRegisterValue());
    }
}