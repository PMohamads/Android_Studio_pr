package com.example.appprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


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




    // Helper method to generate a random value within a range
    private int generateRandomValue(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}*/
}