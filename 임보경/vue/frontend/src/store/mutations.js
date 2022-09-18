import {
    REQUEST_CHARACTER_DATA_FROM_SPRING,
} from './mutation-types'

export default {
    [REQUEST_CHARACTER_DATA_FROM_SPRING] (state, passingData) {
        state.characterStatus = passingData
    },

}
