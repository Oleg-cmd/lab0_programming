import java.util.*;

public class Main {
    public static void main(String[] args) {
        // запуск и выполнение каждого задания
        // тк нам неизвестна изначальная длинна будущего массива, испольщуем ArrayList
        List<Integer> arrayList = new ArrayList<Integer>();

        // заполняем его чётными числами от 4 до 20 включительно
        for (int i=4; i <=20; i++){
            if(i%2 == 0){
                arrayList.add(i);
            }
        }

        // объявляем одномерный массив d типа int длинной arrayList.size()
        // тк в задании должно быть 2 массива с названием a (такое себе), то первый массив я назвал d
        Integer[] d = new Integer[arrayList.size()];
        d = arrayList.toArray(d);

        // сортируем в порядке убывания
        Arrays.sort(d, Collections.reverseOrder());

        // Вывод массива в консоль
        for (Integer h : d)
            System.out.print(" " + h + " ");

        System.out.print("\n");
        System.out.println("End of first array");


        // Создать одномерный массив x типа float длинной в 16.
        float[] x = new float[16];

        // рандомим числа в диапозоне между -7 и 6, преобразуем их в float и добавляем в массив
        for(int i =0; i <= 15; i++){
            double r = Math.random()*13 -7;
            x[i] = (float)r;
            System.out.print(" " + x[i] + " ");
        }

        System.out.println();
        System.out.println("End of second array");

        // создаем двумерный массив 9х16 (тк по формулам задания видно, что числа будут не целые берем double)
        double[][] a = new double[9][16];

        // массив (множество), для проверки условия
        int[] mn = {4, 6, 12, 18};

        if(d[0] != 0 && x[0] != 0){
            for (int i = 0; i < 9; i++) {  //идём по строкам
                for (int j = 0; j < 16; j++) {//идём по столбцам

                    if(d[i] == 10){
                        a[i][j] = Math.tan(Math.cos(Math.pow(x[j]*0.5, 2)));
                    }

                    // переменная для проверки принадлежности значения к множеству
                    boolean doesContain = Arrays.stream(mn)
                            .anyMatch(d[i]::equals);


                    // при округлении будут получаться одинаковые значения, но исчезнет NaN

                    if(doesContain){
                        double elem = Math.pow(-Math.pow(Math.sin(x[j]), 2), 1.0/3.0);
                        // понимаю, что для чтения это трудно воспринимается, однако задание заставило((
                        a[i][j] = Math.asin(Math.pow(Math.E, elem));
                        if(Double.isNaN(a[i][j])){
                            a[i][j] = Math.asin(Math.pow(Math.E, Math.round(elem)));
                        }

                    }

                    if(d[i] !=10 && !doesContain){
                        double elem = Math.pow(Math.sin(x[j]), 1.0/3.0);
                        double elemTan = 0.25*Math.tan(Math.pow(Math.E, x[j]));
                        // простите пожалуйста(((
                        a[i][j] = Math.pow(2*Math.pow(elem, elemTan), 3);
                        if(Double.isNaN(a[i][j])){
                            a[i][j] = Math.pow(2*Math.pow((Math.round(elem)), elemTan), 3);
                        }
                    }



                    System.out.printf("%.5f", a[i][j]); //вывод элемента
                    System.out.print(" ");
                }
                System.out.println();//перенос строки ради визуального сохранения табличной формы
            }

        }


        System.out.println();
        System.out.println("End of third array");

    }
}