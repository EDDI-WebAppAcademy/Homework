<template>
  <div id="app">
    <nav>
      <router-link to="/">Home </router-link> |
      <router-link to="/test"> Test </router-link> |
      <router-link to="/component-test"> Component Test View </router-link> |
      <router-link to="/concave-board-view"> 오목 게임</router-link> |
      <router-link to="/vue2spring"> Vue To Spring</router-link> |
      <router-link to="/rpg-game"> RPG Game</router-link> |
      <router-link to="/data-send-test-view">Data Send Test View</router-link>
      <router-link to="/board-list">게시판</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<style scoped>
/*#app {*/
/*  font-family: Avenir, Helvetica, Arial, sans-serif;*/
/*  -webkit-font-smoothing: antialiased;*/
/*  -moz-osx-font-smoothing: grayscale;*/
/*  text-align: center;*/
/*  color: #2c3e50;*/
/*}*/

/*nav {*/
/*  padding: 30px;*/
/*}*/


/*nav a {*/
/*  font-weight: bold;*/
/*  color: #2c3e50;*/
/*}*/

/*nav a.router-link-exact-active {*/
/*  color: #42b983;*/
/*}*/
</style>
