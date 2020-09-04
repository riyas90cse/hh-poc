package com.hh.export.exception;

/**
 * @author Mohamed Riyas
 */
public class HHExportException extends Exception {

    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 345456L;

    public HHExportException() {

    }

    public HHExportException(String message) {
        super(message);
    }

    public HHExportException(Throwable cause) {
        super(cause);
    }

    public HHExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public HHExportException(String message, Error error) {
        super(message, error);
    }
}
