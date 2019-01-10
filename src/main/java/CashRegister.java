import java.util.HashMap;

public class CashRegister {

    private int totalRegisterValue = 0;

    private HashMap<Denomination, Integer> contents = new HashMap<Denomination, Integer>();

    public CashRegister() {
        contents.put(Denomination.ONE, 0);
        contents.put(Denomination.TWO, 0);
        contents.put(Denomination.FIVE, 0);
        contents.put(Denomination.TEN, 0);
        contents.put(Denomination.TWENTY, 0);
    }

    public int getTotalRegisterValue() {
        for (Denomination denomination : contents.keySet()) {
            totalRegisterValue += denomination.getIntValue() * contents.get(denomination);
        }
        return totalRegisterValue;
    }

    public void add(Denomination denominationToBeAdd, int amount) {
        Integer totalForDenomination = contents.get(denominationToBeAdd);
        contents.put(denominationToBeAdd, totalForDenomination + amount);
    }

    public HashMap<Denomination, Integer> getContents() {
        return contents;
    }
}
