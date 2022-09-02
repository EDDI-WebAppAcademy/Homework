<template>
  <div>
    <fieldset>
      <legend><h3>캐릭터 상태 창</h3></legend>
      <p>HP: {{characterStatus.hp + characterStatus.addedStatus.hp}} MP: {{characterStatus.mp + characterStatus.addedStatus.mp}} ATK: {{ characterStatus.atk + characterStatus.addedStatus.atk }} LV: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob}}</p>
      <p>STR: {{ characterStatus.str + characterStatus.addedStatus.str }} INT: {{ characterStatus.intelligence + characterStatus.addedStatus.intelligence }} DEX: {{ characterStatus.dex + characterStatus.addedStatus.dex }} VIT: {{ characterStatus.vit + characterStatus.addedStatus.vit}} DEF: {{ characterStatus.def + characterStatus.addedStatus.def }} MEN: {{ characterStatus.men + characterStatus.addedStatus.men }}</p>
      <p>경험치: {{ characterStatus.currentLevelBar }} | {{ characterStatus.totalLevelBar }}</p>
      <p>소지금: {{ characterStatus.money }}</p>
      <character-manager/>
      <fieldset>
        <legend><h3>인벤토리 </h3></legend>
        <label>
          <input type="checkbox" v-model="inventoryView">
          아이템 목록
          <button v-on:click="equipItem()">아이템 장착!</button>
        </label>
        <table border="1" v-if="inventoryView">
          <tr>
            <th align="center" width="40">번호</th>
            <th align="center" width="120">아이템 명</th>
            <th align="center" width="320">아이템 설명</th>
            <th align="center" width="80">사용</th>
            <th align="center" width="40">장착</th>
          </tr>
          <tr v-for="(inventoryItems, index) in characterStatus.inventory" :key="index">
            <th align="center" width="40"> {{ index + 1 }}</th>
            <th align="center" width="120"> {{ inventoryItems.name }}</th>
            <th align="center" width="320"> {{ inventoryItems.effect.description }}</th>
            <th align="center" width="80">
              <button v-on:click="useItemInInventory(index)">아이템 사용</button>
            </th>
            <th align="center" width="40">
              <label>
                <input type="checkbox" v-model="characterStatus.inventoryValue" :value="index">
              </label>
            </th>
          </tr>
        </table>
      </fieldset>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "CharacterStatusManager",
  data() {
    return {
      inventoryView: true,
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
        def: 10,
        men: 0,
        totalLevelBar: 10,
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가',
        inventory: [],
        inventoryValue: [],
        addedStatus: {
          hp: 0,
          mp: 0,
          atk: 0,
          str: 0,
          intelligence: 0,
          dex: 0,
          vit: 0,
          def: 0,
          men: 0
        }
      }
    }
  },

  methods: {
    equipItem() {
      let tmpSum = 0
      this.characterStatus.itemAtk = 0


      for (let i = 0; i < this.characterStatus.inventoryValue.length; i++) {
        for (let j = 0; j < this.characterStatus.inventory.length; j++) {
          if(this.characterStatus.inventoryValue[i] == j) {
            tmpSum += this.characterStatus.inventory[j].effect.amount
            break
          }
        }
      }

      this.characterStatus.itemAtk = tmpSum
      this.characterStatus.atk = (this.characterStatus.defaultAtk + this.characterStatus.itemAtk)

    },

    useItemInInventory(index){

      // switch문으로 바꾸는게 더 조을것같음 -> 잘됨~
      // 공통 코드는 메소드로 빼기(애매하네...)


      switch (this.characterStatus.inventory[index].effect.status) {
        case 'atk':
          this.characterStatus.itemAtk += this.characterStatus.inventory[index].effect.amount
          this.characterStatus.inventory.splice(index, 1)
          alert('아이템 효과 적용 완료!')
          break
        case 'hp':
          this.characterStatus.hp += this.characterStatus.inventory[index].effect.amount
          this.characterStatus.inventory.splice(index, 1)
          alert('아이템 효과 적용 완료!')
          break
        default:
          alert('해당사항 없음')
      }
    },


  },

  beforeUpdate() {
    if(this.characterStatus.level == 99) { return }

    while (this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar) {
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

      if(this.characterStatus.level < 10){
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.2)
      } else if(this.characterStatus.level < 30) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      } else if(this.characterStatus < 50) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.1)
      } else if(this.characterStatus.level < 100) {
        this.characterStatus.totalLevelBar = parseInt(this.characterStatus.totalLevelBar * 1.3)
      }

    }

    /* before update end */
  }

}
</script>

<style scoped>

</style>