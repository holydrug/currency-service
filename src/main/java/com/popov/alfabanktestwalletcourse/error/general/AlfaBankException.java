package com.popov.alfabanktestwalletcourse.error.general;

public class AlfaBankException extends  Exception {
    public AlfaBankException() {
    }

    public AlfaBankException(String message) {
        super(message);
    }

    public AlfaBankException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlfaBankException(Throwable cause) {
        super(cause);
    }

    public AlfaBankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
