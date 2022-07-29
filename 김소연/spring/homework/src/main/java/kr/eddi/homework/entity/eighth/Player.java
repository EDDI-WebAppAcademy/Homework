package kr.eddi.homework.entity.eighth;

import kr.eddi.homework.utility.eighth.Lotto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player implements Comparable<Player>{
    private Score score;
    private String nickname;
    private final String DEFAULT = "anonymous";

    public Player(){
        nickname = DEFAULT;
        score = new Score();
    }

    public void lottoStart(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 6; j++) {
                int lottoNum = Lotto.doLotto();
                score.lottoScore(lottoNum);
            }
        }
    }

    public int compareTo(Player player){
        int srcScore = this.getScore().getResultScore();
        int dstScore = player.getScore().getResultScore();

        if(srcScore > dstScore){
            return 1;
        } else if (srcScore < dstScore){
            return -1;
        } else{
            return 0;
        }
    }
}
