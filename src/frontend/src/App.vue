<template>
  <div id="app">
    <div id="nav">
      <h1>HANGMAN</h1>
      <router-link class="links" to="/">HOME</router-link>|
      <router-link class="links" to="/hangman">GAME</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
.links {
  color: white;
  font-size: 1em;
  text-decoration: none;
  text-align: center;
}
h1 {
  color: white;
}
</style>
