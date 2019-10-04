package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonLeft,buttonRight,buttonConfirm;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBoxYoung,checkBoxSimple,checkBoxNaive;
    RatingBar ratingBar;
    String young = "";
    String simple = "";
    String naive = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        buttonLeft = findViewById(R.id.button1);
        buttonRight = findViewById(R.id.button2);
        buttonConfirm = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBoxYoung = findViewById(R.id.checkBox5);
        checkBoxSimple = findViewById(R.id.checkBox6);
        checkBoxNaive = findViewById(R.id.checkBox7);
        ratingBar = findViewById(R.id.ratingBar);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(R.string.button1);
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(R.string.button2);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView.setText(R.string.aSwitchOpen);
                } else {
                    textView.setText(R.string.aSwitchClose);
                }
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)){
                    s = "0";
                }
                progressBar.setProgress(Integer.valueOf(s));
                textView.setText(s);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radioButton2) {
                    imageView.setImageResource(R.drawable.byzantium);
                } else {
                    imageView.setImageResource(R.drawable.ottoman);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBoxYoung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    young = "too young";
                } else {
                    young = "";
                }
                textView.setText(young+simple+naive);
            }
        });

        checkBoxSimple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    simple = "too simple";
                } else {
                    simple = "";
                }
                textView.setText(young+simple+naive);
            }
        });
        checkBoxNaive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    naive = "naive";
                } else {
                    naive = "";
                }
                textView.setText(young+simple+naive);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),String.valueOf(v)+"星评价！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
