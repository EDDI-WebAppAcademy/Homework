<template>
  
  <section>
    <h2 v-if="show">상점 컴포넌트 ( 상점, 교환소 ) </h2>

    <div class="shop">
      <h3>상점</h3>
      
      <div>
        <button @click="updateShopList">상품 불러오기</button>
        <button @click="buyItems">구매하기</button>
      </div>
      
      <ul>
        <li v-for="(item, index) in shopList" :key="index">
          <span><input type="checkbox" v-bind:value="index" v-model="shopListValue"></span>
          <span>
            {{ item.name }} : {{ item.description }} | 가격 : {{ item.price }}
          </span>
        </li>
      </ul>

    </div>
  </section>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "ShopComponent",
  data() {
    return {
      show:false,
      shopList: [],
      shopListValue: [],
      flag: false,
    }
  },
  computed: {
    ...mapState([
        'availabilityOfPurchase',
    ])
  },
  methods: {
    ...mapActions([
        'requestShopItemsDataFromSpring',
        'purchaseRequest',
        'requestAvailabilityOfPurchaseFromSpring',
    ]),
    async updateShopList() {
      console.log("spring에서 아이템을 가져옵니다.")
      await this.requestShopItemsDataFromSpring()
      this.shopList = this.$store.state.shopItemList
    },

    async buyItems() {
      await this.checkInCart()
      console.log("spring에서 가능여부 확인하기.")
      await this.checkAvailability()
    },

    async checkInCart () {
      let shoppingCart = []
      for (let i = 0; i < this.shopListValue.length; i++) {
        shoppingCart.push(this.shopList[this.shopListValue[i]])
      }

      let payload = shoppingCart
      await this.purchaseRequest(payload)
    },

    async checkAvailability() {
      await this.requestAvailabilityOfPurchaseFromSpring()
      this.flag = this.$store.state.availabilityOfPurchase

      if (this.flag) {
        alert("구매 완료")
      } else {
        alert ("소지금액이 부족합니다.")
      }
    },

  },
}
</script>

<style scoped>
ul {
  padding: 0;
}
.shop li {
  width: 100%;
  list-style: none;
  display: flex;
  justify-content: space-between;
  margin: 3px auto;
  border-bottom: 1px solid #ddd;
}

.shop > div > button {
  margin: 0 5px;
}
</style>