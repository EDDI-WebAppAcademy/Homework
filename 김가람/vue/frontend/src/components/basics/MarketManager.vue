<template>
  <div>
    <h3>(Local)상점</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="buyItem()">구매 확정</button>
    <table border="1" v-if="shopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">구매</th>
      </tr>
      <tr v-for="(item, index) in shopList" :key="index">
        <th align="center" width="40">{{ index + 1 }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="shopListValue" :value="index">
          </label>
        </th>
      </tr>
    </table><br/><br/>
  </div>


</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MarketManager",
  data () {
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
      // itemBooks: [
      //   { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
      //   { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
      //   { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
      //   { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
      //   { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
      //   { name: '화열검', price: 550000000, effect: { description: '무기 공격력 500', atk: 500 }},
      //   { name: '군주의검', price: 1000000000, effect: { description: '무기 공격력 1000', atk: 1000 }},
      //   { name: '아이스소드', price: 1500000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
      //   { name: '칠지도', price: 2000000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
      //   { name: '군주의휘장', price: 1000000000, effect: { description: '악세사리 공격력 1000', atk: 1000 }},
      // ],
    }
  },
  methods: {
    ...mapActions([
        'requestRandomShopItem',
        'requestBuyItem'
    ]),
    async shuffleShopList() {
      if (!this.shopView) {
        this.shopListValue = []
        await this.requestRandomShopItem()
        this.shopList = this.$store.state.randomShopItem
      }
    },
    async buyItem () {
      let calculatedPrice = this.calcBuyList()
      let selectedItems = this.checkSelectedItemList()
      let payload = { calculatedPrice, selectedItems}
      await this.requestBuyItem(payload)
    },
    checkSelectedItemList () {
      let tmpList = []
      for (let i = 0; i < this.shopListValue.length; i++) {
        tmpList.push(this.shopList[this.shopListValue[i]])
      }
      console.log(tmpList)
      return tmpList
    },
    calcBuyList () {
      let calculatedPrice = 0
      for (let i = 0; i < this.shopListValue; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            calculatedPrice += this.shopList[j].price
            break
          }
        }
      }
      console.log(calculatedPrice)
      return calculatedPrice
    }
    /*  shuffleShopList () {
        if (!this.shopView) {
          this.shopListValue = []
        }
        for (let i = 0; i < 10; i++) {
          let randIdx = Math.floor(Math.random() * this.itemBooks.length)
          this.shopList[i] = this.itemBooks[randIdx]
        }
      },*/
  }
}
</script>

<style scoped>

</style>