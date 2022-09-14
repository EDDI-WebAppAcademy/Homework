package kr.eddi.demo.homework.utility.seventh;


import kr.eddi.demo.homework.entity.seventh.LottoPlayer;

import java.util.List;

public interface PreventLottoSameNumOption {
    public void checkLottoSameNum(List<LottoPlayer> players, int lottoNum, int lottoSequence, int playerI);
}