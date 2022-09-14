package javapractice;

public class RandomChar {
    private char random;

    public char getRandom() {
        return random;
    }
    public void randomCharacter() {
        int temp = (int)(Math.random()*58 + 65);
        random = (char)temp;
    }
}
