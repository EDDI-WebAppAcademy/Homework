<template>
  <!--이벤트 매핑만 시키는중. 화면에 어떤 것들을 보여줄지만 나옴-->
  <!--컴포넌트가 분리되면서 필요한 부분만 집중할 수 있다-->
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>
      {{ item }}
    </li>
    <button v-on:click="clickHandler">클릭해봐</button>
    <input v-model="initMsg">
    <p>{{ initMsg }}</p><br/>

    <button v-on:click="show=!show">쇼타임!</button>
    <p v-if="show">보였다 안보였다</p><br/>
    <p>{{ lists[1] }}</p><br/>
    <p>{{ lists[0] }}</p><br/>
    <p>{{ lists[2] }}</p><br/>
    <p>{{ lists[num] }}</p><br/>


    <!-- 똑같은 몬스터만 추가돼서 노잼. 랜덤 몬스터가 나오는 게 잼날것이다다 -->
    <p>{{ count }} 번 클릭했습니다.</p><br/>
    <button v-on:click="increment">카운트 버튼</button>
    <br/>

    <h3>상점</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="calcBuyList()">구매 확정</button>
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

    <p>캐릭터 상태 창</p>
    <p>HP: {{ characterStatus.currentHp }} / {{ characterStatus.hp }} MP: {{ characterStatus.currentMp }} / {{ characterStatus.mp }} </p>
    <p>ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT:
      {{ characterStatus.vit }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>

    <label>
      <input type="checkbox" v-model="inventoryView">
      인벤토리 목록
    </label>
    <button v-on:click="useInventoryItems()">아이템 사용하기</button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">사용</th>
      </tr>
      <tr v-for="(item, index) in inventoryList" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="useItemValue" :value="index">
          </label>
        </th>

      </tr>
    </table>
   <p></p>

    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">(고정)몬스터 추가하기</button>
    <br/>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button>
    <br/>

    <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button>

    <button v-on:click="brightnessDawnRagnaBlade">새벽보다 찬란한 라그나 블레이드...</button>
    <br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
        <button v-on:click="removeMonster(index)">맵에 끼어있는 몬스터 삭제하기</button>
        <button v-on:click="darknessBlade(index)">Darkness Blade</button>
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
      shopView: false,
      shopList: [],
      // 상점에서 구매 체크된 아이템의 index값들을 담는 리스트
      shopListValue: [],
      itemBooks: [
        {name: 'HP 포션 I', price: 50, effect: {description: 'hp 200 회복', amount: 200}},
        {name: 'HP 포션 II', price: 200, effect: {description: 'hp 600 회복', amount: 600}},
        {name: '낡은 검', price: 5000000, effect: {description: '무기 공격력 100', atk: 100}},
        {name: '검', price: 50000000, effect: {description: '무기 공격력 200', atk: 200}},
        {name: '강철 검', price: 150000000, effect: {description: '무기 공격력 100', atk: 100}},
      ],
      inventoryView: false,
      inventoryList: [],
      useItemValue: [],
      usingItemList: [],
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      fixedDamage: 10,
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
        {monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50},
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
      // 실제 전투중에 등장한 몬스터의 리스트
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '놀', hp: 200},
      ],
      characterStatus: {
        level: 1,
        currentHp: 50,
        hp: 50,
        currentMp: 30,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        intelligence: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLevelBar: 10,
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가'
      },
    }
  },
  methods: {
    shuffleShopList() {
      if (!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    //물건값 계산만 하는 애
    calcBuyList() {
      let tmpSum = 0

      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price
            break;
          }
        }
      }

      if (this.characterStatus.money - tmpSum >= 0) {
        this.characterStatus.money -= tmpSum

        alert("물품 구매 완료!")
        this.addItemsToInventory()
      } else {
        alert("돈없음. 돈벌어와!!")
      }
    },

    //구매한 아이템들을 인벤토리에 추가하는 기능
    addItemsToInventory () {
      this.useItemValue =[]

        for (let i = 0; i < this.shopListValue.length; i++) {
          for (let j = 0; j < this.shopList.length; j++) {
            if (this.shopListValue[i] === j) {
              this.inventoryList.push(this.shopList[j])
              break;
            }
          }
        }
    },
    // 선택한 아이템 사용 기능
    useInventoryItems () {
      alert("선택한 아이템을 사용합니다!")

      for (let i = 0; i < this.useItemValue.length; i++) {
        for (let j = 0; j < this.inventoryList.length; j++) {
          if(this.useItemValue[i] === j) {
            // 검이냐 포션이냐 분기
            if(this.inventoryList[j].name.includes('포션')) {
              // 포션이면 사용하고 없애기.
              this.characterStatus.currentHp += this.inventoryList[j].effect.amount
              this.inventoryList.splice(j,1)
              // 포션 쓰고 currentHp가 hp를 넘어가지 않도록 조정
              if(this.characterStatus.currentHp > this.characterStatus.hp) {
                this.characterStatus.currentHp = this.characterStatus.hp
              }
            } else {
              this.usingItemList.push(this.inventoryList[j])
            }
          }
        }
      }
    },
    // 편의에 따라서 두가지 스타일 중 골라 쓸 수 있음
    // clickHandler (event) {
    clickHandler: function (event) {
      alert("이벤트 발생: " + event.target)
    },
    // increment: function () {
    increment() {
      this.count += 1
    },
    findCurrentMonsterListsMax() {
      return this.monsterLists.reduce(
          (a, b) => {
            console.log("a: " + a + ", b.id: " + b.id);
            return a > b.id ? a : b.id
          },
          0)
    },
    addFixedMonster() {
      // let은 javascript에서 사용하는 변수 개념.
      // java에서 Object와 유사
      let max = this.findCurrentMonsterListsMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },
    removeMonster(index) {
      // 새로운 개념: splice는?
      // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index, 1)이므로 index에 해당하는 정보 1개를 삭제한다는 뜻.
      this.monsterLists.splice(index, 1)
    },
    addRandomMonster() {
      let max = this.findCurrentMonsterListsMax()
      //Math.floor 하면 소수점 밑 버리는듯..
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },
    addManyRandomMonster() {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },

    darknessBlade(index) {
      console.log("Darkness Blade!")

      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
          Math.floor(
              this.characterStatus.atk * 70 +
              this.characterStatus.str * 33 +
              this.characterStatus.dex * 30 +
              this.characterStatus.intelligence * 30
          )
    },

    brightnessDawnRagnaBlade() {
      console.log("라그나 블레이드...!")
      for (let i = 0; i < this.monsterLists.length; i++) {
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk
      }
    },
    // 과제: 인벤토리 구현이랑 아이템 장착 구현
  },

  beforeUpdate() {
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

    while (this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar) {
      this.characterStatus.currentLevelBar =
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1
      this.characterStatus.currentHp = parseInt(this.characterStatus.hp * 1.05)
      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05)
      this.characterStatus.currentMp = parseInt(this.characterStatus.mp * 1.02)
      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.02)
      this.characterStatus.defaultAtk += 4
      this.characterStatus.atk += 4
      this.characterStatus.def += 1
      this.characterStatus.str += 3
      this.characterStatus.intelligence += 3
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1

      if (this.characterStatus.level < 10) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      } else if (this.characterStatus.level < 30) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.2)
      } else if (this.characterStatus.level < 60) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      }
    }
    // 사용중인 아이템 목록을 돌면서 effect 추가
    for (let j = 0; j < this.usingItemList.length; j++) {
      this.characterStatus.atk += this.usingItemList[j].atk
    }
  }
}
</script>

<style scoped>

</style>