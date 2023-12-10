package com.example.appprojesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    Button GonderBtn;
    EditText TelNum , Mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        GonderBtn = findViewById(R.id.gonderbtn);
        TelNum = findViewById(R.id.telnumara);
        Mesaj = findViewById(R.id.mesaj);


    }

    public void gonder(View view) {
        if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Mesaj Gönderme Yetkiniz Var",Toast.LENGTH_SHORT).show();
        }else {
            ActivityCompat.requestPermissions(SmsActivity.this , new String[] {Manifest.permission.SEND_SMS},100);
            Toast.makeText(getApplicationContext(),"Mesaj Gönderme Yetkiniz Yoktur",Toast.LENGTH_SHORT).show();
        }
        int tel = 0;
        try {
            tel = Integer.parseInt(TelNum.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Telefon Numaraniz Yanlış Formatta Girdiniz ",Toast.LENGTH_SHORT).show();
        }
        try {
            SmsManager smsGonder = SmsManager.getDefault();
            smsGonder.sendTextMessage(String.valueOf(tel),null,Mesaj.toString(),null,null);
            Toast.makeText(getApplicationContext(),"Mesaj Gönderildi ",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Mesaj Gönderilmedi ",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}