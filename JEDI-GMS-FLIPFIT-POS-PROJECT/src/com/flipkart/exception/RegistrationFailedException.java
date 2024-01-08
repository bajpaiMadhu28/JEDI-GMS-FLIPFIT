package com.flipkart.exception;

import static com.flipkart.constant.CommonConstant.RED_COLOR;
import static com.flipkart.constant.CommonConstant.RESET_COLOR;

public class RegistrationFailedException extends Exception {
    public RegistrationFailedException(String gymOwnerId) {
        super(RED_COLOR+"Failed to register Gym Owner with id: " + gymOwnerId+RESET_COLOR);
    }
}