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
        List<Integer> actualContents = cashRegister.put(billsToAdd);
        List<Integer> expectedContents = Arrays.asList(39, 1, 1, 1, 1, 2);

        assertEquals(expectedContents, actualContents);
    }

    @Test
    public void cashRegisterShowsContents() throws Exception {
        CashRegister cashRegister = new CashRegister();
        List<Integer> billsToAdd = Arrays.asList(1, 1, 1, 1, 2);

        List<Integer> expectedContents = Arrays.asList(39, 1, 1, 1, 1, 2);
        List<Integer> actualContents = cashRegister.put(billsToAdd);

        assertEquals(expectedContents, actualContents);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOutOfBoundsException() {
        CashRegister cashRegister = new CashRegister();
        List<Integer> invalidNumberOfBillsToAdd = Arrays.asList(1);
        cashRegister.put(invalidNumberOfBillsToAdd);
    }
}