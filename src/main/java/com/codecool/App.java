package com.codecool;

import java.util.ArrayList;
import java.util.List;

import static com.codecool.WordChecker.alphabet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        inserttChars("orion");


    }

    public static void inserttChars(String word) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < word.length()+1; i++){
            for (char c : alphabet){
                String temp = new StringBuilder(word).insert(i, c).toString();

            }

        }

    }



}
