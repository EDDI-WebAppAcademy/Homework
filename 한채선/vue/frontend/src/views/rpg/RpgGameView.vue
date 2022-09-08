<template>
  <div>

    <market-manager @submit="requestBuyList"/>
    <exp-manager/>
    <character-manager/>
    <monster-manager/>

  </div>
</template>

<script>
import MonsterManager from "@/components/basic/MonsterManager";
import CharacterManager from "@/components/basic/CharacterManager";
import MarketManager from "@/components/basic/MarketManager";
import ExpManager from "@/components/basic/ExpManager";
import axios from "axios";

export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager,
    'market-manager': MarketManager,
    'exp-manager': ExpManager
  },
  methods: {
    requestBuyList(payload) {
      const { totalPrice, shopCheckedItem: shopCheckedItem } = payload
      axios.post('http://localhost:7776/31th/rpg-game-controller/buy-items',
          { totalPrice, checkedItem: shopCheckedItem })
          .then(() => {
            alert('구매 요청 완료')
          })
          .catch(() => {
            alert('오류 발생!')
          })
      console.log("requestBuyList")
    }

  }
}
</script>

<style scoped>

</style>