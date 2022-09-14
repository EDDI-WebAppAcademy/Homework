<template>
  <div>
    <h3>경험치 상점(Local Component)</h3>
    <label>
      <input type="checkbox" v-model="expShopView">
      경험치 교환 목록
    </label>
    <button v-on:click="expSwap()"> 경험치 교환 </button>
    <table border="1" v-if="expShopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="100">필요 경험치</th>
        <th align="center" width="180">교환 스탯</th>
        <th align="center" width="180">설명</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(swap, index) in expSwapList" :key="index">
        <th align="center" width="40">{{ index + 1}}</th>
        <th align="center" width="100">{{ swap.expValue }}</th>
        <th align="center" width="180">{{ swap.name }}</th>
        <th align="center" width="180">{{ swap.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="expSwapValue" :value="index">
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
  name: "CharacterManager",
  data(){
    return {
      expShopView: false,
      expSwapList:[
        {name: 'HP', expValue: 10000000, effect:{description: "체력 50 증가"}},
        {name: 'MP', expValue: 10000000, effect:{description: "마나 50 증가"}},
        {name: 'atk', expValue: 10000000, effect:{description: "공력력 5증가"}},
        {name: 'str', expValue: 10000000, effect:{description: "마력 5증가"}},
        {name: 'dex', expValue: 10000000, effect:{description: "dex 5증가"}},
        {name: 'int', expValue: 10000000, effect:{description: "int 5증가"}},
        {name: 'def', expValue: 10000000, effect:{description: "def 5증가"}},
      ],
      expSwapValue:[],
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
  methods: {
    expSwap(){
      let expSum = 0;

      for (let i = 0; i < this.expSwapValue.length; i++) {
        for (let j = 0; j < this.expSwapList.length; j++) {
          console.log("expValue[" + i + "] : " + this.expSwapValue )

          if (this.expSwapValue[i] === HP) {
            console.log("Select HP")
            this.exchangeStatus.hp += HP_MP_INCREMENT
            this.characterStatus.hp = this.characterStatus.hp + this.exchangeStatus.hp
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === MP) {
            console.log("Select MP")
            this.exchangeStatus.mp += HP_MP_INCREMENT
            this.characterStatus.mp = this.characterStatus.mp + this.exchangeStatus.mp
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === ATK) {
            console.log("Select ATK")
            this.exchangeStatus.atk += OTHER_STATS_INCREMENT
            this.characterStatus.atk = this.characterStatus.defaultAtk + this.characterStatus.itemAtk + this.exchangeStatus.atk
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === STR) {
            console.log("Select STR")
            this.exchangeStatus.str += OTHER_STATS_INCREMENT
            this.characterStatus.str = this.characterStatus.str + this.exchangeStatus.str
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === DEX) {
            console.log("Select DEX")
            this.exchangeStatus.dex += OTHER_STATS_INCREMENT
            this.characterStatus.dex = this.characterStatus.dex + this.exchangeStatus.dex
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === INT) {
            console.log("Select INT")
            this.exchangeStatus.int += OTHER_STATS_INCREMENT
            this.characterStatus.int = this.characterStatus.int + this.exchangeStatus.int
            expSum += this.expSwapList[j].expValue
          }

          if (this.expSwapValue[i] === DEF) {
            console.log("Select DEF")
            this.exchangeStatus.def += OTHER_STATS_INCREMENT
            this.characterStatus.def = this.characterStatus.def + this.exchangeStatus.def
            expSum += this.expSwapList[j].expValue
          }
          break
        }
      }

      if(this.characterStatus.currentLevelBar > expSum){
        this.characterStatus.currentLevelBar = this.characterStatus.currentLevelBar - expSum
        alert("경험치 교환이 완료되었습니다.")
      }else {
        alert("경험치가 부족합니다.")
      }
    },
  }
}
</script>

<style scoped>

</style>