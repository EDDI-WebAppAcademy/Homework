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
      ''
    ]),
    async onSubmit (payload) {
      await this.methodname(payload)

      await this.$router.push({
        name: 'ProductBoardListView'
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