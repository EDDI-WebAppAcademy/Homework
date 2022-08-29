<template>
  <div>
    <h1>{{ testMsg }}</h1> <!--데이터-->
    <ol>
      <li v-for="(item, index) in lists" :key=index> <!--리스트있는 정보의 item 가져옴 인덱스정보를 고유키값으로 사용 (보안)-->
        {{ item }}
      </li>
      <button v-on:click="clickHandler">클릭해봐!</button>
      <!--버튼태그로 버튼 만들어지고 vonclick 는 clickHandler라는 메소드 실행시킴-->
      <!--v-on 클릭했을때 뭐해라 뷰랑 맵핑하는거야 이벤트를-->
      <input v-model="initMsg">
      <p>{{ initMsg }}</p><br>
      <!--뷰 쓰면 양방향 맵핑도 가능 실시간으로 반영되는것-->
      <button v-on:click="show=!show">쇼타임!</button> <!-- 자기자신부정 참거짓참거짓 누를때마다 바뀜 낫쇼를 대입-->
      <p v-if="show">보였다 안보였다</p><br/>
      <!--보였다 안보였다 if문이랑 역할 같음-->
      <!--v-on:click=" "클릭하면 실행되는 메소드인데 메소드 아닌 기능이 적힘-->
      <!--v-if=""는 뭘 할 수 있나? 화면 출력되는것 자체에 객체를 베이스로 동작조건을 걸 수 있다. 기존 html에선 불가능-->
      <!--뷰 기본적으로 쓰는 내부 태그들은 v-어쩌고가 주를 이뤄-->
      <!--메소드는 아래와 같이 추가하면됨-->
      <p>{{ lists[1] }}</p><br/>
      <p>{{ lists[0] }}</p><br/>
      <p>{{ lists[2] }}</p><br/>
      <p>{{ lists[num] }}</p><br/>

      <p>{{ count }}번 클릭했습니다.</p><br/>
      <button v-on:click="increment">카운트 버튼</button><br/>

      <h3>상점</h3>
      <label> <!--아이템목록 누르면 갱신-->
        <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
        판매 목록
      </label>
      <button v-on:click="calcBuyList()">구매 확정</button>
      <!--뷰에서 html태그 혼성해서 쓰고 있어서 줄쳐짐 중요한 이슈는 아냐-->
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


      <h3>인벤토리</h3>
      <label>
        <input type="checkbox" v-model="inventoryView">
        열기
      </label>
      <button v-on:click="addItem()">아이템 장착</button>
      <table border="1" v-if="inventoryView">
        <tr>
          <th align="center" width="40">번호</th>
          <th align="center" width="120">아이템명</th>
          <th align="center" width="320">아이템 설명</th>
          <th align="center" width="40">장착</th>
        </tr>
        <tr v-for="(item, index) in inventoryList" :key="index">
          <th align="center" width="40">{{ index }}</th>
          <th align="center" width="120">{{ item.name }}</th>
          <th align="center" width="320">{{ item.effect.description }}</th>
          <th align="center" width="40">
            <label>
              <input type="checkbox" v-model="inventoryListValue" :value="index">
            </label>
          </th>
        </tr>
      </table>

      <br>

      <label>
      <input type="checkbox" v-model="currentItemView">
      장착중인 아이템
      </label>
      <button v-on:click="unequip()">장착해제</button>
      <table border="1" v-if="currentItem">
        <tr>
          <th align="center" width="40">번호</th>
          <th align="center" width="120">아이템명</th>
          <th align="center" width="320">아이템 설명</th>
          <th align="center" width="40">해제</th>
        </tr>
        <tr v-for="(item, index) in currentItem" :key="index">
          <th align="center" width="40">{{ index }}</th>
          <th align="center" width="120">{{ item.name }}</th>
          <th align="center" width="320">{{ item.effect.description }}</th>
          <th align="center" width="40">
            <label>
              <input type="checkbox" v-model="currentItemValue" :value="index">
            </label>
          </th>
        </tr>
      </table>


      <p>캐릭터 상태 창</p>
      <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
      <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.defaultAtk }} MEN: {{ characterStatus.men }}</p>
      <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
      <p>소지금: {{ characterStatus.money }}</p>



      <!--현재 컨텐츠 측면에서 몬스터가 매번 같은 것이 추가되어서 재미 요소가 반감됨(랜덤 요소를 넣어야함)-->
      (고정) 몬스터 이름: <input v-model="name">
      <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button><br/>

      <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button><br/>

      <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button><br/>

      <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button><br/>

      <ul>
        <li v-for="(monster, index) in monsterLists" :key="index">
          몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
          <!--병맛 감성 스킬명-->
          <button v-on:click="darknessDeathDestinyTypoonBlade(index)">
            Darkness Death Destiny Typoon Blade
          </button>
          <button v-on:click="removeMonster(index)">맵에 끼어 있는 몬스터 삭제하기</button>
        </li>
      </ul>
    </ol>
  </div>
