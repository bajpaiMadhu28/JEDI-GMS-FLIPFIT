package com.flipkart.exception;

import java.io.InvalidObjectException;

import static com.flipkart.constant.CommonConstant.RED_COLOR;
import static com.flipkart.constant.CommonConstant.RESET_COLOR;

public class InvalidChoiceException extends InvalidObjectException {
    public InvalidChoiceException(){
        super(RED_COLOR+"Please enter valid choice"+RESET_COLOR);
    }
}