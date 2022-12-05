<template>
  <div>
    <h1> MAKE GAME VIEW</h1>

    <div class="wrap">
    <game-character-manager />
    <shop-component />
    </div>

  </div>
</template>

<script>
import GameCharacterManager from "@/components/makeGame/GameCharacterManager";
import ShopComponent from "@/components/makeGame/ShopComponent";

export default {
  name: "MakeGameView",
  components : {
    'game-character-manager' : GameCharacterManager,
    'shop-component' : ShopComponent,
  }
}
</script>

<style scoped>

.wrap {
  display: flex;
  justify-content: space-between;
}
.wrap > section {
  min-width: 400px;
  min-height: 200px;
  padding: 30px;
  border: 1px solid #222;
}
</style>