import {
    REQUEST_DATA_FROM_SPRING
} from './mutation-types'

import axios from 'axios'

export default {
    // Critical Section 관련 정리가 필요함(월요일)
    // 얘도 메서드다
    requestDataFromSpring ({ commit }) { // 이 commit은 자동으로 붙음(뭐라 얘기 들었는데 까먹..)
        console.log("I'm from action - requestDataFromSpring()")
        // axios.get() 부분이 주소창에 ()안의 url을 입력한거랑 똑같이 작동함.(요청)
        return axios.get('http://localhost:7777/30th/vue2spring/test')
            // url에서 리턴값이 나오면 .then이 동작
            .then((res) => {
                // 받아온 데이터에서 필요한 값만 가져옴(??randomNumber 객체의 변수 randomNumber)
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)
            })

    }
}
