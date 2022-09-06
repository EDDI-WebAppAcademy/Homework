<template>
  <div class="menu">
    <ul>
      <li
          v-for="(item, index) in menuList"
          v-bind:class="{'white': menuList[index].checked === false, 'red' : menuList[index].checked === true}"
          @click="changeColor(index)"
          :key="index">
        {{ item.name }}
      </li>
    </ul>


  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {
  },
  data() {
    return {
      menuList: [
        {name: '불고기 버거', checked: false},
        {name: '치즈 버거', checked: false},
        {name: '치킨 버거', checked: false}
      ],
    }
  },
  methods: {
    changeColor(index) {
      for (let i = 0; i < this.menuList.length; i++) {
       if(i === index) {
         this.menuList[i].checked = !this.menuList[i].checked
       }
      }
    }
  }
}
</script>
<style>
  .white {
    background-color: white;
  }
  .red {
    background-color: red;
  }

</style>
