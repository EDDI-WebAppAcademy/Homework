package kr.eddi.demo.entity.homework.seventh;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class LottoNumber {
    private int lottoNum;
    private int ranNum = CustomRandom.makeIntCustomRandom(0, 99);








}
