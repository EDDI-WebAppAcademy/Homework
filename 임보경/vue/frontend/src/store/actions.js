import {
    REQUEST_CHARACTER_DATA_FROM_SPRING,
} from './mutation-types'


// npm install axios --save-dev
// cmd 해당 폴더로 들어가서 위의 텍스트 치면 알아서 설치됨.
import axios from 'axios'

export default {

    requestCharacterDataFromSpring ({ commit }) {
        console.log("vue측에서 axios 준비완료")

        return axios.get('http://localhost:7777/2nd/response-character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_DATA_FROM_SPRING, res.data)
            })
    },


}