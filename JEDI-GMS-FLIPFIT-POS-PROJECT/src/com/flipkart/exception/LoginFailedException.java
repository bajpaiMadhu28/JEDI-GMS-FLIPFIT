package com.flipkart.exception;

import static com.flipkart.constant.CommonConstant.RED_COLOR;
import static com.flipkart.constant.CommonConstant.RESET_COLOR;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(String message){
        super(message);
        System.out.println(RED_COLOR+"Unable to login, Check your username and password"+RESET_COLOR);
    }
}