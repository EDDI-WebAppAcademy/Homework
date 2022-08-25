<template>
  <div>
    <h1>{{testMsg}}</h1>
      <li v-for="(item, index) in lists" :key="index">
        {{ item }}
      </li>
    <button v-on:click="clickHandler">클릭해봐!</button>
    <input v-model="initMsg">
    <p>{{initMsg}}</p><br>

    <button v-on:click="show=!show">쇼타임!</button>
    <p v-if="show">보였다 안보였다</p>
    <p v-if="show">{{ lists[1] }}</p><br>
    <p v-if="show">{{ lists[0] }}</p><br>
    <p v-if="show">{{ lists[2] }}</p><br>
    <p v-if="show">{{ lists[num] }}</p><br>

    <p>{{ count }} 번 클릭했습니다.</p>
    <p>
    <button v-on:click="increment">카운트 버튼</button>
     |
    <button v-on:click="reset">리셋 버튼</button><br>
    </p>
    <br>

    (고정)몬스터 이름: <input v-model="this.name">
    <button v-on:click="addFixedMonster">몬스터 추가하기</button><br>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가</button><br>
    <button v-on:click="addManyMonsters">몬스터 뭉치 추가</button>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{monster.name}}   |   HP: {{monster.hp}}
        <button v-on:click="removeMonster(index)">맵에 끼어있는 몬스터 삭제하기</button>
      </li>
    </ul>

  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return {
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      monsterBooks: [
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10},
        { monsterId: 3, name: '놉', hp: 200, exp: 40, dropMoney: 20},
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20},
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10},
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40},
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 100, dropMoney: 50},
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50},
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80},
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50},
        { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300},
        { monsterId: 12, name: '오거', hp: 1000, exp: 250, dropMoney: 50},
        { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1},
        { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100},
        { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150},
        { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500},
        { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100},
        { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 50},
        { monsterId: 19, name: '미노타우르스', hp: 10000, exp: 1500, dropMoney: 1000},
        { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000},
        { monsterId: 21, name: '죽음의 군주', hp: 100000, exp: 20000, dropMoney: 100000},
      ],
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '오크', hp: 150 },
      ]
    }
  },
  methods: {
    clickHandler(event) {
      alert("이벤트 발생: " + event.target)
    },

    increment() {
      this.count += 1
    },

    reset() {
      this.count = 0
    },

    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => {
            console.log("a: " + a + ", b: " + b.id);
            return a > b.id ? a : b.id
          }, 0)

    },

    addFixedMonster() {
      // let 은 js에서 사용하는 변수 개념념
      // js에서는 변수 타입을 직접 선언할 필요가 없으며 let으로 선언할 경우 알아서 판단한다
      let max = this.findCurrentMonsterListMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },

    removeMonster(index) {
      // splice : 리스트에서 index 파트를 특정 개수만큼 잘라냄
      // splice(index, 1)이므로 index에서 해당하는 정보 1개를 삭제한다는 듯
      this.monsterLists.splice(index, 1)
    },

    addRandomMonster() {
      let max = this.findCurrentMonsterListMax()
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },
    addManyMonsters(){
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    }
  }
}

</script>

<style>

</style>