<template>

  <div align="right" class="menu">
    <a>
      <router-link to="/guest-join">회원가입</router-link>
    </a>
    <a>
      <router-link to="/guest-login">로그인</router-link>
    </a>
    <a>
      <router-link to="">고객센터</router-link>
    </a>
    <div/>


    <div>
      <h1 align="center" class="banner">
        <router-link to="/goods-sale">테스트 굿즈샵</router-link>
      </h1>
    </div>

    <div>
      <table align="left">
        <tr>
          <th width="100">
            <router-link to="/goods-sale">
              전체상품
            </router-link>
          </th>
          <th width="100">
            <router-link to="">
              인기상품
            </router-link>
          </th>
          <th width="100">
            <router-link to="">
              NEW
            </router-link>
          </th>
        </tr>
      </table>
      <div> <router-link :to="{ name: 'ProductRegisterView' }">
        게시물 작성
      </router-link></div>
    </div>
    <br/><br/><br/><br/><br/><br/>
    <div align="center">
      <table border="1">
        <tr>
          <th align="center" width="100">No</th>
          <th align="center" width="640">상품명</th>
          <th align="center" width="150">판매자</th>
          <th align="center" width="240">가격</th>
        </tr>
        <tr v-if="!goodsSaleBoards || (Array.isArray(goodsSaleBoards) && goodsSaleBoards.length === 0)">
          <td colspan="4" align="center">
            현재 등록된 상품이 없습니다!
          </td>
        </tr>
        <tr v-else v-for="goodsSaleBoard in goodsSaleBoards" :key="goodsSaleBoard.boardNo">
          <td align="center">
            {{ goodsSaleBoard.boardNo }}
          </td>
          <td align="center">
            <router-link :to="{ name: 'JpaBoardReadView',
                              params: { boardNo: goodsSaleBoard.boardNo.toString() }}">
              {{ goodsSaleBoard.title }}
            </router-link>
          </td>
          <td align="center">
            {{ goodsSaleBoard.seller}}
          </td>
          <td align="center">
            {{ goodsSaleBoard.price.toLocaleString() }}원
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "JpaProductList",
  props: {
    goodsSaleBoards: {
      type: Array
    }
  }
}
</script>

<style scoped>
.menu a {
  padding: 5px;
}

.banner {
  margin-top: 100px;
  margin-bottom: 100px;
}

</style>