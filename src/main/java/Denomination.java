
public enum Denomination {

    TWENTY("20"),
    TEN("10"),
    FIVE("5"),
    TWO("2"),
    ONE("1");

    private Integer intValue;

    Denomination(String s) {
        intValue = Integer.valueOf(s);
    }

    public Integer getIntValue() {
        return intValue;
    }
}
