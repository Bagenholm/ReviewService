package org.ia.reviews;

public class ReviewException extends RuntimeException {
    String s;

    public ReviewException(String s) {
        this.s = s;
    }
}
