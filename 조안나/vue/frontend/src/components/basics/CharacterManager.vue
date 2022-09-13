<template>
<div>
  <h3>캐릭터 상태 창(Local Component)</h3>
  <button v-on:click="characterStatusInfo">UPDATE</button>
  <p>HP: {{ characterStatus.hp }}  MP: {{ characterStatus.mp }}
    ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
  <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }}
    DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }}
    DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
  <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
  <p>소지금: {{ characterStatus.money }}</p>
</div>
</template>

<script>
import MonsterManager from "@/components/basics/MonsterManager";
import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data() {
    return {
      characterStatus: [],
      // characterStatus: {
      //   level: 1,
      //   hp: 50,
      //   mp: 30,
      //   itemAtk: 0,
      //   defaultAtk: 10,
      //   atk: 10,
      //   str: 10,
      //   intelligence: 10,
      //   dex: 10,
      //   vit: 10,
      //   def: 10,
      //   men: 0,
      //   totalLevelBar: 10,
      //   currentLevelBar: 0,
      //   money: 0,
      //   currentJob: '모험가'
      // },
    }
  },
  methods: {
    ...mapActions(['requestCharacterStatus']),
    async characterStatusInfo() {
      console.log("vue에서 characterStatusInfo()동작 중")
      await this.requestCharacterStatus()
      this.characterStatus = this.$store.state.characterStatus
    }
  },
  beforeUpdate() { //얘는 메소드 밖에다가 선언해야함!
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")
    let i
    for (i = 0; i < MonsterManager.data().monsterLists.length; i++) {
      if (MonsterManager.data().monsterLists[i].hp <= 0) {
        for (let j = 0; j < MonsterManager.data().monsterBooks.length; j++) {
          if (MonsterManager.data().monsterLists[i].name === MonsterManager.data().monsterBooks[j].name) {
            this.characterStatus.currentLevelBar += MonsterManager.data().monsterBooks[j].exp * 20
            this.characterStatus.money += MonsterManager.data().monsterBooks[j].dropMoney * 5
          }
        }
        MonsterManager.data().monsterLists.splice(i, 1)
      }
    }

    while(this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar){
      if (this.characterStatus.level === 99) { return }

      this.characterStatus.currentLevelBar =
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1
      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05) + this.exchangeStatus.hp
      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.05) + this.exchangeStatus.mp
      this.characterStatus.defaultAtk += 4
      this.characterStatus.atk = this.characterStatus.defaultAtk + this.exchangeStatus.atk
      this.characterStatus.def += 1 + this.exchangeStatus.def
      this.characterStatus.str += 3 + this.exchangeStatus.str
      this.characterStatus.intelligence += 1 + this.exchangeStatus.int
      this.characterStatus.dex += 2 + this.exchangeStatus.dex
      this.characterStatus.vit += 3
      this.characterStatus.men += 1

      // 레벨에 따른 렙업 경험치 통 증가하도록 관리하기
      if (this.characterStatus.level < 10) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.2)
      } else if (this.characterStatus.level < 30) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if (this.characterStatus.level < 50) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      } else if (this.characterStatus.level < 70) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if (this.characterStatus.level < 100) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      }
    }
  },
}
</script>

<style scoped>

</style>