public class Hash{
    // init the private variables for this class; key: value are immutable; so it's a final property
    private final int key;
    private final String value;

    // create the constructor for this class
    public Hash(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // create the key getter
    public int getKey() {
        return this.key;
    }

    // create the value getter
    public String getValue() {
        return this.value;
    }
}
