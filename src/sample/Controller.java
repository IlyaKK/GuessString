package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {
    @FXML
    private TextField textField;

    @FXML
    private Button buttonGame, buttonGuess, buttonRetun;

    @FXML
    private Label label1, label2, labelPromptTxt, labelPrompt;

    @FXML
    private ListView listWords;


    GuessString game = new GuessString();

    @FXML
    void playGame(){
        listWords.setItems(game.getWORDS());
        listWords.setVisible(true);
        buttonGame.setVisible(false);
        label1.setVisible(true);
        label2.setVisible(true);
        textField.setVisible(true);
        labelPrompt.setVisible(true);
        labelPromptTxt.setVisible(true);
        buttonGuess.setVisible(true);
        game.selectRundomWord();
    }

    @FXML
    void returnGame(){
        game.selectRundomWord();
        buttonRetun.setVisible(false);
        textField.setDisable(false);
        labelPromptTxt.setVisible(true);
        buttonGuess.setVisible(true);
        labelPrompt.setText("");
        textField.setText("");
    }

    @FXML
    void equalWord(){
        String word = textField.getText();
        game.setUserWord(word);
        if(game.start_game()){
            buttonGuess.setVisible(false);
            buttonRetun.setVisible(true);
            textField.setDisable(true);
            labelPromptTxt.setVisible(false);
        }
        labelPrompt.setText(game.getMessage());
    }
}
