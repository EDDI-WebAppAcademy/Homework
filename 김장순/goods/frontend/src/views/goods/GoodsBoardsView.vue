<template>
  <div>
    <goods-boards :goodsList="goodsList"/>
  </div>
</template>

<script>
import GoodsBoards from "@/components/goods/GoodsBoards";
import {mapActions, mapState} from "vuex"

export default {
  name: "GoodsBoardsView",
  components: {
    GoodsBoards
  },
  computed:{
    ...mapState([
        'goodsList'
    ])
  },
  mounted() {
    this.requestGoodsListFromSpring()
  },
  methods:{
    ...mapActions([
        'requestGoodsListFromSpring'
    ])

  }
}
</script>

<style scoped>

</style>