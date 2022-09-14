<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
export default {
  name: "TdComponent",
  data () {
    return {
      game: {
        // 이 시키는 왜 계속 O이지?
        propsTurnShape: this.turnShape,
        propsWinner: ''
      }
    }
  },
  props: {
    cellData: String,
    cellIndex: Number,
    rowIndex: Number,
    tableData: Array,
    turnShape: String,
  },
  methods: {
    onClickTd () {
      if(this.cellData) {
        return
      }

      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turnShape)
      // 이거 하면 이제 값이 cellData에 들어가는거지? 근데 어케 들어가지는거임??
      let win = this.checkWinner()


      // 이겼다면,,
      if(win) {
        this.game.propsWinner = this.turnShape

        // 여기서 this.game.propsWinner 데이터를 윗 컴포넌트로 올림(?).
        this.$emit('updateWinner', this.game.propsWinner)
        // 이시키는 뭐하는 시키지? 판 엎는 시키? 갑자기 등장한 녀석,,
        this.$emit('updateTableData')
      } else {
        // 이긴 게 아니라면,,,(아직 겜중)
        let allCellFull = true
        // 뭐임 이거 for문 어케 도는거임? 대충 줄따라,,열따라,,인듯,,ㅇㅇ,,ㅋ
        this.tableData.forEach(row => {
          row.forEach(cell => {
            // 이 if문 조건은 머임? cell이 아니야?
            // cell이 비었다..그런..건가..? 머 표시를 이렇게 하는거야..?
            if(!cell) {
              allCellFull = false
            }
          })
        })
        //위의 else문까지 돌고 allCellFull이 true이면 무승부
        if(allCellFull) {
          this.$emit('updateTableData')
        }
      }
      this.game.propsTurnShape = this.turnShape === 'O' ? 'X' : 'O'
      // 여기서 this.game.propsTurnShape 정보를 위 컴포넌트로 올려주는 것 같다...
      this.$emit('updateTurnShape', this.game.propsTurnShape)
    },
    checkWinner () {
      if (
          this.tableData[this.rowIndex][0] === this.turnShape &&
          this.tableData[this.rowIndex][1] === this.turnShape &&
          this.tableData[this.rowIndex][2] === this.turnShape &&
          this.tableData[this.rowIndex][3] === this.turnShape &&
          this.tableData[this.rowIndex][4] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][this.cellIndex] === this.turnShape &&
          this.tableData[1][this.cellIndex] === this.turnShape &&
          this.tableData[2][this.cellIndex] === this.turnShape &&
          this.tableData[3][this.cellIndex] === this.turnShape &&
          this.tableData[4][this.cellIndex] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][0] === this.turnShape &&
          this.tableData[1][1] === this.turnShape &&
          this.tableData[2][2] === this.turnShape &&
          this.tableData[3][3] === this.turnShape &&
          this.tableData[4][4] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][4] === this.turnShape &&
          this.tableData[1][3] === this.turnShape &&
          this.tableData[2][2] === this.turnShape &&
          this.tableData[3][1] === this.turnShape &&
          this.tableData[4][0] === this.turnShape
      ) {
        return true
      }
    }
    // 음..else-if문 끝에 꼭 else를 안붙여줘도 되는군...
  }
}
</script>

<style scoped>

</style>