package kr.co.clozet.auth.exception;

public class LoginRunnerException extends RuntimeException {
    private static final long SerializableUID = 1L;

    public LoginRunnerException() {
        super();
    }

    public LoginRunnerException(String msg) {
        super(msg);
    }
}
