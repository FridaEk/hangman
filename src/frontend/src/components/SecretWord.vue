<template>
  <div class="secretword-container">
    <input
      class="placeholder"
      type="text"
      @keyup.enter="createGame"
      placeholder="Write your secret word here..."
      v-model="secretWord"
    />
    <br />
    <router-link to="/hangman">
      <button class="btn-play" @click="createGame">PLAY GAME!</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "SecretWord",
  data() {
    return {
      secretWord: "",
    }
  },
  methods: {
    createGame() {
      if (this.secretWord) this.$store.dispatch("createGame", this.secretWord)
    },
  },
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");

.secretword-container {
  font-family: "Press Start 2P", cursive;
  display: flex;
  align-self: center;
  padding: 10%;
  flex-direction: column;
}

.placeholder {
  font-family: inherit;
  border: none;
  padding: 3.6em 4.5em;
  color: black;
  width: 50%;
}
.btn-play {
  font-family: inherit;
  padding: 3em 4em;
  margin: 0.3rem;
  cursor: pointer;
}
</style>
