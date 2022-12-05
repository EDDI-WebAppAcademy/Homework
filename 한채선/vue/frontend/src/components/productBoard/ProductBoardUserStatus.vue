<template>
  <div>
    <table>
      <tr v-if="!isAdmin">
        <td> admin: {{ isAdmin }}</td>
        <td> | </td>
        <td> <router-link :to=" { name: 'ProductBoardAdminLoginView' } "> 관리자 로그인 </router-link> </td>
      </tr>
      <tr v-if="isAdmin">
        <td> admin: {{ isAdmin }}</td>
        <td> | </td>
        <td> <button @click="adminLogOut()"> 관리자 로그아웃 </button></td>
      </tr>
    </table>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: "ProductBoardLoginMenu",
  computed: {
    ...mapState(['isAdmin'])
  },

  data() {
    return {
      adminFalse: false
    }
  },

  methods: {
    adminLogOut() {
      if(this.isAdmin) {
        this.$store.state.isAdmin = this.adminFalse
        alert("로그아웃 되었습니다!")
      }
    }
  }
}
</script>

<style scoped>

</style>