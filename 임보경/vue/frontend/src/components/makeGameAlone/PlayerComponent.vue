<template>
  <section class="playerWrap">
    <h2> 플레이어 정보 </h2>

    <div class="buttons">
<!--    <button @click="callRequestData" >로그인</button>-->
    <button @click="update">정보갱신</button>
    </div>

    <h3>스테이터스</h3>
    <ul>
      <li> LEVEL : {{ status.level }}</li>
      <li> HP : {{ status.hp }}</li>
      <li> MP : {{ status.mp }}</li>
      <li> ATK : {{ status.atk }}</li>
      <li> MONEY : {{ status.money }}</li>
      <li> EXP : {{ status.currentExpBar }} / {{ status.totalExpBar }}</li>
    </ul>


    <h3>인벤토리</h3>
    <ul>
      <li v-for="(item, index) in inventory" :key="index">
        <span>
          {{ item.name }} | {{ item.description }}
        </span>

        <span v-if="item.itemType === '포션'">
          <button>사용하기</button>
        </span>
        <span v-if="item.itemType === '무기'">
          <button @click="equipItem(index)" :key="index">장비하기</button>
        </span>
      </li>
    </ul>

    <h3>장비</h3>
    <ul>
      <li v-for="(item, index) in equipments" :key="index">
        <span>
          {{ item.name }} | {{ item.description }}
        </span>
      </li>
    </ul>
  </section>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "PlayerComponent",
  data() {
    return {
      status: '',
      inventory: '',
      equipments:'',
    }
 },


  methods : {
    ...mapActions([
        'requestCharacterStatusData',
        'requestInventoryData',
        'requestEquipmentData',
        'requestEquipItem',
    ]),

    update () {
      this.callRequestData()
      this.callMyInventory()
      this.callMyEquipment()
    },

    async callRequestData() {
      await this.requestCharacterStatusData()
      this.status = this.$store.state.characterStatusData
    },

    async callMyInventory() {
      await this.requestInventoryData()
      this.inventory = this.$store.state.inventoryData
    },

    async callMyEquipment() {
      await this.requestEquipmentData()
      this.equipments = this.$store.state.equipmentData
    },

    async equipItem(index) {
      let payload = []
      payload.push(this.inventory[index])

      alert(payload)
      await this.requestEquipItem(payload)
    },
  },

}
</script>

<style scoped>
.buttons {
  display:flex;
  justify-content: space-evenly;
}
ul {
  padding: 0 40px;
}
ul, li {
  list-style: none;
  margin: 2px 0;

}
ul li {
  display:flex;
  justify-content: space-between;
  margin: 4px 0;
}
</style>