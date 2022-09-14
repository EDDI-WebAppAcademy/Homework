<template>
  <div>
    <h3>인벤토리 (Local Component)</h3>
    <label>
      <input type="checkbox" v-model="inventoryView" @click="addInventory">
      소지품 보기
    </label>
    <button v-on:click="equipItem()">아이템 장착!</button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">장착</th>
      </tr>
      <tr v-for="(itemList, idx) in myInventory" :key="idx">
        <th align="center" width="40">{{ idx + 1 }}</th>
        <th align="center" width="120">{{ itemList.itemName }}</th>
        <th align="center" width="320">{{ itemList.itemDescription }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="myInventoryValue" :value="idx">
          </label>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>

import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
      inventoryView: false,
      myInventory: [],
      myInventoryValue: [],
    }
  },
  methods: {
    ...mapActions(['requestInventoryList']),
    async addInventory() {
      await this.requestInventoryList();
      this.myInventory = this.$store.state.inventoryItemList;
    },
    // equipItem () {
    //   let tmpSum = 0
    //   for (let i = 0; i < this.myInventoryValue.length; i++) {
    //     for (let j = 0; j < this.myInventory.length; j++) {
    //       if (this.myInventoryValue[i] === j) {
    //         tmpSum += this.myInventory[j].effect.atk
    //         break
    //       }
    //     }
    //   }
    //   console.log(tmpSum)
    //   /*
    //   this.characterStatus.itemAtk = tmpSum
    //   this.characterStatus.atk = this.characterStatus.defaultAtk + tmpSum + this.exchangeStatus.atk
    //    */
    // },
  }
}
</script>

<style scoped>
</style>