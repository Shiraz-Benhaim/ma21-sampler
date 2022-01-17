package com.ma21Sample.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FailedToWriteDataFileException extends Exception {
    public FailedToWriteDataFileException(String message) {
        super(message);
    }

    public FailedToWriteDataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToWriteDataFileException(Throwable cause) {
        super(cause);
    }

    public FailedToWriteDataFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
