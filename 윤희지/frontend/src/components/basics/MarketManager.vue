<template>
  <div>
      <h3>상점</h3>
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
      </table>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "MarketManager",
  data() {
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        // { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        // { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
      ]
    }
  },
  methods: {
    ...mapActions([
        'requestRandomGameItem',
        'requestBuyItem'
    ]),
    async shuffleShopList () {
      if (!this.shopView) {
        this.shopListValue = []
        await this.requestRandomGameItem()
        this.shopList = this.$store.state.randomShopItem
      }
    },
    async buyItem () {
      let selectedItems = this.checkSelectedItemList()
      // javascript에서 객체 만드는 건 중괄호로 하면 됨.
      let payload = { selectedItems }
      await this.requestBuyItem(payload)
    },
    // 구매 체크된 아이템들을 담는 리스트를 리턴. 리스트 요소는 당연 item 객체.
    checkSelectedItemList () {
      let tmpList = []

      for (let i = 0; i < this.shopListValue.length; i++) {
        tmpList.push(this.shopList[this.shopListValue[i]])
      }

      console.log(tmpList)
      return tmpList
    },

  },
  /*shuffleShopList () {
    if (!this.shopView) {
      this.shopListValue = []
    }

    for (let i = 0; i < 10; i++) {
      let randIdx = Math.floor(Math.random() * this.itemBooks.length)
      this.shopList[i] = this.itemBooks[randIdx]
    }
  },
  /
   */

  /* calcBuyList () {
    let tmpSum = 0

    for (let i = 0; i < this.shopListValue.length; i++) {
      for (let j = 0; j < this.shopList.length; j++) {
        if (this.shopListValue[i] === j) {
          tmpSum += this.shopList[j].price
          break;
        }
      }
    }

    console.log(tmpSum)

    if (this.characterStatus.money - tmpSum >= 0) {
      this.characterStatus.money -= tmpSum

      for (let i = 0; i < this.shopListValue.length; i++) {
        this.myInventory.push({
          name: this.shopList[this.shopListValue[i]].name,
          effect: this.shopList[this.shopListValue[i]].effect
        })
      }

      alert("물품 구매 완료!")
    } else {

      alert("돈없음. 돈벌어와!!")
    }
  }
  * */
  beforeUpdate() {

  }
}
</script>

<style scoped>

</style>