<template>
  <div>
    <h3>인벤토리 (Local component)</h3>
    <label>
      <input type="checkbox" v-model="inventoryView" v-on:click="viewMyInventory">
      소지품 목록
    </label>
    <button v-on:click="equipItem()"> 장착하기 </button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">장착</th>
      </tr>
      <!-- 구매 확정이 되면 인벤토리로 들어와지게 해야함-->
      <tr v-for="(byeItem, idx) in inventoryList" :key="idx">
        <th align="center" width="40">{{ idx + 1}}</th>
        <th align="center" width="120">{{ byeItem.name }}</th>
        <th align="center" width="320">{{ byeItem.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="inventoryValue" :value="idx">
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
          inventoryList:[],
          inventoryValue:[],
    }
  },
  methods: {
    ...mapActions(['requestMyInventory']),
    async viewMyInventory (){
      if(!this.inventoryView){
        this.inventoryValue = []
        await this.requestMyInventory()
        this.inventoryList = this.$store.state.inventoryList
      }
    },
    equipItem(){
      let tmpSum = 0;

      for (let i = 0; i < this.inventoryValue.length; i++) {
        for (let j = 0; j < this.inventoryList.length; j++) {
          if (this.inventoryValue[i] === j){
            tmpSum += this.inventoryList[j].effect.atk
            break
          }
        }
      }
      this.characterStatus.itemAtk = tmpSum
      this.characterStatus.atk = this.characterStatus.defaultAtk + tmpSum + this.exchangeStatus.atk
    },
  }
}
</script>

<style scoped>

</style>