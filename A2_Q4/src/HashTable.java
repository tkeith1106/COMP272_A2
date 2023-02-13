public class HashTable {
    // create the private variables.
    private final int TABLE_SIZE;
    private final Hash[] table;
    private int size = 0;

    // construct hashTable: user must specify exact size... not a dynamic hashtable
    public HashTable(int size) {
        TABLE_SIZE = size;
        this.table = new Hash[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            this.table[i] = null;
        }
    }

    // getter: this method takes in the key and fetches the value of the key via the mod 13 algorithm
    public String get(int key) {
        int hash = (key % TABLE_SIZE);

        while (this.table[hash] != null && this.table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        if (this.table[hash] == null) {
            return null;
        } else {
            return this.table[hash].getValue();
        }

    }

    // setter: this method takes the users key and value pairs and sets via the mod 13 algorithm. if the table is full
    //         it will throw and index out of bounds error
    public void set(int key, String value) {
        if (this.size >= TABLE_SIZE) throw new IndexOutOfBoundsException("Hash Table is Full");

        int hash = (key % TABLE_SIZE);

        while (this.table[hash] != null && this.table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        this.table[hash] = new Hash(key, value);
        this.size++;
    }

    // this method prints the input key info in a certain format to help with the readability of the index position of
    // the k: v pairs. NOTE: This is for this exercise only and is not typically implemented.
    public void printKeyInfo(int key) {

        // only reason 'i' have the while loop is to print of what index in the hash table the k: v set went into.
        int i = 0;
        while (i != -1) {
            // if 'i' is less than table size, index isn't null and keys match then print out key info
            if (i < TABLE_SIZE && table[i] != null && table[i].getKey() == key) {
                System.out.printf("Hash Table %2d - [%03d] : %s\n", i, table[i].getKey(), table[i].getValue());
                i = -2;
            }
            i++;
        }
    }
}
