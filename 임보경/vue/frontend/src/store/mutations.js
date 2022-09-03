import {
    REQUEST_PLAYER_DATA_FROM_SPRING,
    REQUEST_MONSTER_DATA,
} from './mutation-types'

export default {
    [REQUEST_PLAYER_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_MONSTER_DATA] (state, passingData) {
        state.monstersData = passingData
    }
}
