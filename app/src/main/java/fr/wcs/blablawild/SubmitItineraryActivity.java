package fr.wcs.blablawild;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class SubmitItineraryActivity extends AppCompatActivity {

    private EditText editTextDeparture;
    private EditText editTextDestination;
    private EditText editTextPrice;
    private EditText editTextDate;
    private Button buttonPublish;
    ItineraryModel mItineraryModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);
        editTextDeparture = (EditText) findViewById(R.id.editTextDeparture);
        editTextDestination = (EditText) findViewById(R.id.editTextDestination);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        buttonPublish = (Button) findViewById(R.id.buttonPublish);

        buttonPublish.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (editTextDeparture.length() != 0 && editTextDestination.length() != 0 && editTextPrice.length() != 0 && editTextDate.length() != 0) {
                    String mLastName = "Proust";
                    String mFirstName = "Marcel";
                    int mId = 0;
                    String mDeparture = editTextDeparture.getText().toString();
                    String mDestination = editTextDestination.getText().toString();
                    int mPrice = Integer.parseInt(editTextPrice.getText().toString());
                    String mDate = editTextDate.getText().toString();


                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("itineraries");


                    mItineraryModel = new ItineraryModel(mId, mLastName, mFirstName, mDate, mPrice, mDeparture, mDestination);
                    ref.push().setValue(mItineraryModel);
                    finish();
                }

                    else {
                        Context context = getApplicationContext();
                        CharSequence text = getString(R.string.toast);
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
            }
        });
    }
}
