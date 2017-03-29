package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchRequestModel implements Parcelable {
    private String mDeparture;
    private String mDestination;
    private String mDate;


    public SearchRequestModel(String mDepart, String mArrivee, String mDateDepart) {
        this.mDeparture = mDepart;
        this.mDestination = mArrivee;
        this.mDate = mDateDepart;
    }

    protected SearchRequestModel(Parcel in) {
        mDestination = in.readString();
        mDeparture = in.readString();
        mDate = in.readString();
    }

    public static final Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };


    public String getmDepart() {
        return mDeparture;
    }
    public String getmArrivee() {
        return mDestination;
    }
    public String getmDateDepart() {
        return mDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDeparture);
        dest.writeString(mDestination);
        dest.writeString(mDate);

    }

}
