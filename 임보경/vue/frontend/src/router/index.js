import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from "@/components/Test";
import ComponentsTestView from "@/views/basics/ComponentsTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axiosTest/VueToSpringView";
import DataSendTestView from "@/views/axiosTest/DataSendTestView";
import MakeGameView from "@/views/makeGame/MakeGameView";

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
    path: '/make-game-view',
    name: 'MakeGameView',
    component: MakeGameView
  },
  {
    path: '/components-test-view',
    name: 'ComponentsTestView',
    component: ComponentsTestView
  },
  {
    path: '/concave-board-game',
    name: 'ConcaveBoardView',
    component: ConcaveBoardView
  },
  {
    path: '/vue2spring',
    name: 'VueToSpringView',
    component: VueToSpringView
  },
  {
    path: '/data-send-test',
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
