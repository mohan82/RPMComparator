package org.rpmcomparator.service;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPMParseException extends Exception {
    private static final long serialVersionUID = -8858932640645181339L;

    public RPMParseException() {
    }

    public RPMParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RPMParseException(String message) {
        super(message);
    }

    public RPMParseException(Throwable cause) {
        super(cause);
    }

    public RPMParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
