package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class EnGame extends AbstractGame{
    @Override
    ArrayList<String> generateCharList() {
        String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        return new ArrayList<>(Arrays.asList(alphabet.split("\\s* \\s*")));
    }
}
