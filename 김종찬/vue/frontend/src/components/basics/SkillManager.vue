<template>
  <div>
    <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button><br/>
  <button @click="darknessDeathDestinyTypoonBlade(index)">
    Darkness Death Destiny Typoon Blade
  </button>
  </div>
</template>

<script>
export default {
  name: "SkillManager.vue",

methods: {

darknessDeathDestinyTypoonBlade (index) {
  console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
      "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!!")
  this.monsterLists[index].hp =
      this.monsterLists[index].hp -
      Math.floor(
          this.characterStatus.atk * 70 +
          this.characterStatus.str * 33 +
          this.characterStatus.dex * 30 +
          this.characterStatus.intelligence * 30
      )
},
darknessTwilightBrightnessDawnRagnaBlade () {
  console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
      "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")
  for (let i = 0; i < this.monsterLists.length; i++) {
    this.monsterLists[i].hp -= 30 * this.characterStatus.atk
  }
}
}}
</script>

<style scoped>

</style>