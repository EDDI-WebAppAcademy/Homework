<template>
  <div>
    <h3>(Local)경험치 교환 시스템</h3>
    <p>
      경험치 1000만당 스탯 교환이 가능합니다.(hp, mp는 50씩, 나머지는 5씩)<br>
    </p>
    <button v-on:click="doExpExchange">교환</button>
    <table border="1">
      <tr>
        <th align="center" width="120">교환 리스트</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(exchangeList, idx) in expExchangeLists" :key="idx">
        <th align="center" width="120">{{ exchangeList }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="exchangeListValue" :value="idx">
          </label>
        </th>
      </tr>
    </table><br><br>
  </div>
</template>

<script>

// const HP = 0
// const MP = 1
// const ATK = 2
// const STR = 3
// const DEX = 4
// const INT = 5
// const DEF = 6
// const HP_MP_INCREMENT = 50
// const OTHER_STATS_INCREMENT = 5


import {mapActions} from "vuex";

export default {

  name: "ExperienceManager",
  data () {
    return {
      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],
      exchangeListValue: [],
    }
  },
  methods: {
    ...mapActions(['requestExpExchangeFromSpring']),
    async doExpExchange () {
      await this.requestExpExchangeFromSpring(this.exchangeListValue)
    }

    // doExpExchange () {
    //   if (this.characterStatus.currentLevelBar < 10000000) {
    //     alert("exp 부족!")
    //     return
    //   }
    //   console.log("expValue[0]: " + this.exchangeListValue[0] + ", ATK = " + ATK)
    //   if (this.exchangeListValue[0] === HP) {
    //     this.exchangeStatus.hp += HP_MP_INCREMENT
    //   } else if (this.exchangeListValue[0] === MP) {
    //     this.exchangeStatus.mp += HP_MP_INCREMENT
    //   } else if (this.exchangeListValue[0] === ATK) {
    //     console.log("Select ATK")
    //     this.exchangeStatus.atk += OTHER_STATS_INCREMENT
    //     this.characterStatus.atk = this.characterStatus.defaultAtk + this.characterStatus.itemAtk + this.exchangeStatus.atk
    //   } else if (this.exchangeListValue[0] === STR) {
    //     this.exchangeStatus.str += OTHER_STATS_INCREMENT
    //   } else if (this.exchangeListValue[0] === DEX) {
    //     this.exchangeStatus.dex += OTHER_STATS_INCREMENT
    //   } else if (this.exchangeListValue[0] === INT) {
    //     this.exchangeStatus.int += OTHER_STATS_INCREMENT
    //   } else if (this.exchangeListValue[0] === DEF) {
    //     this.exchangeStatus.def += OTHER_STATS_INCREMENT
    //   }
    //
    //   this.characterStatus.currentLevelBar -= 10000000
    //
    // },

  }
}
</script>

<style scoped>

</style>