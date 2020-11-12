package com.codecool;

/**
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */

public class HashTable {
    /**
     * The constructor is given a table size (i.e. how big to make the array)
     * and a StringHasher, which is used to hash the strings.
     *
     * @param tableSize number of elements in the hash array
     *                  hasher    Object that creates the hash code for a string
     * @see StringHasher
     */

    private StringHasher hasher;
    private Bucket[] array;
    int tableSize;



    public HashTable(int tableSize, StringHasher hasher) {
        this.hasher = hasher;
        this.tableSize = tableSize;
        array = new Bucket[tableSize];
        for (int i = 0; i < tableSize; i++){
            array[i] = new Bucket();
        }
    }

    public Bucket[] getArray() {
        return array;
    }

    /**
     * Takes a string and adds it to the hash table, if it's not already
     * in the hash table.  If it is, this method has no effect.
     *
     * @param s String to add
     */
    public void add(String s) {
        int bucketIndex = Math.abs(hasher.hash(s)) % tableSize;
        array[bucketIndex].put(s.toUpperCase());
    }


    /**
     * Takes a string and returns true if that string appears in the
     * hash table, false otherwise.
     *
     * @param s String to look up
     */
    public boolean lookup(String s) {
        int bucketIndex = Math.abs(hasher.hash(s)) % tableSize;
        return array[bucketIndex].get(s);
    }


    /**
     * Takes a string and removes it from the hash table, if it
     * appears in the hash table.  If it doesn't, this method has no effect.
     *
     * @param s String to remove
     */
    public void remove(String s) {
        int bucketIndex = Math.abs(hasher.hash(s)) % tableSize;
        Bucket bucket = array[bucketIndex];
        if(bucket.get(s)){
            bucket.delete(s);
        }



    }


}
