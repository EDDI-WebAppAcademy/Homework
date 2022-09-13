<template>
  <div>
    <fieldset>
      <legend><h3>캐릭터 상태 창</h3></legend>
      <button @click="viewCharacterStatus">정보 갱신</button>
      <p>이름: {{characterStatusFromSpring.name}}</p>
      <p>HP: {{characterStatusFromSpring.hp}} MP: {{characterStatusFromSpring.mp }} ATK: {{ characterStatusFromSpring.atk }} LV: {{ characterStatusFromSpring.level }} 직업: {{ characterStatusFromSpring.currentJob }}</p>
      <p>STR: {{ characterStatusFromSpring.str }} INT: {{ characterStatusFromSpring.intelligence }} DEX: {{ characterStatusFromSpring.dex }} VIT: {{ characterStatusFromSpring.vit }} DEF: {{ characterStatusFromSpring.def }} MEN: {{ characterStatusFromSpring.men }}</p>
      <p>경험치: {{ characterStatusFromSpring.currentLeverBar }} | {{ characterStatusFromSpring.totalLevelBar }}</p>
      <p>소지금: {{ characterStatusFromSpring.money }}</p>
      <fieldset>
        <legend><h3>인벤토리 </h3></legend>
        <label>
          <input type="checkbox" v-model="inventoryView" @click="viewCharacterInventory">
          아이템 목록
          <button v-on:click="equipItem()">아이템 장착!</button>
        </label>
        <table border="1" v-if="inventoryView">
          <tr>
            <th align="center" width="40">번호</th>
            <th align="center" width="120">아이템 명</th>
            <th align="center" width="320">아이템 설명</th>
            <th align="center" width="80">사용</th>
            <th align="center" width="40">장착</th>
          </tr>
          <tr v-for="(inventoryItems, index) in characterInventory" :key="index">
            <th align="center" width="40"> {{ index + 1 }}</th>
            <th align="center" width="120"> {{ inventoryItems.name }}</th>
            <th align="center" width="320"> {{ inventoryItems.description }}</th>
            <th align="center" width="80">
              <button v-on:click="useItemInInventory(index)">아이템 사용</button>
            </th>
            <th align="center" width="40">
              <label>
                <input type="checkbox" v-model="inventoryUsingItemValue" :value="index">
              </label>
            </th>
          </tr>
        </table>
      </fieldset>
    </fieldset>
  </div>
</template>

<script>

import { mapActions } from "vuex";

export default {
  name: "CharacterManager",
  mounted() {
    this.viewCharacterStatus()
  },

  data() {
    return {
      inventoryView: true,
      characterStatusFromSpring: null,
      characterInventory: [],
      inventoryUsingItemValue: [],
    }
  },

  methods: {

    ...mapActions(['requestCharacterStatus', 'requestCharacterInventory']),
    async viewCharacterStatus() {
      console.log('viewCharacterStatus')
      await this.requestCharacterStatus()
      this.characterStatusFromSpring = this.$store.state.characterStatus
    },

    async viewCharacterInventory() {
      console.log('viewCharacterInventory')
      await this.requestCharacterInventory()
      this.characterInventory = this.$store.state.characterInventory
    },

    equipItem() {
      let tmpSum = 0
      this.characterStatus.itemAtk = 0


      for (let i = 0; i < this.characterStatus.inventoryValue.length; i++) {
        for (let j = 0; j < this.characterStatus.inventory.length; j++) {
          if(this.characterStatus.inventoryValue[i] == j) {
            tmpSum += this.characterStatus.inventory[j].effect.amount
            break
          }
        }
      }

      this.characterStatus.itemAtk = tmpSum
      this.characterStatus.atk = (this.characterStatus.defaultAtk + this.characterStatus.itemAtk)

    },

    useItemInInventory(index){

      // switch문으로 바꾸는게 더 조을것같음 -> 잘됨~
      // 공통 코드는 메소드로 빼기(애매하네...)


      switch (this.characterStatus.inventory[index].effect.status) {
        case 'atk':
          this.characterStatus.itemAtk += this.characterStatus.inventory[index].effect.amount
          this.characterStatus.inventory.splice(index, 1)
          alert('아이템 효과 적용 완료!')
          break
        case 'hp':
          this.characterStatus.hp += this.characterStatus.inventory[index].effect.amount
          this.characterStatus.inventory.splice(index, 1)
          alert('아이템 효과 적용 완료!')
          break
        default:
          alert('해당사항 없음')
      }
    },


  },

  beforeUpdate() {

  }

}
</script>

<style scoped>

</style>