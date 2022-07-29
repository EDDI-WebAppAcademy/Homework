package kr.eddi.demo.entity.basic.sixth;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxFinder {
    public int findMaxScore(List<Integer> list){

        int maxScore = Collections.max(list);

        return maxScore;
    }
    public int findMaxScorePlayer(List<Integer> list){

        int maxScore = Collections.max(list);
        int indexNum = list.indexOf(maxScore);

        return indexNum;
    }
}
