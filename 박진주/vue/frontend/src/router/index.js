import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from '@/components/basics/RpgGame/Test.vue'
import ComponentTestView from "@/views/basics/ComponentTestView";
import Homework from "@/components/basics/RpgGame/Homework.vue";
import ConcaveBoardView from "@/views/game/ConcaveBoardView.vue";
import VueToSpringView from "@/views/axiosTest/VueToSpringView";
import RpgGameView from "@/views/rpg/RpgGameView";
import TestButtonView from "@/views/khtest/TestButtonView";
import DataSendTestView from "@/views/basics/DataSendTestView";

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
    path: '/homework',
    name: 'homework',
    component: Homework
  },
  {
    path: '/components-test',
    name: 'ComponentTestView',
    component: ComponentTestView
  },

  {
    path: '/concave-board-game',
    name: 'ConcaveBoardView',
    component: ConcaveBoardView
  },
  {
    path: '/vue2spring',
    name: 'vue2springView',
    component: VueToSpringView
  },
  {
    path: '/rpg-game',
    name: 'rpggameView',
    component: RpgGameView
  },
  {
    path: '/test-button',
    name: 'testbuttonView',
    component: TestButtonView
  },
  {
    path: '/vue2spring-data-send-test',
    name: 'DataSendTestView',
    component: DataSendTestView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router