<template>
  <div>
    <fieldset>
      <legend><h3>상점</h3></legend>
      <label>
        <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
        판매 목록
      </label>
      <button type="submit" v-on:click="buyItems">구매확정</button>
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
          <th align="center" width="40"> {{ item.description }}</th>
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
import {mapActions} from "vuex";

export default {
  name: "MarketManager",
  data() {
    return {
      shopView: true,
      shopList: [],
      shopListValue: [],
      totalPrice: 0,
    }
  },
  methods: {

    ...mapActions([
        'requestShopItemData',
    'requestBuyItem']),

    async shuffleShopList() {
      if(!this.shopView) {
        this.shopListValue = []
        await this.requestShopItemData()
        this.shopList = this.$store.state.randomShopItem
      }
    },

    async buyItems() {
      let buyItemsList = this.requestBuyList()
      let payload = buyItemsList
      await this.requestBuyItem(payload)
      console.log('buyItems()')
    },


    requestBuyList() {
      let checkedItems = []
      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if(this.shopListValue[i] === j) {
            checkedItems.push(this.shopList[j])
            break
          }
        }
      }

      console.log("requestBuyList()")
      return checkedItems
    },


    /*

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
        },
    */

  }
}
</script>

<style scoped>

</style>