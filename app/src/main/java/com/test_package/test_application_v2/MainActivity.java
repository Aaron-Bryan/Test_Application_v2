package com.test_package.test_application_v2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText user_name_text_id, user_email_text_id, user_password_id, user_confirm_password_id;
    private TextView name_warning_id, email_warning_id, password_warning_id, confirm_password_warning_id;
    private Button image_select_button_id, register_button_id;
    private CheckBox agreement_checkbox_id;
    private RadioGroup gender_radio_group_id;
    private RadioButton gender_radiobutton_male, gender_radiobutton_female;
    private Spinner country_spinner_id;
    private ConstraintLayout const_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize_views();

        image_select_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This feature will be added in future updates", Toast.LENGTH_SHORT).show();
            }
        });

        register_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "User data saved.", Toast.LENGTH_SHORT).show();
                register();
            }
        });
    }

    private void initialize_views() {

        Log.d(TAG, "Initializing Views");

        //Intialize the UI Elements
        //Edit Texts
        user_name_text_id = findViewById(R.id.user_name_text_id);
        user_email_text_id = findViewById(R.id.user_email_text_id);
        user_password_id = findViewById(R.id.user_password_id);
        user_confirm_password_id = findViewById(R.id.user_confirm_password_id);

        //Warning Texts
        name_warning_id = findViewById(R.id.name_warning_id);
        email_warning_id = findViewById(R.id.email_warning_id);
        password_warning_id = findViewById(R.id.password_warning_id);
        confirm_password_warning_id = findViewById(R.id.confirm_password_warning_id);

        //Buttons
        image_select_button_id = findViewById(R.id.image_select_button_id);
        register_button_id = findViewById(R.id.register_button_id);

        //Checkbox
        agreement_checkbox_id = findViewById(R.id.agreement_checkbox_id);

        //Radio Button
        gender_radio_group_id = findViewById(R.id.gender_radio_group_id);

        //Spinner
        country_spinner_id = findViewById(R.id.country_spinner_id);

        //Layout
        const_layout = findViewById(R.id.const_layout);

    }

    private void register() {

        Log.d(TAG, "Processing registration attempt.");

        if (check_data()) {
            if (agreement_checkbox_id.isChecked()) {
                display_snackbar();
            }
            else {
                Toast.makeText(this, "You are required to agree to the liscence agreement.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean check_data() {

        Log.d(TAG, "Checking data..");

        if (user_name_text_id.getText().toString().equals("")) {
            name_warning_id.setVisibility(View.VISIBLE);
            name_warning_id.setText("Fill in the field mf.");
            return false;
        }
        if (user_email_text_id.getText().toString().equals("")) {
            email_warning_id.setVisibility(View.VISIBLE);
            email_warning_id.setText("Fill in the field mf.");
            return false;
        }
        if (user_password_id.getText().toString().equals("")) {
            password_warning_id.setVisibility(View.VISIBLE);
            password_warning_id.setText("Fill in the field mf.");
            return false;
        }
        if (user_confirm_password_id.getText().toString().equals("")){
            confirm_password_warning_id.setVisibility(View.VISIBLE);
            confirm_password_warning_id.setText("Fill in the field mf.");
            return false;
        }

        if (!user_password_id.getText().toString().equals(user_confirm_password_id.getText().toString())) {
            confirm_password_warning_id.setVisibility(View.VISIBLE);
            confirm_password_warning_id.setText("Password does not match");
            return false;
        }

        return true;

    }

    private void display_snackbar() {

        Log.d(TAG, "Initializaing Snackbar");

        name_warning_id.setVisibility(View.GONE);
        email_warning_id.setVisibility(View.GONE);
        password_warning_id.setVisibility(View.GONE);
        confirm_password_warning_id.setVisibility(View.GONE);

        //Take in the inputs of the user
        String output_name = user_name_text_id.getText().toString();
        String output_email = user_email_text_id.getText().toString();
        String output_country = country_spinner_id.getSelectedItem().toString();



        String output_name_snackbar = "Name " + output_name;
        String output_email_snackbar = "Email " + output_email;
        String output_country_snackbar = "Country " + output_country;

        String snackbar_text = output_name_snackbar + "\n" +
                output_email_snackbar + "\n" +
                output_country_snackbar + "\n";

        Log.d(TAG, "Snackbar Text: " + snackbar_text);

        Snackbar.make(const_layout, "Test Text", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user_name_text_id.setText("");
                        user_email_text_id.setText("");
                        user_password_id.setText("");
                        user_confirm_password_id.setText("");
                    }
                }).show();

    }

}
