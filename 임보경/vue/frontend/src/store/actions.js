import {
    REQUEST_PLAYER_DATA_FROM_SPRING,
    REQUEST_MONSTER_DATA,
} from './mutation-types'


// npm install axios --save-dev
// cmd 해당 폴더로 들어가서 위의 텍스트 치면 알아서 설치됨.
import axios from 'axios'

export default {
    //Critical Section 관련 정리가 필요함(월요일)
    //Critical Section때문에 mutation에 저장해야 하는 이유가 있음
    requestPlayerDataFromSpring ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/player')
            .then((res) => {
                commit(REQUEST_PLAYER_DATA_FROM_SPRING, res.data)
            })
    },

    requestMonsterData ({ commit }) {
        return axios.get('http://localhost:7777/make-game-alone/start/playing')
            .then((res) => {
                console.log("왜 커밋일 안될까???")
                commit(REQUEST_MONSTER_DATA, res.data)
            })
    },
}