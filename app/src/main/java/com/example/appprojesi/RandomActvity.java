package com.example.appprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class RandomActvity extends AppCompatActivity {

    Button SonucBtn;
    EditText AdetSayisi,MaksDegeri,MinimumDegeri;
    LinearLayout AnaPenceresi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_actvity);

        SonucBtn = findViewById(R.id.sonucbtn);
        AdetSayisi = findViewById(R.id.adetinput);
        MaksDegeri = findViewById(R.id.maksinput);
        MinimumDegeri = findViewById(R.id.mininput);
        AnaPenceresi = findViewById(R.id.liste);


    }

    public void SonucuGetir(View view) {
        int deger = 0;
        int maks = 0;
        int min = 0;
        try {
            deger = Integer.parseInt(AdetSayisi.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Sayiyi Yanlış Formatta Girdiniz ",Toast.LENGTH_SHORT).show();
        }
        try {
            maks = Integer.parseInt(MaksDegeri.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Maksimim Sayiyi Yanlış Formatta Girdiniz ",Toast.LENGTH_SHORT).show();
        }
        try {
            min = Integer.parseInt(MinimumDegeri.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Minimum Sayiyi Yanlış Formatta Girdiniz ",Toast.LENGTH_SHORT).show();
        }
        AnaPenceresi.removeAllViews();
        for (int i = 1 ; i <= deger ; i++){
            Random rnd = new Random();
            int temp;
            int minimumdeger = rnd.nextInt(maks - min + 1 )+ min;
            int maksinmumdeger = rnd.nextInt(maks - min + 1 )+ min;
            if (minimumdeger > maksinmumdeger){
                temp = minimumdeger;
                minimumdeger = maksinmumdeger;
                maksinmumdeger = temp;
            }
            int rasgeledeger = rnd.nextInt(maksinmumdeger - minimumdeger + 1 )+ minimumdeger;
            float ilkdeger = maksinmumdeger - minimumdeger ;
            float ikincideger = ilkdeger /100;
            float sondeger = ikincideger * rasgeledeger ;
            int rasgeledegerinoraini = Math.round(sondeger);

            LinearLayout Pencere = new LinearLayout(this);
            Pencere.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
            Pencere.setOrientation(LinearLayout.VERTICAL);

            TextView RasgeleDegerView = new TextView(this);
            RasgeleDegerView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            RasgeleDegerView.setText(rasgeledeger + " = " + rasgeledegerinoraini +"%");
            RasgeleDegerView.setGravity(Gravity.CENTER_HORIZONTAL);

            LinearLayout horizantalPenceresi = new LinearLayout(this);
            horizantalPenceresi.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            horizantalPenceresi.setOrientation(LinearLayout.HORIZONTAL);

            Pencere.addView(RasgeleDegerView);
            Pencere.addView(horizantalPenceresi);

            TextView MinimumDegerView = new TextView(this);
            LinearLayout.LayoutParams mindegerParams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            );
            mindegerParams.setMargins(15,0,0,0);
            MinimumDegerView.setLayoutParams(mindegerParams);
            MinimumDegerView.setText(String.valueOf(minimumdeger));
            MinimumDegerView.setGravity(Gravity.START);

            ProgressBar progressBar = new ProgressBar(RandomActvity.this,null, android.R.attr.progressBarStyleHorizontal);
            LinearLayout.LayoutParams progressBarparams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    3
            );
            progressBar.setLayoutParams(progressBarparams);
            progressBar.setProgressDrawable(getDrawable(R.drawable.custom_progressbar_bg));
            progressBarparams.setMargins(0,20,0,20);
            progressBar.setMax(200);
            progressBar.setProgress(rasgeledeger);

            TextView MaksimumDegerView = new TextView(this);
            LinearLayout.LayoutParams maksdegerParams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            );
            maksdegerParams.setMargins(70,0,0,0);
            MaksimumDegerView.setLayoutParams(maksdegerParams);
            MaksimumDegerView.setText(String.valueOf(maksinmumdeger));
            MaksimumDegerView.setGravity(Gravity.START);


            horizantalPenceresi.addView(MinimumDegerView);
            horizantalPenceresi.addView(progressBar);
            horizantalPenceresi.addView(MaksimumDegerView);

            AnaPenceresi.addView(Pencere);

        }

    }


















































    /*private void createProgressBars() {
        int deger = 0;
        try {
            deger = Integer.parseInt(numProgressBar.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
            Log.d("JAFeafae","esfrdgbfhn");
            Toast.makeText(getApplicationContext(), "asdfsghfgfds", Toast.LENGTH_LONG).show();
        }
        // Get the number of progress bars from the EditText
        String input = numProgressBar.getText().toString();
        if (!input.isEmpty()) {

            for (int i = 0; i < deger; i++) {
                int temp;
                Random random = new Random();
                // Generate random min and max values for the progress bar
                int minValue = random.nextInt(200); // Example: Random value between 0 and 50
                int maxValue = random.nextInt(200);
                if (minValue > maxValue){
                    temp = minValue;
                    minValue = maxValue;
                    maxValue = temp;
                }// Example: Random value between 51 and 100
                float val1 = maxValue - minValue;
                float val2 = val1 / 100;
                // Generate a random value for the progress bar within the min-max range
                int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
                float val3 = val2 * randomValue;
                int val4 = Math.round(val3);
                // Create a LinearLayout to hold TextViews and ProgressBar
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                // Create a TextView for the random value above the ProgressBar
                TextView randomValueTextView = new TextView(this);
                randomValueTextView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                randomValueTextView.setText("Random value: " + randomValue + " " + val4 + "%");
                randomValueTextView.setGravity(Gravity.CENTER_HORIZONTAL);

                // Create a horizontal LinearLayout for min-max values and ProgressBar
                LinearLayout horizontalLayout = new LinearLayout(this);
                horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);


                // Create a TextView for the min value on the left side
                TextView minValueTextView = new TextView(this);
                LinearLayout.LayoutParams minValueParams = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );
                minValueTextView.setLayoutParams(minValueParams);
                minValueTextView.setText(String.valueOf(minValue));
                minValueTextView.setGravity(Gravity.START);

                // Create a ProgressBar
                ProgressBar progressBar = new ProgressBar(RandomActvity.this, null, android.R.attr.progressBarStyleHorizontal);
                LinearLayout.LayoutParams progressParams = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        3
                        );
                progressParams.setMargins(0,20,0,20);
                progressBar.setProgressDrawable(getDrawable(R.drawable.custom_progressbar_bg));
                progressBar.setLayoutParams(progressParams);
                progressBar.setMax(maxValue); // Set max value as needed
                progressBar.setProgress(randomValue); // Set progress

                // Create a TextView for the max value on the right side
                TextView maxValueTextView = new TextView(this);
                LinearLayout.LayoutParams maxValueParams = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );
                maxValueTextView.setLayoutParams(maxValueParams);
                maxValueTextView.setText(String.valueOf(maxValue));
                maxValueTextView.setGravity(Gravity.END);

                // Add TextViews and ProgressBar to the LinearLayout
                horizontalLayout.addView(minValueTextView);
                horizontalLayout.addView(progressBar);
                horizontalLayout.addView(maxValueTextView);
                linearLayout.addView(randomValueTextView);
                linearLayout.addView(horizontalLayout);

                containerLayout.addView(linearLayout); // Add the LinearLayout to the main container
            }
        }
    }
}*/
}