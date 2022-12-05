<template>
  <form @submit.prevent="onLogin">
    <div align="center">
      <h3>로그인</h3>
      <table>
        <tr>
          <td>아이디</td>
          <td>
            <input type="email" v-model="userId" placeholder="이메일 형식">
          </td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>
            <input type="password" v-model="userPassword" placeholder="비밀번호">
          </td>
        </tr>
      </table>
      <button type="submit" style="margin-right: 20px; margin-left: 42px">로그인</button>
      <router-link :to="{name: 'EcommerceSignUpView'}">
        회원가입
      </router-link>
    </div>
  </form>

</template>

<script>
export default {
  name: "EcommerceLoginForm",
  data() {
    return{
      userId: null,
      userPassword: null,
    }
  },
  methods:{
    onLogin() {
      const { userId, userPassword } = this
      this.$emit('submit', { userId, userPassword })
    }
  },
}
</script>

<style scoped>

</style>