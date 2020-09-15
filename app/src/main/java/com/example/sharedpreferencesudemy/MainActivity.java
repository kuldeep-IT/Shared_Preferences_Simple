package com.example.sharedpreferencesudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    RadioGroup rg;
    RadioButton r,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        r = findViewById(R.id.radioButton);
        k = findViewById(R.id.radioButton2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

//                switch (checkedId)
//                {
//                    case R.id.radioButton:
//
//                        Toast.makeText(MainActivity.this, "rudrax", Toast.LENGTH_SHORT).show();
//                        r.setText("Rudra");
//
//                        break;
//
//                    case R.id.radioButton2:
//
//                        Toast.makeText(MainActivity.this, "kuldeep", Toast.LENGTH_SHORT).show();
//                        k.setText("kuldeep");
//                        break;
//                }

                if (r.isChecked())
                {
                    Toast.makeText(MainActivity.this, "rudrax", Toast.LENGTH_SHORT).show();
                    r.setText("Rudra");
                    k.setText("kuldeep not checked");
                }
                if (k.isChecked())
                {
                    Toast.makeText(MainActivity.this, "kuldeep", Toast.LENGTH_SHORT).show();
                    k.setText("kuldeep");
                    r.setText("rudra not checked");
                }

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("RG_1",r.getText().toString());
        editor.putBoolean("RG_ONE",r.isChecked());



        editor.putString("RG_2",k.getText().toString());
        editor.putBoolean("RG_TWO",k.isChecked());

        editor.commit();




    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(0);
        boolean value = sharedPreferences.getBoolean("RG_ONE",false);
        String string = sharedPreferences.getString("RG_1","rudra not checked");

        boolean val2= sharedPreferences.getBoolean("RG_TWO",false);
        String s2 = sharedPreferences.getString("RG_2","kuldeep not checked");

        r.setChecked(value);
        r.setText(string);

        k.setText(s2);
        k.setChecked(val2);

    }
}
