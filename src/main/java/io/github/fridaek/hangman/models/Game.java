
package io.github.fridaek.hangman.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String secretWord;
    private Integer noOfGuesses;
    private List<Character> charList;

    public Game() {
        this.noOfGuesses = 10;
        this.charList = new ArrayList<>();
    }

    public Game(String secretWord) {
        this.secretWord = secretWord;
        this.noOfGuesses = 10;
        this.charList = new ArrayList<>();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public Integer getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(Integer noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    public List<Character> getCharList() {
        return charList;
    }

    public void setCharList(List<Character> charList) {
        this.charList = charList;
    }

    public Integer decrementNoOfGuesses() {
        noOfGuesses--;
        return noOfGuesses;
    }
}
