package kr.eddi.demo.entity.basic.practiceQuestion;

public enum ScaleCode {

    C("도", 1),
    D("레", 2),
    E("미", 3),
    F("파", 4),
    G("솔", 5),
    A("라", 6),
    B("시", 7);

    private final String code;
    private final int value;
    private ScaleCode(String code , int value){
        this.code = code;
        this.value = value;
    }
}
