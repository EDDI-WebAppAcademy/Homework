<template>
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>        <!--   li v-for  반복문으로 lists 배열의 원소 꺼내서 출력
                                                                 기본 형태:  v-for="item in 리스트명" 이며,
                                                                 배열처럼 인덱스를 사용하고 싶은 경우 "(item, index) in 리스트명" :key=index 라고 써준다
                                                            <li><p> 태그 등에서 for문은 v-for, if문은 v-if로 사용 됨  -->
      {{ item }}
    </li>
    <button v-on:click="clickHandler"> 클릭해봐! </button>      <!-- <button v-on:click="메소드명 또는 메소드명(인자)"> 버튼에 표시되는 텍스트 </button> 형식으로 사용 -->
    <input v-model ="initMsg">                                <!-- v-model은 양방향으로 반영되는 기능 구현에 사용, html 문법 input태그, checkbox태그, select태그에서 사용 가능
                                                                 여기서는 v-model="들어갈 데이터" (data()에 저장되어 있는 데이터) 형식으로 사용                -->
    <p>{{initMsg}}</p>

    <button v-on:click="show=!show"> 쇼타임! </button>    <!-- 버튼 클릭했을 때 show를 !show에 대입하므로 false가 됨 -->
    <p v-if="show">보였다 안보였다</p><br>                 <!-- v-if는 if문과 동일  -> 즉, 만약 show가 true인 경우 <p>태그가 감싸고있는 텍스트(보였다 안보였다)를 출력함-->
    <p>{{lists[1]}}</p><br/>
    <p>{{lists[0]}}</p><br/>
    <p>{{lists[2]}}</p><br/>
    <p>{{lists[num]}}</p><br/>

    <p>{{count}}번 클릭했습니다.</p><br/>
    <button v-on:click="increment">카운트 버튼</button><br/>

    <h3>상점</h3>                                                                     <!-- 상점 -->
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">           <!-- input type의 v-model="" ,  v-on:click ="인풋 타입인 체크박스 클릭시 실행될 메소드"  -->
      판매 목록
    </label>
    <button v-on:click="calcBuyList()">구매 확정</button>                            <!-- 구매 확정누르면 calcBuyList() 메소드 실행 -->
    <table border="1" v-if="shopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">구매</th>
      </tr>
      <tr v-for="(item, index) in shopList" :key="index">    <!-- 여기서 반복을 해서  1줄 1줄의 아이템 리스트가 랜덤하게 나올건데 어디서 반복횟수를 찾을수 잇지?->shuffleShopList()메소드 보기  -->
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="shopListValue" :value="index">       <!--  input type의 v-model="화면에서 실시간으로 양방향 데이터받을 데이터 ", :value="index"
                                                                      -> 여기서 shopListValue[]는 data()에 저장되어 있는 배열로, checkbox 형태에서 체크된 인덱스들을 value로 저장함       -->
          </label>
        </th>
      </tr>
    </table>


    <p>캐릭터 상태창 </p>
    <p> HP: {{characterStatus.hp}} , MP: {{characterStatus.mp}} , ATK: {{characterStatus.atk}} , LV: {{characterStatus.level}}, 직업: {{characterStatus.currentJob}}</p>
    <p> STR: {{characterStatus.str}} , INT: {{characterStatus.intelligence}}, DEX: {{characterStatus.dex}}, VIT:{{characterStatus.vit}}, DEF: {{characterStatus.def}}, MEN: {{characterStatus.men}} </p>
    <p> 경험치: {{characterStatus.currentLevelBar}} / {{characterStatus.totalLevelBar}} </p>
    <p> 소지금 : {{characterStatus.money}}</p>

    <label>
      <input type="checkbox" v-model="inventoryView">           <!-- input type의 v-model="" 여기서 inventoryView는 boolean 값으로 false,  v-on:click ="인풋 타입인 체크박스 클릭시 실행될 메소드"  -->
      인벤토리
    </label>
    <button v-on:click="useItem()">아이템 사용</button>                            <!-- 구매 확정누르면 calcBuyList() 메소드 실행 -->
    <table border="1" v-if="inventoryView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">사용</th>
      </tr>
      <tr v-for="(item, index) in inventoryList" :key="index">    <!-- 여기서 반복을 해서  1줄 1줄의 아이템 리스트가 랜덤하게 나올건데 어디서 반복횟수를 찾을수 잇지?->shuffleShopList()메소드 보기  -->
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="320">{{ item.description}}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="inventoryListValue" :value="index">       <!--  input type의 v-model="화면에서 실시간으로 양방향 데이터받을 데이터 ", :value="index"
                                                                      -> 여기서 shopListValue[]는 data()에 저장되어 있는 배열로, checkbox 형태에서 체크된 인덱스들을 value로 저장함       -->
          </label>
        </th>
      </tr>
    </table><br/><br/>

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
      inventoryView: false,                                  // 인벤토리 체크 시 보여주기 위한 boolean 값
      tmpBuyList:[],                                         // 구매하겠다고 체크한 아이템 리스트 임시로 받아옴 (토탈 가격 비교 전 값으로, 임시 저장)
      inventoryList: [],                                     // 실제 구매완료한 내 인벤토리 아이템 리스트
      inventoryListValue: [],                                // 인벤토리 아이템 사용에 체크된 인덱스(양방향 데이터로 사용자가 체크 시 자동으로 저장됨)
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000, effect: { description: '무기 공격력 100', atk: 100 }},
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
  //2. 메소드  메소드 형식은  메소드명: function (인자) ->  메소드명(인자) 간단하게 표기할 수 있음
  methods: {
    shuffleShopList () {
      if (!this.shopView) {                 // 기본값이 shopView는 false로, 상점 버튼 체크표시가 안된 상태로 이 때는 shopListValue를 빈 배열로 값 넣어주기
        this.shopListValue = []             // -> shopListValue는 원래 shopList에서 구매 체크한 인덱스 담는 배열임
      }
      for (let i = 0; i < 10; i++) {                                          // 상점 버튼 체크된 경우 shopList 만들어 주기(10개 상품)
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)     //Math.floor(): 소수점 이하를 버림 (정수 만들어줌), Math.random(): 0 ~ 1사이의 난수
                                                                              // Math.floor(Math.random() * 최대값) -> (0 ~ 최대값) 사이의 정수 생성됨
        this.shopList[i] = this.itemBooks[randIdx]                      //shopList 10개 랜덤으로 itemBooks에서 뽑아 주기
      }
    },
    calcBuyList () {                                              //구매 확정 누르면 실행되는 메소드
      let tmpSum = 0
      for (let i = 0; i < this.shopListValue.length; i++) {        // shopListValue: 내가 구매 체크한 아이템들의 인덱스 배열
        for (let j = 0; j < this.shopList.length; j++) {           //shopList는 구매 가능 상점 목록
          if (this.shopListValue[i] === j) {                      // 만약 구매 체크한 아이템 인덱스가 shopList의 인덱스와 일치하면
            tmpSum += this.shopList[j].price                      // tmpSum에 해당 아이템 가격을 더해라
            this.tmpBuyList.push(
              this.shopList[j].name
            )
            break                                                 // 일치한게 나오면 반복문 탈출
          }
        }
      }
      if (this.characterStatus.money - tmpSum >= 0) {            //만약 총합가격이 캐릭터 머니보다 많으면 캐릭터 머니에서 가져가고 돈이 없으면 alert 창 띄우기
        this.characterStatus.money -= tmpSum
        console.log(this.tmpBuyList)
        console.log(this.tmpBuyList.length)

        for(let i = 0; i< this.tmpBuyList.length; i++){
          for(let j = 0; j< this.itemBooks.length; j++){

            if(this.tmpBuyList[i] === this.itemBooks[j].name){
              if(this.itemBooks[j].effect.atk === undefined){
                this.inventoryList.push({
                  name: this.itemBooks[j].name,
                  description: this.itemBooks[j].effect.description,
                  amount: this.itemBooks[j].effect.amount
                })
              } else{
                this.inventoryList.push({
                  name: this.itemBooks[j].name,
                  description: this.itemBooks[j].effect.description,
                  atk: this.itemBooks[j].effect.atk
              })
            }
          }
        }
      }
        alert("물품 구매 완료!")
      } else {
        alert("돈읎다 - 돈벌어와!!!")
      }
      this.tmpBuyList=[];
    },

    useItem(){    //사용하기 체크한 후 아이템 사용 버튼 눌렀을때 메소드 동작
      //우선 체크하면 알아서 inventoryListValue에 값이 저장됨  ->  단 저장이 실시간이므로 체크한 순서대로 값이 저장됨 -> [3, 2, 5 ,1] 이런 식 -> 따라서 크기 순서대로 연산해야되는 경우 정렬 필요

      this.inventoryListValue.sort(function compare(a,b){                    //inventoryListValue 배열 값 오름차순 정렬
        return a - b
      })
      console.log(this.inventoryListValue)

      for(let i = 0; i< this.inventoryListValue.length; i++){  //3 개다  -> 0, 1, 2로 동작
        let removeNum = i

        // 적용한 아이템 삭제를 위해서는 첫번째 아이템 사용 시 해당 아이템 삭제하면 inventoryList의 배열길이가 줄어들게 됨
        if(i === 0){                                                                                       // 첫번째 아이템 적용 후 삭제하는 경우 배열 인덱스 길이 상관 없음
          if(this.inventoryList[this.inventoryListValue[i]].atk === undefined){
            this.characterStatus.hp += this.inventoryList[this.inventoryListValue[i]].amount
          } else{
            this.characterStatus.atk += this.inventoryList[this.inventoryListValue[i]].atk
          }
          this.inventoryList.splice(this.inventoryListValue[i], 1)

        }else {
          if(this.inventoryList[this.inventoryListValue[i]-removeNum].atk === undefined){                 // 두번째 아이템 이후 부터는 삭제하는 경우 배열 인덱스 길이를 이전에 삭제한 i개 만큼 빼줘야 함
            this.characterStatus.hp += this.inventoryList[this.inventoryListValue[i]-removeNum].amount
          } else{
            this.characterStatus.atk += this.inventoryList[this.inventoryListValue[i]-removeNum].atk
          }
          this.inventoryList.splice(this.inventoryListValue[i]-removeNum, 1)
        }
        if(this.inventoryList.length === 0){                                                            //  아이템 다 사용해서 인벤토리 사이즈 0인 경우 반복문 탈출
          break
        }
      }

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