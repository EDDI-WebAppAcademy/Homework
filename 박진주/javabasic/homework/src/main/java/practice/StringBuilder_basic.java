package practice;

public class StringBuilder_basic {

    public static void main(String[] args) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("hell").append(" ");
        stringbuilder.append("world");
        String a = stringbuilder.toString();

        System.out.println(a);
        System.out.println(stringbuilder);
    }

}
