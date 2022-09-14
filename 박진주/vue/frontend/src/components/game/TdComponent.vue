<template>
  <td @click="onClickTd">{{ cellData }}</td>
  <!--
   1. 상위컴포넌트 - 하위 컴포넌트 소통 방식 파악     -> 대충 알겠음
   2.  store- mutaion 등 spring 과의 소통방식 공부
   3. 새로 작성 한 코드 리뷰
  -->

</template>

<script>
/** 부모 <-> 자식 컴포넌트간 데이터 전달 방법

 1. 부모 -> 자식에게 전달하는 방법은 props를 사용
 자식 컴포넌트가 부모컴포넌트에서 전달받은 데이터를 저장하기 위해 표기
 자식 Component는 props 옵션을 사용하여 수신 할 것으로 기대되는 props를 명시적으로 선언해 사용

 2. 자식 -> 부모 컴포넌트에게 데이터 전달하는 방법 (emit 사용)
 emit: 다른 컴포넌트에게 현재 컴포넌트의 event나 데이터를 전달하기 위해 사용
 자식 컴포넌트에서 사용자 지정 이벤트를 생성 후(이때 emit 코드 사용)
 ->  부모 컴포넌트에게 전달 -> 부모컴포넌트 : (1) component에 자식컴포넌트 적어주고 (2) 전달받은 emit데이터를 커스텀 태그 적용 (3) emit데이터 메소드 생성
 emit 형식: this.$emit('사용자 지정 emit 명칭', 현재 컴포넌트에서 전송할 event나 data)
 */

export default {
  name: "TdComponent",
  data () {
    return {
      game: {                                    //여기서 props변수명 사용하는 건 emit해서 사용할 변수명
        propsTurnShape: this.turnShape,          // propsTurnShape는 emit에 의해 전달된 데이터를 받는거고 실제 내가 받는 데이터는 this.turnShape
        propsWinner: '',                           //  위너 판정으로 새로 작성된 데이터 1
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
      if (this.cellData) {
        return
      }
      //this.$set(this.tableData[this.rowIndex], this.cellIndex, this.game.propsTurnShape)  -> 턴이 O로 바뀌지 않았던 코드 아래와 같이 this.turnShape로 변경하여 정상 동작됨
      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turnShape)

      //행 자료 - this.tableData[this.rowIndex]
      // 열 인덱스 - this.cellIndex
      // 턴 모양 - this.turnShape

//위너 판정으로 새로 작성된 코드 시작
      let win = this.checkWinner()

      if (win) {
        this.game.propsWinner = this.turnShape
        this.$emit('updateWinner', this.game.propsWinner)
        this.$emit('updateTableData')
      } else {
        let allCellFull = true
        this.tableData.forEach(row => {
          row.forEach(cell => {
            if (!cell) {
              allCellFull = false
            }
          })
        })
        if (allCellFull) {
          this.$emit('updateTableData')
        }
      }

//위너 판정으로 새로 작성된 코드 끝

      this.game.propsTurnShape = (this.turnShape === 'O' ? 'X' : 'O')
      this.$emit('updateTurnShape', this.game.propsTurnShape)                    //  emit한 데이터 해야될 것 - 이후 상위 컴포넌트에 메소드 작성 + 커스텀 태그 적용
      //emit 형식: this.$emit('사용자 지정 emit 명칭', 현재 컴포넌트에서 전송할 event나 data)

    },

    //위너 판정으로 새로 작성된 메소드
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
  }
}
</script>

<style scoped>
</style>