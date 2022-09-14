<template>
  <div>
    <h3>(Local)인벤토리</h3>
    <label>
      <input type="checkbox" v-model="inventoryView" v-on:click="viewInventoryLists">
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
    </table><br/><br/>
  </div>

</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "InventoryManager",
  data () {
    return {
      inventoryView: false,
      myInventory: [],
      myInventoryValue: [],
    }
  },
  methods: {
    ...mapActions([
        'requestInventoryItems',
        'requestEquippedItems'
    ]),
    // equipItem() {
    //   if (!this.inventoryView) {
    //     this.myInventoryValue = []
    //   }
    //   this.requestInventoryItems()
    //   this.myInventory = this.$store.state.inventoryItem
    // },
    async viewInventoryLists () {
      if (!this.inventoryView) {
        this.myInventoryValue = []
        await this.requestInventoryItems()
        this.myInventory = this.$store.state.myInventory
      }
    },
    async equipItem() {
      let selectedInventoryItem = this.checkedSelectedInventoryList()
      let payload = { selectedInventoryItem }
      await this.requestEquippedItems(payload)
    },
    checkedSelectedInventoryList () {
      let tmpList = []
      for (let i = 0; i < this.myInventoryValue.length; i++) {
        tmpList.push(this.myInventory[this.myInventoryValue[i]])
      }
      console.log('expTmpList')
      return tmpList
    }

  }
}
</script>

<style scoped>

</style>