<template>
  <div>
    <h2>상품 등록</h2>
    <product-board-register-form @submit="onSubmit"/>
  </div>

</template>

<script>
import ProductBoardRegisterForm from "@/components/productBoard/ProductBoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "ProductBoardRegisterView",

  components: { ProductBoardRegisterForm, },

  methods: {

    ...mapActions(['requestProductBoardRegisterToSpring']),

    checkAdmin() {
      if (!this.$store.state.isAdmin) {
        alert("관리자만 상품을 등록 가능합니다.")
        this.$router.push( {
          name: 'ProductBoardMainView'
        })
      }
    },

    async onSubmit(payload) {
      await this.requestProductBoardRegisterToSpring(payload)
      await this.$router.push(
          { name: 'ProductBoardMainView'}
      )
    }
  },

  mounted() {
    this.checkAdmin()
  }
}
</script>

<style scoped>

</style>