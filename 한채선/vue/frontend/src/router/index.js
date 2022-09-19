import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from '@/components/basic/Test.vue'
import ComponentTestView from "@/views/basic/ComponentTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axoisTest/VueToSpringView";
import RpgGameView from "@/views/rpg/RpgGameView";
import DataSendTestView from "@/views/basic/DataSendTestView";

import JpaBoardListView from "@/views/boards/JpaBoardListView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/test',
    name: 'test',
    component: Test
  },
  {
    path: '/component-test',
    name: 'ComponentTestView',
    component: ComponentTestView
  },
  {
    path: '/concave-board-view',
    name: 'ConcaveBoardView',
    component: ConcaveBoardView
  },
  {
    path: '/vue2spring',
    name: 'VueToSpring',
    component: VueToSpringView
  },
  {
    path: '/rpg-game',
    name: 'RPGGame',
    component: RpgGameView
  },
  {
    path: '/data-send-test-view',
    name: 'DataSendTestView',
    component: DataSendTestView
  },

  {
    path: '/board-list',
    name: 'JpaBoardListView',
    component: JpaBoardListView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
