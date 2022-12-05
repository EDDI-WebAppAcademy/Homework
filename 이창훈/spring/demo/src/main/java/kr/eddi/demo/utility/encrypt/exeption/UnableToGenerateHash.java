package kr.eddi.demo.utility.encrypt.exeption;

public class UnableToGenerateHash extends RuntimeException {
    public UnableToGenerateHash(String message) {
        super(message);
    }

    public UnableToGenerateHash(String message, Throwable cause) {
        super(message, cause);
    }
}
