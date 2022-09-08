<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <!-- 표기법: 아래의 :initial-test는 v-bind:initial-test 라고도 표기 가능 -->

      <p>{{ msg }}</p>
      <global-component
          :initial-test="counter"
      />                                <!-- 커스텀 태그 형식이라고 볼 수 있음.  initial-test라는 글로벌컴포넌트   (2단계) counter 데이터 0 전달 받음-->
      <local-component
          :initial-value="num"
      />
      <button v-on:click="plus">클릭해봐</button>


    </div>

  </div>
</template>

<script>
import Vue from 'vue'
import GlobalComponent from "@/components/basics/ComponentDivide/GlobalComponent";
import LocalComponent from "@/components/basics/ComponentDivide/LocalComponent";

Vue.component(GlobalComponent.name, GlobalComponent)            // 컴포넌트 선언 방법 1) 글로벌컴포넌트는 Vue.component 즉, Vue 자체에 선언 -> 어디서든 사용 가능

export default {
  name: "ComponentTestView",
  components: {
    'local-component': LocalComponent,                           //컴포넌트 선언 방법 2) 로컬컴포넌트는 export default {components: 여기에 선언}

  },
  data(){
    return{
      counter: 0,                                                   //(1단계) 이 정보가 global-component 에 전달됨
      num: 0,
      msg: 'vue가 이래서 생산성이 높고 트렌디한 거임'
    }
  },
  methods:{
    plus(){
      this.num++
    },

  }
}
</script>

<style scoped>

</style>


//하위에서 상위로 전달하는 방법은 내일
//오늘은 그럼 상위에서 하위로 전달하는 거엿나?
