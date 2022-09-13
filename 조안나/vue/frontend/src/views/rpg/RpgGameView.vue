<template>
  <div>
    <item-manager/>
    <inventory-manager/>
    <exp-shop-manager/>
    <character-status/>
    <skills-manager/>
    <monster-manager/>
  </div>
</template>

<script>

import MonsterManager from "@/components/basics/MonsterManager";
import CharacterStatus from "@/components/basics/CharacterManager";
import SkillsManager from "@/components/basics/SkillsManager";
import ItemManager from "@/components/basics/ItemShopManager";
import InventoryManager from "@/components/basics/InventoryManager";
import ExpShopManager from "@/components/basics/ExpShopManager";

export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-status' : CharacterStatus,
    'skills-manager' : SkillsManager,
    'item-manager' : ItemManager,
    'inventory-manager' : InventoryManager,
    'exp-shop-manager' : ExpShopManager,
  },
}
</script>

<style scoped>

</style>