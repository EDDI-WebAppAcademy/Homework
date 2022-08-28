<template>
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>            <!-- li v-for  반복문으로 lists 배열의 원소 꺼내서 출력 -->
      {{ item }}
    </li>
    <button v-on:click="clickHandler"> 클릭해봐! </button>
    <input v-model ="initMsg">
    <p>{{initMsg}}</p>

    <button v-on:click="show=!show"> 쇼타임! </button>    <!-- 버튼 클릭했을 때 show를 !show에 대입하므로 false가 됨 -->
    <p v-if="show">보였다 안보였다</p><br>                     <!-- v-if는 if문과 동일-->
    <p>{{lists[1]}}</p><br/>
    <p>{{lists[0]}}</p><br/>
    <p>{{lists[2]}}</p><br/>
    <p>{{lists[num]}}</p><br/>

    <p>{{count}}번 클릭했습니다.</p><br/>
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


    <p>캐릭터 상태창 </p>
    <p> HP: {{characterStatus.hp}} , MP: {{characterStatus.mp}} , ATK: {{characterStatus.atk}} , LV: {{characterStatus.level}}, 직업: {{characterStatus.currentJob}}</p>
    <p> STR: {{characterStatus.str}} , INT: {{characterStatus.intelligence}}, DEX: {{characterStatus.dex}}, VIT:{{characterStatus.vit}}, DEF: {{characterStatus.def}}, MEN: {{characterStatus.men}} </p>
    <p> 경험치: {{characterStatus.currentLevelBar}} / {{characterStatus.totalLevelBar}} </p>
    <p> 소지금 : {{characterStatus.money}}</p>

    <!-- 현재 컨텐츠 측면에서 몬스터가 매번 같은 것이 추가되서 재미요소가 반감됨(랜덤 요소 필요) -->

    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button>

    <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button>

    <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button>

    <ul>
      <li v-for="(monster,index) in monsterLists" :key="index">
         몬스터 이름: {{monster.name}},  HP: {{monster.hp}}
        <button v-on:click="darknessDeathDestinyTypoonBlade(index)">
          Darkness Death Destiny Typoon Blade
        </button>

        <button v-on:click="removeMonster(index)"> 맵에 끼어 있는 몬스터 삭제하기</button>
      <!--  <button v-on:click="attackMonster(index)"> 몬스터 공격하기</button> -->
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {                                                   //1. 데이터
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
      ],
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑됨",
      show: true,                                             //show의 기본 값은 true
      num: 1,
      count: 0,
      monsterBooks:[
        { monsterId: 1, name:'슬라임', hp:50, exp:10, dropMoney: 5},
        { monsterId: 2, name:'고블린', hp:100, exp:20, dropMoney: 10},
        { monsterId: 3, name:'놀', hp:200, exp:40, dropMoney: 20},
        { monsterId: 4, name:'멧돼지', hp:400, exp:100, dropMoney: 20},
        { monsterId: 5, name:'스켈레톤', hp:350, exp:90, dropMoney: 10},
        { monsterId: 6, name:'오크', hp:550, exp:150, dropMoney: 40},
        { monsterId: 7, name:'홉고블린', hp:650, exp:180, dropMoney: 50},
        { monsterId: 8, name:'스켈레톤 아처', hp:300, exp:150, dropMoney: 50},
        { monsterId: 9, name:'트롤', hp:800, exp:200, dropMoney: 80},
        { monsterId: 10, name:'좀비', hp:350, exp:90, dropMoney: 50},
        { monsterId: 11, name:'고블린 매지션', hp:700, exp:500, dropMoney: 300},
        { monsterId: 12, name:'오우거', hp:1000, exp:250, dropMoney: 50},
        { monsterId: 13, name:'고스트', hp:750, exp:300, dropMoney: 1},
        { monsterId: 14, name:'골렘', hp:2000, exp:400, dropMoney: 100},
        { monsterId: 15, name:'와이번', hp:3500, exp:500, dropMoney: 150},
        { monsterId: 16, name:'리치', hp:2000, exp:1000, dropMoney: 500},
        { monsterId: 17, name:'스켈레톤 기사', hp:2500, exp:700, dropMoney: 100},
        { monsterId: 18, name:'웨어울프', hp:5000, exp:1000, dropMoney: 700},
        { monsterId: 19, name:'미노타우루스', hp:10000, exp:1500, dropMoney: 1000},
        { monsterId: 20, name:'드레이크', hp:20000, exp:2000, dropMoney: 50000},
        { monsterId: 21, name:'죽음의 군주', hp:1000000, exp:200000, dropMoney: 1000000},
      ],
      monsterLists: [
        { id: 1, name:'슬라임' , hp: 50},
        { id: 2, name:'고블린' , hp: 100},
        { id: 3, name:'놀' , hp: 200},
      ],
      characterStatus: {
       level: 1,
       hp: 50,
       mp: 30,
       itemAtk: 0,
       defaultAtk: 10,
       atk: 10,
       str: 10,
       intelligence: 10,
       dex: 10,
       vit: 10,
       def:10,
       men: 0,
       totalLevelBar: 10,
       currentLevelBar: 0,
       money:0,
       currentJob: '모험가'
      },
    }
  },
  methods: {                                                 //2. 메소드  메소드 형식은  메소드명: function (인자) ->  메소드명(인자) 간단하게 표기할 수 있음
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
            break
          }
        }
      }
      if (this.characterStatus.money - tmpSum >= 0) {
        this.characterStatus.money -= tmpSum
        alert("물품 구매 완료!")
      } else { alert("돈읎다 - 돈벌어와!!!") }
    },

    clickHandler: function (event) {                       // clickHandler: function (event)  =>  clickHandler(event)로 표기 가능
      alert("이벤트 발생: " + event.target)
    },
    increment() {
      this.count += 1
    },
    findCurrentMonsterMax() {
      return this.monsterLists.reduce(                             // a는 몬스터리스트의 시작값 id: 1 을 의미, b는 두번째 오브젝트를 의미(b.id를 비교하겠다고 지정해줘야함) -> 더 높은 맥스값을 찾을 수 있음
          (a, b) => {
            console.log("a: " + a + "b.id: " + b.id);
            return a > b.id ? a : b.id
          },
          0)
    },
    addFixedMonster() {
      // let은 자바스크립트에서 사용하는 변수 개념입니다.
      // 변수 데이터타입을 따로 지정할 필요 없음  -> 자바에서 object와 비슷한 개념
      let max = this.findCurrentMonsterMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },
    removeMonster(index) {
      // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index, 1) 이므로 index에 해당하는 정보 1개를 삭제한다는 의미입니다.
      this.monsterLists.splice(index, 1)
    },
    addRandomMonster() {
      let max = this.findCurrentMonsterMax()

      //ex) 20개라면 0 ~19.xxx까지인데 floor 버림이니까 0~19까지
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
    // attackMonster(index){
    //   //해당 인덱스 몬스터 hp 깎기 this.monsterLists.
    // },
    // addManyRandomMonster(){
    //   //여러마리 몬스터 hp 깎기
    // },
    darknessDeathDestinyTypoonBlade(index) {
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
    darknessTwilightBrightnessDawnRagnaBlade() {
     console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라!" +
         "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!")

      for(let i =0; i <this.monsterLists.length; i++){
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk

      }
    }
  },
  //  뷰에서 기본제공하는 메소드-> beforeUpdate(): 뷰가 화면에 랜더링(그림그리기)전에 변화를 감지하는 메소드 -> 변화 감지 시점에서 동작할 기능이 있으면 여기서 구현
  //
  beforeUpdate() {
    console.log("나는 vdom의 변화를 감지하면 무조건 동작해!")
    let i
    for (i = 0; i < this.monsterLists.length; i++) {
      if (this.monsterLists[i].hp <= 0) {                                        // 공격해서 몬스터 hp가 0이하되면

        for (let j = 0; j < this.monsterBooks.length; j++) {                     // 몬스터 도감 만큼 반복문 실행()
          if (this.monsterLists[i].name === this.monsterBooks[j].name) {           // 몬스터 리스트의 이름에서 몬스터 도감의 이름이 동일하면
            this.characterStatus.currentLevelBar += this.monsterBooks[j].exp       // 캐릭터에 몬스터북에서 해당 몬스터 경험치 부여
            this.characterStatus.money += this.monsterBooks[j].dropMoney           // 캐릭터에 드랍머니 부여
          }
        }
        this.monsterLists.splice(i, 1)
      }
    }

    //경험치 쌓이면 레벨업 + 캐릭터 스탯 상승 기능
    while (this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar){           // 현재 경험치바가 토탈경험치바 보다 큰 동안에 실행되라

      this.characterStatus.currentLevelBar =                                                       // 경험치 현재바 = 경험치 현재바 - 토탈경험치 바
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1                                               // 레벨업 + 1   -> while문이라 한번에 경험치 많이 얻는다해도 현재 경험치바가 더 높은 경우 반복 실행되므로 레벨업 한번에 많이 가능

      this.characterStatus.hp = parseInt(this.characterStatus.hp *1.05)
      this.characterStatus.mp = parseInt(this.characterStatus.mp *1.02)
      this.characterStatus.defaultAtk += 4
      this.characterStatus.atk += 4
      this.characterStatus.def += 1
      this.characterStatus.str += 3
      this.characterStatus.intelligence += 1
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1

      if(this.characterStatus.level <10 ){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)              //경험치 토탈 채워야하는 것 10퍼센트씩 증가
      } else if(this.characterStatus.level <30){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if(this.characterStatus.level <50) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.5)
      } else if(this.characterStatus.level <70) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.6)
      } else if(this.characterStatus.level <80) {
      this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.7)
    } else if(this.characterStatus.level < 100) {
      this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.8)
    }

    }


  },


}
</script>

<style scoped>
</style>


//아이템 착용하고 아이템 스텟 적용 -> 구매한 인벤토리 리스트 관리 필요 , 인벤토리에서 장착누르면 적용되도록