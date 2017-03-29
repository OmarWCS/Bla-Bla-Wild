package fr.wcs.blablawild;


public class ItineraryModel {


    private int mUser = 0;
    private String mDriverLastName = "Proust";
    private String mDriverFirstName = "Marcel";
    private String mDepartureDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;

    private ItineraryModel(){
    }

    public ItineraryModel(int user, String driverLastName, String driverFirstName, String departureDate, int price, String departure, String destination){
        mUser = user;
        mDriverFirstName = driverFirstName;
        mDriverLastName = driverLastName;
        mDepartureDate = departureDate;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;

    }

    public int getmUser() {
        return mUser;
    }

    public void setmUser(int mUser) {
        this.mUser = mUser;
    }

    public String getmDriverLastName() {
        return mDriverLastName;
    }

    public void setmDriverLastName(String mDriverLastName) {
        this.mDriverLastName = mDriverLastName;
    }

    public String getmDriverFirstName() {
        return mDriverFirstName;
    }

    public void setmDriverFirstName(String mDriverFirstName) {
        this.mDriverFirstName = mDriverFirstName;
    }

    public String getmDepartureDate() {
        return mDepartureDate;
    }

    public void setmDepartureDate(String mDepartureDate) {
        this.mDepartureDate = mDepartureDate;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getmDeparture() {
        return mDeparture;
    }

    public void setmDeparture(String mDeparture) {
        this.mDeparture = mDeparture;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmDestination(String mDestination) {
        this.mDestination = mDestination;
    }
}

