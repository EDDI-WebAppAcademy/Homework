package kr.eddi.demo.homeworkEntity.utility.basic.seventh;


import kr.eddi.demo.homeworkEntity.seventh.LottoPlayer;

import java.util.List;

public interface PreventLottoSameNumOption {
    public void checkLottoSameNum(List<LottoPlayer> players, int lottoNum, int lottoSequence, int playerI);
}