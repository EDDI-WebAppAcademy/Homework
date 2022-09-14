<template>
  <div>
    <h3>상점</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">판매 목록
      <button v-on:click="calcBuyList()">구매 확정</button><br/>
    </label>
    <br/>

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
    <h3>캐릭터 상태 창</h3>
    <input type="checkbox" v-model="inventoryView"> 인벤토리
    <button v-on:click="useItem()">사용하기</button><br/>
    <table border="1" v-if="inventoryView"> <!-- 구입하면 인벤토리로 이동하게 하고싶은데 잘 안됨-->
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
            <input type="checkbox" v-model="inventoryListValue" :value="index">
          </label>
        </th>
      </tr>
    </table>
    <p>HP: {{characterStatus.currentHp}} / {{characterStatus.maxHp}} MP: {{characterStatus.currentMp}} / {{characterStatus.maxMp}}
      ATK: {{characterStatus.atk}} Lv: {{characterStatus.level}} 직업: {{characterStatus.currentJob}}</p>
    <p>STR: {{characterStatus.str}} INT: {{characterStatus.intelligence}} DEX: {{characterStatus.dex}}
      VIT: {{characterStatus.vit}} DEF: {{characterStatus.def}} MEN: {{characterStatus.men}}</p>
    <p>경험치: {{characterStatus.currentLevelBar}} / {{characterStatus.totalLevelBar}}</p>
    <p>소지금: {{characterStatus.money}}</p>

    <!-- 현재 컨텐츠 측면에서 몬스터가 매번 같은것이 추가되서 재미 요소가 반감됨(그러므로 랜덤 요소를 넣어야함) -->
    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button><br/>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button><br/>

    <button v-on:click="addManyMonster">랜덤 몬스터 100마리 추가하기</button><br/>

    <button v-on:click="dragonSlave">드래곤 슬레이브</button><br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{monster.name}}, HP: {{monster.hp}}
        <button v-on:click="ragnarokBlade(index)">라그나블레이드</button>
        <button v-on:click="removeMonster(index)">맵에 끼어 있는 몬스터 삭제하기</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "RpgGame",
  data() {
    return {
      shopView: false,
      inventoryView: false,
      shopList: [],
      shopListValue: [],
      inventoryList: [],
      inventoryListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', hpAmount: 200}},
        { name: 'MP 포션 I', price: 100, effect: { description: 'mp 200 회복', mpAmount: 200}},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', hpAmount: 600}},
        { name: 'MP 포션 II', price: 400, effect: { description: 'mp 600 회복', mpAmount: 600}},
        { name: '힘의 알약 I', price: 100000, effect: { description: '영구적으로 atk가 1 오름', atk: 1}},
        { name: '힘의 알약 II', price: 500000, effect: { description: '영구적으로 atk가 6 오름', atk: 6}},
        { name: '힘의 알약 III', price: 1000000, effect: { description: '영구적으로 atk가 13 오름', atk: 13}},
      ],
      monsterBooks: [
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5},
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10},
        { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20},
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20},
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10},
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40},
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50},
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50},
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80},
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50},
        { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300},
        { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50},
        { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1},
        { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100},
        { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150},
        { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500},
        { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100},
        { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700},
        { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000},
        { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000},
        { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000},
      ],
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '놀', hp: 200},
      ],
      name:"키메라",

      characterStatus: {
        level: 1,
        currentHp: 50,
        maxHp: 50,
        currentMp: 30,
        maxMp: 30,
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
        currentJob: '모험가',
      },
    }
  },
  methods: {
    shuffleShopList() {
      if(!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    calcBuyList () {
      let tmpSum = 0
      let i
      let j
      for (i = 0; i < this.shopListValue.length; i++) {
        for (j = 0; j < this.shopList.length; j++) {
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
      } else { alert("돈이 부족합니다.") }
    },
    useItem() {
      for (let i = 0; i < this.itemBooks.length; i++) {
        for (let j = 0; j < this.inventoryList.length; j++) {
          // 사용하면 계속 반복...
          if(this.inventoryList[j].name === this.itemBooks[i].name) {
            if(this.itemBooks[i].effect.hpAmount > 0) {
              this.characterStatus.currentHp += this.itemBooks[i].effect.hpAmount
              if(this.characterStatus.currentHp > this.characterStatus.maxHp) {
                this.characterStatus.currentHp = this.characterStatus.maxHp
                alert(this.itemBooks[i].effect.hpAmount + "hp 가 회복되었습니다.")
              }
            }
          } else if (this.itemBooks[i].effect.mpAmount > 0) {
            this.characterStatus.currentMp += this.itemBooks[i].effect.mpAmount
            if(this.characterStatus.currentMp > this.characterStatus.maxMp) {
              this.characterStatus.currentMp = this.characterStatus.maxMp
              alert(this.itemBooks[i].effect.mpAmount + "mp 가 회복되었습니다.")
            }
          } else {
            this.characterStatus.atk += this.itemBooks[i].effect.atk
            alert("atk가 " + this.itemBooks[i].effect.atk + " 증가하였습니다..")
          }

        }
      }
    },
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(((a,b) => { console.log("a: " + a + ", b.id: " + b.id);
        return a > b.id ? a : b.id}), 0)
    },
    addFixedMonster() {
      // let은 javascript에서 사용하는 변수 개념
      // java에서 Object와 유사
      let max = this.findCurrentMonsterListMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },
    removeMonster(index) {
      // splice는 ?
      // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index, 1) 이므로 index에 해당하는 정보 1개를 삭제한다라는 뜻입니다.
      this.monsterLists.splice(index,1)
    },
    addRandomMonster() {
      let max = this.findCurrentMonsterListMax()

      //ex) 20개라면 0~19.xxx 까지인데 floor 버림이니까 0~19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max+1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp,
      })
    },
    addManyMonster() {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },
    ragnarokBlade(index) {
      console.log("악몽의 왕의 그림자여, 하늘을 가르는 무서운 힘이여, 얼음같이 차가운 허무의 칼이여, " +
          "그대와 나 한몸이 되어 우리 이 파멸의 길을 헤쳐나가리니. " +
          "신들의 영혼조차 베어버리는 암흑의 검! 라그나 블레이드!!")
      this.monsterLists[index].hp = this.monsterLists[index].hp -
          Math.floor(this.characterStatus.atk * 70 + this.characterStatus.str * 33 + this.characterStatus.dex * 30
              + this.characterStatus.intelligence * 30)
    },
    dragonSlave() {
      console.log("황혼보다 어두운 자여, 피의 흐름보다 더 붉은 자여, 시간 속에 파묻힌" +
          "위대한 너의 이름을 걸고, 나 여기서 어둠에 맹세하노라. 우리들의 앞을 가로막고 있는" +
          "모든 어리석은 자에게 너와 내가 힘을 합쳐 그 위대한 파멸을 가져다 줄 것을!! 드래곤 슬레이브!!")
      if(this.characterStatus.currentHp <= 30) {
        alert("HP가 부족합니다!")
        // hp가 부족하면 밑에가 실행안되게 하는방법??
        // break는 안되네요;
        return
      }
      if(this.characterStatus.currentMp <= 20) {
        alert("MP가 부족합니다!")
        // 여기도 마찬가지;
        return
      }
      this.characterStatus.currentHp -= 30
      this.characterStatus.currentMp -= 20

      for (let i = 0; i < this.monsterLists.length; i++) {
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk
      }
    }
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
      this.characterStatus.currentLevelBar = parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1
      this.characterStatus.maxHp = parseInt(this.characterStatus.maxHp * 1.05)
      this.characterStatus.maxMp = parseInt(this.characterStatus.maxMp * 1.05)
      this.characterStatus.defaultAtk += 4
      this.characterStatus.atk += 4
      this.characterStatus.def += 1
      this.characterStatus.str += 3
      this.characterStatus.intelligence += 1
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1
      this.characterStatus.currentHp = this.characterStatus.maxHp
      this.characterStatus.currentMp = this.characterStatus.maxMp

      if (this.characterStatus.level < 10) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      } else if (this.characterStatus.level < 30) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if (this.characterStatus.level < 50) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.5)
      } else if (this.characterStatus.level < 70) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.6)
      } else if (this.characterStatus.level < 80) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.7)
      } else if (this.characterStatus.level < 100) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.8)
      }

    }
  }
}
</script>

<style scoped>
</style>