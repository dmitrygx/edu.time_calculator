package com.itmm.timecalculator;

/**
 * Created by Dmitry on 10/6/2016.
 */

public class TimeClass {
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    static final int HOUR = 1;
    static final int MINUTE = 2;

    public void setStartHour(int hour) {

        startHour = hour;
    }

    public int getStartHour() {

        return startHour;
    }

    public void setStartMinute(int minute) {

        startMinute = minute;
    }

    public int getStartMinute() {

        return startMinute;
    }

    public void setEndHour(int hour) {

        endHour = hour;
    }

    public int getEndHour() {

        return endHour;
    }

    public void setEndMinute(int minute) {

        endMinute = minute;
    }

    public int getEndMinute() {

        return endMinute;
    }

    public int MinuteDifference() {
        int endTotal = (endHour * 60) + endMinute;
        int startTotal = (startHour * 60) + startMinute;

        return (endTotal - startTotal);
    }

    public String getDifferenceHours() {
        if (validateInputParams()) {
            int result = MinuteDifference() / 60;
            return String.valueOf(result);
        }
        else {
            return "0";
        }
    }

    public String getDifferenceMinutes() {
        if (validateInputParams()) {
            return String.valueOf(MinuteDifference() % 60);
        }
        else {
            return "0";
        }
    }

    public boolean validateInputParams() {
        return ((endHour > startHour) || (endHour == startHour) && (endMinute >= startMinute));
    }

    static public boolean valideteBeforeSet(String value, int type) {

        int numValue = Integer.valueOf(value);

        switch (type) {
            case HOUR:
                if ((numValue > 24) || (numValue < 0))
                    return false;
                break;
            case MINUTE:
                if ((numValue > 59) || (numValue < 0))
                    return false;
                break;
        }

        return true;
    }
}
