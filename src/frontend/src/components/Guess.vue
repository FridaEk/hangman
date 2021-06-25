<template>
  <div class="root-container">
    <div class="state-check-container">
      <div>
        <h3 v-if="hasWon">YOU {{ msg }}</h3>

        <h3 v-else-if="hasLost">YOU {{ msg }}</h3>
      </div>
      <div class="guesses-left">
        {{ getNoOfGuesses }}<br />
        <span class="guesses-left-label">GUESSES LEFT</span>
      </div>
    </div>

    <div class="info-container">
      <div class="letter-container">
        <div
          class="letter-display"
          v-for="(item, index) in getCharList"
          :key="index"
        >
          {{ item }}
        </div>
      </div>

      <div class="input-container">
        <input
          type="text"
          class="input-guess"
          v-model="guess"
          @keyup.enter="onSubmit"
          :disabled="(hasWon, hasLost)"
          placeholder="GUESS A LETTER"
        /><br />
        <button
          class="btn-guess"
          @click="onSubmit"
          :disabled="(hasWon, hasLost)"
        >
          GUESS!
        </button>
      </div>
      <div class="wrong-guesses-container">
        <div
          v-for="(letter, index) in wrongLetters"
          :key="index"
          class="wrong-guesses"
        >
          {{ letter }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex"
export default {
  name: "Guess",
  data() {
    return {
      guess: "",
      wrongLetters: [],
      msg: "",
      hasWon: false,
      hasLost: false,
    }
  },
  updated() {
    this.checkState()
  },
  computed: {
    ...mapGetters(["getCharList", "getNoOfGuesses"]),
  },
  methods: {
    ...mapActions(["addNewLetterGuess", "noOfGuessesLeft"]),
    addGuess() {
      if (this.guess) {
        console.log(this.getCharList)
        this.addNewLetterGuess(this.guess)
        this.noOfGuessesLeft()
      }
    },
    checkLetter() {
      if (!this.$store.state.game.secretWord.includes(this.guess)) {
        this.wrongLetters.push(this.guess)
        this.noOfGuessesLeft()
      }
      this.guess = ""
    },
    checkState() {
      if (!this.getCharList.includes("_")) {
        this.msg = "WON!"
        this.hasWon = true
      }
      if (this.getNoOfGuesses === 0) {
        this.hasLost = true
        this.msg = "LOST!"
      }
    },
    onSubmit() {
      this.addGuess()
      this.checkLetter()
    },
  },
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");

body {
  font-family: "Press Start 2P", cursive;
  margin: 25px;
  background-color: black;
}

.info-container {
  display: flex;
  flex-direction: column;
}

.root-container {
  display: flex;
  flex-direction: column;
}

.state-check-container {
  color: white;
  display: flex;
  justify-content: space-between;
}

.guesses-left {
  color: white;
  font-size: 5em;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.letter-container {
  display: flex;
  flex-wrap: wrap;
}

.letter-display {
  font-size: 3em;
  color: white;
  flex-direction: column;
  margin: 0.7em;
}

.guesses-left-label {
  font-size: 0.2em;
}

.wrong-guesses-container {
  display: flex;
}

.wrong-guesses {
  color: white;
  font-size: 2em;
  margin: 15px;
  flex-direction: column;
}

.btn-guess {
  background-color: white;
  font-family: inherit;
  border: none;
  height: 35px;
  padding: 1em;
  cursor: pointer;
}

.input-guess {
  background-color: white;
  color: black;
  margin: 15px 0;
  padding: 1.5em;
  text-align: center;
  font-family: inherit;
}
</style>
