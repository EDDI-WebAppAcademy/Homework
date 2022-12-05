<template>

  <section>
    <h2 v-if="show">캐릭터 정보창</h2>

    <div class="status">
      <h3>Status</h3>
      <ul>
        <li>
          <span>직업 : </span>
          <span>{{ characterStatus.job }}</span>
        </li>
        <li>
          <span>Level : </span>
          <span>{{ characterStatus.level }}</span>
        </li>
        <li>
          <span>HP : </span>
          <span>{{ characterStatus.hp }}</span>
        </li>
        <li>
          <span>MP : </span>
          <span>{{ characterStatus.mp }}</span>
        </li>
        <li>
          <span>ATK : </span>
          <span>{{ characterStatus.atk }}</span>
        </li>
        <li>
          <span>STR : </span>
          <span>{{ characterStatus.str }}</span>
        </li>
        <li>
          <span>DEF : </span>
          <span>{{ characterStatus.def }}</span>
        </li>
        <li>
          <span>소지금액 : </span>
          <span>{{ characterStatus.money }}</span>
        </li>
        <li>
          <span>경험치 : </span>
          <span>
            {{ characterStatus.current_exp_bar }} |
            {{ characterStatus.total_exp_bar }}
          </span>
        </li>
      </ul>
    </div>

  </section>

</template>

<script>


import {mapState , mapActions} from "vuex";

export default {
  name: "GameCharacterManager",
  data() {
    return {
      show : false,
    }
  },
  computed : {
    ...mapState([
        'characterStatus',
    ])
  },
  methods: {
    ...mapActions([
        'requestCharacterDataFromSpring',
    ]),

  },
  async mounted() {
    console.log("캐릭터 정보 요청합니다.")
    await this.requestCharacterDataFromSpring()
  },
}
</script>

<style scoped>
  ul {
   padding: 0;
  }
  li {
    width: 200px;
    list-style: none;
    display: flex;
    justify-content: space-between;
    margin: 3px auto;
    border-bottom: 1px solid #ddd;
  }

</style>