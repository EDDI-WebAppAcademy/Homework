import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from '@/components/basics/Test'
import ComponentTestView from "@/views/basics/ComponentTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axiosTest/VueToSpringView";
import RpgGameView from "@/views/rpg/RpgGameView";
import DataSendTestView from "@/views/basics/DataSendTestView";
import JpaBoardListView from "@/views/boards/JpaBoardListView";
import JpaBoardRegisterView from "@/views/boards/JpaBoardRegisterView";
import JpaBoardReadView from "@/views/boards/JpaBoardReadView";
import JpaBoardModifyView from "@/views/boards/JpaBoardModifyView";
import GoodsSaleListView from "@/views/goodsSale/GoodsSaleListView";
import ProductRegisterView from "@/views/goodsSale/ProductRegisterView";


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
        path: '/concave-board-game',
        name: 'concaveBoardView',
        component: ConcaveBoardView
    },
    {
        path: '/vue2spring',
        name: 'vue2spring',
        component: VueToSpringView
    },
    {
        path: '/rpg-game',
        name: 'RpgGameView',
        component: RpgGameView
    },
    {
        path: '/data-send-test',
        name: 'DataSendTestView',
        component: DataSendTestView
    },
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
        props: {             //복합컴포넌트이기때문에
            default: true
        }
    },
    {
        path: '/board-modify/:boardNo', //가변인자 처리
        name: 'JpaBoardModifyView',
        components: {
            default: JpaBoardModifyView
        },
        props: {
            default: true
        }
    },
    {
        path: '/goods-sale-list',
        name: 'GoodsSaleListView',
        component: GoodsSaleListView
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
