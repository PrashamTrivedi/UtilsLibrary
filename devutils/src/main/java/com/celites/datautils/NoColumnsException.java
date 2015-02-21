package com.celites.datautils;

/**
 * Created by Prasham on 21-02-2015.
 */
public class NoColumnsException
		extends Exception {
	/**
	 * Constructs a new {@code Exception} with the current stack trace and the specified detail message.
	 *
	 * @param detailMessage
	 * 		the detail message for this exception.
	 */
	public NoColumnsException(String detailMessage) {
		super(detailMessage);
	}
}
