package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Darth Vader: No, I Am Your Father.", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Darth Vader: No, I Am Your Father.", String::toUpperCase);

        poemBeautifier.beautify("Darth Vader: No, I Am Your Father.", text -> {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if(Character.isLowerCase(c)) result.append(Character.toUpperCase(c));
                else result.append(Character.toLowerCase(c));
            }
            return result.toString();
        });

        poemBeautifier.beautify("Darth Vader: No, I Am Your Father.", text -> {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                switch(Character.toLowerCase(c)) {
                    case 'i': result.append(1); break;
                    case 'z': result.append(2); break;
                    case 'e': result.append(3); break;
                    case 'a': result.append(4); break;
                    case 's': result.append(5); break;
                    case 't': result.append(7); break;
                    case 'b': result.append(8); break;
                    case 'o': result.append(0); break;
                    default: result.append(c); break;
                }
            }
            return result.toString();
        });

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
