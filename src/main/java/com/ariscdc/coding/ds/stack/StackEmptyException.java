package com.ariscdc.coding.ds.stack;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160206 0910-0915 (5 mins.)
 */
public class StackEmptyException extends Exception {

    private static final long serialVersionUID = -8488040577057832379L;

    public StackEmptyException() {
        super();
    }

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackEmptyException(Throwable cause) {
        super(cause);
    }
}
