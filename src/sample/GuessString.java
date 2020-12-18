package sample;

import java.util.Arrays;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class GuessString {
    private final ObservableList<String> WORDS = FXCollections.observableArrayList("apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato");
    private final int NUMBER_FAKE_SYMBOLS = 15;
    private String userWord;
    private String message;
    private String rundomWord = "";

    public GuessString() {

    }

    public void selectRundomWord(){
        int numberRundomWord = (int) (Math.random() * WORDS.size());
        rundomWord = WORDS.get(numberRundomWord);
    }

    public boolean start_game() {
        message = "";
        if(compare_words(userWord, rundomWord)){
            message = "Поздравляю, вы выиграли!!! Хотите сыграть ещё раз?";
            return true;
        }else {
            printPrompt(rundomWord);
        }
        return false;
    }

    public boolean compare_words(String userWord, String rundomWord){
        return userWord.equals(rundomWord);
    }

    public void printPrompt(String rundomWord){
        char sharp = '#';
        for(int i = 0; i < NUMBER_FAKE_SYMBOLS; i++){
            if(i < rundomWord.length() && i < userWord.length() && userWord.charAt(i) == rundomWord.charAt(i)){
                message += userWord.charAt(i);
            }else {
                message += sharp;
            }
        }
    }

    public ObservableList<String> getWORDS() {
        return WORDS;
    }

    public String getMessage() {
        return message;
    }

    public void setUserWord(String userWord) {
        this.userWord = userWord;
    }
}
