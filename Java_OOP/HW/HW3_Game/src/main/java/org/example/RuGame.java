package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class RuGame extends AbstractGame{
    @Override
        ArrayList<String> generateCharList() {
        return new ArrayList<>(Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и",
                "й", "к", "л", "м", "н", "о", "п", "р", "с",
                "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"));
    }
}
