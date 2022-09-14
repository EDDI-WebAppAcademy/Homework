<template>
  <div>
    <shop-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <monster-manager/>
  </div>
</template>

<script>
import MonsterManager from "@/components/basic/MonsterManager";
import CharacterManager from "@/components/basic/CharacterManager";
import ShopManager from "@/components/basic/ShopManager";
import InventoryManager from "@/components/basic/InventoryManager";
import ExperienceManager from "@/components/basic/ExperienceManager";
export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager,
    'shop-manager': ShopManager,
    'inventory-manager': InventoryManager,
    'experience-manager': ExperienceManager,
  },
}
</script>

<style scoped>
</style>