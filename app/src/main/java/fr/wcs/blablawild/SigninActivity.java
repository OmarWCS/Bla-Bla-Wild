package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SigninActivity extends AppCompatActivity {

    private Button buttonSignIn;
    private Button buttonNoAccountYet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        buttonNoAccountYet = (Button)findViewById(R.id.buttonToSignIn);


        buttonNoAccountYet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(toSignUp);
            }
        });
    }

}
