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

        billsToAdd = Arrays.asList(0, 0, 0, 0, 1);
        expectedContents = Arrays.asList(40, 1, 1, 1, 1, 3);
        actualContents = cashRegister.put(billsToAdd);

        assertEquals(expectedContents, actualContents);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOutOfBoundsException() {
        CashRegister cashRegister = new CashRegister();
        List<Integer> invalidNumberOfBillsToAdd = Arrays.asList(1);
        cashRegister.put(invalidNumberOfBillsToAdd);
    }

    @Test
    public void cashRegisterSubtractsDenominations() throws Exception {
        CashRegister cashRegister = new CashRegister();
        List<Integer> billsToAdd = Arrays.asList(3, 0, 0, 0, 0);
        cashRegister.put(billsToAdd);

        List<Integer> billsToSubtract = Arrays.asList(1, 0, 0, 0, 0);

        List<Integer> expectedContents = Arrays.asList(40, 2, 0, 0, 0, 0);
        List<Integer> actualContents = cashRegister.take(billsToSubtract);


        assertEquals(expectedContents, actualContents);
    }

    @Test
    public void cashRegisterMakesChange() throws Exception {
        CashRegister cashRegister = new CashRegister();
        List<Integer> billsToAdd = Arrays.asList(0, 0, 2, 0, 3);
        cashRegister.put(billsToAdd);

        List<Integer> expectedChangeDenominationsToSubtract = Arrays.asList(0, 0, 1, 0, 3);
        List<Integer> actualChangeDenominationsToSubtract = cashRegister.change(8);

        assertEquals(expectedChangeDenominationsToSubtract, actualChangeDenominationsToSubtract);

        List<Integer> expectedRegisterContents = Arrays.asList(5, 0, 0, 1, 0, 0);
        List<Integer> actualRegisterContents = cashRegister.show();

        assertEquals(expectedRegisterContents, actualRegisterContents);
    }

    @Test(expected = RuntimeException.class)
    public void cashRegisterThrowsExceptionWhenUnableToMakeChange() throws Exception {
        CashRegister cashRegister = new CashRegister();
        List<Integer> billsToAdd = Arrays.asList(0, 1, 0, 0, 3);
        cashRegister.put(billsToAdd);

        cashRegister.change(8);
    }

}