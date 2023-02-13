/*
Name        : Q_4
Author      : Ty Keith | 3270281
Version     : 1.0
Created     : 2023-02-12
Description : Implement a commonly used hash table in a program that handles collision using linear probing.
              Using (K mod 13) as the hash function, store the following elements in the table:
              {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146}.
*/

/*
Underlying assumptions for implementation of assignment question:
    - Will only be implementing the methods asked for above as it is assumed any other methods are known via reading
    text and watching YouTube lectures and do not need to be shown, unless necessary to properly implement things.
    - any classes needed for the implementation will be in a class file with its corresponding name; ex. Node.java
    for node class
 */

public class Q4 {
    public static void main(String[] args) {
        // create a set of numbers
        int[] keys = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};

        // construct the hashTable var with length of the key set as the table size
        HashTable hashTable = new HashTable(keys.length);

        // input same value for them all just as a proof of concept
        String value = "Test Value";

        try {
            for (int key : keys) {
                hashTable.set(key, value);
                System.out.printf("Key %03d: Value %-5s || ", key, hashTable.get(key));
                hashTable.printKeyInfo(key);
            }
        }
        catch (Exception e) {
            if (e.getMessage().equals("Hash Table is Full")) {
                System.out.println("Hash Table is Full. No Other Values Added");
            } else {
                System.out.printf("ERROR %s: ", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}