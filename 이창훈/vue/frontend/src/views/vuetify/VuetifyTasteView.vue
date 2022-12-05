<template>
  <v-container>
    <div>
      <p class="blue lighten-4 red--text">Test</p>
      <p class="blue white--text">Test</p>
      <p class="blue darken-3">Test</p>
      <p class="teal lighten-1 text-center">
        뷰.티.파.이!
      </p>
      <p class="purple darken-5 white--text">Test</p>

      <v-btn class="teal" rounded @click="btnClick">Round Button</v-btn>
      <v-btn class="indigo white--text">Basic Button</v-btn>
      <v-btn class="teal" text>기본 버튼</v-btn>
      <v-btn class="teal" dark>
        <!-- https://materialdesignicons.com/ -->
        <v-icon>mdi-battery-alert-variant-outline</v-icon>
        <span>배터리 교체</span>
      </v-btn>
      <v-btn fab color="orange" dark>
        <v-icon>mdi-bluetooth</v-icon>
      </v-btn>
    </div>

    <v-layout wrap>
      <v-flex class="primary white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="green white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="blue white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>
    <v-layout wrap>
      <v-flex class="teal white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>

    <!-- transition animation은 아래 참조
         https://vuejs.org/guide/built-ins/transition.html
         https://vuejs.org/guide/extras/animation.html -->

    <v-layout justify-center>
      <v-dialog v-model="dialog" persisten max-width="400">
        <template v-slot:activator="{on}">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ name }}
          </v-card-title>
          <v-card-text>
            오늘만 날이다! 먹고 죽엇! 할인 30%!!!
          </v-card-text>
          <v-card-text>
            지금 당장 결제 하시겠습니꽈 ?
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">
              결제 승인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog><br/>
    </v-layout>

    <v-layout justify-center>
      <v-dialog v-model="loginDialog" persistent max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">로그인</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            <span>
              로그인
            </span>
          </v-card-title>
          <v-card-text>
            <v-text-field label="Email" v-model="email" required></v-text-field>
          </v-card-text>
          <v-card-text>
            <v-text-field label="Password" v-model="password" required></v-text-field>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click="btnClick">
              로그인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>

    <v-toolbar dense dark>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
      </v-app-bar-nav-icon>
      <v-toolbar-title>
        <span class="font-weight-light">쵝오의 여행!</span>
        <span>꾸르팁</span>
      </v-toolbar-title>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
          {{ link.text }}
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
          <v-list-item-action>
            <v-icon left>
              {{ link.icon }}
            </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ link.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <div>
      <v-menu offset-y>
        <template v-slot:activator="{ on }">
          <v-btn color="teal darken-1" class="white--text ma-5" v-on="on">
            마! 이거시 DropDown이닷! offset-x는 좌우!
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(dropItem, index) in dropItems" :key="index" link>
            <v-list-item-title>
              {{ dropItem.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <v-data-table :headers="headerTitle"
                  :items="contents"
                  :items-per-page="10"
                  class="elevation-1">
    </v-data-table>

    <div>
      <v-img class="responsive-img" src="@/assets/img/99몽둥이.jpeg"/>
    </div>
    <div class="video-container">
      <iframe width="1200" height="720" src="https://www.youtube.com/embed/3AyCy1UUlpU"
              frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
              allowfullscreen>
      </iframe>
      <!-- url만 바꾸고 나머지는 그냥 계속 따라 쓰면됨-->
    </div>
    <br/>

    <div class="row">
      <div class="col-sm-2 green text-center">2</div>
      <div class="col-sm-2 blue text-center">2</div>
      <div class="col-sm-1 red text-center">1</div>
      <div class="col-sm-3 purple text-center">3</div>
      <div class="col-sm-4 yellow text-center">4</div>

      <div class="col-sm-5 green text-center">5</div>
      <div class="col-sm-6 blue text-center">6</div>
      <div class="col-sm-4 red text-center">4</div>
      <div class="col-sm-8 purple text-center">8</div>
      <div class="col-sm-1 yellow text-center">1</div>
    </div>

    <!-- npm add vue-coverflow -->
    <div>
      <coverflow :coverList="coverList" :coverWidth="260" :index="0"/>
      <!-- index는 어디서 시작할건지 -->
    </div>
  </v-container>
</template>

<script>

import coverflow from 'vue-coverflow'

export default {
  name: "VuetifyTasteView",
  components: {
    coverflow
  },
  data () {
    return {
      coverList: [
        {
          cover: require('@/assets/img/99몽둥이.jpeg'),
          title: '99몽둥이'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/logo.svg'),
          title: 'logo2'
        },
      ],
      headerTitle: [
        { text: '번호', value: 'boardNo', width: "70px"},
        { text: '제목', value: 'title', width: "200px"},
        { text: '작성자', value: 'writer', width: "100px"},
        { text: '내용', value: 'content', width: "100px"},
      ],
      contents: [
        { boardNo: 1, title: '가', writer: 'aa', content: '11'},
        { boardNo: 2, title: '나', writer: 'bb', content: '22'},
        { boardNo: 3, title: '다', writer: 'cc', content: '33'},
        { boardNo: 4, title: '라', writer: 'dd', content: '44'},
        { boardNo: 5, title: '마', writer: 'ee', content: '55'},
        { boardNo: 6, title: '바', writer: 'ff', content: '66'},
        { boardNo: 7, title: '사', writer: 'gg', content: '77'},
        { boardNo: 8, title: '아', writer: 'hh', content: '88'},
        { boardNo: 9, title: '자', writer: 'ii', content: '99'},
        { boardNo: 10, title: '차', writer: 'jj', content: '1010'},
        { boardNo: 11, title: '카', writer: 'kk', content: '1111'},
        { boardNo: 12, title: '타', writer: 'll', content: '1212'},
        { boardNo: 13, title: '파', writer: 'mm', content: '1313'},
        { boardNo: 14, title: '하', writer: 'nn', content: '1414'},
        { boardNo: 15, title: '야호', writer: 'oo', content: '1515'},
      ],
      name: '7박 8일 여행 코스!',
      email: '',
      password: '',
      loginDialog: false,
      dialog: false,
      nav_drawer: false,
      links: [
        { icon: 'mdi-home', text: 'Home', name: 'home', route: '/' },
        { icon: 'mdi-ev-station', text: '전기차 충전소', name: 'home', route: '/' },
      ],
      dropItems: [
        { title: '가'},
        { title: '나'},
        { title: '다'},
        { title: '라'},
      ],
    }
  },
  methods: {
    btnClick () {
      alert('Vuetify 테스트 버튼')
    }
  }
}
</script>

<style scoped>
</style>