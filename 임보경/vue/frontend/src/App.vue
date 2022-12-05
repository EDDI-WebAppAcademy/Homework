<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/Test">Test</router-link>  |
      <router-link to="/components-test-view">Components Test</router-link>  |
      <router-link to="/concave-board-game">tic tak toe</router-link>  |
      <router-link to="/practiceView">임시 테스트용</router-link>  |
      <router-link to="/vue2spring">Vue 2 Spring 통신 테스트</router-link> |
      <router-link to="/make-game-view">게임 만들기 테스트</router-link> |
      <router-link to="/data-send-test">Vue 2 Spring 데이터 전송 테스트</router-link> |
    </nav>
    <router-view/>
  </div>
</template>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

