import Vue from 'vue'
import VueRouter from 'vue-router'
import Test from '@/components/basic/Test.vue'
import ComponentTestView from "@/views/basic/ComponentTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axoisTest/VueToSpringView";
import RpgGameView from "@/views/rpg/RpgGameView";
import DataSendTestView from "@/views/basic/DataSendTestView";

import JpaBoardListView from "@/views/boards/JpaBoardListView";
import JpaBoardRegisterView from "@/views/boards/JpaBoardRegisterView";
import JpaBoardModifyView from "@/views/boards/JpaBoardModifyView";
import JpaBoardReadView from "@/views/boards/JpaBoardReadView";
import ProductBoardMainView from "@/views/productBoard/ProductBoardMainView";
import ProductBoardAdminLoginView from "@/views/productBoard/ProductBoardAdminLoginView";
import ProductBoardRegisterView from "@/views/productBoard/ProductBoardRegisterView";
import ProductBoardReadView from "@/views/productBoard/ProductBoardReadView";

Vue.use(VueRouter)

const routes = [
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


    /* --- JpaBoard --- */


  {
    path: '/board-list',
    name: 'JpaBoardListView',
    component: JpaBoardListView
  },
  {
    path: '/board-register',
    name: 'JpaBoardRegisterView',
    component: JpaBoardRegisterView
  },
  {
    path: '/board-read/:boardNo',
    name: 'JpaBoardReadView',
    components: {
      default: JpaBoardReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/board-modify/:boardNo',
    name: 'JpaBoardModifyView',
    components: {
      default: JpaBoardModifyView
    },
    props: {
      default: true
    }
  },


    /* --- product board --- */
  {
    path: '/product-board-main',
    name: 'ProductBoardMainView',
    component: ProductBoardMainView
  },
  {
    path: '/product-board-admin-login',
    name: 'ProductBoardAdminLoginView',
    component: ProductBoardAdminLoginView
  },
  {
    path: '/product-board-register',
    name: 'ProductBoardRegisterView',
    component: ProductBoardRegisterView
  },
  {
    path: 'product-board-read/:productNo',
    name: 'ProductBoardReadView',
    components:{
      default: ProductBoardReadView
    },
    props: {
      default: true
    }
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
