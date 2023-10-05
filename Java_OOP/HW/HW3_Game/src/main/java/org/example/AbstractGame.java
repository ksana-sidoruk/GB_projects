package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Мы заимплементили интерфейс. Но в абстрактном классе необязательно оверрайдить методы из интерфейса

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;
    Random r = new Random();

    /**
     * @apiNote генерирует набор символов из которых будет составляться загадываемое слово
     * @return набор символов
     */
    abstract ArrayList<String> generateCharList();

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        gameStatus = GameStatus.START;
    }

    /**
     * @apiNote генерирует загадываемое слово
     * @return загадываемый компьютером набор символов
     */
    private String generateWord() {
        List<String> alphabet = generateCharList();
        String result = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = r.nextInt(alphabet.size());
            result += alphabet.get(randomIndex);//проверка повторения, или добавив символ, удалить его из листа
            alphabet.remove(randomIndex);
        }
        return result;
    }

    @Override
    public Answer inputValue(String value) {
        //считаем быков коров, меняем статус
        int countCow = 0;
        int countBull = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                countBull++;
                countCow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                countCow++;
            }
        }
        if (countBull == computerWord.length()) {
            gameStatus = GameStatus.WIN;
        }
        maxTry--;
        if (maxTry == 0 && gameStatus != GameStatus.WIN) {
            gameStatus = GameStatus.LOSE;
        }
        return new Answer(countBull, countCow, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
         return gameStatus;
    }

    @Override
    public String printGameStatus(){
        switch (gameStatus){
            case START -> {
                return "Игра в процессе";
            }
            case WIN -> {
                return "Победа!";
            }
            case LOSE -> {
                return "Вы проиграли";
            }
            default -> {
                return "Инициалиризорована новая игра";
            }
        }
    }

    public String getComputerWord() {
        return computerWord;
    }
}
