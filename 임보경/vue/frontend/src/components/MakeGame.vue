<template>
<div>
  <h1>RPG GAME</h1>
  <div class="wrap">
    <section class="character">
      <h2>캐릭터 창</h2>
      <ul class="statusList">
        <li v-for="(status, index) in characterStatus" :key="index">
          {{ status.statusName }} : {{ status.stat }}    ( {{ status.addStat }} )
        </li>
      </ul>

      <p> 인벤토리 </p>
      <ul>
        <li v-for="(item, index) in inventory" :key="index">
          {{ item.name }}
          <button v-on:click="equipItem(index)"> 사용하기 </button>
        </li>
      </ul>

      <p> 장비창 </p>
      <ul>
        <li v-for="(item, index) in equipments" :key="index">
          {{ item.name }} - ( {{ item.effect.description }} )
        </li>
      </ul>
    </section>

    <section class="stage">
      <h2>스테이지</h2>
      <div>
        <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button><br/>
        <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button><br/>
        <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button>
      </div>
      <ul class = "monstersOnStage">
        <li v-for="(monster, index) in monsterLists" :key="index">
          <p>몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}</p>
          <!-- 병맛 감성 스킬명 -->
          <button v-on:click="darknessDeathDestinyTypoonBlade(index)">
            D.D.D Typoon Blade
          </button>
        </li>
      </ul>
    </section>

    <section class="newContents">
      <h2>상점</h2>

      <h3>아이템 구매</h3>
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
      </table><br/>

      <h3>교환소</h3>
      <p>1회 - 경험치 10,000,000</p>
      <button v-bind:disabled="this.characterStatus[0].stat < 99"  v-on:click="calExpPoint()">교환 가능한지 확인하기</button>
      <p v-show ="this.surPlusExp.possible">
        사용 가능한 경험치 : {{ surPlusExp.surplusExpPoint }} <br/>
        교환 횟수 : {{ surPlusExp.amount }} 회
      </p>
      <ul class="exchangeExpShop">
        <li v-for="(item, index) in testLists" :key="item">
          <p>{{ item.statusName }} {{ item.amount }}증가</p>
          <div>
            <button v-on:click="exchangeExpForStatus(index)" >교환하기</button>
            <button v-on:click="exchangeAllExpForStatus(index)" >모두 교환하기</button>
          </div>
        </li>
      </ul>
    </section>
  </div>
</div>
</template>

<script>
const level = 0;
const hp = 1;
const mp = 2;
// const itemAtk = 3;
const defaultAtk = 4;
const atk = 5;
const str = 6;
const intelligence = 7;
const dex = 8;
const vit = 9;
const currentLevelBar = 10;
const totalLevelBar = 11;
const money = 12;




