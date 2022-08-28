<!--
1. Vue.js란
- 컴포넌트 기반의 SPA를 구축할 수 있게 해주는 프레임워크
 * 컴포넌트(component) : 웹을 구성하는 로고, 메뉴바, 버튼 등 웹 페이지 내의 다양한 UI 요소 -> 재사용 가능하도록 구조화한 것
 * SPA(Single Page Application): 단일 페이지 어플리케이션. -> 하나의 페이지 안에서 필요한 부분만 로딩되는 형태 (빠른 페이지 변환 + 적은 트래픽)

2. VUE 태그 구조
<template> 태그 안에는 디자인요소나 화면에 명시해줄 부분을 넣고 -> (HTML)
<script> 태그 안에는 e data(), method와 같이 실제 동작에 대해 기술 -> (JS, 자바스크립트)
<style>  실제 요소들에 대한 스타일 색, 선, 정렬 등을 지정 -> (CSS 역할)
-->


<template>
  <div id="app">
    <nav>           <!--  html <nav> 태그는 다른 페이지 또는 현재 페이지의 다른 부분과 연결되는 네비게이션 링크(navigation links)들의 집합을 정의할 때 사용합니다. 주로, 메뉴, 목차 등에 사용 -->
      <router-link to="/">Home</router-link> |
      <router-link to="/test">Test</router-link>   |      <!-- /test 추가해주며 router/index.js 에도 반영 필요 -->
      <router-link to="/homework">homework</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<scopedstyle>
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
</scopedstyle>