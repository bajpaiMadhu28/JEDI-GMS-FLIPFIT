package com.flipkart.exception;

import static com.flipkart.constant.CommonConstant.RED_COLOR;
import static com.flipkart.constant.CommonConstant.RESET_COLOR;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message){
        super(message);
        System.out.println(RED_COLOR+"User not found!!"+RESET_COLOR);
    }
}