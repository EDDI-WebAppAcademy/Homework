import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from "@/components/Test";
import MakeGame from "@/components/MakeGame";
import ComponentsTestView from "@/views/basics/ComponentsTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axiosTest/VueToSpringView";
import MakeGameAloneView from "@/views/makeGameAlone/GameView";

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
    path: '/MakeGame',
    name: 'MakeGame',
    component: MakeGame
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
    path: '/make-game-alone',
    name: 'MakeGameAloneView',
    component: MakeGameAloneView
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
