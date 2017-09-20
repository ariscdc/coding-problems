package com.ariscdc.coding.ds.queue;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160306 1420-1425 (5 mins.)
 */
public class QueueEmptyException extends Exception {

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

    public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueEmptyException(Throwable cause) {
        super(cause);
    }
}
