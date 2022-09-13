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


export default {
  name: "ExperienceManager",
  data () {
    return {
      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],
      exchangeListValue: [],
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>