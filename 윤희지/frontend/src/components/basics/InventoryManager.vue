<template>
  <div>
    <h3>인벤토리</h3>
    <label>
      <input type="checkbox" v-model="inventoryView" v-on:click="requestInventoryList">
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
        <th align="center" width="120">{{ itemList.name }}</th>
        <th align="center" width="320">{{ itemList.description }}</th>
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
  name: "InventoryManager",
  data() {
    return {
      myInventory: [],
      myInventoryValue: [],
      inventoryView: false
    }
  },
  methods: {
    ...mapActions([
        'requestInventoryItems',
        'requestEquippedItemLists'
    ]),
    async requestInventoryList () {
      await this.requestInventoryItems()
      this.myInventory = this.$store.state.inventoryItems
    },
    async equipItem () {
      let selectedItems = this.checkedInventoryItems()

      let payload = { selectedItems }
      // 여기서 뭔가 안먹힘? 왜 펑션이 아니라고 하는거야!!!!
      // -> mapActions에 requestEquippedItemLists를 추가하지 않아서 그랬음^^,,
      await this.requestEquippedItemLists(payload)
      // 이렇게 하고 스프링에 있는 characterStatus의 itemAtk에 스탯 추가!

    },
    checkedInventoryItems() {
      let tmpList = []

      for (let i = 0; i < this.myInventoryValue.length; i++) {
        tmpList.push(this.myInventory[this.myInventoryValue[i]])
      }
      return tmpList
    }
  },
}
</script>

<style scoped>

</style>