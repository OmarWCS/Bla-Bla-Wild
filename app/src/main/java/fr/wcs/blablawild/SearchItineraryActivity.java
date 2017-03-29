package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class SearchItineraryActivity extends AppCompatActivity {


    Button seekButton;
    EditText textUserDeparture;
    EditText textUserDestination;
    EditText textUserDate;

    public static String SEARCH = "search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        seekButton = (Button) findViewById(R.id.seekButton);
        textUserDeparture = (EditText) findViewById(R.id.textUserDeparture);
        textUserDestination = (EditText) findViewById(R.id.textUserDestination);
        textUserDate = (EditText) findViewById(R.id.textUserDate);


        seekButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (textUserDeparture.length() != 0 && textUserDestination.length() != 0) {

                    String mDeparture = textUserDeparture.getText().toString();
                    String mDestination = textUserDestination.getText().toString();
                    String mDate = textUserDate.getText().toString();

                    SearchRequestModel search = new SearchRequestModel(mDeparture, mDestination, mDate);

                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra(SEARCH, search);
                    startActivity(intent);

                }
                    else {
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
