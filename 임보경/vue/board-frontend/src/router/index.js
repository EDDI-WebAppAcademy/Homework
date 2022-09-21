import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ProductsBoardListView from "@/views/productsBoard/ProductsBoardListView";
import ProductRegisterView from "@/views/productsBoard/ProductRegisterView";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/board-list',
    name: 'ProductsBoardListView',
    component: ProductsBoardListView
  },
  {
    path: '/product-register',
    name: 'ProductRegisterView',
    component: ProductRegisterView
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
