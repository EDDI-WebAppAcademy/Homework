<template>

  <div>

    <h2>상품 페이지 입니다.</h2>


    <img src="require('@/assets/Top.PNG')" height="490" width="492"/>


    <p> 상품 이름 : </p>
    <p> 상품 가격 : </p>
    <p> 배송비 : </p>
    <p> 해당 상품 설명 : </p> <br><br><br><br><br><br><br>



    <h3>*게시판*</h3>

    <router-link :to="{ name: 'BoardProductView' }">
      게시물 작성하기
    </router-link>

    <board-product-view: boards="boards"/>

  </div>





</template>



<script>
import { mapState, mapActions } from "vuex";
import BoardProductView from "@/components/boards/BoardProductView";

export default {
  name: "BoardProductView",
  components:{
    BoardProductView

  },
  computed:{
    ...mapState([
        'boards'
    ])

  },
  mounted() {

  }


}
</script>

<style scoped>

</style>