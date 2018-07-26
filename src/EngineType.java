public enum EngineType {
    DIESEL(0), BENZYNA(1);


    private final int value;

    EngineType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
