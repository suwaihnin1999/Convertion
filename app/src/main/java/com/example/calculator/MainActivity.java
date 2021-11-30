package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Toolbar mToolbar;
EditText mCalNum;
Button calculateBtn,clearBtn;
EditText mRice,mOil,mBean,mSalt,mFish,mChill,mMilk,mSugar,mTeaLeaf,mWater,mRam,mCV,mSaltFlat;

    double folrmularice = 1.625;
    double folrmulp = 0.05;
    double oil = 0.0225;
    double salt = 0.0075;
    double fish = 0.005;
    double chill = 0.0015;
    double milk = 0.12875;
    double mmkilk = 0.0255625;
    double labbat = 0.01296875;
    double paper = 2;
    double ram = 0.016;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Home");


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double cal=Double.parseDouble(mCalNum.getText().toString());

                //todo rice(aungsa)
                mRice.setText(calculatePAS(folrmularice));

                //todo milk(aungsa)
                mMilk.setText(calculatePAS(milk));

                //todo tealeaf(aungsa)
                mTeaLeaf.setText(calculatePAS(labbat));

                //todo bean
                mBean.setText(String.format("%.5f", calculate(folrmulp)));
                //todo oil
                mOil.setText(String.format("%.5f", calculate(oil)));
                //todo salt
                mSalt.setText(String.format("%.5f", calculate(salt)));
                //todo fish
                mFish.setText(String.format("%.5f", calculate(fish)));
                //todo chill
                mChill.setText(String.format("%.5f", calculate(chill)));
                //todo sugar
                mSugar.setText(String.format("%.5f", calculate(mmkilk)));
                //todo water
                mWater.setText(String.format("%.5f", calculate(paper)));
                //todo ram
                mRam.setText(String.format("%.5f", calculate(ram)/1000));

                //todo cv
                mCV.setText(String.valueOf(cal));
                //todo saltflat
                mSaltFlat.setText(String.valueOf(cal));

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRice.setText("");
                mOil.setText("");
                mBean.setText("");
                mSalt.setText("");
                mMilk.setText("");
                mSugar.setText("");
                mFish.setText("");
                mChill.setText("");
                mTeaLeaf.setText("");
                mWater.setText("");
                mRam.setText("");
                mCV.setText("");
                mSaltFlat.setText("");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.info){
            Intent intent=new Intent(MainActivity.this,InfoActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private double calculate(double formula){
        double cal=Double.parseDouble(mCalNum.getText().toString());
        double result=cal*formula;
        return result;
    }

    private String calculatePAS(double formula){
        double cal=Double.parseDouble(mCalNum.getText().toString());
        double result=cal*formula;
        String num=String.format("%.5f", result);
        Log.e("gg",num);
        int index=num.indexOf(".");
        Log.e("gg","num="+index);

        String intNum=num.substring(0,index);
        String decimalNum=num.substring(index+1);
        Log.e("gg",intNum+" "+decimalNum);

        int aungsa=Integer.parseInt(decimalNum)*16;
        Log.e("gg","aungsa"+aungsa);
        Log.e("gg",intNum +" "+ aungsa);
        String total=intNum+"."+aungsa;
        double d=Double.parseDouble(total);

        return String.format("%.5f", d);

    }

    private void init() {
        View view=findViewById(R.id.main_toolbar);
        mToolbar=view.findViewById(R.id.mtoolbar);
        mCalNum=findViewById(R.id.cal_edittext);
        calculateBtn=findViewById(R.id.button);
        mRice=findViewById(R.id.rice_editText);
        mOil=findViewById(R.id.oil_editText);
        mBean=findViewById(R.id.bean_editText);
        mSalt=findViewById(R.id.salt_editText);
        mFish=findViewById(R.id.fish_editText);
        mChill=findViewById(R.id.pepper_editText);
        mMilk=findViewById(R.id.milk_editText);
        mSugar=findViewById(R.id.sugar_editText);
        mTeaLeaf=findViewById(R.id.tealeaf_editText);
        mWater=findViewById(R.id.water_editText);
        mRam=findViewById(R.id.ram_btn);
        clearBtn=findViewById(R.id.clear_btn);
        mCV=findViewById(R.id.cv_editText);
        mSaltFlat=findViewById(R.id.saltflat_editText);
    }
}