export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "MakeGame",
  data() {
    return {
      testLists : [
        { statusName : 'hp', amount: 50 },
        { statusName : 'mp', amount: 50 },
        { statusName : 'atk', amount: 5 },
        { statusName : 'str', amount: 5 },
        { statusName : 'intelligence',amount: 5},
        { statusName : 'dex', amount:5 },
      ],
      surPlusExp : {
        surplusExpPoint : 0,
        amount : 0,
        possible : false
      },
      inventory: [],
      equipments: [],
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
          // 아이템 타입 1 : 소모품, 아이템 타입 2 : 장비
        { itemType:1, name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { itemType:1, name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { itemType:2, name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { itemType:2, name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { itemType:2, name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
      ],
      characterStatus: [
        { statusName : 'level', stat : 1},
        { statusName : 'hp', stat : 50, addStat: 0 },
        { statusName : 'mp', stat : 40, addStat: 0 },
        { statusName : 'itemAtk', stat : 0, addStat: 0 },
        { statusName : 'defaultAtk', stat : 10, addStat: 0 },
        { statusName : 'atk', stat : 10, addStat: 0 },
        { statusName : 'str', stat : 10, addStat: 0 },
        { statusName : 'intelligence', stat : 10, addStat: 0 },
        { statusName : 'dex', stat : 10, addStat: 0 },
        { statusName : 'vit', stat : 10, addStat: 0 },
        { statusName : 'currentLevelBar', stat : 0},
        { statusName : 'totalLevelBar', stat : 10},
        { statusName : 'money', stat : 0},
        { statusName : 'currentJob', stat : '모험가' },
      ],
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
        { monsterId: 9999, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 30000000, dropMoney: 10000000 }
      ],
      monsterLists: [
        { id: 1, name: '슬라임', hp: 50 },
        { id: 2, name: '고블린', hp: 100 },
        { id: 3, name: '놀', hp: 200 },
      ],
    }
  },
  methods : {
    exchangeAllExpForStatus(index) {
      let numOfexchange = this.surPlusExp.amount

      if (this.surPlusExp.amount > 0) {
          for(let i = 0; i < this.characterStatus.length; i++) {

            if (this.testLists[index].statusName === this.characterStatus[i].statusName) {
              this.characterStatus[i].stat += this.testLists[index].amount * numOfexchange
              this.surPlusExp.surplusExpPoint -= 10000000* numOfexchange
              this.surPlusExp.amount -= 1* numOfexchange
              this.characterStatus[currentLevelBar].stat -= 10000000* numOfexchange
            }

          }
          alert(numOfexchange + "회 올랐습니다.")

      } else {
      alert("필요한 경험치가 부족합니다.")
      }
    },
    exchangeExpForStatus(index) {

      if (this.surPlusExp.amount > 0) {

        for(let i = 0; i < this.characterStatus.length; i++) {

          if (this.testLists[index].statusName === this.characterStatus[i].statusName) {
             this.characterStatus[i].stat += this.testLists[index].amount
             this.surPlusExp.surplusExpPoint -= 10000000
             this.surPlusExp.amount -= 1
             this.characterStatus[currentLevelBar].stat -= 10000000
             alert(this.testLists[index].statusName + " " + this.testLists[index].amount + "증가!")
           }

        }

      } else {
        alert("필요한 경험치가 부족합니다.")
      }

    },
    calExpPoint() {
      let tmpSurplusExp =
          this.characterStatus[currentLevelBar].stat - this.characterStatus[totalLevelBar].stat
      let tmpAmount = tmpSurplusExp / 10000000

      if (tmpSurplusExp >= 10000000) {
        this.surPlusExp.surplusExpPoint = tmpSurplusExp
        this.surPlusExp.amount = parseInt(tmpAmount)
        this.surPlusExp.possible = true
      } else {
        alert("아직 불가능" + tmpSurplusExp)
      }

    },
    equipItem(index) {
      let itemTypeNum

      for (let j = 0; j < this.itemBooks.length; j++) {
        if (this.inventory[index].name === this.itemBooks[j].name) {
          itemTypeNum = this.itemBooks[j].itemType

          if (itemTypeNum > 1) {
            this.equipments.push(this.itemBooks[j])
            this.inventory.splice(index, 1)
            this.characterStatus[atk].addStat += this.itemBooks[j].effect.atk
            this.characterStatus[atk].stat += this.characterStatus[atk].addStat


          } else {
            alert("데미지를 입지 않아서 아직 적용 불가")
            // this.characterStatus.hp += this.itemBooks[j].effect.amount
          }
        }
      }
    },
    findMaxInventoryIndex() {
      return this.inventory.reduce(
          (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id },
          0)
    },
    shuffleShopList() {
      if (!this.shopView) {
        this.shopListValue = []
      }
      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    calcBuyList() {
      let tmpSum = 0
      const buyedItem = []
      let maxInventoryIdx = this.findMaxInventoryIndex()

      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price
            buyedItem.push(this.shopList[j].name)
            break
          }
        }
      }

      if (this.characterStatus[money].stat - tmpSum >= 0) {
        this.characterStatus[money].stat -= tmpSum
        alert("물품 구매 완료!" + this.characterStatus[money].stat)

        for(let i = 0; i < buyedItem.length; i++) {
          this.inventory.push({
            id: maxInventoryIdx + 1,
            name: buyedItem[i]
          })
        }

      } else { alert("돈읎다 - 돈벌어와!!!") }

    },
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id },
          0)
    },
    addRandomMonster () {
      let max = this.findCurrentMonsterListMax()
      // ex) 20개라면 0 ~ 19.xxx 까지인데 floor 버림이니까 0 ~ 19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)
      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },
    addManyRandomMonster () {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },
    darknessTwilightBrightnessDawnRagnaBlade () {
      console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
          "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")
      for (let i = 0; i < this.monsterLists.length; i++) {
        this.monsterLists[i].hp -= 30 * this.characterStatus[atk].stat
      }
    },
    darknessDeathDestinyTypoonBlade (index) {
      console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
          "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!!")
      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
          Math.floor(
              this.characterStatus[atk].stat * 70 +
              this.characterStatus[str].stat * 33 +
              this.characterStatus[dex].stat * 30 +
              this.characterStatus[intelligence].stat * 30
          )
    },
  },
  beforeUpdate() {
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    let i
    for (i = 0; i < this.monsterLists.length; i++) {
      if (this.monsterLists[i].hp <= 0) {
        for (let j = 0; j < this.monsterBooks.length; j++) {
          if (this.monsterLists[i].name === this.monsterBooks[j].name) {
            this.characterStatus[currentLevelBar].stat += this.monsterBooks[j].exp
            this.characterStatus[money].stat += this.monsterBooks[j].dropMoney
          }
        }
        this.monsterLists.splice(i, 1)
      }
    }

    let levelStat = this.characterStatus[level].stat

    if (levelStat == 99) { return; }
    while (this.characterStatus[currentLevelBar].stat >= this.characterStatus[totalLevelBar].stat) {
      this.characterStatus[currentLevelBar].stat =
          parseInt(this.characterStatus[currentLevelBar].stat - this.characterStatus[totalLevelBar].stat)
      this.characterStatus[level].stat += 1
      this.characterStatus[hp].stat = parseInt(this.characterStatus[hp].stat * 1.05)
      this.characterStatus[mp].stat = parseInt(this.characterStatus[mp].stat * 1.05)
      this.characterStatus[defaultAtk].stat += 4
      this.characterStatus[atk].stat += 4
      this.characterStatus[str].stat += 3
      this.characterStatus[intelligence].stat += 1
      this.characterStatus[dex].stat += 2
      this.characterStatus[vit].stat += 3
      if (levelStat < 10) {
        this.characterStatus[totalLevelBar].stat = parseInt(this.characterStatus[totalLevelBar].stat * 1.2)
      } else if (levelStat < 30) {
        this.characterStatus[totalLevelBar].stat = parseInt(this.characterStatus[totalLevelBar].stat * 1.2)
      } else if (levelStat < 50) {
        this.characterStatus[totalLevelBar].stat = parseInt(this.characterStatus[totalLevelBar].stat * 1.2)
      } else if (levelStat < 70) {
        this.characterStatus[totalLevelBar].stat = parseInt(this.characterStatus[totalLevelBar].stat * 1.1)
      } else if (levelStat < 99) {
        this.characterStatus[totalLevelBar].stat = parseInt(this.characterStatus[totalLevelBar].stat * 1.1)
      }
    }
  }
}
</script>

<style scoped>


ul, li {
  list-style: none;
  text-align: left;
}

li > button {
  text-align: right;
}

h2  {
  margin: 10px 0;
}

div.wrap {
  display: flex;
  justify-content: center;
}

div.wrap > section {
  justify-content: flex-start;
  width: 430px;
  border: 1px solid #555;
  padding: 10px;
  margin: 0 10px;
}

section.stage > div {
  margin: 20px 0 10px;
}

section > ul {
  width : 390px;
  border: 1px solid #ddd;
  padding : 20px ;
}
section.stage > div > button {
  margin-bottom: 15px;
}

ul > li {
  height: 27px;
  margin : 5px 0;
  display:flex;
  justify-content: space-between;
  align-items: center;
}

ul.exchangeExpShop > li > div > button  {
margin-left: 8px;
}

</style>