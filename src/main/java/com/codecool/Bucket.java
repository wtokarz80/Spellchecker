package com.codecool;

public class Bucket {

    public Node firstNode;

    public boolean get(String stringToFind){
        Node next = firstNode;
        while (next != null){
            if (next.word.equals(stringToFind)){
                return true;
            }
            next = next.next;
        }
        return false;
    }


    public void put(String key) {
        for (Node curr = firstNode; curr != null; curr = curr.next) {
            if (key.equals(curr.word)) {
                return;
            }
        }
        firstNode = new Node(key, firstNode);
    }


    public void delete(String stringToRemove) {
        Node temp = firstNode;
        Node prev = null;
        if (temp != null && temp.word.equals(stringToRemove)){
            firstNode = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next

        while (temp != null && !temp.word.equals(stringToRemove))
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }


    class Node {

        String word;
        Node next;

        public Node(String key, Node next){
            this.word = key;
            this.next = next;
        }
    }
}
