package com.example.arafat.eightpuzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView name, email, dept, dist;
    private EditText inputText;
    private String mText = "";
    private int x = 0;
    private String Dist[] = {"Dhaka", "Cumilla", "Sylhet"};
    private String Dept[] = {"CSE", "CE", "EEE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_text);
        email = findViewById(R.id.email_text);
        dept = findViewById(R.id.dept_text);
        dist = findViewById(R.id.dist_text);

        inputText = findViewById(R.id.input_text);

        Button enter = findViewById(R.id.enter_btn);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSetEmail();
                checkAndSetDept();
                checkAndSetDist();
                x = 0;


            }
        });
    }

    private void checkAndSetEmail() {
        mText = inputText.getText().toString();
        for (int i = 0; i <mText.length() ; i++) {
            if(mText.charAt(i) == '@') {
                email.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }

    }

    private void checkAndSetDept() {
        mText = inputText.getText().toString();
        for (String aDept : Dept) {
            if (mText.equals(aDept)) {
                dept.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }
    }

    private void checkAndSetDist() {
        mText = inputText.getText().toString();
        for (String aDist : Dist) {
            if (mText.equals(aDist)) {
                dist.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }
        if(x == 0) name.setText(mText);
    }
}
