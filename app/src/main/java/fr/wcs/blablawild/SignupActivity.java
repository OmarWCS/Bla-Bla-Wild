package fr.wcs.blablawild;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    // je déclare une variable firebase
    private FirebaseAuth firebaseAuth;

    private EditText mUserPassword;
    private EditText mUserEmail;
    private Button mButtonSignUp;

    // pour implémenter un txt type "Veuillez patienter : inscription en cours"
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // J'initialise l'objet firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        mUserPassword = (EditText)findViewById(R.id.editTextId);
        mUserEmail = (EditText)findViewById(R.id.editTextEmail);
        mButtonSignUp = (Button)findViewById(R.id.buttonSignUp);
        mProgressDialog = new ProgressDialog(this);

        // J'attache un listener sur mon bouton sign up
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling register method on click
                registerUser();
            }

            });

    }

    // j'applique la méthode createUserWithEmailAndPassword() sur l'objet firebaseAuth
    private void registerUser(){

        //getting email and password from edit texts
        String email = mUserEmail.getText().toString().trim();
        String password  = mUserPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Quel est ton email ?",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Entre ton mot de passe",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        mProgressDialog.setMessage("Registering Please Wait...");
        mProgressDialog.show();

        //création d'un nouvel user
        firebaseAuth.createUserWithEmailAndPassword("user email here", "user password here")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //checking if success
                        if(task.isSuccessful()){
                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.toastSignUpOk);
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                        }else{
                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.toastSignUpFail);
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                        }

                    }
                });

    }

}



