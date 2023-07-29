import java.util.Scanner;

public class MonthData {
    int[] days=new int[30];                                                  //Массив для статистики на каждый день месяца

    void printDaysAndStepsFromMonth(MonthData[]monthToData, int monthPick){                //уточнить у эксперта, как надо было сделать правильно. Сделал не по тз, но не знал как по другому
        for (int i=0; i< days.length; i++){

            System.out.println((i+1)+" день: "+monthToData[monthPick-1].days[i]);
        }
    }
    int sumStepsFromMonth(MonthData[]monthToData, int monthPick){
        int sumStepsFromMonth=0;
        for(int i=0; i< days.length;i++){
            sumStepsFromMonth+=monthToData[monthPick-1].days[i];
        }
        return sumStepsFromMonth;
    }
    int maxSteps(MonthData[]monthToData, int monthPick){
        int maxSteps=0;
        for(int i=0; i< days.length;i++){
            if(monthToData[monthPick-1].days[i]>maxSteps){
                maxSteps=monthToData[monthPick-1].days[i];
            }
        }
        return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay, MonthData[]monthToData, int monthPick){
        int currentSeries=0;
        int finalSeries=0;
        for(int i=1; i< days.length;i++){
            if(monthToData[monthPick-1].days[i]>=goalByStepsPerDay && monthToData[monthPick-1].days[i-1]>=goalByStepsPerDay){
                currentSeries+=1;
                if(currentSeries>finalSeries){
                    finalSeries=currentSeries;
                }
            }else{
                currentSeries=0;
            }
        }

        return finalSeries;
    }
}
