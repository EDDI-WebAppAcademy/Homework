import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainBoard from "@/components/boards/MainBoard";
import BoardRegisterView from "@/views/boards/BoardRegisterView";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/main-board',
    name: 'main-board',
    component: MainBoard
  },
  {
    path: '/Board-Register-View',
    name: 'Board-Register-View',
    component: BoardRegisterView
  },







]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
