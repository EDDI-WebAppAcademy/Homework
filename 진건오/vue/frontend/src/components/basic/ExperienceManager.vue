<template>
  <div>
    <h3>경험치 교환 시스템 (Local Component)</h3>
    <p>경험치 1000만당 스탯치 교환이 가능합니다. (hp, mp는 50, 나머지는 5)</p>
    <label>
      <input type="checkbox" v-model="exchangeKindView" @click="expKind">
    </label>
    <button v-on:click="doExpExchange()">교환</button>
    <table border="1" v-if="exchangeKindView">
      <tr>
        <th align="center" width="120">교환 리스트</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(exchangeList, idx) in expChangeLists" :key="idx">
        <th align="center" width="120">{{ exchangeList.name }}</th>
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
import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
      exchangeKindView: false,
      expChangeLists: [],
      exchangeListValue: [],
    }
  },
  methods: {
    ...mapActions([
        'requestExperienceKind',
        'requestSelectedExpType'
    ]),
    async expKind() {
      await this.requestExperienceKind();
      this.expChangeLists = this.$store.state.expKindList;
    },
    async doExpExchange() {
      let selectedExpTypes = this.checkSelectedExpTypesList();
      let payload = {selectedExpTypes}
      await this.requestSelectedExpType(payload)
    },
    checkSelectedExpTypesList() {
      let anotherExpTypeList = [];
      for (let i = 0; i < this.exchangeListValue.length; i++) {
        anotherExpTypeList.push(this.expChangeLists[this.exchangeListValue[i]])
      }
      return anotherExpTypeList;
    },
    // doExpExchange() {
    //   /*
    //   if (this.characterStatus.currentLevelBar < 10000000) { return }
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
    //   this.characterStatus.currentLevelBar -= 10000000
    //    */
    // }
  }
}
</script>

<style scoped>
</style>