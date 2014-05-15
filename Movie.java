package swerefactoringhomework;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }
    
    public double getCharge(int daysRented)
    {
        return price.getCharge(daysRented);
    }
    
    public int getFrequentRenterPoints(int daysRented)
    {
        int frequentRenterPoints = 0;
        
        frequentRenterPoints++;
        if ((price.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
        {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
    
    
    public int getPriceCode() {
        return price.getPriceCode();
    }
    public void setPriceCode(int arg) {
        switch(arg)
        {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    public String getTitle (){
        return title;
    };
}