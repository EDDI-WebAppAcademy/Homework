<template>
  <div>
    <market-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <monster-manager/>
  </div>
</template>

<script>
import CharacterManager from "@/components/basics/CharacterManager";
import MonsterManager from "@/components/basics/MonsterManager";
import MarketManager from "@/components/basics/MarketManager";
import InventoryManager from "@/components/basics/InventoryManager";
import Experience from "@/components/basics/Experience";

export default {
  name: "RpgGameView",
  components: {
    'market-manager': MarketManager,
    'monster-manager':MonsterManager,
    'character-manager': CharacterManager,
    'inventory-manager': InventoryManager,
    'experience-manager' : Experience
  }
}
</script>

<style scoped>

</style>