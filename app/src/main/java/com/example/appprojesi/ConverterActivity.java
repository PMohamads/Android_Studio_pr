package com.example.appprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConverterActivity extends AppCompatActivity {

    TextView DecimalSonuc,MegaByteSonuc,DegreeSonuc;
    EditText DecimalInput,MegaInput,DegreeInput;
    Spinner DecimalListesi,MegaListesi;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        DecimalSonuc = findViewById(R.id.sonuc1);
        MegaByteSonuc = findViewById(R.id.sonuc2);
        DegreeSonuc = findViewById(R.id.sonuc3);
        DecimalInput = findViewById(R.id.decimalinput);
        MegaInput = findViewById(R.id.megabyteinput);
        DegreeInput = findViewById(R.id.celsiusinput);
        DecimalListesi = findViewById(R.id.liste1);
        MegaListesi = findViewById(R.id.liste2);
        radioGroup = findViewById(R.id.radiogroup);

        String[] SayiDizisi = {"Binary","Octal","HexDecimal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,SayiDizisi);
        DecimalListesi.setAdapter(adapter);

        String[] ByteDizisi = {"KiloByte","Byte","KibiByte","Bit"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,ByteDizisi);
        MegaListesi.setAdapter(adapter2);

    }
    public void DecimalFun(View view) {
        int deger = 0;
        try {
            deger = Integer.parseInt(DecimalInput.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        String Secilen = DecimalListesi.getSelectedItem().toString();
        if (Secilen.equals("Binary")){
            String BinarySonucu = Integer.toBinaryString(deger);
            DecimalSonuc.setText(BinarySonucu);
        } else if (Secilen.equals("Octal")) {
            String OctalSonucu = Integer.toOctalString(deger);
            DecimalSonuc.setText(OctalSonucu);
        }
        else if (Secilen.equals("HexDecimal")) {
            String HexSonucu = Integer.toHexString(deger);
            DecimalSonuc.setText(HexSonucu);
        }else {
            Log.e("Hataaa","Hataaaa");
        }
    }

    public void MegabyteFun(View view) {
        int deger = 0;
        try {
            deger = Integer.parseInt(MegaInput.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        String Secilen = MegaListesi.getSelectedItem().toString();
        if (Secilen.equals("KiloByte")){
            double KiloByte = deger * 1000;
            String KiloByteSonucu = Double.toString(KiloByte);
            MegaByteSonuc.setText(KiloByteSonucu);
        } else if (Secilen.equals("Byte")) {
            double Byte = deger * 1000000;
            String ByteSonucu = Double.toString(Byte);
            MegaByteSonuc.setText(ByteSonucu);
        }
        else if (Secilen.equals("KibiByte")) {
            double KibiByte = deger * 976.5625;
            String KibiByteSonucu = Double.toString(KibiByte);
            MegaByteSonuc.setText(KibiByteSonucu);
        }
        else if (Secilen.equals("Bit")) {
            double Bit = deger * 8000000.0;
            String BitSonucu = Double.toString(Bit);
            MegaByteSonuc.setText(BitSonucu);
        }
        else {
            Log.e("Hataaa","Hataaaa");
        }
    }
    public void DegreeFun(View view) {
        int deger = 0;
        try {
            deger = Integer.parseInt(MegaInput.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        int Secilen = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(Secilen);
        if (radioButton.getText().toString().equals("Fehrenhit")){
            double FehSonucu = (deger * 1.8) + 32;
            String FehString = Double.toString(FehSonucu);
            DegreeSonuc.setText(FehString);
        }
        else if (radioButton.getText().toString().equals("Kelvin")){
            double KelvinSonucu = (deger + 274.15);
            String KevlinString = Double.toString(KelvinSonucu);
            DegreeSonuc.setText(KevlinString);
        }

    }
}