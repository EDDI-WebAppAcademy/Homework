<template>
  <div align="center">
    <product-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import ProductRegisterForm from "@/components/goodsSale/ProductRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "ProductRegisterView",
  components: {
    ProductRegisterForm
  },
  methods: {
    ...mapActions([
        'requestCreateGoodsBoardContentsToSpring'
    ]),
    async onSubmit (payload){
      await this.requestCreateGoodsBoardContentsToSpring(payload)

      await this.$router.push({
        name: 'GoodsSaleListView'
      })
    }
  }
}
</script>

<style scoped>

</style>