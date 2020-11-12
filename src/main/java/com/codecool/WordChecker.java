package com.codecool;

import java.util.*;

/**
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 * public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */

public class WordChecker {
    /**
     * Constructor that initializes a new WordChecker with a given WordList.
     *
     * @param wordList Initial word list to check against.
     * @see WordList
     */

    private WordList wordList;
    final static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public WordChecker(WordList wordList) {
        this.wordList = wordList;


    }

    public WordList getWordList() {
        return wordList;
    }

    /**
     * Returns true if the given word is in the WordList passed to the
     * constructor, false otherwise.
     *
     * @param word Word to chack against the internal word list
     * @return bollean indicating if the word was found or not.
     */
    public boolean wordExists(String word) {
        return wordList.lookup(word);

    }


    /**
     * Returns an ArrayList of Strings containing the suggestions for the
     * given word.  If there are no suggestions for the given word, an empty
     * ArrayList of Strings (not null!) should be returned.
     *
     * @param word String to check against
     * @return A list of plausible matches
     */
    public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        suggestions.addAll(swapPairs(word));
        suggestions.addAll(insertChars(word));
        suggestions.addAll(deleteChars(word));
        suggestions.addAll(replaceChars(word));
        suggestions.addAll(splitChars(word));

        return suggestions;
    }


    private Set<String> swapPairs(String word){
        Set<String> result = new HashSet<>();
        char[] arr = word.toCharArray();
        for (int i = 1; i < arr.length; i += 2){
            char temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
            if(wordExists(word))
                result.add(new String(arr));
        }
        return result;
    }

    private Set<String> insertChars(String word) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < word.length()+1; i++){
            for (char c : alphabet){
                String temp = new StringBuilder(word).insert(i, c).toString();
                if(wordExists(temp)){
                    result.add(temp);
                }
            }
        }
        return result;
    }

    private Set<String> deleteChars(String word) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < word.length(); i++){
            String temp = new StringBuilder(word).deleteCharAt(i).toString();
            if(wordExists(temp)){
                result.add(temp);
            }
        }
        return result;

    }

    private Set<String> replaceChars(String word) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < word.length(); i++){
            for (char c : alphabet){
                String temp = word.replace(word.charAt(i), c);
                if (wordExists(temp)){
                    result.add(temp);
                }
            }
        }
        return result;
    }

    private Set<String> splitChars(String word) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < word.length() - 1; i++){
                String temp1 = word.substring(0, i);
                String temp2 = word.substring(i);
                if (wordExists(temp1) && wordExists(temp2)){
                    result.add(temp1 + " " + temp2);
                }
        }
        return result;
    }


}
