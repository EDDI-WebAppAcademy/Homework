import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ProductsBoardListView from "@/views/productsBoard/ProductsBoardListView";
import ProductRegisterView from "@/views/productsBoard/ProductRegisterView";
import ProductsBoardReadView from "@/views/productsBoard/ProductsBoardReadView";
import ProductsBoardModifyView from "@/views/productsBoard/ProductsBoardModifyView";


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
  {
    path: '/board-read/:boardNo',
    name: 'ProductsBoardReadView',
    components: {
      default: ProductsBoardReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/board-modify/:boardNo',
    name: 'ProductsBoardModifyView',
    components: {
      default: ProductsBoardModifyView
    },
    props: {
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
