package com.example.testtaskrestapi.exceptions;

public abstract class ClientRequestException extends RuntimeException {
    public ClientRequestException(String message) {
        super(message);
    }

    public ClientRequestException(Throwable cause) {
        super(cause);
    }

    public static class InputException extends ClientRequestException {
        public InputException(Throwable cause) {
            super(cause);
        }

        public InputException(String message) {
            super(message);
        }
    }
}
