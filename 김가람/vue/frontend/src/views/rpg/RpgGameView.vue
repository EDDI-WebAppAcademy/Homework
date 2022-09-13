<template>
  <div>
    <market-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <monster-manager/>
    <skill-manager/>
  </div>
</template>

<script>
import InventoryManager from "@/components/basics/InventoryManager";
import MarketManager from "@/components/basics/MarketManager";
import ExperienceManager from "@/components/basics/ExperienceManager";
import CharacterManager from "@/components/basics/CharacterManager";
import MonsterManager from "@/components/basics/MonsterManager";

export default {
  name: "RpgGameView",
  components: {
    InventoryManager,
    MarketManager,
    ExperienceManager,
    CharacterManager,
    MonsterManager,
  },
}
</script>

<style scoped>

</style>