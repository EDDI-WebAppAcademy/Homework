<template>
  <table>
    <tr-component
      v-for="(rowData, index) in tableData"
      :key="index"
      :row-data="rowData"
      :row-index="index"
      :table-data="tableData"
      :turn-shape="turnShape"
      @updateTurnShape="updateTurnShape"
      @updateWinner="updateWinner"
      @updateTableData="updateTableData"/>
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
    TrComponent
  },
  props: {
    tableData: Array,
    turnShape: String,
  },
  methods: {
    updateTurnShape(passingValue) {
      console.log('TableComponent - turnShape: ' + passingValue)
      this.propsTurnShape = passingValue
      this.$emit('updateTurnShape', this.propsTurnShape)
    },
    updateWinner (passingValue) {
      // 여기의 this.propsWinner는 TdComponent에 있던 그건가..? 그런가봄..
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