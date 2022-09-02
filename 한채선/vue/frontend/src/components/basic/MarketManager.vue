<template>
  <div>
    <fieldset>
      <legend><h3>상점</h3></legend>
      <label>
        <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
        판매 목록
      </label>
      <button v-on:click="calcBuyList()">구매확정</button>
      <table border="1" v-if="shopView">
        <tr>
          <th align="center" width="40">번호</th>
          <th align="center" width="120">아이템 명</th>
          <th align="center" width="160">가격</th>
          <th align="center" width="320">아이템 설명</th>
          <th align="center" width="40">구매</th>
        </tr>
        <tr v-for="(item, index) in shopList" :key="index">
          <th align="center" width="40"> {{ index }}</th>
          <th align="center" width="120"> {{ item.name }}</th>
          <th align="center" width="40"> {{ item.price }}</th>
          <th align="center" width="40"> {{ item.effect.description }}</th>
          <th align="center" width="40">
            <label>
              <input type="checkbox" v-model="shopListValue" :value="index">
            </label>
          </th>
        </tr>
      </table>
    </fieldset>
  </div>

</template>

<script>
export default {
  name: "MarketManager",
  data() {
    return {

      shopView: true,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션', price: 50, effect: { description: 'hp 200 회복', status: 'hp', amount: 200 }},
        { name: 'HP 포션2', price: 200, effect: { description: 'hp 600 회복', status: 'hp', amount: 600 }},
        { name: '낡은 검', price: 50000, effect: { description: '무기 공격력 100', status: 'atk', amount: 100 }},
        { name: '검', price: 500000, effect: { description: '무기 공격력 200', status: 'atk', amount: 200 }},
        { name: '강철 검', price: 1000000, effect: { description: '무기 공격력 300', status: 'atk', amount: 300 }},
      ]

    }
  },
  methods: {

    shuffleShopList() {
      if(!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },

    calcBuyList() {
      let tmpSum = 0


      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if(this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price
            this.checkedItem.push(this.shopList[j])
            break
          }
        }
      }

      // 인벤토리에서 바로 집어넣으면 소지금 부족으로 구매하지 못한 아이템까지 인벤토리에 들어감
      // 저장 리스트를 만들고 구매가 확정 되면 그때 넣도록 하는 방식 사용해야함

      if((this.characterStatus.money - tmpSum) >= 0) {
        this.characterStatus.money -= tmpSum
        for (let i = 0; i < this.checkedItem.length; i++) {
          this.characterStatus.inventory.push({
            name: this.shopList[this.shopListValue[i]].name,
            effect: this.shopList[this.shopListValue[i]].effect
          })
        }
        alert("물품 구매 완료!")
        this.checkedItem = []
      } else {
        alert("소지금이 부족합니다.")
        this.checkedItem = []
      }
    }

  }
}
</script>

<style scoped>

</style>