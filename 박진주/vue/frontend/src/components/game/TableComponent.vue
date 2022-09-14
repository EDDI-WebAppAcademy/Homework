<template>
  <table>

    <!--props란
    : 부모 컴포넌트에서 자식 컴포넌트로 데이터를 전달할때 사용되어지는 단방향 데이터 전달 방식이다
      사용방법 : 부모 컴포넌트에서 자식 컴포넌트를 호출시 자식 컴포넌트 태그 내 v-bind나 : 키워드를통해 데이터를 전달하고 자식 컴포넌트에서 props객체를 통해 데이터를 전달받는 방식

    기본 형식:
    - 부모 컴포넌트에 적는 내용
    <template>
      1. 첫번째 방법
      <자식컴포넌트이름 :props이름="전달데이터"/>
      2. 두번째 방법
      <자식컴포넌트이름 v-bind:props이름="전달데이터"/>
    </template>

    -->
    <!-- 아래와 같이 tr에 대한 커스텀 태그 작성해줌(tr은 현재 TableComponent의 자식 컴포넌트)-->
    <!--  HTML 속성에서는 대소문자 구분이 안되므로 케밥케이스 (소문자-소문자-소문자)로 작성해줘야 함 (자바스크립트는 자바와 동일하게 카멜케이스) -->
    <tr-component
        v-for="(rowData, index) in tableData"
        :key="index"
        :row-data="rowData"
        :row-index="index"
        :table-data="tableData"
        :turn-shape="turnShape"
        @updateTurnShape="updateTurnShape"
        @updateWinner="updateWinner"
        @updateTableData="updateTableData"/>        <!--위너 판정으로 추가된 emit 데이터 :@updateWinner, @updateTableData -->
      <!-- 여기 커스텀 태그에 들어간 @메소드들은 이 태그가 실행될 때 (즉 화면에 뿌려지는거겠지?) 실행되는 메소드들이겠군 -->
  </table>
</template>

<script>
import TrComponent from "@/components/game/TrComponent";
export default {
  name: "TableComponent",
  data () {
    return {
    }
  },
  components: {
    TrComponent            // 컴포넌트에는 자식 컴포넌트 적어줌
  },
  props: {
    tableData: Array,
    turnShape: String,
  },
  methods: {
    updateTurnShape (passingValue) {
      console.log('TableComponent - turnShape: ' + passingValue)
      this.propsTurnShape = passingValue
      this.$emit('updateTurnShape', this.propsTurnShape)
    },
    updateWinner (passingValue) {
      console.log('TableComponent - winner: ' + passingValue)
      this.propsWinner = passingValue
      this.$emit('updateWinner', this.propsWinner)
    },
    updateTableData () {
      this.$emit('updateTableData')
    }
  }
}
</script>

<style scoped>
</style>