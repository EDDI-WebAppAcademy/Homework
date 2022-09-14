<template>
  <button @click="addCounter">{{ counterValue }}</button>     <!-- (4단계) 여기로 counterValue 표시됨  -->
</template>

<script>
export default {
  name: "global-component",
  // 케밥 표기법 -> 초기 소문자 이후로 이니셜마다 대문자
  // 이런 형태가 vue와 연결시에는 initial-test

  props: ['initialTest'],                        //부모-> 자식에게 전달하는 방법은 props를 사용
                                                  // 자식 컴포넌트가 부모컴포넌트에서 전달받은 데이터를 저장하기 위해 표기
                                                 //자식 Component는 props 옵션을 사용하여 수신 할 것으로 기대되는 props를 명시적으로 선언해 사용

  data () {
    return {
      counterValue: this.initialTest           //(3단계) 여기서 ComponentTestView의 initialTest를 받아서 CounterValue에 저장
    }
  },
  methods: {
    addCounter () {
      this.counterValue += 1
    }
  }
}
</script>

<style scoped>

</style>