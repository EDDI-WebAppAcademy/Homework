<template>
  <div>
    <p>캐릭터 상태 창 (Local Component)</p>
    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>
  </div>
</template>

<script>
export default {
  name: "CharacterManager",
  data () {
    return {
      characterStatus: {
        level: 1,
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        intelligence: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLevelBar: 10,
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가'
      },
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>





<!--!&#45;&#45;<template>&ndash;&gt;-->
<!--  <div>-->
<!--    <p>캐릭터 상태 창</p>-->
<!--    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }}-->
<!--      직업: {{ characterStatus.currentJob }}</p>-->
<!--    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }}-->
<!--      VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>-->
<!--    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>-->
<!--    <p>소지금: {{ characterStatus.money }}</p>-->


<!--    <h3>경험치 교환 시스템</h3>-->
<!--    <p>경험치 1000만당 스탯치 교환이 가능합니다. (hp, mp는 50, 나머지는 5)</p>-->

<!--    <button @click="doExpExchange">교환</button>-->
<!--    <table border="1">-->
<!--      <tr>-->
<!--        <th align="center" width="120">교환 리스트</th>-->
<!--        <th align="center" width="40">교환</th>-->
<!--      </tr>-->
<!--      <tr v-for="(exchangeList, idx) in expExchangeLists" :key="idx">-->
<!--        <th align="center" width="120">{{ exchangeList }}</th>-->
<!--        <th align="center" width="40">-->
<!--          <label>-->
<!--            <input type="checkbox" v-model="exchangeListValue" :value="idx">-->
<!--          </label>-->
<!--        </th>-->
<!--      </tr>-->
<!--    </table>-->
<!--    <br/>-->
<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--const HP = 0-->
<!--const MP = 1-->
<!--const ATK = 2-->
<!--const STR = 3-->
<!--const DEX = 4-->
<!--const INT = 5-->
<!--const DEF = 6-->
<!--const HP_MP_INCREMENT = 50-->
<!--const OTHER_STATS_INCREMENT = 5-->

<!--export default {-->
<!--  name: "CharacterManager",-->
<!--  data() {-->
<!--    return {-->
<!--      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],-->
<!--      exchangeListValue: [],-->
<!--      exchangeStatus: {-->
<!--        hp: 0,-->
<!--        mp: 0,-->
<!--        atk: 0,-->
<!--        str: 0,-->
<!--        dex: 0,-->
<!--        int: 0,-->
<!--        def: 0,-->
<!--      },-->
<!--      characterStatus: {-->
<!--        level: 1,-->
<!--        hp: 50,-->
<!--        mp: 30,-->
<!--        itemAtk: 0,-->
<!--        defaultAtk: 10,-->
<!--        atk: 10,-->
<!--        str: 10,-->
<!--        intelligence: 10,-->
<!--        dex: 10,-->
<!--        vit: 10,-->
<!--        def: 10,-->
<!--        men: 0,-->
<!--        totalLevelBar: 10,-->
<!--        currentLevelBar: 9999999999,-->
<!--        money: 0,-->
<!--        currentJob: '모험가'-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    doExpExchange () {-->
<!--      if (this.characterStatus.currentLevelBar < 10000000) { return }-->
<!--      console.log("expValue[0]: " + this.exchangeListValue[0] + ", ATK = " + ATK)-->
<!--      if (this.exchangeListValue[0] === HP) {-->
<!--        this.exchangeStatus.hp += HP_MP_INCREMENT-->
<!--      } else if (this.exchangeListValue[0] === MP) {-->
<!--        this.exchangeStatus.mp += HP_MP_INCREMENT-->
<!--      } else if (this.exchangeListValue[0] === ATK) {-->
<!--        console.log("Select ATK")-->
<!--        this.exchangeStatus.atk += OTHER_STATS_INCREMENT-->
<!--        this.characterStatus.atk = this.characterStatus.defaultAtk + this.characterStatus.itemAtk + this.exchangeStatus.atk-->
<!--      } else if (this.exchangeListValue[0] === STR) {-->
<!--        this.exchangeStatus.str += OTHER_STATS_INCREMENT-->
<!--      } else if (this.exchangeListValue[0] === DEX) {-->
<!--        this.exchangeStatus.dex += OTHER_STATS_INCREMENT-->
<!--      } else if (this.exchangeListValue[0] === INT) {-->
<!--        this.exchangeStatus.int += OTHER_STATS_INCREMENT-->
<!--      } else if (this.exchangeListValue[0] === DEF) {-->
<!--        this.exchangeStatus.def += OTHER_STATS_INCREMENT-->
<!--      }-->
<!--      this.characterStatus.currentLevelBar -= 10000000-->
<!--    }-->
<!--  },-->
<!--  beforeUpdate() {-->
<!--    if (this.characterStatus.level == 99) { return }-->
<!--    while (this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar) {-->
<!--      if (this.characterStatus.level == 99) { return }-->
<!--      this.characterStatus.currentLevelBar =-->
<!--          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)-->
<!--      this.characterStatus.level += 1-->
<!--      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05)-->
<!--      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.05)-->
<!--      this.characterStatus.defaultAtk += 4-->
<!--      this.characterStatus.atk = this.characterStatus.defaultAtk + this.exchangeStatus.atk-->
<!--      this.characterStatus.def += 1-->
<!--      this.characterStatus.str += 3-->
<!--      this.characterStatus.intelligence += 1-->
<!--      this.characterStatus.dex += 2-->
<!--      this.characterStatus.vit += 3-->
<!--      this.characterStatus.men += 1-->
<!--      if (this.characterStatus.level < 10) {-->
<!--        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.2)-->
<!--      } else if (this.characterStatus.level < 30) {-->
<!--        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)-->
<!--      } else if (this.characterStatus.level < 50) {-->
<!--        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)-->
<!--      } else if (this.characterStatus.level < 70) {-->
<!--        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)-->
<!--      } else if (this.characterStatus.level < 100) {-->
<!--        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--table {-->
<!--  margin: 16px auto;-->
<!--}-->
<!--</style>-->