package com.example.geektrust.Model;

public class ErrorMessage {
    private static String errorMessage = null;

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static void setErrorMessage(String errorMessage) {
        ErrorMessage.errorMessage = errorMessage;
    }

    public static void printMessage(String methodName) {
        System.out.println(methodName +(methodName.isEmpty() ? "" :" ")+ errorMessage);
    }
}
