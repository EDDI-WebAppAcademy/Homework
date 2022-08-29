<template>
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>
      {{ item }}
    </li>
    <button v-on:click="clickHandler">클릭해봐!</button>
    <input v-model="initMsg">
    <p>{{ initMsg }}</p><br/>

    <button v-on:click="show=!show">쇼타임!</button>
    <p v-if="show">보였다 안보였다</p><br/>
    <p>{{ lists[1] }}</p><br/>
    <p>{{ lists[0] }}</p><br/>
    <p>{{ lists[2] }}</p><br/>
    <p>{{ lists[num] }}</p><br/>

    <p>{{ count }} 번 클릭했습니다.</p>
    <button v-on:click="increment">카운트 버튼</button>
    <br/>

    <h3>상점</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="calcBuyList">구매 확정</button>
    <table border="1" v-if="shopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">구매</th>
      </tr>
      <tr v-for="(item, index) in shopList" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="shopListValue" :value="index">
          </label>
        </th>
      </tr>
    </table>
    <br/>
    <label>
      <input type="checkbox" v-model="inventoryView" v-on:click="inventoryList()">
      인벤토리
    </label>
    <button v-on:click="calcUseList">아이템 사용(착용)</button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="120">사용(착용)</th>
      </tr>
      <tr v-for="(item, index) in inventoryList" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="inventoryListValue" :value="index">
          </label>
        </th>
      </tr>
    </table>

    <p>캐릭터 상태 창</p>
    <p>HP:{{ characterStatus.currentHp }}/{{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK:
      {{ characterStatus.atk }} Lv:
      {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT:{{ characterStatus.intelligence }} DEX:{{ characterStatus.dex }}
      VIT:{{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLeverBar }}</p>
    <P>소지금: {{ characterStatus.money }}</P>

    <!-- 현재 컨텐츠 측면에서 몬스터가 매번 같은것이 추가되서 재미 요소가 반감됨(랜덤 요소 필요)-->
    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button>
    <br/>
    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button>
    <br/>
    <button v-on:click="addManyMonster">랜덤 몬스터 100마리 추가하기</button>
    <br/>
    <button v-on:click="attackMonsters">라그나 블레이드</button>
    <br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP : {{ monster.hp }}
        <button v-on:click="attackMonster(index)">Darkness Death Destiny Typhoon Blade</button>
        <button v-on:click="removeMonster(index)">맵에 끼어 있는 몬스터 삭제하기</button>

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
      inventoryView: false,
      inventoryList: [],
      inventoryListValue: [],
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        {name: 'HP 포션 I', price: 50, effect: {description: 'hp 200 회복', amount: 200}},
        {name: 'HP 포션 II', price: 200, effect: {description: 'hp 600 회복', amount: 600}},
        {name: '낡은 검', price: 5000000, effect: {description: '무기 공격력 100', atk: 100}},
        {name: '검', price: 50000000, effect: {description: '무기 공격력 100', atk: 200}},
        {name: '강철 검', price: 150000000, effect: {description: '무기 공격력 100', atk: 300}}
      ],
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      monsterBooks: [
        {monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5},
        {monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10},
        {monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20},
        {monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20},
        {monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10},
        {monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40},
        {monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50},
        {monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50},
        {monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80},
        {monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50},
        {monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300},
        {monsterId: 12, name: '오우거', hp: 1000, exp: 500, dropMoney: 300},
        {monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1},
        {monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100},
        {monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150},
        {monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500},
        {monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100},
        {monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700},
        {monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000},
        {monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000},
        {monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000},
      ],
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '놀', hp: 200},
      ],
      characterStatus: {
        level: 1,
        currentHp: 50,
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defalutAtk: 10,
        atk: 10,
        str: 10,
        intelligence: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLeverBar: 10,
        currentLevelBar: 0,
        currentJob: "모험가",
        money: 0
      }
    }
  },
  methods: {
    shuffleShopList() {
      if (!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let ranIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[ranIdx]
      }
    },
    calcBuyList() {
      let tmpSum = 0
      let i
      let j


      for (i = 0; i < this.shopListValue.length; i++) {   // shopListValue: 내가 구매 체크한 아이템들의 인덱스 배열
        for (j = 0; j < this.shopList.length; j++) {  //shopList: 구매 가능 목록
          if (this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price
            break
          }
        }
      }
      if (this.characterStatus.money - tmpSum >= 0) {
        this.characterStatus.money -= tmpSum

        alert("물품 구매 완료!")
        this.inventoryList.push(this.shopList[j])
        this.shopList.splice(j, 1)
      } else {
        alert("소지 금액 부족!")
      }
    },
    calcUseList() {
      let j
      for (let i = 0; i < this.inventoryListValue.length; i++) {   // shopListValue: 내가 구매 체크한 아이템들의 인덱스 배열
        for (j = 0; j < this.inventoryList.length; j++) {  //shopList: 구매 가능 목록
          if (this.inventoryListValue[i] === j) {
            break
          }
        }
      }
      alert("사용(착용)했습니다")
      this.itemEffect(j)
      this.inventoryList.splice(j, 1)

    },
    itemEffect(idx) {
      for (let i = 0; i < this.itemBooks.length; i++) {
        if (this.inventoryList[idx] == this.itemBooks[i]) {
          if (this.itemBooks[i].effect.atk > 0) {
            this.characterStatus.atk += this.itemBooks[i].effect.atk
            alert("공격력이 " + this.itemBooks[i].effect.atk + "만큼 증가합니다.")
          } else {
            this.characterStatus.currentHp += this.itemBooks[i].effect.amount
            if (this.characterStatus.currentHp > this.characterStatus.hp) {
              this.characterStatus.currentHp = this.characterStatus.hp
              alert("HP가 최대입니다.")
            } else {
              alert("HP가 " + this.itemBooks[i].effect.amount + "만큼 회복되었습니다.")
              if (this.characterStatus.currentHp > this.characterStatus.hp) {
                this.characterStatus.currentHp = this.characterStatus.hp
              }
            }
          }
        }
      }
    },
    // clickHandler (event) { function을 이런식으로 생략가능
    clickHandler: function (event) {
      alert("이벤트 발생 " + event.target)
    },
    //increment: function (){ 이게 단축된 형태
    increment() {
      this.count += 1
    },
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          //(a,b)의 비교를 하며 반복문이 돌아가는데 a는 무조건 첫번째 인덱스인 id값을 가진다
          //b는 설정해줘야 하기 때문에 b.id
          (a, b) => {
            console.log("a: " + a + ", b.id: " + b.id);
            return a > b.id ? a : b.id
          },
          0) //a를 다시 0으로 리셋하기 위해 사용
    },
    addFixedMonster() {
      //let은 javascript에서 사용하는 변수 개념입니다.
      //java에서 Object와 유사
      let max = this.findCurrentMonsterListMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },
    removeMonster(index) {
      //새로운 개념: splice는 ?
      //리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index, 1)이므로 index에 해당하는 정보 1개를 삭제한다는 뜻입니다.
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
    addManyMonster() {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },
    attackMonster(index) {
      console.log("단일기 사용")

      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
          Math.floor(
              this.characterStatus.atk * 70 +
              this.characterStatus.str * 33 +
              this.characterStatus.dex * 30 +
              this.characterStatus.intelligence * 30
          )
    },
    attackMonsters() {
      console.log("광역기 사용")

      for (let i = 0; i < this.monsterLists.length; i++) {
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk
      }
      this.characterStatus.currentHp -= 5
      if (this.characterStatus.currentHp < 1){
        alert("HP가 0이 되어 Game Over")
        location.replace(location.href)

      }
    }
  },
  beforeUpdate() { //메소드아님, 메소드 내에 입력하지 않도록 주의
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    let i

    for (i = 0; i < this.monsterLists.length; i++) {
      if (this.monsterLists[i].hp <= 0) {
        for (let j = 0; j < this.monsterBooks.length; j++) {
          if (this.monsterLists[i].name === this.monsterBooks[j].name) {
            this.characterStatus.currentLevelBar += this.monsterBooks[j].exp
            this.characterStatus.money += this.monsterBooks[j].dropMoney
          }
        }
        this.monsterLists.splice(i, 1)
      }
    }
    while (this.characterStatus.currentLevelBar >= this.characterStatus.totalLeverBar) {
      this.characterStatus.currentLevelBar =
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLeverBar)

      this.characterStatus.level += 1
      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05)
      this.characterStatus.currentHp = this.characterStatus.hp
      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.05)
      this.characterStatus.defalutAtk += 4
      this.characterStatus.atk += 4
      this.characterStatus.def += 1
      this.characterStatus.str += 3
      this.characterStatus.intelligence += 1
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1

      if (this.characterStatus.level < 10) {
        this.characterStatus.totalLeverBar = parseInt((this.characterStatus.totalLeverBar * 1.1))
      } else if (this.characterStatus.level < 30) {
        this.characterStatus.totalLeverBar = parseInt((this.characterStatus.totalLeverBar * 1.3))
      } else if (this.characterStatus.level < 50) {
        this.characterStatus.totalLeverBar = parseInt((this.characterStatus.totalLeverBar * 1.5))
      } else if (this.characterStatus.level < 70) {
        this.characterStatus.totalLeverBar = parseInt((this.characterStatus.totalLeverBar * 1.7))
      } else if (this.characterStatus.level < 100) {
        this.characterStatus.totalLeverBar = parseInt((this.characterStatus.totalLeverBar * 1.9))

      }
    }
  }
}

</script>

<style scoped>

</style>