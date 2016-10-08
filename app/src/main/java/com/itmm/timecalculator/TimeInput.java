package com.itmm.timecalculator;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Dmitry on 10/8/2016.
 */

public class TimeInput {

    private InputHappend Delegate;
    private ArrayList<EditText> InputTextBox;

    private EditText startHours;
    private EditText startMinutes;
    private EditText endHours;
    private EditText endMinutes;

    public TimeInput(InputHappend delegate) {
        Delegate = delegate;

        InputTextBox = new ArrayList<>();
    }

    public void setUIComponent(Activity activity) {
        Resources tmpRes = activity.getResources();

        int tmpOperandId = tmpRes.getIdentifier("editText" + 1, "id", activity.getPackageName());
        startHours = (EditText) activity.findViewById(tmpOperandId);

        tmpOperandId = tmpRes.getIdentifier("editText" + 2, "id", activity.getPackageName());
        startMinutes = (EditText) activity.findViewById(tmpOperandId);

        tmpOperandId = tmpRes.getIdentifier("editText" + 3, "id", activity.getPackageName());
        endHours = (EditText) activity.findViewById(tmpOperandId);

        tmpOperandId = tmpRes.getIdentifier("editText" + 4, "id", activity.getPackageName());
        endMinutes = (EditText) activity.findViewById(tmpOperandId);

        startHours.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals("")) {
                    Delegate.startHoursIn(String.valueOf(s));
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        startMinutes.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals("")) {
                    Delegate.startMinutesIn(s.toString());
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        endHours.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals("")) {
                    Delegate.endHoursIn(s.toString());
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });

        endMinutes.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals("")) {
                    Delegate.endMinutesIn(s.toString());
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });
    }

    public interface InputHappend {
        void startHoursIn(String hours);
        void startMinutesIn(String minutes);
        void endHoursIn(String hours);
        void endMinutesIn(String minutes);
    }
}
