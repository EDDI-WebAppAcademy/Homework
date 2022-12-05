<template>
  <div align="center">
    <h2>등록 상품</h2>
    <jpa-product-board-read v-if="productBoard" :productBoard="productBoard"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'JpaProductBoardModifyView', params: { productNo } }">
      상품 정보 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'JpaProductBoardListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import JpaProductBoardRead from "@/components/productBoards/JpaProductBoardRead";

export default {
  name: "JpaProductBoardReadView",
  components: {
    JpaProductBoardRead
  },
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['productBoard'])
  },
  methods: {
    ...mapActions([
      'requestProductBoardFromSpring',
      'requestDeleteProductBoardToSpring'
    ]),
    async onDelete () {
      await this.requestDeleteProductBoardToSpring(this.productNo);
      await this.$router.push({ name: 'JpaProductBoardListView' })
    }
  },
  created() {
    this.requestProductBoardFromSpring(this.productNo)
  }
}

</script>

<style scoped>

</style>