package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button homePageButton;
    Button submitButton;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePageButton = (Button) findViewById(R.id.homePageButton);
        submitButton = (Button) findViewById(R.id.submitButton);
        signUpButton = (Button)findViewById(R.id.buttonToSignUp);

        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSearch = new Intent(MainActivity.this, SearchItineraryActivity.class);
                startActivity(toSearch);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toSearch = new Intent(MainActivity.this, SubmitItineraryActivity.class);
                        startActivity(toSearch);
                    }
                });
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(toSignUp);
            }
        });
    }
}