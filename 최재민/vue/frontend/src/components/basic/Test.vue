<template>
  <div>
    <h1>{{ testmsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>
        {{ item }}
    </li>
    <button v-on:click="clickHandler">클릭해봐!</button>
    <input v-model="initMsg">
    <p>{{ initMsg }}</p><br>

    <button v-on:click="show=!show">쇼타임!</button>
    <p v-if="show">보였다 안보였다</p>
    <p>{{ lists[1] }}</p><br/>
    <p>{{ lists[0] }}</p><br/>
    <p>{{ lists[2] }}</p><br/>
    <p>{{ lists[num] }}</p><br/>

    <p>{{ count }}번 클릭했습니다.</p><br/>
    <button v-on:click="increment">카운트 버튼</button><br/>


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
        <th align="center" width="40">{{ index+1 }}</th>
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

    <label>
    인벤토리
    <input type="checkbox" v-model="showInventory">
    </label>
    <button v-on:click="UseItem()">장비 사용</button>
    <table border="1" v-if="showInventory">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">장착</th>
      </tr>
      <tr v-for="(item,index) in inventoryList" :key="index">
        <th align="center" width="40">{{ index+1 }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <input type="checkbox" v-model="useItemValue" :value="index">
        </th>
      </tr>
    </table>

    <p>캐릭터 상태 창</p>
    <P>HP: {{characterStatus.hp}} MP: {{characterStatus.mp}} ATK: {{characterStatus.atk}} Lv: {{characterStatus.level}} 직업: {{characterStatus.currentJob}}</P>
    <P>STR: {{characterStatus.str}} INT: {{characterStatus.int}} DEX: {{characterStatus.dex}} VIT: {{characterStatus.vit}} DEF: {{characterStatus.def}} MEN: {{characterStatus.men}}</P>
    <P>경험치 : {{characterStatus.currentLevelBar}} / {{characterStatus.totalLevelBar}}</P>
    <p>소지금: {{characterStatus.money}}</p>
    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button><br/>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button><br/>

    <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button><br/>

    <button v-on:click="DarknessTwilLightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드
    </button><br/>

    <ul>
      <li v-for="(monster,index) in monsterLists" :key="index">
        몬스터 이름: {{monster.name}} , HP: {{ monster.hp }}
        <button v-on:click="darknessDeathDestinyTypoonBlade(index)">darknessDeathDestinyTypoonBlade</button>
        <button v-on:click="removeMonster(index)">맵에 낀 몬스터 삭제하기</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return{
      showInventory : false,
      inventoryList :[],
      useItemValue :[],
      shopView : false,
      shopList :[],
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
      ],
      name:"키메라",
      testmsg: "My Message",
      lists : ['apple','banana','grape'],
      initMsg: "양뱡향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count:0,
      monsterBooks: [
        { monsterId :1, name:'슬라임' ,hp: 50,exp:10,dropMoney: 5000000} ,
        { monsterId :2, name:'고블린' ,hp: 100,exp:20,dropMoney: 10} ,
        { monsterId :3, name:'놀' ,hp: 200,exp:40,dropMoney: 20} ,
        { monsterId :4, name:'멧돼지' ,hp: 400,exp:100,dropMoney: 20},
        { monsterId :5, name:'스켈레톤' ,hp: 350,exp:90,dropMoney: 10},
        { monsterId :6, name:'오크' ,hp: 550,exp:150,dropMoney: 40},
        { monsterId :7, name:'홉고블린' ,hp: 650,exp:100,dropMoney: 50},
        { monsterId :8, name:'스켈레톤 아처' ,hp: 300,exp:150,dropMoney: 50},
        { monsterId :9, name:'트롤' ,hp: 800,exp:200,dropMoney: 80},
        { monsterId :10, name:'좀비' ,hp: 350,exp:90,dropMoney: 50},
        { monsterId :11, name:'고블린 메지션' ,hp: 700,exp:500,dropMoney: 300},
        { monsterId :12, name:'오우거' ,hp: 1000,exp:250,dropMoney:50},
        { monsterId :13, name:'고스트' ,hp: 750,exp:300,dropMoney: 1},
        { monsterId :14, name:'골렘' ,hp: 2000,exp:400,dropMoney: 100},
        { monsterId :15, name:'와이번' ,hp: 3500,exp:500,dropMoney: 150},
        { monsterId :16, name:'리치' ,hp: 2000,exp:1000,dropMoney: 500},
        { monsterId :17, name:'스켈레톤 기사' ,hp: 2500,exp:700,dropMoney:100},
        { monsterId :18, name:'웨어울프' ,hp: 5000,exp:1000,dropMoney:700},
        { monsterId :19, name:'미노타우르스' ,hp: 10000,exp:1500,dropMoney:1000},
        { monsterId :20, name:'드레이크' ,hp: 20000,exp:5000,dropMoney:5000},
        { monsterId :21, name:'죽음의 군주' ,hp: 1000000,exp:200000,dropMoney:100000000},
      ],
      monsterLists: [
        { id :1, name: '슬라임', hp:50 },
        { id :2, name: '고블린', hp:100 },
        { id :3, name: '놀', hp:200 },
      ],
      characterStatus: {
        level: 1,
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        int: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLevelBar:10,
        currentLevelBar :0,
        money: 0,
        currentJob:'모험가',
      },
    }
  },
  methods : {
    UseItem(){
      alert('아이템 사용 완료!')
      let amount = 0;
      for(let i =0; i< this.useItemValue.length; i++){
        for (let j = 0; j < this.inventoryList.length; j++) {
          if(this.useItemValue[i] === j){
            if(this.inventoryList[j].effect.atk != null){
              amount += this.inventoryList[j].effect.atk

              this.characterStatus.atk += amount
            }else {
              amount += this.inventoryList[j].effect.amount

              this.characterStatus.hp += amount
              this.inventoryList.splice(j , 1)
            }
            break
          }
        }
      }
    },
    shuffleShopList(){
      if(!this.shopView){
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    calcBuyList() {
      let tmpSum =0

      for(let i =0; i< this.shopListValue.length; i++){
        for(let j = 0; j <this.shopList.length; j++){
          if(this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price

            if(this.characterStatus.money - tmpSum >= 0){
              this.inventoryList.push(this.shopList[j])
              alert("물품 구매 완료!")
              this.characterStatus.money -= tmpSum
            }else {alert("돈이 부족합니다!")}

            break
          }
        }
      }
    },
    // clickHandler(event){}
    clickHandler: function (event){
      alert("이벤트 발생" + event.target)
    },
    // increment : function() {} 같은거 표현의 차이
    increment(){
      this.count +=1
    },
    findCurrentMonsterListMax(){
      return this.monsterLists.reduce(
          (a, b) => { console.log("a: "+a+", b,id :"+b.id);return a > b.id ? a : b.id},
          0)
    },
    addFixedMonster(){
      //let은 자바스크립트 에서 사용하는 변수 개념입니다. 자바에서의 object 유사
      // java 에서는 변수타입이 지정 되어야 하지만 자바스크립트에서는 할필요 x
      let max = this.findCurrentMonsterListMax()

      this.monsterLists.push(({
        id: max +1,
        name :this.name,
        hp : 500,
      }))

    },
    removeMonster (index) {
      // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index ,1)이므로 index에 해당하는 정보 1개를 삭제한다라는 뜻입니다.
      this.monsterLists.splice(index, 1)
    },
    addRandomMonster(){
      let max = this.findCurrentMonsterListMax()

      //ex) 20개라면 0 ~19.xxx 까지인데 floor버림이니까 0-19까지
      let randomMonsterBookIdx = Math.floor(Math.random()*this.monsterBooks.length)

      this.monsterLists.push({
        id: max +1,
        name :this.monsterBooks[randomMonsterBookIdx].name,
        hp : this.monsterBooks[randomMonsterBookIdx].hp,
      })
    },
    addManyRandomMonster(){
      for(let i =0; i <100; i++){
        this.addRandomMonster()
      }
    },
    darknessDeathDestinyTypoonBlade(index){
      console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니!"+
      "간닷! 다크니스 데스트니 타이푼 블레이드!")

      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
              Math.floor(
                  this.characterStatus.atk * 70 +
                  this.characterStatus.str * 33 +
                  this.characterStatus.dex * 30 +
                  this.characterStatus.int * 30
              )
    },
    DarknessTwilLightBrightnessDawnRagnaBlade(){
      console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라!"+
      "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!")

      for(let i =0; i <this.monsterLists.length; i++){
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk
      }
    }
  },
  beforeUpdate() {
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    let i

    for (i = 0; i <this.monsterLists.length; i++){
      if(this.monsterLists[i].hp <= 0){
        for(let j =0; j <this.monsterBooks.length; j++){
          if(this.monsterLists[i].name === this.monsterBooks[j].name){
            this.characterStatus.currentLevelBar += this.monsterBooks[j].exp
            this.characterStatus.money += this.monsterBooks[j].dropMoney
          }
        }
        this.monsterLists.splice(i,1)
      }
    }

    while(this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar){
      this.characterStatus.currentLevelBar =
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1
      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05)
      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.05)
      this.characterStatus.defaultAtk +=4
      this.characterStatus.atk +=4
      this.characterStatus.def +=1
      this.characterStatus.str +=3
      this.characterStatus.int +=1
      this.characterStatus.dex +=2
      this.characterStatus.vit +=3
      this.characterStatus.men += 1

      if(this.characterStatus.level < 10){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      }else if(this.characterStatus.level < 30){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      }else if(this.characterStatus.level < 50){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.5)
      }else if(this.characterStatus.level < 70){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.6)
      }else if(this.characterStatus.level < 80){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.7)
      }else if(this.characterStatus.level < 100){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.8)
      }
    }
  }
}
</script>

<style scoped>

</style>