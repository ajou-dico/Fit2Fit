package com.dico.fit2fit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dico.fit2fit.databinding.ActivituMainDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitu_main_dashboard);

        TextView time = (TextView)findViewById(R.id.time);
        time.setText(String.format("%d분",runtime));

        TextView settingtime = (TextView)findViewById(R.id.settingtime);
        settingtime.setText(String.format("%d분",settime));

        TextView usecal = (TextView)findViewById(R.id.usecal);
        usecal.setText(String.format("%d분",cal));

        TextView settingcal = (TextView)findViewById(R.id.settingcal);
        settingcal.setText(String.format("%d분",setcal));


        binding.progressbar.progress = 30;
    }
}
