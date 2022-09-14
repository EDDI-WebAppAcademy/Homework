<template>
  <form @submit.prevent="onSubmit"><!--  <form v-on:submit="onSubmit">이라고 쓰지 않고 @submit.prevent 사용하면 submit 버튼 클릭해도 form 입력창에 압력했던 데이터 날아가지 않음 -->
    <table>
      <tr>
        <td>이름</td>
        <td>
          <input type="text" v-model="memberName"/>
        </td>
      </tr>
      <tr>
        <td>전공</td>
        <td>
          <input type="text" v-model="major"/>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">전송</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "DataSendTestForm",
  data () {
    return {
      memberName: '이름을 작성하세요',
      major: '전공을 적어주세요',
    }
  },
  methods: {
    onSubmit () {
      const { memberName, major } = this
      this.$emit('submit', { memberName, major })          // 하위 컴포넌트-> 상위 컴포넌트로 데이터 보낼때 emit
                                                           //여기서 하위는 DataSendTestForm.vue,  상위는 DataSendTestView.vue
    }
  }
}
</script>

<style scoped>
</style>