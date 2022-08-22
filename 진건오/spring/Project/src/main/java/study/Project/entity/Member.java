package study.Project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Member {

    private String userName = "eddi";
    private String password = "123456";

}
/*
        반 학생이 30명이 있다.

        이들은 모두 시험을 치뤘고 모든 학생들은 60점 미만이 없다고 한다.

        이 상태에서 학생들의 점수를 임의로 배치하고

        학급의 평균값을 구해보도록 한다.


        4번의 경우엔 URL 맵핑을 "/homework2"

*/


