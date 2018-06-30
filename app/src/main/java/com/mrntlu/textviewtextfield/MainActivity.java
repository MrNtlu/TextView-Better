package com.mrntlu.textviewtextfield;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout userLayout;
    TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(AppCompatEditText)findViewById(R.id.username_field);
        userLayout=(TextInputLayout)findViewById(R.id.username_TextinputLayout);
        passLayout=(TextInputLayout)findViewById(R.id.password_TextinputLayout);
        pass=(AppCompatEditText)findViewById(R.id.password_field);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);

        relativeLayout.setOnClickListener(null);

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textErrorMessage(user,"Please enter your Username");
                }
                else {
                    userLayout.setErrorEnabled(false);
                }
            }
        });

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textErrorMessage(user,"Please enter your Username");
            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(60);
    }

    private void textErrorMessage(AppCompatEditText editText,String message){
        if (editText.getText().toString().isEmpty()){
            userLayout.setErrorEnabled(true);
            userLayout.setError(message);
        }else{
            userLayout.setErrorEnabled(false);
        }
    }
}
