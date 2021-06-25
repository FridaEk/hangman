import { createStore } from 'vuex'

export default createStore({
    state: {
        game: {
            secretWord: '',
            noOfGuesses: 0,
            charList: []
        },
    },
    getters: {
        getCharList: state => {
            return state.game.charList
        },
        getNoOfGuesses: state => {
            return state.game.noOfGuesses
        }
    },
    mutations: {
        LETTER_GUESS(state, charList) {
            state.game.charList = charList
        },
        SET_GAME(state, game) {
            state.game = game
        },
        GUESSES_LEFT(state, noOfGuesses) {
            state.game.noOfGuesses = noOfGuesses
        },
    },
    actions: {
        createGame({ commit }, secretWord) {
            fetch(`/api/games/${secretWord}`, {
                    method: 'POST',
                })
                .then(response => response.json())
                .then((data) => {
                    return commit('SET_GAME', data)
                })
        },
        addNewLetterGuess({ commit }, guess) {
            fetch(`/api/games/guess/${guess}`, {
                    method: 'POST'
                })
                .then(response => response.json())
                .then((data) => {
                    return commit('LETTER_GUESS', data)
                })
        },
        noOfGuessesLeft({ commit }) {
            fetch('/api/games/guesses')
                .then(response => response.json())
                .then((data) => {
                    console.log(data);
                    return commit('GUESSES_LEFT', data)
                })
        },
    },
})