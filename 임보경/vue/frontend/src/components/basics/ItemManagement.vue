<template>

</template>

<script>
export default {
  name: "ItemManagement",
  data(){
    return {

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
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>