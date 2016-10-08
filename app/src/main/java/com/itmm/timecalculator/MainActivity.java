package com.itmm.timecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dmitry on 10/8/2016.
 */

public class MainActivity extends AppCompatActivity implements TimeInput.InputHappend {

    TimeClass time;
    private TextView OutputHoursTextView;
    private TextView OutputMinutesTextView;
    private TextView OutputErrorTextView;
    private TimeInput InputTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new TimeClass();
        OutputHoursTextView = (TextView) this.findViewById(R.id.textView1);
        OutputMinutesTextView = (TextView) this.findViewById(R.id.textView2);
        OutputErrorTextView = (TextView) this.findViewById(R.id.textView3);
        InputTime = new TimeInput(this);
        InputTime.setUIComponent(this);
    }

    @Override
    public void startHoursIn(String hours) {
        OutputErrorTextView.setText("");
        if ((!hours.equals("")) && (TimeClass.valideteBeforeSet(hours, TimeClass.HOUR))) {
            time.setStartHour(Integer.valueOf(hours));
            OutputHoursTextView.setText(time.getDifferenceHours());
            OutputMinutesTextView.setText(time.getDifferenceMinutes());
        }
        else {
            OutputErrorTextView.setText("WARNING: Wrong value of Start Hours");
        }
    }

    @Override
    public void startMinutesIn(String minutes) {
        OutputErrorTextView.setText("");
        if ((!minutes.equals("")) && (TimeClass.valideteBeforeSet(minutes, TimeClass.MINUTE))) {
            time.setStartMinute(Integer.valueOf(minutes));
            OutputHoursTextView.setText(time.getDifferenceHours());
            OutputMinutesTextView.setText(time.getDifferenceMinutes());
        }
        else {
            OutputErrorTextView.setText("WARNING: Wrong value of Start Minutes");
        }

    }

    @Override
    public void endHoursIn(String hours) {
        OutputErrorTextView.setText("");
        if ((!hours.equals("")) && (TimeClass.valideteBeforeSet(hours, TimeClass.HOUR))) {
            time.setEndHour(Integer.valueOf(hours));
            OutputHoursTextView.setText(time.getDifferenceHours().toString());
            OutputMinutesTextView.setText(time.getDifferenceMinutes());
        }
        else {
            OutputErrorTextView.setText("WARNING: Wrong value of End Hours");
        }
    }

    @Override
    public void endMinutesIn(String minutes) {
        OutputErrorTextView.setText("");
        if ((!minutes.equals("")) && (TimeClass.valideteBeforeSet(minutes, TimeClass.MINUTE))) {
            time.setEndMinute(Integer.valueOf(minutes));
            OutputHoursTextView.setText(time.getDifferenceHours());
            OutputMinutesTextView.setText(time.getDifferenceMinutes());
        }
        else {
            OutputErrorTextView.setText("WARNING: Wrong value of End Minutes");
        }
    }
}
