import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_CHARACTER_STATUS,
    REQUEST_SKILL
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_CHARACTER_STATUS] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_SKILL] (state, passingData) {
        state.myInventory = passingData
    }
}