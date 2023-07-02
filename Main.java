package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        Random random = new Random();
        int L = 2000;
        int i = random.nextInt(L);
        System.out.println("Наше случайное число = " + i);

        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        String binSTR = Integer.toBinaryString(i);
        System.out.println("Число в двоичном виде: " + binSTR);
        int n = Integer.valueOf(binSTR.length()) - 1;
        System.out.println("Номер старшего значащего бита в числе = " + n);

        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        /*
        Я придумал сделать вот такую конструкцию, чтобы мы не расходовали лишнюю память на массив
        избыточной длины, и чтобы в конце массив не был заполнен нулями.
        Сначала считаем, сколько у нас кратных чисел от i до Short.MaxValue:
        */
        int j = i;
        int counter = 0;
        while(j <= Short.MAX_VALUE){
            if ((j % n != 0) && (j <= Short.MAX_VALUE)) {
                j++;
            } else if ((j % n == 0) && (j <= Short.MAX_VALUE)){
                counter++;
                j+=n;
            }
        }
        //Далее инициализируем массив m1 длины counter и заполняем массив числами, кратными n:
        Integer[] m1 = new Integer[counter];
        j = i;
        for (int k = 0; k < m1.length; k++){
            while (j <= Short.MAX_VALUE){
                if ((j % n != 0) && (j <= Short.MAX_VALUE)) {
                    j++;
                } else if ((j % n == 0) && (j <= Short.MAX_VALUE)){
                    m1[k] = j;
                    j+=n;
                    break;
                }
            }
        }
        System.out.println(Arrays.deepToString(m1));
        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        /*
        Здесь сделал по образу и подобию третьего.
        Только здесь пробежались по всем значениям от Short.MIN_VALUE до i, посчитали, сколько некратных
        чисел, а дальше создали массив m2 нужного размера и заполнили его.
         */
        j = Short.MIN_VALUE;
        counter = 0;
        while(j <= i){
            if ((j % n == 0) && (j <= i)) {
                j++;
            } else if ((j % n != 0) && (j <= i)){
                counter++;
                j++;
            }
        }
        Integer[] m2 = new Integer[counter];
        j = Short.MIN_VALUE;
        for (int k = 0; k < m2.length; k++){
            while (j <= i){
                if ((j % n == 0) && (j <= i)) {
                    j++;
                } else if ((j % n != 0) && (j <= i)){
                    m2[k] = j;
                    j++;
                    break;
                }
            }
        }
        System.out.println(Arrays.deepToString(m2));
    }
}