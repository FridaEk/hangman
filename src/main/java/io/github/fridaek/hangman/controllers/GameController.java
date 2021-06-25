package io.github.fridaek.hangman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.fridaek.hangman.models.Game;
import io.github.fridaek.hangman.services.GameService;

@RestController
@RequestMapping(value = "/api")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games/{secretWord}")
    public Game createGame(@PathVariable String secretWord) {
        return gameService.createGame(secretWord);
    }

    @PostMapping("/games/guess/{letter}")
    public List<Character> letterGuess(@PathVariable Character letter) {
        return gameService.letterGuesses(letter);
    }

    @GetMapping("/games/guesses")
    public Integer guessesLeft() {
        return gameService.guessesLeft();
    }
}
