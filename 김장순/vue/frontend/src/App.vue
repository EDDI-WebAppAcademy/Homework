<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/test">Test</router-link> |
          <router-link to="/component-test">Component Test</router-link> |
          <router-link to="/concave-board-game">오목 게임</router-link> |
          <router-link to="/vue2spring">Vue 2 Spring 통신 테스트</router-link> |
          <router-link to="/rpg-game">RPG 게임</router-link> |
          <router-link to="/data-send-test">Vue 2 Spring 데이터 전송 테스트</router-link> |
          <router-link to="/board-list">게시판</router-link> |
          <router-link to="/goods-sale-list">굿즈 판매 사이트</router-link> |

    </nav>
    <router-view/>
  </div>
</template>

<scopedstyle scoped>

</scopedstyle>
