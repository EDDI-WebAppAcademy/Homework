<template>
  <div>
    <div>{{ turnShape }} 님의 턴입니다.</div>
    <table-component
        :table-data="tableData"
        :turn-shape="turnShape"
        @updateTurnShape="updateTurnShape"
        @updateWinner="updateWinner"
        @updateTableData="updateTableData"/>    <!-- emit한 데이터를 위해 상위컴포넌트에서 해야될 것 1 - 커스텀 태그에 새로 생성한 메소드 써주기 -->
    <div v-if="winner">{{ winner }} 님의 승리!</div>
  </div>
</template>

<script>
import TableComponent from "@/components/game/TableComponent";
export default {
  name: "ConcaveBoardView",
  components: {
    TableComponent
  },
  data () {
    return {
      turnShape: 'O',
      winner: '',
      tableData: [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
      ]
    }
  },
  methods: {
    updateTurnShape(passingValue) {                                               // emit한 데이터를 위해 상위컴포넌트에서 해야될 것 2 - emit 데이터 업데이트를 위한 메소드 신규 작성해주기
      console.log('ConcaveBoardView - turnShape: ' + passingValue)
      this.turnShape = passingValue
    },

    updateWinner (passingValue) {
      console.log('ConcaveBoardView - winner: ' + passingValue)
      this.winner = passingValue
    },
  updateTableData () {
    this.tableData = [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
      ]
    }
  }
}

  //beforeUpdate() {

  //  console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    //행비교 메소드 실행
  // 행비교 내가 작성
    // for (let i = 0; i < this.tableData.length; i++) {
    //   if (this.tableData[i].toString() === ['O', 'O', 'O', 'O', 'O'].toString()) {
    //     this.winner = 'O'
    //     break
    //   } else if (this.tableData[i].toString() === ['X', 'X', 'X', 'X', 'X'].toString()) {
    //     this.winner = 'X'
    //     break
    //   } else {
    //     continue
    //   }
    // }


    // 열비교 내가 작성하다 실패
    // let checkcountO=0, checkcountX = 0;
    //
    // for(let i = 0; i < this.tableData.length; i++){
    //   for(let j=0; j< this.tableData.length; j++){
    //     console.log(this.tableData[j][i])
    //     if(this.tableData[j][i].toString() === 'O'){
    //       checkcountO += 1
    //       if(checkcountO === 5){
    //         this.winner='O'
    //         break
    //       }
    //     } else if(this.tableData[j][i].toString() === 'X'){
    //       checkcountX += 1
    //       if(checkcountX === 5){
    //         this.winner='X'
    //         break
    //       }
    //     }else{
    //       continue
    //     }
    //   }
    // }


</script>

<style scoped>
</style>