package fr.wcs.blablawild;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth;
    private static final String TAG = "AccountActivity";
    private TextView mUsername;
    private TextView mUsermail;
    private Button mDisconnectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    String userPseudo = user.getDisplayName();
                    String userEmail = user.getEmail();


                    mUsermail = (TextView) findViewById(R.id.textViewUserMail);
                    mUsername = (TextView) findViewById(R.id.textViewUserName);


                    mUsermail.setText(userEmail);
                    mUsername.setText(userPseudo);

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    finish();
                    Intent toSignIn = new Intent(AccountActivity.this, SigninActivity.class);
                    startActivity(toSignIn);
                }
             mDisconnectButton = (Button)findViewById(R.id.buttonDisconnect);
             mDisconnectButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     FirebaseAuth.getInstance().signOut();
                     finish();
                     startActivity(new Intent(AccountActivity.this,MainActivity.class));
                 }
             });
            }
        };
    }

}