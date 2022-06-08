package com.dico.fit2fit;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dico.fit2fit.databinding.ActivituMainDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        TextView time = (TextView)findViewById(R.id.time);
        time.setText(String.format("%d분",5));

        TextView settingtime = (TextView)findViewById(R.id.settingtime);
        settingtime.setText(String.format("/%d분",10));

        TextView usecal = (TextView)findViewById(R.id.usecal);
        usecal.setText(String.format("%d kcal",5));

        TextView settingcal = (TextView)findViewById(R.id.settingcal);
        settingcal.setText(String.format("/%d kcal",10));

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressBar.setProgress(10/5);
    }
}

//runtime, settime, cal, setcal