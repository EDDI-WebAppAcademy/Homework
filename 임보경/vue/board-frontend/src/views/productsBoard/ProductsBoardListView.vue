<template>
  <div class="boardList">
    <h2>Goods Shop</h2>
    <products-board-list :boards="boards"/>


    <div class="adminNavi" v-if="checkAdmin">
      <p>어드민 메뉴</p>

      <router-link :to="{ name: 'ProductRegisterView' } ">
        제품 등록
      </router-link>

    </div>
  </div>
  

</template>

<script>
import {mapActions, mapState} from "vuex";
import ProductsBoardList from "@/components/productsBoard/ProductsBoardList";


export default {
  name: "ProductsBoardListView",
  components: {
    ProductsBoardList
  },
  data() {
    return {
      checkAdmin : true,  
    }
  },
  computed : {
   ...mapState ([
      'boards'
  ])
  },
  mounted() {
    this.requestBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>
.adminNavi {
  margin: 80px auto;
  font-size: 10px;
  color: #aaa;
  text-align: center;
}

.adminNavi a {
  display: block;
  width: 56px;
  padding : 6px 8px;
  margin: 0 auto;
  text-decoration: none;
  background-color: #42b983;
  border-radius: 4px;
  font-size: 12px;
  color: #fff;
}

</style>