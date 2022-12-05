<template>
  <div>
    <goods-read-form v-if="goods" :goods="goods"/>
    <p v-else>Loading ....... </p>
  </div>
</template>

<script>
import GoodsReadForm from "@/components/goods/GoodsReadForm";
import {mapActions, mapState} from "vuex";

export default {
  name: "GoodsReadView",
  components: {GoodsReadForm},
  props: {
    goodsNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['goods'])
  },
  methods: {
    ...mapActions([
      'requestGoodsFromSpring'
    ])
  },
  created() {
    this.requestGoodsFromSpring(this.goodsNo)
  }
}

</script>

<style scoped>

</style>