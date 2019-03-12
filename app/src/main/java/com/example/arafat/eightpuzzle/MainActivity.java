package com.example.arafat.eightpuzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView name, email, phone, dist, bloodGroup;
    private EditText inputText;
    private String mText = "";
    private int x = 0;


    private String Dist[] = {"DHAKA", "CUMILLA", "SYLHET", "BARGUNA", "BARISAL", "BHOLA", "JHALOKATI", "PATUAKHALI", "PIROJPUR", "BANDARBAN", "BRAHMANBARIA",
            "CHANDPUR", "CHITTAGONG", "COX'S BAZAR", "FENI", "KHAGRACHHARI", "LAKSHMIPUR", "NOAKHALI", "RNAGAMATI", "COMILLA", "FARIDPUR", "GAZIPUR", "GOPLAGANJ",
            "KISHOREGANJ", "MADARIPUR", "MANIKGANJ", "MUNSHIGANJ", "NARAYANGANJ", "NARSINGDI", "RAJBARI", "SHARIATPUR", "TANJAIL", "BAGERHAT", "CHUADANGA"
            , "JESSORE", "JHENAIDAH", "KHULNA", "KUSTIA", "MAGURA", "MEHERPUR", "NARAIL", "SATKHIRA", "JAMALPUR", "MYMENSINGH", "NETROKONA", "SHERPUR"
            , "BOGRA", "JOYPURHAT", "JOYPURHAT", "NAOGAON", "NATORE", "CHAPAI NAWABGANJ", "PABNA", "RAJSHAHI", "SIRAJGANJ", "DINAJPUR", "GAIBANDAHA"
            , "KURIGRAM", "LALMONIRHAT", "NILPHAMARI", "PANCHAGARH", "RANGPUR", "THAKURGAON", "HABIGANJ", "MOULVIBAZAR", "SUNAMGANJ", "BOGURA"
            , "JASHORE", "CHATTOGRAM"};


    private String BloodGroup[] = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    private char[] number = {'+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_text);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.phone_text);
        dist = findViewById(R.id.dist_text);
        bloodGroup = findViewById(R.id.blood_group_text);

        inputText = findViewById(R.id.input_text);

        Button enter = findViewById(R.id.enter_btn);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSetEmail();
                checkAndSetPhone();
                checkAndSetBloodGroup();
                checkAndSetDist();
                x = 0;


            }
        });
    }

    private void checkAndSetPhone() {
        int check = 0;
        mText = inputText.getText().toString();

        for (int i = 0; i < mText.length(); i++) {
            for (char aNumber : number) {
                if (mText.charAt(i) == aNumber)
                    check++;
            }
        }

        if (mText.length() == check) {
            phone.setText(mText);
            x = 1;
        }
    }

    private void checkAndSetEmail() {
        mText = inputText.getText().toString();
        for (int i = 0; i < mText.length(); i++) {
            if (mText.charAt(i) == '@') {
                email.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }

    }

    private void checkAndSetBloodGroup() {
        mText = inputText.getText().toString();
        String text = toUpper(mText);
        for (String bg : BloodGroup) {
            if (text.equals(bg)) {
                bloodGroup.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }
    }

    private void checkAndSetDist() {
        mText = inputText.getText().toString();
        String text = toUpper(mText);
        for (String aDist : Dist) {
            if (text.equals(aDist)) {
                dist.setText(mText);
                inputText.setText("");
                x = 1;
                break;
            }
        }
        if (x == 0) name.setText(mText);
    }

    private String toUpper(String mText) {

        return mText.toUpperCase();

    }
}
