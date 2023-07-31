public class Converter {


    int convertToKm(int sumStepsFromMonth) {

        double sumStepsKm = sumStepsFromMonth * 0.00075;
        sumStepsFromMonth = (int) Math.round(sumStepsKm);
        return sumStepsFromMonth;
    }
    int convertStepsToKilocalories(int sumStepsFromMonth) {

        double sumKCal=sumStepsFromMonth*0.05;
        sumStepsFromMonth=(int) Math.round(sumKCal);
        return sumStepsFromMonth;
    }

}
