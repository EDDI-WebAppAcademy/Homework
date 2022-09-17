<template>
  <section class="shopWrap">
    <h2> 상점 </h2>

    <div class="buttons">
      <button class="btn_shop" @click="callRequestStocksData">상점 열기</button>
      <button @click="buyItems">구매하기</button>
    </div>

    <ul id="shop" class="shop" >
      <li v-for="(item,idx) in shopList" :key="idx">
        <input type="checkbox" name="checkedItem" id="checkedItem" v-model="shopListValue" :value="idx">
        {{ idx + 1 }} | {{ item.name }} | {{ item.description }} | {{ item.price }}
      </li>
    </ul>


    <div>
      <h3> 교환소 </h3>
      <p> 경험치 1000만당 HP.MP는 50, 그외는 5 포인트 교환 가능합니다.</p>
      <button @click="exchangeStatusPoint">교환하기</button>
      <ul>
        <li v-for="(status, i) in exchangeStatusList" :key="i">
          <input type="checkbox" name="checkedStatus" id="checkedStatus" v-model="exchangeStatusListValue" :value="i">
          <span>{{ status }}</span>
        </li>
      </ul>
    </div>


  </section>
</template>

<script>

import {mapActions} from "vuex";

export default {
  name: "ShopComponent",
  components: {

  },
  data() {
    return {
      shopList : [],
      shopListValue : [],
      show : false,
      exchangeStatusList: [ 'HP', 'MP', 'ATK', 'INTELLINGENCE', 'DEX', 'DEF', 'MEN' ],
      exchangeStatusListValue: [],
    }
  },
  methods: {
    ...mapActions([
        'requestStockData',
        'requestBuyItem',
    ]),

    async callRequestStocksData() {
      await this.requestStockData()
      this.shopList = this.$store.state.stockData

      // if (!this.show) {
      //   document.querySelector('#shop').style.display = "block"
      //   this.show = true
      // } else {
      //   document.querySelector('#shop').style.display = "none"
      //   this.show = false
      // }
      this.shopListValue = []
    },
    async buyItems() {
      let shoppingCart = []
      for (let i = 0; i < this.shopListValue.length; i++) {
        shoppingCart.push(this.shopList[this.shopListValue[i]])
      }

      let payload = shoppingCart
      await this.requestBuyItem(payload)
    },
    async exchangeStatusPoint() {
      let payload = this.exchangeStatusListValue
      await this.requestBuyItem(payload)
    },


  }
}
</script>

<style scoped>
.buttons {
  display:flex;
  justify-content: space-evenly;
}
.shop {
  margin-top: 30px;
  text-align: left;

}
.shop > li > input {
  margin: 0 16px 0 10px;
}
ul {
  padding: 0 20px;
}
ul, li {
  list-style: none;
  margin: 2px 0;
}
</style>