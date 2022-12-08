public class Temperature {
    private double highTemp;
    private double lowTemp;
    private String tempScale;

    private static final int FREEZING_TEMP_F = 32;
    private static double highestTrackedTempF = 0;
    private static double lowestTrackedTempF = 0;

    private static boolean isFirstInstance = true;


    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale) {
        highTemp = high;
        lowTemp = low;

        double highC;
        double lowC;
        double highF;
        double lowF;

        if (scale.equals("C")) {
            highC = high;
            lowC = low;
            highF = convertCtoF(highC);
            lowF = convertCtoF(lowC);
        } else {
            highF = high;
            lowF = low;
        }

        if (scale.equals("F") || scale.equals("C")) {
            tempScale = scale;
        } else {
            tempScale = "F";
        }

        if (isFirstInstance) {
            if (scale.equals("C")) {
                highestTrackedTempF = convertCtoF(high);
                lowestTrackedTempF = convertCtoF(low);
            } else {
                highestTrackedTempF = high;
                lowestTrackedTempF = low;
            }
        }

        isFirstInstance = false;

        if (highF > highestTrackedTempF) {
            highestTrackedTempF = highF;
        }
        if (lowF < lowestTrackedTempF) {
            lowestTrackedTempF = lowF;
        }
    }



    public static double convertCtoF(double temp) {
        return (temp * (9.0 / 5)) + 32;
    }

    public static double convertFtoC(double temp) {
        return (temp - 32) * (5.0 / 9);
    }

    public boolean belowFreezing() {
        double highF;
        double lowF;
        if(tempScale.equals("C")) {
            highF = convertCtoF(highTemp);
            lowF = convertCtoF(lowTemp);
        } else {
            highF = highTemp;
            lowF = lowTemp;
        }

        return (highF < FREEZING_TEMP_F || lowF < FREEZING_TEMP_F);
    }

    public void changeToC() {
        if(tempScale.equals("F")) {
            tempScale = "C";
            highTemp = convertFtoC(highTemp);
            lowTemp = convertFtoC(lowTemp);
        }
    }

    public void changeToF() {
        if(tempScale.equals("C")) {
            tempScale = "F";
            highTemp = convertCtoF(highTemp);
            lowTemp = convertCtoF(lowTemp);
        }
    }


    private static double round(double num) {
        return Math.round(num * 100) / 100.0;
    }

    private static double getHighestTrackedTempF() {
        return round(highestTrackedTempF);
    }

    private static double getLowestTrackedTempF() {
        return round(lowestTrackedTempF);
    }

    public static boolean sawFreezing() {
        return (highestTrackedTempF < FREEZING_TEMP_F || lowestTrackedTempF < FREEZING_TEMP_F);
    }

    private String getTempScale() {
        return tempScale;
    }

    public double getHighTemp() {
        return round(highTemp);
    }

    public double getLowTemp() {
        return round(lowTemp);
    }

    public String toString() {
        return "High temperature: " + round(highTemp) +  " " + tempScale +
                "\nLow temperature: " + round(lowTemp) + " " + tempScale;
    }
}