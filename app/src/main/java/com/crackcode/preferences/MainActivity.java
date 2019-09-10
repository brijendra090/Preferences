package com.crackcode.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button storeinformation=findViewById(R.id.store_information);
        Button showinformation=findViewById(R.id.show_information);
        textView=findViewById(R.id.txtPrefs);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.store_information:
                        Intent intent = new Intent(MainActivity.this,PrefsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.show_information:
                        displaySharedPreferences();
                        break;
                        default:
                            break;
                }
            }
        };
        storeinformation.setOnClickListener(listener);
        showinformation.setOnClickListener(listener);
    }

    private void displaySharedPreferences(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String useename = prefs.getString("username","Default NickName");
        String password = prefs.getString("password","Default Password");
        boolean chechBox = prefs.getBoolean("checkBox",false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");

        StringBuilder builder = new StringBuilder();
        builder.append("Username: "+useename+"\n");
        builder.append("Password: "+password+"\n");
        builder.append("Keep me logged in: "+ chechBox+"\n");
        builder.append("List preference: "+listPrefs);
        textView.setText(builder.toString());

    }
}
