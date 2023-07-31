import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[]monthToData=new MonthData[12];
    int goalByStepsPerDay=10000;
    MonthData monthData= new MonthData();
    Converter converter=new Converter();
    StepTracker(Scanner scan){
        scanner = scan;
        for (int i=0; i< monthToData.length; i++){
            monthToData[i]= new MonthData();

        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Ввежите номер месяца или вернитесь назад, введя команду \"0\": ");
        month: while (true) {

            int month = scanner.nextInt();

            if (month >= 1 && month <= 12) {
                //MonthData monthData = monthToData[month-1]; изначальный вариант, когда в коде везде были параметры у методов
                while(true) {
                    System.out.println("Введите номер дня от 1 до 30 (включительно) или вернитесь назад, введя команду \"0\": ");
                    int day = scanner.nextInt();
                    if (day >= 1 && day <= 30) {
                        System.out.println("Введите количество пройденных шагов: ");
                        while (true) {     //Узнать, делается ли цикл true в цикле true.
                            int steps = scanner.nextInt();
                            if (steps > 0) {
                                //MonthData monthData = monthToData[month-1];
                                monthData.days[day -1] = steps;
                                System.out.println("Количество шагов ("+steps+") добавлено в "+day+"-й день, "+month+"-го месяца");
                                break month;
                            } else {
                                System.out.println("Количество шагов должно быть положительным числом");
                            }
                        }
                    } else if (day == 0) {
                        break;
                    }
                }
            } else if (month == 0){
                break;
            } else {
                System.out.println("Введите номер месяца от 1 до 12 или вернитесь назад, введя команду \"0\"");
            }
        }
    }
    void changesStepGoal(){
        System.out.println("Текущая цель на количество шагов в день = "+goalByStepsPerDay);
        System.out.print("Введите новую цель: ");
        int goal=scanner.nextInt();
        if(goal>0) {
            goalByStepsPerDay = goal;
            System.out.println("Цель в " + goal + " успешно введена!");
        }else{
            System.out.println("Цель должна быть положительным числом");
        }
    }
    void printStatistic(){
        System.out.println("За какой месяц вы хотите увидеть статистику?");
        while (true) {
            int monthPick=scanner.nextInt();
            if (monthPick >= 1 && monthPick <= 12) {
                monthData.printDaysAndStepsFromMonth();
                int sumStepsFromMonth= monthData.sumStepsFromMonth();
                System.out.println("За " + monthPick + " месяц вы прошли " + sumStepsFromMonth + " шагов");
                System.out.println("Ваш максимальный рекорд за день: " + monthData.maxSteps());
                System.out.println("Среднее количество шагов за месяц: " + (sumStepsFromMonth / 30));
                System.out.println("За месяц вы прошли " + converter.convertToKm(sumStepsFromMonth) + " км!");
                System.out.println("За месяц вы сожгли " + converter.convertStepsToKilocalories(sumStepsFromMonth) + " килокалорий!");
                System.out.println("Ваша максимальная серия дней с выполненной целью: " + monthData.bestSeries(goalByStepsPerDay) + " дней");
                break;
            } else {
                System.out.println("Диапазон месяцев от 1 до 12");
            }
        }

    }
}

