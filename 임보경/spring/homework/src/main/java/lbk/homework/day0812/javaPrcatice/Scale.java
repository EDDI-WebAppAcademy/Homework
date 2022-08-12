package lbk.homework.day0812.javaPrcatice;

public enum Scale {

    Do, Re, Mi, Fa, Sol, La, Si;

    public static String acquireScale(Scale sc) {
        switch (sc) {
            case Do: return "도";
            case Re:  return "레";
            case Mi: return "미";
            case Fa:  return "파";
            case Sol:  return "솔";
            case La:  return "라";
            case Si:  return "시";
        }
        return "잘못된 이름";
    }

}




