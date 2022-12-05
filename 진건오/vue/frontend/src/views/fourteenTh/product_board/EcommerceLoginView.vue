<template>
  <div>
    <ecommerce-login-form @submit="onLogin"/>
  </div>
</template>

<script>

import EcommerceLoginForm from "@/components/fourteenTh/product_board/EcommerceLoginForm";

export default {
  name: "EcommerceLoginView",
  components:{
    EcommerceLoginForm
  },
  methods:{
    async onLogin(payload) {
      await this.requestEcommerceUserLoginToSpring(payload)
      await this.$router.push({name: 'EcommerceConsumerListView'})
    },
  }
}
</script>

<style scoped>

</style>