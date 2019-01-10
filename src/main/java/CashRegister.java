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
            contents.forEach((key, value) -> {
                contents.put(key, contents.get(key) + denominationsToBeAdded.get(key.getIndex()));
            });
        } else {
            throw new IllegalArgumentException("List of denominations needs to be a list of 5 elements");
        }
    }

    public List<Integer> show() {
        ArrayList<Integer> allContents = new ArrayList<>();
        allContents.add(getTotalRegisterValue());
        contents.forEach((key, value) -> {
            allContents.add(value);
        });
        return allContents;
    }
}
