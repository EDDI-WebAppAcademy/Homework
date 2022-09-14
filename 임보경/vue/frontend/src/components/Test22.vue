<template>
  <div>
    <character-manager/>
    <monster-manager/>

    <h3>상점</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
<!--    <button v-on:click="calcBuyList()">구매 확정</button>-->
<!--    <table border="1" v-if="shopView">-->
<!--      <tr>-->
<!--        <th align="center" width="40">번호</th>-->
<!--        <th align="center" width="120">아이템명</th>-->
<!--        <th align="center" width="160">가격</th>-->
<!--        <th align="center" width="320">아이템 설명</th>-->
<!--        <th align="center" width="40">구매</th>-->
<!--      </tr>-->
<!--      <tr v-for="(item, index) in shopList" :key="index">-->
<!--        <th align="center" width="40">{{ index }}</th>-->
<!--        <th align="center" width="120">{{ item.name }}</th>-->
<!--        <th align="center" width="160">{{ item.price }}</th>-->
<!--        <th align="center" width="320">{{ item.effect.description }}</th>-->
<!--        <th align="center" width="40">-->
<!--          <label>-->
<!--            <input type="checkbox" v-model="shopListValue" :value="index">-->
<!--          </label>-->
<!--        </th>-->
<!--      </tr>-->
<!--    </table><br/><br/>-->

<!--    <h3>인벤토리</h3>-->
<!--    <label>-->
<!--      <input type="checkbox" v-model="inventoryView">-->
<!--      소지품 보기-->
<!--    </label>-->
<!--    <button v-on:click="equipItem()">아이템 장착!</button>-->
<!--    <table border="1" v-if="inventoryView">-->
<!--      <tr>-->
<!--        <th align="center" width="40">번호</th>-->
<!--        <th align="center" width="120">아이템명</th>-->
<!--        <th align="center" width="320">아이템 설명</th>-->
<!--        <th align="center" width="40">장착</th>-->
<!--      </tr>-->
<!--      <tr v-for="(itemList, idx) in myInventory" :key="idx">-->
<!--        <th align="center" width="40">{{ idx + 1 }}</th>-->
<!--        <th align="center" width="120">{{ itemList.name }}</th>-->
<!--        <th align="center" width="320">{{ itemList.effect.description }}</th>-->
<!--        <th align="center" width="40">-->
<!--          <label>-->
<!--            <input type="checkbox" v-model="myInventoryValue" :value="idx">-->
<!--          </label>-->
<!--        </th>-->
<!--      </tr>-->
<!--    </table><br/><br/>-->




<!--    <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button><br/>-->
<!--    <button v-on:click="darknessDeathDestinyTypoonBlade(index)"> Darkness Death Destiny Typoon Blade </button>-->


  </div>
</template>

<script>
import MonsterManager from "@/components/basics/MonsterManager";
import CharacterManager from "@/components/basics/CharacterManager";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager
  },
  data() {
    return {
      inventoryView: false,
      myInventory: [],
      myInventoryValue: [],
      shopView: false,
      shopList: [],
      shopListValue: [],
    }
  },
  methods: {
    // equipItem () {
    //   let tmpSum = 0
    //   for (let i = 0; i < this.myInventoryValue.length; i++) {
    //     for (let j = 0; j < this.myInventory.length; j++) {
    //       if (this.myInventoryValue[i] === j) {
    //         tmpSum += this.myInventory[j].effect.atk
    //         break
    //       }
    //     }
    //   }
    //   this.characterStatus.itemAtk = tmpSum
    //   this.characterStatus.atk = this.characterStatus.defaultAtk + tmpSum + this.exchangeStatus.atk
    // },
    // shuffleShopList () {
    //   if (!this.shopView) {
    //     this.shopListValue = []
    //   }
    //   for (let i = 0; i < 10; i++) {
    //     let randIdx = Math.floor(Math.random() * this.itemBooks.length)
    //     this.shopList[i] = this.itemBooks[randIdx]
    //   }
    // },
    // calcBuyList () {
    //   let tmpSum = 0
    //   for (let i = 0; i < this.shopListValue.length; i++) {
    //     for (let j = 0; j < this.shopList.length; j++) {
    //       if (this.shopListValue[i] === j) {
    //         tmpSum += this.shopList[j].price
    //         break
    //       }
    //     }
    //   }
    //   if (this.characterStatus.money - tmpSum >= 0) {
    //     this.characterStatus.money -= tmpSum
    //     for (let i = 0; i < this.shopListValue.length; i++) {
    //       this.myInventory.push({
    //         name: this.shopList[this.shopListValue[i]].name,
    //         effect: this.shopList[this.shopListValue[i]].effect
    //       })
    //     }
    //     alert("물품 구매 완료!")
    //   } else { alert("돈읎다 - 돈벌어와!!!") }
    // },
    // // clickHandler (event) {
    // clickHandler: function (event) {
    //   alert("이벤트 발생: " + event.target)
    // },


  //   darknessDeathDestinyTypoonBlade (index) {
  //     console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
  //         "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!!")
  //     this.monsterLists[index].hp =
  //         this.monsterLists[index].hp -
  //         Math.floor(
  //             this.characterStatus.atk * 70 +
  //             this.characterStatus.str * 33 +
  //             this.characterStatus.dex * 30 +
  //             this.characterStatus.intelligence * 30
  //         )
  //   },
  //   darknessTwilightBrightnessDawnRagnaBlade () {
  //     console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
  //         "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")
  //     for (let i = 0; i < this.monsterLists.length; i++) {
  //       this.monsterLists[i].hp -= 30 * this.characterStatus.atk
  //     }
  //   }
  },

  beforeUpdate() {
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")
  }
}
</script>

<style scoped>
</style>