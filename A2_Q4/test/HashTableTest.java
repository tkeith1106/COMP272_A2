import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    public void testGetMethod() {
        HashTable hashTable = new HashTable(10);
        hashTable.set(1, "Value1");
        hashTable.set(2, "Value2");
        assertEquals("Value1", hashTable.get(1));
        assertEquals("Value2", hashTable.get(2));
        assertNull(hashTable.get(3));
    }

    @Test
    public void testGetWithHashCollision() {
        HashTable hashTable = new HashTable(10);
        hashTable.set(2, "Value 2");
        hashTable.set(12, "Value 12");
        assertEquals("Value 2", hashTable.get(2));
        assertEquals("Value 12", hashTable.get(12));
    }

    @Test
    public void testSetMethod() {
        HashTable hashTable = new HashTable(10);
        hashTable.set(1, "Value1");
        hashTable.set(2, "Value2");
        hashTable.set(3, "Value3");
        assertEquals("Value1", hashTable.get(1));
        assertEquals("Value2", hashTable.get(2));
        assertEquals("Value3", hashTable.get(3));
        hashTable.set(3, "NewValue3");
        assertEquals("NewValue3", hashTable.get(3));
    }

    @Test
    public void testSetWithHashCollision() {
        HashTable hashTable = new HashTable(10);
        int key1 =2;
        int key2 = 12;
        hashTable.set(2, "Value 2");
        hashTable.set(12, "Value 12");
        assertEquals("Value 2", hashTable.get(key1));
        assertEquals("Value 12", hashTable.get(key2));
    }

    @Test
    public void testTableFullException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            HashTable hashTable = new HashTable(1);
            hashTable.set(1, "Value1");
            hashTable.set(2, "Value2");
        });

        String expectedMessage = "Hash Table is Full";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }
}