import {
    REQUEST_PLAYER_DATA_FROM_SPRING,
    REQUEST_MONSTER_DATA,
    REQUEST_STOCK_DATA,
} from './mutation-types'

export default {
    [REQUEST_PLAYER_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_MONSTER_DATA] (state, passingData) {
        state.monstersData = passingData
    },
    [REQUEST_STOCK_DATA] (state, passingData) {
        state.stockData = passingData
    }
}
