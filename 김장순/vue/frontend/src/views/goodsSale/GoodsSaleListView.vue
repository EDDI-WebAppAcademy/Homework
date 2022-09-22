<template>
  <div align="right">
    <goods-sale-list :goods-sale-boards="goodsSaleBoards"/>
  </div>
</template>

<script>
import GoodsSaleList from "@/components/goodsSale/GoodsSaleList";
import {mapActions, mapState} from "vuex";

export default {
  name: "GoodsSaleListView",
  components: {
    GoodsSaleList
  },
  computed: {
    ...mapState([
      'goodsSaleBoards'
    ]),
  },
  mounted() {
    this.requestGoodsSaleBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestGoodsSaleBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>