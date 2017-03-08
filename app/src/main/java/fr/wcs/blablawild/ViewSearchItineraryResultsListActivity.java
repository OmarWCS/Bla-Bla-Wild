package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;




public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        SearchRequestModel result = intent.getParcelableExtra(SearchItineraryActivity.SEARCH);

        Toast.makeText(this, result.getmDateDepart(), Toast.LENGTH_SHORT).show();
        this.setTitle(result.getmDepart() + ">>" + result.getmArrivee());


}
}

