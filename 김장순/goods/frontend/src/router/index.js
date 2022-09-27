import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import GoodsBoardsView from "@/views/goods/GoodsBoardsView";
import GoodsRegisterView from "@/views/goods/GoodsRegisterView";
import GoodsReadView from "@/views/goods/GoodsReadView";


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView
    },
    {
        path: '/goods-board',
        name: 'GoodsBoardsView',
        component: GoodsBoardsView
    },
    {
        path: '/goods-register',
        name: 'GoodsRegisterView',
        component: GoodsRegisterView
    },
    {
        path: '/goods-read/:goodsNo',
        name: 'GoodsReadView',
        components: { //s 를 무조건 붙여줘야한다......
            default: GoodsReadView
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
