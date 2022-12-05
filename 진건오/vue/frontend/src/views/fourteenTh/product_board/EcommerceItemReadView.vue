<template>
  <div align="center">
    <ecommerce-item-read v-if="item" :item="item"/>
  </div>
</template>

<script>

import EcommerceItemRead from "@/components/fourteenTh/product_board/EcommerceItemRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "EcommerceItemReadView",
  components:{
    EcommerceItemRead
  },
  props:{
    itemId:{
      type: String,
      required: true,
    }
  },
  computed:{
    ...mapState([
        'item'
    ])
  },
  methods:{
    ...mapActions([
        'requestSelectedItemFromSpring'
    ])
  },
  created() {
    this.requestSelectedItemFromSpring(this.itemId)
  }
}
</script>

<style scoped>

</style>