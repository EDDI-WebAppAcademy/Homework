<template>
  <div>
    <h1> Make Game Alone ~ 시도중 ~ </h1>
    <div class="wrapper">
      <player-component />
      <stage-component />
      <shop-component />
    </div>
  </div>
</template>

<script>
import PlayerComponent from "@/components/makeGameAlone/PlayerComponent";
import StageComponent from "@/components/makeGameAlone/StageComponent";
import ShopComponent from "@/components/makeGameAlone/ShopComponent";

export default {
  name: "MakeGameAloneView",
  components: {
    PlayerComponent,
    StageComponent,
    ShopComponent,
  }
}
</script>

<style scoped>
  div.wrapper {
    display:flex;
    justify-content: space-between;
    align-items: flex-start;
    margin: 0 5px;
  }

  div.wrapper > section {
    width: 33%;
    min-width: 360px;
    min-height: 600px;
    margin: 0 5px;
    border:1px solid #222;
  }
</style>