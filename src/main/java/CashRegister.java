import java.util.*;

public class CashRegister {

    private int totalRegisterValue = 0;

    private LinkedHashMap<Denomination, Integer> contents = new LinkedHashMap<Denomination, Integer>();

    public CashRegister() {
        contents.put(Denomination.TWENTY, 0);
        contents.put(Denomination.TEN, 0);
        contents.put(Denomination.FIVE, 0);
        contents.put(Denomination.TWO, 0);
        contents.put(Denomination.ONE, 0);
    }

    public int getTotalRegisterValue() {
        for (Denomination denomination : contents.keySet()) {
            totalRegisterValue += denomination.getIntValue() * contents.get(denomination);
        }
        return totalRegisterValue;
    }

    public void add(List<Integer> denominationsToBeAdded) {
        if (denominationsToBeAdded.size() == 5) {
            contents.put(Denomination.TWENTY, contents.get(Denomination.TWENTY) + denominationsToBeAdded.get(0));
            contents.put(Denomination.TEN, contents.get(Denomination.TEN) + denominationsToBeAdded.get(1));
            contents.put(Denomination.FIVE, contents.get(Denomination.FIVE) + denominationsToBeAdded.get(2));
            contents.put(Denomination.TWO, contents.get(Denomination.TWO) + denominationsToBeAdded.get(3));
            contents.put(Denomination.ONE, contents.get(Denomination.ONE) + denominationsToBeAdded.get(4));
        } else {
            throw new IllegalArgumentException("List of denominations needs to be a list of 5 elements");
        }
    }
}
