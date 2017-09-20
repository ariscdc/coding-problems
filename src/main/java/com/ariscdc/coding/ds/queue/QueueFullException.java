package com.ariscdc.coding.ds.queue;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160306 1420-1425 (5 mins.)
 */
public class QueueFullException extends Exception {

    private static final long serialVersionUID = 1893933029947533102L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

    public QueueFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueFullException(Throwable cause) {
        super(cause);
    }
}
