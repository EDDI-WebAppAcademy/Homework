<template>
  <div>
    <character-status-manager/>
    <market-manager/>
    <inventory-manager/>
    <monster-manager/>
    <exp-exchange-manager/>
  </div>
</template>

<script>
import MonsterManager from "@/components/basics/MonsterManager";
import CharacterStatusManager from "@/components/basics/CharacterStatusManager";
import MarketManager from "@/components/basics/MarketManager";
import InventoryManager from "@/components/basics/InventoryManager";
import ExpExchangeManager from "@/components/basics/ExpExchangeManager";
export default {
  name: "RpgGameView",
  components: {
    'exp-exchange-manager':ExpExchangeManager,
    'inventory-manager':InventoryManager,
    'market-manager':MarketManager,
    'character-status-manager':CharacterStatusManager,
    'monster-manager': MonsterManager,
  },
}
</script>

<style scoped>
</style>