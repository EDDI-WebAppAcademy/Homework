<template>
<div>
  <fieldset>
    <legend><h3>경험치 교환소 (lv99~ Open) </h3></legend>
    <p>누적된 경험치를 추가 스테이터스 수치로 교환 가능합니다.</p>
    <p>1회당 소모 경험치: 100000000
    </p>
    <label>
      <input type="checkbox" v-model="exchangeStatusListView">
      경험치 목록
      <button v-on:click="exchangeExpToStatus()">교환</button>
    </label>
    <table border="1" v-if="exchangeStatusListView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">스테이터스</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(exchangeStatus, idx) in exchangeStatusList" :key="idx">
        <th align="center" width="40">{{ idx + 1 }}</th>
        <th align="center" width="120">{{ exchangeStatus }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="exchangeStatusValue" :value="idx">
          </label>
        </th>
      </tr>
    </table>
  </fieldset>
</div>
</template>

<script>
import {mapActions} from "vuex";
export default {
  name: "ExpManager",
  data() {
    return {
      exchangeStatusList : ["HP", "MP", "ATK", "STR", "DEX", "INT", "DEF", "VIT", "MEN"],
      exchangeStatusListView: true,
      exchangeStatusValue: [],
    }
  },
  mounted() {

  },
  methods: {

    ...mapActions(['requestExchangingExpToStatus']),

   async exchangeExpToStatus() {
      console.log('exchangeExpToStatus()')
      await this.requestExchangingExpToStatus( this.exchangeStatusValue )
    },


    /*   exchangingStatus(){
         let tmpExp = 0;

         for (let i = 0; i < this.exchangeStatusValue.length; i++) {
           for (let j = 0; j < this.exchangeStatusList.length; j++) {
             if(this.exchangeStatusValue[i] == j){
               tmpExp += 10000
               // 테스트를 위해 필요한 경험치 수치를 조정하였음
               break
             }
           }
         }

         if (this.characterStatus.currentLevelBar - tmpExp >= 0) {
           this.characterStatus.currentLevelBar -= tmpExp
           for (let i = 0; i < this.exchangeStatusValue.length; i++) {
             this.addExchangedStatus(this.exchangeStatusList[this.exchangeStatusValue[i]].status)
           }
         }
       },*/


  }
}
</script>

<style scoped>

</style>