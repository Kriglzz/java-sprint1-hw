public class MonthData {
    int[] days=new int[30];

    void printDaysAndStepsFromMonth(){
        for (int i=0; i< days.length; i++){

            System.out.println((i+1)+" день: "+days[i]);
        }
    }
    int sumStepsFromMonth(){
        int sumStepsFromMonth=0;
        for(int i=0; i< days.length;i++){
            sumStepsFromMonth+=days[i];
        }
        return sumStepsFromMonth;
    }
    int maxSteps(){
        int maxSteps=0;
        for(int i=0; i< days.length;i++){
            if(days[i]>maxSteps){
                maxSteps=days[i];
            }
        }
        return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay){
        int currentSeries=0;
        int finalSeries=0;
        for(int i=1; i< days.length;i++){
            if(days[i]>=goalByStepsPerDay && days[i-1]>=goalByStepsPerDay){
                currentSeries++;
                if(currentSeries>finalSeries){
                    finalSeries=currentSeries;
                }
            }else{
                currentSeries=0;
            }
        }
        if (finalSeries!=0){
        finalSeries++;
        }
        return finalSeries;
    }
}
