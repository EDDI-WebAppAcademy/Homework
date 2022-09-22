<template>
  <div>
    <ecommerce-consumer-list :items="items"/>
  </div>
</template>

<script>
import EcommerceConsumerList from "@/components/fourteenTh/product_board/consumer/EcommerceConsumerList";
import {mapActions, mapState} from "vuex";
export default {
  name: "EcommerceConsumerListView",
  components:{
    EcommerceConsumerList
  },
  computed:{
    ...mapState([
        'items'
    ])
  },
  mounted() {
    this.requestSellItemListFromSpring()
  },
  methods:{
    ...mapActions([
        'requestSellItemListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>