package com.hh.export.reftype;

/**
 * Created by Mohamed Riyas
 * */
public enum YNStatus {
    YES("T", "Yes"),
    NO("F", "No");

    private String status;
    private String display;

    YNStatus(String status, String display) {
        this.status = status;
        this.display = display;
    }

    public String getStatus() {
        return status;
    }

    public String getDisplay() {
        return display;
    }

    public static YNStatus statusMatch(String status) {
        for (YNStatus YNStatus : YNStatus.values()) {
            if (YNStatus.getStatus().equalsIgnoreCase(status)) {
                return YNStatus;
            }
        }
        return NO;
    }
}
