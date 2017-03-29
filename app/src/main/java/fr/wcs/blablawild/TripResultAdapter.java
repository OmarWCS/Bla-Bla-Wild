package fr.wcs.blablawild;


import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.database.Query;
import static java.lang.String.valueOf;
import static fr.wcs.blablawild.R.id.textViewPrice;


public class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {


    private TextView textViewDeparture;
    private TextView textViewName;
    private TextView texViewPrice;


        //public constructor
        public TripResultAdapter(Query ref, Activity activity, int layout) {
            super(ref, ItineraryModel.class, layout, activity);
        }


    @Override
    protected void populateView(View view, ItineraryModel model) {
        textViewDeparture = (TextView) view.findViewById(R.id.textViewDeparture);
        textViewName = (TextView) view.findViewById(R.id.textViewName);
        texViewPrice = (TextView) view.findViewById(textViewPrice);

        textViewDeparture.setText(model.getmDeparture());
        textViewName.setText(model.getmDriverFirstName());
        texViewPrice.setText(Integer.toString(model.getmPrice()));



    }
}


