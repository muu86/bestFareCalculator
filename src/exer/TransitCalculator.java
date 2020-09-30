package exer;

import java.util.Arrays;

public class TransitCalculator {

    int days;
    int rides;

    public TransitCalculator(int numDays, int numRides) {
        days = numDays;
        rides = numRides;
    }

    public double unlimited7Price() {
        int num7DaysPass;
        if (days % 7 == 0) {
            num7DaysPass = days / 7;
        } else {
            num7DaysPass = days / 7 + 1;
        }
        return 33.00 * num7DaysPass / rides;
    }

    public double unlimited30Price() {
        int num30DaysPass;
        if (days % 30 == 0) {
            num30DaysPass = days / 30;
        } else {
            num30DaysPass = days / 30 + 1;
        }
        return 127.00 * num30DaysPass / rides;
    }

    public double[] getRidePrices() {
        double[] arrEachPrice = {
                2.75,
                unlimited7Price(),
                unlimited30Price()
        };
        return arrEachPrice;
    }

    public String getBestFare() {
        String theBestMethod = "";
        double theBestFare = 2.76;

        String[] arrRides = {
                "Pay-per-ride",
                "7-day Unlimited Rides",
                "30-day Unlimited Rides"
        };

        double[] arrFare = {
                2.75,
                33.00,
                127.00
        };

        for (int i = 0; i < getRidePrices().length; i++) {
            if (getRidePrices()[i] < theBestFare) {
                theBestFare = getRidePrices()[i];
                theBestMethod = arrRides[i];
            }
        }
        return "You should get the " + theBestMethod + " at $" + theBestFare + " per ride.";
    }
    public static void main(String[] args) {
        TransitCalculator mj = new TransitCalculator(7, 60);
        System.out.println(mj.getBestFare());
    }
}
