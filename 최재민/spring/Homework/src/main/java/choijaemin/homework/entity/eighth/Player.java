package choijaemin.homework.entity.eighth;

import choijaemin.homework.utility.eighth.DrawLottoNum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player implements Comparable<Player>{
    private Score score;
    private String nickName;
    private final int DRAWCNT = DrawLottoNum.setDrawCnt();
    private final String DEFAULT_NICKNAME = "anonymous";

    public Player(){
        score = new Score();
        nickName = DEFAULT_NICKNAME;
    }
    public Player(String NickName){
        score = new Score();
        this.nickName = NickName;
    }

    public void drawLottoNum(List<Player> players){
        int drawNum;
        for (int i = 0; i < DRAWCNT; i++) {
            drawNum = DrawLottoNum.makeLottoNum();
            score.addlotteryNum(drawNum);
        }
    }


    @Override
    public int compareTo(Player player) {
        int srcScore = this.getScore().getTotalScore();
        int dstScore = player.getScore().getTotalScore();


        if (srcScore > dstScore){
            return 1;
        }else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}