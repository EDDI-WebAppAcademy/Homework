<template>
  <div class="registerWrap">
    <h3>
      상품 등록
      <span> only admin </span>
    </h3>

    <product-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import ProductRegisterForm from "@/components/productsBoard/ProductRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "ProductRegisterView",
  components : {
    ProductRegisterForm
  },
  methods: {
    ...mapActions([
      'requestRegisterProductToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestRegisterProductToSpring(payload)
      await this.$router.push({
        name: 'ProductsBoardListView'
      })
    }
  }
}
</script>

<style scoped>
h3 > span {
  font-size: 11px;
  color: #42b983;
}
</style>