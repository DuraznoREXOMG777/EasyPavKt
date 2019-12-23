package com.highflyers.commonresources.utils;

public class AppDataResponse {
    private boolean success;
    private String errorMessage;

    public AppDataResponse(boolean success) {
        this.success = success;
    }

    public AppDataResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