</template>
<!--코드? 태그만 있어 UI는 어떻게 되어있는지 정도만 보게됨 -->
<!--어떤 데이터를 화면에 보여줄건지 클릭을 했을때 어떤걸 할건지 -->
<!--그림그리는 작업이나 이벤트만 하고 있어-->

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() { //데이터는 전부 여기
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200}},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600}},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100}},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200}},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300}},
      ],
      inventoryView: false,
      inventoryList: [],
      inventoryListValue: [],
      currentItemView: false,
      currentItem:[],
      currentItemValue:[],
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      monsterBooks: [ //몬스터 관리 도감 필요
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney:10 },
        { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 }, //경치많은 렙업존ㅎ
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 }, //쩐파밍ㅎ
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 }, //쪽수가많은애들
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
        { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 }, //깨지마
      ],
      monsterLists: [ //실제 전투중에 등장한 몬스터의 리스트
        {id: 1, name: '슬라임', hp: 50 },
        {id: 2, name: '고블린', hp: 100 },
        {id: 3, name: '놀', hp: 200 },
      ],
      characterStatus: {
        level: 1, //초기값1
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        intelligence:10,
        dex: 10, //민첩
        vit: 10, //체력
        men: 0, //마방 초기니까 0
        totalLevelBar: 10, //초기는 경치 10만 채우면 된다하자
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가'
      },
    }
  } ,
  methods: {
    addItem () {
      for (let i = 0; i < this.inventoryListValue.length; i++) {
        for (let j = 0; j < this.inventoryList.length; j++) {
          if(this.inventoryListValue[i] == j){
            if(this.inventoryList[j].effect.atk != null){
              this.characterStatus.atk += this.inventoryList[j].effect.atk
              this.currentItem.push(this.inventoryList[j])
              this.inventoryList.splice(j, 1)
            } else {
              this.characterStatus.hp += this.inventoryList[j].effect.hp
              this.inventoryList.splice(j, 1)
            }
            break
          }
        }
      }
      alert("아이템 장착 완료!")
    },
    unequip () {
      for (let i = 0; i < this.currentItemValue.length; i++) {
        for (let j = 0; j < this.currentItem.length; j++) {
          if (this.currentItemValue[i] == j) {
            if (this.currentItem[j].effect.atk != null) {
              this.characterStatus.atk -= this.currentItem[j].effect.atk
              this.inventoryList.push(this.currentItem[j])
              this.currentItem.splice(j, 1)
            }
            break
          }
        }
      }
      alert("장착해제 완료!")
    },
    shuffleShopList () {
      if (!this.shopView) {
        this.shopListValue = []
      }

      for(let i = 0; i < 10; i++){
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

      if(this.characterStatus.money - tmpSum >= 0) {
        this.characterStatus.money -= tmpSum

        for (let i = 0; i < this.shopListValue.length; i++) {
          for (let j = 0; j < this.shopList.length; j++) {
            if (this.shopListValue[i] === j) {
              this.inventoryList.push(this.shopList[j])
              break
            }
          }
        }
        alert("물품 구매 완료!")
      } else { alert("돈읎다 - 돈벌어와!!!")
      }
    },
    //clickHandler (event){ 이렇게 써도되고 아래처럼 줄여도 됨 상급자의 의견에 따라
    clickHandler: function (event) {
      alert("이벤트 발생: " + event.target)
    }, //메소드 추가하려면 , 하고 똑같이 쓰면됨 실제 코드는 전부 여기배치
    // increment: function () {
    increment() {
      this.count += 1
    },
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id }, 0)
    },
    addFixedMonster () {
      //let은 javascript에서 사용하는 변수 개념이다.
      //java에서는 데이터타입이 반드시 선언에 필요했다면 자바스크립트에서는 let 적으면 알아서 다됨 int 이런거 선언할 필요없어
      //자바의 Object랑 유사
      let max = this.findCurrentMonsterListMax()
      //람다 나왔어 A a = (매개값) -> { 구현코드 }
      //F12 눌러서 디버깅 가능 뷰 개발 때 필수 (console.log("a: " + a + ", b.id: " + b.id);)
      //reduce라는게 동작할때 a,b라는게 있는데 123이 있잖아 a는 리스트의 시작값 1 b는 2
      //1,2 아이디가 대소비교 > b가 더 커 그럼 b를 0번에 배치해둠 2와 3 비교
      //최종적으로 마지막에 있는 3이 뽑혀 나오게 됨
      //자바에서는 collection sort 썼지 자바스크립트에서 reduce 쓰면 최댓값 찾기 매우 간단

      //ab 라고 했을때 인덱스, 객체정보 전체를 가져온거
      //a 는 배열의 인덱스 b는 인덱스에 있는 정보
      //그걸 자동으로 해주는거야 그 정보를 기반으로 이런 함수를 동작 시켜라
      //끝날때까지 돌려 foreach같음
      //마지막에 나온 녀석이 return의 데이터가 된다.
      //, 0자리에 오는게 어떤 의미였나요??
      //  {id: 1, name: '슬라임', hp: 50 },이거 0
      //내부에서는 두개만 있는거고 (a,b)
      //마지막 한자리 올때 까지 채워넣겠다. 마지막 한자리를 0이라고 하는거지. reduce에 의해서 출렸되는 건 하나만 나오는거


      this.monsterLists.push({
            id: max + 1,
            name: this.name,
            hp: 500
      })
    },
    removeMonster (index) {
      this.monsterLists.splice(index, 1)
      //새로운 개념 : splice
      //리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      //splice(index, 1)이므로 index에 해당하는 정보 1개를 삭제한다라는 뜻
      //내가 클릭한 자리에 있는 몬스터가 삭제돼 인덱스에 해당하는 몬스터 1개 삭제
    },
    addRandomMonster () {
      let max = this.findCurrentMonsterListMax()

      //ex) 20개라면 0-19.xxx 까지인데 floor 버림이니까 0~19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },
    addManyRandomMonster () {
      for (let i = 0; i < 100; i++){
        this.addRandomMonster()
      }
    },
    darknessDeathDestinyTypoonBlade (index) {
      console.log(" 어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
      "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!")

      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
          Math.floor( //소수점 발생할수도 있을것 같아서 버림 씀
              this.characterStatus.atk * 78 +
              this.characterStatus.str * 33 +
              this.characterStatus.dex * 30 +
              this.characterStatus.intelligence * 30
          )
    },
    darknessTwilightBrightnessDawnRagnaBlade () {
      console.log(" 여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
      "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!!")

      for (let i = 0; i < this.monsterLists.length; i++) {
        this.monsterLists[i].hp -= 30 * this.characterStatus.atk
      }
    }
  },
  beforeUpdate() {//머서드랑 beforeUpdate는 구별해야해 메서드 안에 넣으면 안됨
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    let i

    for (i = 0; i < this.monsterLists.length; i++) {
      if (this.monsterLists[i].hp <= 0){
        for (let j = 0; j < this.monsterBooks.length; j++){
          if (this.monsterLists[i].name === this.monsterBooks[j].name) { //같다는건 해당 몬스터 잡았다는것 경치랑 드롭머니 지급필요
            this.characterStatus.currentLevelBar += this.monsterBooks[j].exp
            this.characterStatus.money += this.monsterBooks[j].dropMoney
          }
        }
        this.monsterLists.splice(i,1)
      }
    }

    //캐릭터 레벨 1일 떄 광역기 난사하다가 경치 높은 몬스터 동시에 잡았어 > 동시에 여러개 레벨업 되어야함
    while(this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar){
      this.characterStatus.currentLevelBar =
          parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

      this.characterStatus.level += 1
      this.characterStatus.hp = parseInt(this.characterStatus.hp * 1.05)
      this.characterStatus.mp = parseInt(this.characterStatus.mp * 1.05)
      this.characterStatus.defaultAtk += 4
      this.characterStatus.atk += 4
      this.characterStatus.def += 1
      this.characterStatus.str += 3
      this.characterStatus.intelligence += 1
      this.characterStatus.dex += 2
      this.characterStatus.vit += 3
      this.characterStatus.men += 1
      //캐릭터 스테이터스들만 상승 중
      //레벨이 올라갈수록 필요 경치도 증가해야함

      if (this.characterStatus.level < 10) { //레벨이 10보다 낮은 구간
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
//!!!!인벤토리랑 아이템 적용 필요 주말과제!!!! 인벤토리에서 장착 누르면 적용되도록 과제 캐릭터 상태정보에 아이템
</script>

<style scoped>

</style>

