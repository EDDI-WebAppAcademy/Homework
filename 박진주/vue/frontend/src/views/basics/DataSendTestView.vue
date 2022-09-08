<template>
  <div>
    <h2>vue에서 spring으로 요청시 데이터 전송 테스트</h2>
    <data-send-test-form @submit="onSubmit"/>          <!--하위 컴포넌트 커스텀 태그 -->
  </div>
</template>

<script>
import DataSendTestForm from "@/components/basics/DataSend/DataSendTestForm";
import axios from "axios";
export default {
  name: "DataSendTestView",
  components: {
    DataSendTestForm            // 하위 컴포넌트
  },
  methods: {
    onSubmit (payload) {
      const { memberName, major } = payload
                        // 스프링 postMapping()의 url
      axios.post('http://localhost:7777/32th/vue2spring/receive-test',
          { memberName, major })
          .then(() => {
            alert('전송 요청 완료')
          })
          .catch(() => {
            alert('문제 발생!')
          })
    }
  }
}
</script>

<style scoped>
</style>