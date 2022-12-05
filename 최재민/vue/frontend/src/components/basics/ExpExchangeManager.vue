<template>
  <div>
    <!-- 경험치 교환 시스템
         공격력을 증가시킬 수 있는 수단이 필요
         대략 경험치 1000만당 공격력 5 증가 정도로 구현하면 적합하다 판단됨
         그 외 스탯도 1000만당 스탯 5 증가, hp, mp는 1000만당 50 증가로 작성해보도록 한다. -->
    <h3>(local component)경험치 교환 시스템</h3>
    <p>경험치 1000만당 스탯치 교환이 가능합니다. (hp, mp는 50, 나머지는 5)</p>
    <button v-on:click="doExpExchange()">교환</button>
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
    </table>
  </div>
</template>

<script>
const HP = 0
const MP = 1
const ATK = 2
const STR = 3
const DEX = 4
const INT = 5
const DEF = 6
const HP_MP_INCREMENT = 50
const OTHER_STATS_INCREMENT = 5
export default {
  name: "ExpExchangeManager",
  data(){
    return{
      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],
      exchangeListValue: [],
      exchangeStatus: {
        hp: 0,
        mp: 0,
        atk: 0,
        str: 0,
        dex: 0,
        int: 0,
        def: 0,
      },
    }
  },
  methods:{
    doExpExchange () {
      if (this.characterStatus.currentLevelBar < 10000000) { return }
      console.log("expValue[0]: " + this.exchangeListValue[0] + ", ATK = " + ATK)
      if (this.exchangeListValue[0] === HP) {
        this.exchangeStatus.hp += HP_MP_INCREMENT
      } else if (this.exchangeListValue[0] === MP) {
        this.exchangeStatus.mp += HP_MP_INCREMENT
      } else if (this.exchangeListValue[0] === ATK) {
        console.log("Select ATK")
        this.exchangeStatus.atk += OTHER_STATS_INCREMENT
        this.characterStatus.atk = this.characterStatus.defaultAtk + this.characterStatus.itemAtk + this.exchangeStatus.atk
      } else if (this.exchangeListValue[0] === STR) {
        this.exchangeStatus.str += OTHER_STATS_INCREMENT
      } else if (this.exchangeListValue[0] === DEX) {
        this.exchangeStatus.dex += OTHER_STATS_INCREMENT
      } else if (this.exchangeListValue[0] === INT) {
        this.exchangeStatus.int += OTHER_STATS_INCREMENT
      } else if (this.exchangeListValue[0] === DEF) {
        this.exchangeStatus.def += OTHER_STATS_INCREMENT
      }
      this.characterStatus.currentLevelBar -= 10000000
    },
  }
}
</script>

<style scoped>

</style>