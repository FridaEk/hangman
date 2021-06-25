package io.github.fridaek.hangman.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.fridaek.hangman.models.Game;

@Service
public class GameService {

    private Game game = new Game();

    public Game createGame(String secretWord) {
        List<Character> secretWordList = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            secretWordList.add('_');
        }
        game.setSecretWord(secretWord);
        game.setCharList(secretWordList);
        game.setNoOfGuesses(10);
        return game;
    }

    public List<Character> letterGuesses(Character letter) {
        boolean isFound = false;
        String secretWord = game.getSecretWord();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                game.getCharList().set(i, letter);
                isFound = true;
            }
        }
        if (!isFound) {
            decrementNoOfGuesses();
        }
        return game.getCharList();
    }

    public Integer guessesLeft() {
        return game.getNoOfGuesses();
    }

    public Integer decrementNoOfGuesses() {
        return game.decrementNoOfGuesses();
    }
}
