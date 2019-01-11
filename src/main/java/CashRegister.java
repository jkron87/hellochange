import java.util.*;

public class CashRegister {

    private LinkedHashMap<Denomination, Integer> contents = new LinkedHashMap<Denomination, Integer>();

    public CashRegister() {
        contents.put(Denomination.TWENTY, 0);
        contents.put(Denomination.TEN, 0);
        contents.put(Denomination.FIVE, 0);
        contents.put(Denomination.TWO, 0);
        contents.put(Denomination.ONE, 0);
    }

    public int getTotalRegisterValue() {
        int totalRegisterValue = 0;
        for (Denomination denomination : contents.keySet()) {
            totalRegisterValue += denomination.getIntValue() * contents.get(denomination);
        }
        return totalRegisterValue;
    }

    public List<Integer> put(List<Integer> denominationsToBeAdded) {
        if (denominationsToBeAdded.size() == 5) {
            contents.forEach((key, value) -> {
                contents.put(key, contents.get(key) + denominationsToBeAdded.get(key.getIndex()));
            });
        } else {
            throw new IllegalArgumentException("List of denominations must contain 5 elements");
        }

        List<Integer> registerContents = this.show();
        return registerContents;
    }

    public List<Integer> show() {
        ArrayList<Integer> allContents = new ArrayList<>();
        allContents.add(getTotalRegisterValue());
        contents.forEach((key, value) -> {
            allContents.add(value);
        });
        return allContents;
    }

    public List<Integer> take(List<Integer> billsToSubtract) {
        if (billsToSubtract.size() == 5) {
            contents.forEach((key, value) -> {
                contents.put(key, contents.get(key) - billsToSubtract.get(key.getIndex()));
            });
        } else {
            throw new IllegalArgumentException("List of denominations must contain 5 elements");
        }

        List<Integer> registerContents = this.show();
        return registerContents;
    }

    public List<Integer> change(int changeAmount) {
        List<Integer> denominationsToSubtract = new ArrayList<>();
        int changeLeft = changeAmount;
        for (Denomination denomination : contents.keySet()) {
            if (contents.get(denomination) > 0 && changeLeft > 0) {

                int billsNeeded = changeLeft / denomination.getIntValue();
                int billsAvailable = contents.get(denomination);

                if (billsAvailable < billsNeeded) {
                    billsNeeded = billsAvailable;
                }
                changeLeft -= billsNeeded * denomination.getIntValue();
                denominationsToSubtract.add(billsNeeded);

            } else {
                denominationsToSubtract.add(0);
            }
        }

        return this.take(denominationsToSubtract);
    }
}
