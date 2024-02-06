package com.test_package.test_application_v2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText user_name_text_id, user_email_text_id, user_password_id, user_confirm_password_id;
    private TextView name_warning_id, email_warning_id, password_warning_id, confirm_password_warning_id;
    private Button image_select_button_id, register_button_id;
    private CheckBox agreement_checkbox_id;
    private RadioButton gender_radio_group_id;
    private Spinner country_spinner_id;
    private ConstraintLayout const_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize_views();
    }



}
