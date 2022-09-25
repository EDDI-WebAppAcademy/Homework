<template>
  <form @submit.prevent="onSubmit">
    <div align="center">
      <div>
        <h1 align="center" class="banner">
          <h2>회원가입</h2>
        </h1>
      </div>

      <div>
        <label>아이디 &nbsp; &nbsp;</label>
        <input type="text" class="input" placeholder="영문, 숫자 5-11자" v-model="id">
      </div>
      <br>
      <div>
        <label>비밀번호 &nbsp;</label>
        <input type="text" class="input" placeholder="최소 8자" v-model="password">
      </div>
      <br>
      <div>
        <label>이메일 &nbsp;</label>
        <input type="text" class="input" v-model="email">
        <p>계정 분실 시 본인인증 정보로 활용됩니다.</p>
      </div><br>
      <button type="submit" class="button">가입하기</button> &nbsp;
      <button class="button">
        <router-link to='/goods-sale-list'>
          취소
      </router-link>
      </button>
    </div>
  </form>
</template>

<script>
export default {
  name: "GuestJoin",
  data() {
    return {
      id: "",
      password: "",
      email: ""

    }
  },
  methods: {
    onSubmit() {
      const {id, password, email} = this
      this.$emit('submit', {id, password, email})
    }
  }
}
</script>

<style scoped>
.banner {
  margin-top: 100px;
  margin-bottom: 100px;
}

.input {
  box-sizing: border-box;
  width: 20%;
  height: 50px;
  margin-top: 8px;
  padding: 0 12px;
  border: 1px solid #e5e5e5;
  border-radius: 4px;
  background-color: #fff;
  font-size: 15px;
  color: #000;
  box-shadow: 0 0 0 30px #fff inset !important;
}

.button {
  box-sizing: border-box;
  width: 8%;
  height: 50px;
  padding: 14px 16px 15px;
  border: 1px solid #000;
  border-radius: 4px;
  font-weight: 700;
  color: #000;
}

</style>