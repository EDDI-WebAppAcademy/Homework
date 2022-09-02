<template>
  <div>
    <div>{{ turnShape }} 님의 턴입니다</div>
    <table-component
        :table-data="tableData"
        :turn-shape="turnShape"
        @updateTurnShape="updateTurnShape"
        @updateWinner="updateWinner"
        @updateTableData="updateTableData"
    />
    <div v-if="winner"> {{ winner }} 님의 승리! </div>
  </div>
</template>

<script>
import TableComponent from "@/components/game/TableComponent";

export default {
  name: "ConcaveBoardView",
  components: {
    'table-component': TableComponent
  },

  data() {
    return {
      turnShape: 'O',
      winner: false,
      tableData: [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', '']
      ],

      getWinnerValue: []
    }
  },

  methods: {

    updateTurnShape(passingValue) {
      console.log('ConcaveBoardView-passingValue: ' + passingValue)
      console.log('ConcaveBoardView-turnShape: ' + this.turnShape)
      this.turnShape = passingValue
    },
    updateWinner(passingValue) {
      this.winner = passingValue
    },
    updateTableData() {
      this.tableData = [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', '']
      ]
    }
    /* methods end */
  },
  beforeUpdate() {
    /* beforeUpdate end */
  }

  /* export default end */
}
</script>

<style scoped>

</style>