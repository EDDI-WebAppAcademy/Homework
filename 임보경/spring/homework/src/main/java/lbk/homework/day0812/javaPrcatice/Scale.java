package lbk.homework.day0812.javaPrcatice;

public enum Scale {
    Do("도", "C"),
    Re("레", "D"),
    Mi("미", "E"),
    Fa("파", "F"),
    Sol("솔", "G"),
    La("라", "A"),
    Si("시", "B");

    private final String name;
    private final String value;

    private Scale(String name, String value) {
        this.name = name;
        this.value = value;
    }

}




