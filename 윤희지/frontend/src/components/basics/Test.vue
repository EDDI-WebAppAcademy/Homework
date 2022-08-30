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
    </table><br/><br/>

    <h3>인벤토리</h3>
    <label>
      <input type="checkbox" v-model="inventoryView">
      소지품 보기
    </label>
    <button v-on:click="equipItem()">아이템 장착!</button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">장착</th>
      </tr>
      <tr v-for="(itemList, idx) in myInventory" :key="idx">
        <th align="center" width="40">{{ idx + 1 }}</th>
        <th align="center" width="120">{{ itemList.name }}</th>
        <th align="center" width="320">{{ itemList.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="myInventoryValue" :value="idx">
          </label>
        </th>
      </tr>
    </table><br/><br/>

    <h3>경험치 교환 시스템</h3>
    <p>경험치 1000만당 스탯치 교환이 가능합니다. (hp, mp는 50, 나머지는 5)</p>
    <button v-on:click="doExpExchange()">교환</button>
    <label>
      <input type="number" v-model="exchangeAmount" min="0" max="10" step="1">
    </label>
    <p>value: {{ exchangeAmount }}</p>
    <table border="1">
      <tr>
        <th align="center" width="120">교환 리스트</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(exchangeList, idx) in expExchangeLists" :key="idx">
        <th align="center" width="120">{{ exchangeList }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="exchangeListValue" :value="idx">
          </label>
        </th>
      </tr>
    </table><br/><br/>

    <!-- 경험치 교환 시스템
         공격력을 증가시킬 수 있는 수단 필요
         대략 경험치 1000만 당 공격력 5 증가 정도로 구현하면 적당
         그 외 스탯도 1000만 당 스탯 5 증가, mp는 1000만 당 50 증가로 작성
    <h3>경험치 교환하기</h3>
    <label>
      <input type="checkbox" v-model="expSystemView">
      경험치 교환 시스템
    </label>
    <button v-on:click="tradeExp()">경험치 교환하기!</button>
    <table border="1" v-if="expSystemView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">시스템명</th>
        <th align="center" width="320">경험치 교환 시스템 설명</th>
        <th align="center" width="80">옵션 선택</th>
      </tr>
      <tr v-for="(system, idx) in expExchangeSystemBook" :key="idx">
        <th align="center" width="40">{{ idx + 1 }}</th>
        <th align="center" width="120">{{ system.name }}</th>
        <th align="center" width="320">{{ system.effect.description }}</th>
        <th align="center" width="80">
          <label>
            <input type="checkbox" v-model="expSystemValue" :value="idx">
          </label>
        </th>
      </tr>
    </table><br/><br/>
    -->

    <p>캐릭터 상태 창</p>
    <p>HP: {{ characterStatus.currentHp }} / {{ characterStatus.hp }} MP: {{ characterStatus.currentMp }} / {{ characterStatus.mp }} </p>
    <p>ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }}
      VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>

    <!--내가 짠 부분
    <label>
      <input type="checkbox" v-model="inventoryView">
      인벤토리 목록
    </label>
    <button v-on:click="equipItems()">아이템 사용하기</button>
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">장착</th>
      </tr>
      <tr v-for="(item, index) in myInventory" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="myInventoryValue" :value="index">
          </label>
        </th>

      </tr>
    </table>
    -->

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

const HP = 0
const MP = 1
const ATK = 2
const STR = 3
const DEX = 4
const INT = 5
const DEF = 6

const HP_MP_INCREMENT = 50
const OTHER_STATS_INCREMENT = 5

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return {
      exchangeAmount: 0,
      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],
      exchangeListValue: [],
      /*내가 짠 코드(경험치 교환)
      expSystemView: false,
      expExchangeSystemBook : [
        { name: 'ATK', effect: {description: '경험치 1000만 당 ATK 5 증가', atk: 5 }},
        { name: 'STR 증가', effect: {description: '경험치 1000만 당 STR 5 증가', str: 5 }},
        { name: 'INT 증가', effect: {description: '경험치 1000만 당 INT 5 증가', intelligence: 5 }},
        { name: 'DEX 증가', effect: {description: '경험치 1000만 당 DEX 5 증가', dex: 5 }},
        { name: 'VIT 증가', effect: {description: '경험치 1000만 당 VIT 5 증가', vit: 5 }},
        { name: 'DEF 증가', effect: {description: '경험치 1000만 당 DEF 5 증가', def: 5 }},
        { name: 'MEN 증가', effect: {description: '경험치 1000만 당 MEN 5 증가', men: 5 }},
        { name: 'MP 증가', effect: {description: '경험치 1000만 당 MP 50 증가', mp: 50 }}
      ],
      expSystemValue: [],
      */
      myInventory: [],
      myInventoryValue: [],
      shopView: false,
      shopList: [],
      // 상점에서 구매 체크된 아이템의 index값들을 담는 리스트
      inventoryView: false,
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
        { name: '화열검', price: 550000000, effect: { description: '무기 공격력 500', atk: 500 }},
        { name: '군주의검', price: 1000000000, effect: { description: '무기 공격력 1000', atk: 1000 }},
        { name: '아이스소드', price: 1500000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '칠지도', price: 2000000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '군주의휘장', price: 1000000000, effect: { description: '악세사리 공격력 1000', atk: 1000 }},
      ],
      //inventoryList: [],
      //useItemValue: [],
      //usingItemList: [],
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      fixedDamage: 10,
      monsterBooks: [
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10 },
        { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 },
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 },
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 },
        { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300 },
        { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50 },
        { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1 },
        { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100 },
        { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150 },
        { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500 },
        { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100 },
        { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700 },
        { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000 },
        { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000 },
        { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 },
        { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000 }
      ],
      // 실제 전투중에 등장한 몬스터의 리스트
      monsterLists: [
        {id: 1, name: '슬라임', hp: 50},
        {id: 2, name: '고블린', hp: 100},
        {id: 3, name: '놀', hp: 200},
      ],
      exchangeStatus: {
        hp: 0,
        mp: 0,
        atk: 0,
        str: 0,
        dex: 0,
        int: 0,
        def: 0,
      },
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
    doExpExchange () {
      if (this.characterStatus.currentLevelBar < 10000000) { return }
      console.log("expValue[0]: " + this.exchangeListValue[0] + ", ATK = " + ATK)
      if (this.exchangeListValue[0] === HP) {
        this.exchangeStatus.hp += HP_MP_INCREMENT*this.exchangeAmount
      } else if (this.exchangeListValue[0] === MP) {
        this.exchangeStatus.mp += HP_MP_INCREMENT*this.exchangeAmount
      } else if (this.exchangeListValue[0] === ATK) {
        console.log("Select ATK")
        this.exchangeStatus.atk += OTHER_STATS_INCREMENT*this.exchangeAmount
        this.characterStatus.atk = this.characterStatus.defaultAtk + this.characterStatus.itemAtk + this.exchangeStatus.atk
      } else if (this.exchangeListValue[0] === STR) {
        this.exchangeStatus.str += OTHER_STATS_INCREMENT*this.exchangeAmount
      } else if (this.exchangeListValue[0] === DEX) {
        this.exchangeStatus.dex += OTHER_STATS_INCREMENT*this.exchangeAmount
      } else if (this.exchangeListValue[0] === INT) {
        this.exchangeStatus.int += OTHER_STATS_INCREMENT*this.exchangeAmount
      } else if (this.exchangeListValue[0] === DEF) {
        this.exchangeStatus.def += OTHER_STATS_INCREMENT*this.exchangeAmount
      }
      this.characterStatus.currentLevelBar -= 10000000*this.exchangeAmount
    },

    /*경험치 교환 내가 짠거
    *  tradeExp () {
      if(this.characterStatus.currentLevelBar <
          this.expSystemValue.length*10000000) {
        alert('교환할 경험치가 부족합니다!')
      } else {
        for (let i = 0; i < this.expSystemValue.length; i++) {
          for (let j = 0; j < this.expExchangeSystemBook.length; j++) {
            switch(this.expSystemValue[i]) {
              case 1:
                this.characterStatus.defaultAtk += 5
                break
              case 2:
                this.characterStatus.str += 5
                break
              case 3:
                this.characterStatus.intelligence += 5
                break
              case 4:
                this.characterStatus.dex += 5
                break
              case 5:
                this.characterStatus.vit += 5
                break
              case 6:
                this.characterStatus.def += 5
                break
              case 7:
                this.characterStatus.men += 5
                break
              case 8:
                this.characterStatus.mp += 50
                break
            }
          }
          this.characterStatus.currentLevelBar = this.characterStatus.currentLevelBar - 10000000
        }
        alert('경험치 교환 완료!')
      }
    },
    */

    equipItem () {
      let tmpSum = 0

      for (let i = 0; i < this.myInventoryValue.length; i++) {
        for (let j = 0; j < this.myInventory.length; j++) {
          if (this.myInventoryValue[i] === j) {
            tmpSum += this.myInventory[j].effect.atk
            break
          }
        }
      }
      this.characterStatus.itemAtk = tmpSum
      this.characterStatus.atk = this.characterStatus.defaultAtk + tmpSum
    },
    shuffleShopList () {
      if (!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    calcBuyList () {
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

        for (let i = 0; i < this.shopListValue.length; i++) {
          this.myInventory.push({
            name: this.shopList[this.shopListValue[i]].name,
            effect: this.shopList[this.shopListValue[i]].effect
          })
        }

        alert("물품 구매 완료!")
        // this.addItemsToInventory()
      } else {
        alert("돈없음. 돈벌어와!!")
      }
    },

    /*
    /구매한 아이템들을 인벤토리에 추가하는 기능
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
    /useInventoryItems () {
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
     */

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

    if (this.characterStatus.level === 99) { return; }

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
      this.characterStatus.intelligence += 1
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1

      if (this.characterStatus.level < 10) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.2)
      } else if (this.characterStatus.level < 30) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if (this.characterStatus.level < 50) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      } else if (this.characterStatus.level < 70) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if (this.characterStatus.level < 100) {
        this.characterStatus.totalLevelBar = this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      }
    }
    /*
    / 사용중인 아이템 목록을 돌면서 effect 추가
    for (let j = 0; j < this.usingItemList.length; j++) {
      this.characterStatus.atk += this.usingItemList[j].atk
    }
     */

  }
}
</script>

<style scoped>

</style>