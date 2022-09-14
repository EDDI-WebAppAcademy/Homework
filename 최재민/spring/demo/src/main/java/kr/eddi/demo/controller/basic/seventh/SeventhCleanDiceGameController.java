package kr.eddi.demo.controller.basic.seventh;
import kr.eddi.demo.entity.basic.seventh.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/seventh")
public class SeventhCleanDiceGameController {

        private final int DEFAULT_PLAYER_NUM = 2;
        private final int DEATH_SCORE = -4444;
        private List<Player> players;
        private int playerNum;

        @GetMapping("/dice-game")
        public String diceGameStarter() {

                createPlayer();
                gameStart();

                return checkWinner();
        }

        public void createPlayer() {

                players = new ArrayList<>();
                this.playerNum = DEFAULT_PLAYER_NUM;
                createPlayerObj(players, DEFAULT_PLAYER_NUM);

        }
        public void createPlayerObj(List<Player> players, int playerObjNum) {
                for (int i = 0; i < playerObjNum; i++) {
                        players.add(new Player());
                }
        }


        public void gameStart() {
                for (int i = 0; i < playerNum; i++) {
                        players.get(i).gameStart(players);
                }
        }

        public String checkWinner() {

                log.info("정렬전: " + String.valueOf(players));

                Collections.sort(players);

                log.info("정렬후: " + String.valueOf(players));

                int maxPlayerScore = acquirePlayerTotalScore(playerNum - 1);

                if (maxPlayerScore == DEATH_SCORE) { return "전원 탈락!!!"; }

                List<Integer> sameScoreIdxList = new ArrayList<>();

                for (int i = playerNum - 2; i >= 0; i--) {
                        int tmpScore = acquirePlayerTotalScore(i);

                        if (maxPlayerScore != tmpScore) { break; }

                        sameScoreIdxList.add(i);
                }

                if (sameScoreIdxList.size() > 0) { return "무승부입니다!"; }

                return "플레이어: " + players.get(playerNum - 1).getNickName() + " 님이 승리하였습니다!";
                }

                public int acquirePlayerTotalScore(int idx) {
                        return players.get(idx).getScore().getTotalScore();
                }
        }