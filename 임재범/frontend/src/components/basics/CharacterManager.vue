<template>
  <div>
    <label>
      <input type="checkbox" v-model="characterStatusView" @click="getCharacterStatus">
      캐릭터 상태창 보기
    </label>
    <div v-for="(characterStatus, index) in characterStatus" :key="index">
      <div v-if="characterStatusView">
        <table>
          <tr>
            <th align="center" width="40">레벨</th>
            <th align="center" width="40">HP</th>
            <th align="center" width="40">MP</th>
            <th align="center" width="40">ATK</th>
            <th align="center" width="40">STR</th>
            <th align="center" width="40">INT</th>
            <th align="center" width="40">DEX</th>
            <th align="center" width="40">VIT</th>
            <th align="center" width="40">DEF</th>
            <th align="center" width="40">MEN</th>
            <th align="center" width="300">경험치</th>
            <th align="center" width="300">보유골드</th>
          </tr>
          <tr>
            <th align="center" width="40">{{ characterStatus.level }}</th>
            <th align="center" width="40">{{ characterStatus.hp }}</th>
            <th align="center" width="40">{{ characterStatus.mp}}</th>
            <th align="center" width="40">{{ characterStatus.atk }}</th>
            <th align="center" width="40">{{ characterStatus.str }}</th>
            <th align="center" width="40">{{ characterStatus.intelligence }}</th>
            <th align="center" width="40">{{ characterStatus.dex }}</th>
            <th align="center" width="40">{{ characterStatus.vit }}</th>
            <th align="center" width="40">{{ characterStatus.def }}</th>
            <th align="center" width="40">{{ characterStatus.men }}</th>
            <th align="center" width="300">{{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</th>
            <th align="center" width="300">{{ characterStatus.money }}</th>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {

      characterStatusView: false,
      characterStatus: [],
    }
  },
  methods: {
    ...mapActions(['requestCharacterStatus']),
    async getCharacterStatus() {
      await this.requestCharacterStatus();
      this.characterStatus = this.$store.state.characterStatus
    },
  }
}
</script>

<style scoped>
</style>