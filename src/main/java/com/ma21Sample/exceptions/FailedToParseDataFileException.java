package com.ma21Sample.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FailedToParseDataFileException extends Exception {
    public FailedToParseDataFileException(String message) {
        super(message);
    }

    public FailedToParseDataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToParseDataFileException(Throwable cause) {
        super(cause);
    }

    public FailedToParseDataFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
