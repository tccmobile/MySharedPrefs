package com.example.drwillsmith.mysharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name;
    TextView showName;
    Button saveName;

    private static final String PREFS_NAME="MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText);
        showName = (TextView) findViewById(R.id.textView);
        saveName = (Button) findViewById(R.id.button);

        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPrefs.edit();

                if (name.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter a name.",Toast.LENGTH_LONG).show();
                } else {
                    editor.putString("name",name.getText().toString());
                    editor.apply();
                }
            }
        });


        SharedPreferences prefs=getSharedPreferences(PREFS_NAME,0);

        if (prefs.contains("name")){
            String userName = prefs.getString("name","not found");
            showName.setText("You are "+userName);
        } else {
            showName.setText("");
        }
    }
}
