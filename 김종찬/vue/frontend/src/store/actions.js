import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_CHARACTER_STATUS,
    REQUEST_SKILL
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7777/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })
    },
    requestCharacterStatus ({ commit }) {
        console.log("requestCharacterStatus()")

        return axios.get('http://localhost:7777/31th/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS, res.data)
            })
    },

    requestSkill ({ commit }) {
        console.log("requestSkill()")

        return axios.get('http://localhost:7777/31th/rpg-game/character-status')
            .then((res) => {
                commit(REQUEST_SKILL, res.data)
            })
    }
}