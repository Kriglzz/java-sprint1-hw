public class Converter {
    MonthData monthData=new MonthData();

    int convertToKm(MonthData[] monthToData, int monthPick) {
        int sumSteps = monthData.sumStepsFromMonth(monthToData, monthPick);
        double sumsStepsKm = sumSteps * 0.00075;
        sumSteps = (int) Math.round(sumsStepsKm);
        return sumSteps;
    }
    int convertStepsToKilocalories(MonthData[] monthToData, int monthPick) {
        int sumCal = monthData.sumStepsFromMonth(monthToData, monthPick);
        double sumKCal=sumCal*0.05;
        sumCal=(int) Math.round(sumKCal);
        return sumCal;
    }

}
