
public enum Denomination {

    TWENTY("20", 0),
    TEN("10", 1),
    FIVE("5", 2),
    TWO("2", 3),
    ONE("1", 4);

    private Integer intValue;
    private Integer index;

    Denomination(String s, int i) {
        intValue = Integer.valueOf(s);
        index = i;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Integer getIndex() {
        return index;
    }
}
