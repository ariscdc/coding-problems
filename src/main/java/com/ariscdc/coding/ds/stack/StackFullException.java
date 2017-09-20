package com.ariscdc.coding.ds.stack;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160206 0910-0915 (5 mins.)
 */
public class StackFullException extends Exception {

    private static final long serialVersionUID = 5877160872957627497L;

    public StackFullException() {
        super();
    }

    public StackFullException(String message) {
        super(message);
    }

    public StackFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackFullException(Throwable cause) {
        super(cause);
    }
}
