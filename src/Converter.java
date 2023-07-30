public class Converter {
    MonthData monthData=new MonthData();

    int convertToKm() {
        int sumSteps = monthData.sumStepsFromMonth();
        double sumsStepsKm = sumSteps * 0.00075;
        sumSteps = (int) Math.round(sumsStepsKm);
        return sumSteps;
    }
    int convertStepsToKilocalories() {
        int sumCal = monthData.sumStepsFromMonth();
        double sumKCal=sumCal*0.05;
        sumCal=(int) Math.round(sumKCal);
        return sumCal;
    }

}
