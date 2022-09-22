<template>


  <form @submit.prevent="onSubmit">

    <table>

      <input type="checkbox" v-model="arr" value="배송문의">배송문의
      <input type="checkbox" v-model="arr" value="상품문의">상품문의
      <input type="checkbox" v-model="arr" value="사이즈문의">사이즈문의
      <input type="checkbox" v-model="arr" value="재입고문의">재입고문의
      <button @click='checkArr()'>check</button>


      <tr>
        <td>제목</td>
        <td>
          <input type="text" v-model="title">
        </td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>
          <input type="text" v-model="writer">
        </td>
      </tr>
      <tr>
        <td>내용</td>
        <td>
          <textarea cols="50" rows="20" v-model="content">
          </textarea>
        </td>
      </tr>

    </table>

    <div>
      <button type="submit">등록하기</button>
      <router-link to="{ name: 'BoardProductView' }">
        취소하기
      </router-link>
    </div>
  </form>
</template>



<script>
export default {
  name: "BoardRegisterForm",
    arr:[],

  data(){

    return{

      title:"제목을 입력하세요",
      writer:"작성자를 입력하세요",
      content:"본문 내용을 입력하세요"

    }


  },

  methods:{
    checkArr: function(){
      console.log(this.arr);
    },

    onSubmit(){
      const{title,writer,content} = this
      this.$emit('submit',{title,writer,content})

    }

  }




}

</script>

<style scoped>

</style>