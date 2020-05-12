import java.util.Random;
import java.util.Scanner;


/**
 * Разработка на конзолно приложение, което да обработва
 * числа и да извършва операции с тях.
 * @author Александрина Филипова
 */
public class Public_Administration {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

            System.out.print("Въведете броя на елементите на масива: ");
            int sizeOfArray = scanner.nextInt();

            int[] array = new int[sizeOfArray];
            for (int i = 0; i < array.length; i++) {
                System.out.print("Въведете числото на масива: ");
                int numberOfArray = scanner.nextInt();

                while (numberOfArray < 0 || numberOfArray > 100) {
                    System.out.println("Въведените числа не трябва да са по-малки от 0 и по-големи от 100!");
                    numberOfArray = scanner.nextInt();
                }
                array[i] = numberOfArray;
            }
            System.out.println();
            System.out.println("Масива е:");
            enteredArray(array);
            System.out.println();
            menu();

        /**
         * Избиране на номер от менюто
         */

        System.out.println("Изберете номер от менюто: ");
        int chooseNumber=scanner.nextInt();

        while(true){
            switch(chooseNumber){
                case 1:
                    ascendingNumberOfArray(array);
                    break;
                case 2:
                    descendingNumberOfArray(array);
                    menu();
                    break;
                case 3:
                    findingCertainNumber(array);
                    menu();
                    break;
                case 4:
                    rollArray(array);
                    menu();
                    break;
                case 5:
                    sumNumbers(array);
                    menu();
                    break;
                case 6:
                    maxNumber(array);
                    menu();
                    break;
                case 7:
                    minNumber(array);
                    menu();
                    break;
                case 8:
                    averageNumber(array);
                    menu();
                    break;
                case 9:
                    symmetryOfArray(array);
                    menu();
                    break;
                case 10:
                    reversedArray(array);
                    menu();
                    break;
                case 11:
                    System.out.print("Числата на масива са: ");
                    enteredArray(array);
                    menu();
                    break;
                case 12:
                    System.out.println("Изход!");
                    return;
            }
            System.out.println("Въведете номер от менюто!: ");
            chooseNumber=scanner.nextInt();
        }

    }

    /**
     *  Въвеждане на числата в масива
     * @param array масив
     */
    public static void enteredArray(int[] array){
        for(int i=0; i<array.length-1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print(array[array.length-1]);
    }

    /**
     * Сортиране на въведените числа във възходящ ред
     * @param array масив
     */
    public static void ascendingNumberOfArray(int[] array){
        int Temp;
        for(int i=0;i<array.length; i++){
            for(int j=i+1; j< array.length; j++){
                 if(array[i]>array[j]){
                    Temp=array[i];
                    array[i]=array[j];
                    array[j]=Temp;
                 }
            }
        }
        System.out.println("Сортиране на въведените числа във възходящ ред: ");
        enteredArray(array);
    }

    /**
     * Сортиране на въведените числа в низходящ ред
     * @param array масив
     */
    public static void descendingNumberOfArray(int[] array){
        int Temp;
        for(int i=0;i<array.length; i++){
            for(int j=i+1; j< array.length; j++){
                if(array[i]<array[j]){
                    Temp=array[i];
                    array[i]=array[j];
                    array[j]=Temp;
                }
            }
        }
        System.out.println("Сортиране на въведените числа в низходящ ред: ");
        enteredArray(array);
    }

    /**
     * Търсене на позиция на конкретно число
     * @param array масив
     */
    public static void findingCertainNumber(int[] array){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Кое число търсите?: ");
        int certainNumber= scanner.nextInt();
        int index=-1;
        for(int i=0; i<array.length;i++){
            if(array[i] == certainNumber){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("Числото не е намерено!");
        }else{
            System.out.print("Числото " +certainNumber+ " е намерено на позиция " + index);
        }
    }

    /**
     * Разбъркване на числата
     * @param array масив
     */
    public static void rollArray(int[] array){
        Random random=new Random();

        int temp;
        int randomNumber=random.nextInt(array.length);
        for(int i=0; i<array.length; i++){
            temp= array[randomNumber];
            array[randomNumber]=array[i];
            array[i]=temp;
        }
        System.out.println("Разбъркване на числата!");
        enteredArray(array);
    }

    /**
     * Изчисляване на сбора на всички числа
     * @param array масив
     */
    public static void sumNumbers(int[] array){
        int sum=0;
        for(int i: array){
             sum+=i;
        }
        System.out.print("Сборът на числата е: " + sum);
    }

    /**
     * Намиране на най-голямото число
     * @param array масив
     * @return най-голямото число
     */
    public static int maxNumber(int[] array){
        int max=0;
        for(int i=0; i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        System.out.print("Най-голямото число е: " + max);
        return max;
    }

    /**
     * Намиране на най-малкото число
     * @param array масив
     * @return най-малкото число
     */
    public static int minNumber(int[] array){
        int min= array[0];
        for(int i=0; i<array.length; i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        System.out.print("Най-малкото число е: " + min);
        return min;
    }

    /**
     * Намиране средно-аритметично на числата
     * @param array масив
     */
    public static void averageNumber(int[] array){
        int sum=0;
        for(int i=0; i< array.length;i++){
            sum= sum + array[i];
            int average= sum/ array.length;
            System.out.print("Средно-аритметично на числото е: " + average);
        }
    }

    /**
     * Проверка за симетричност на масива от числа
     * @param array масив
     */
    public static void symmetryOfArray(int[] array){
    boolean symmetric=true;
        for(int i=0; i<(array.length + 1) /2; i++){
            if(array[i] != array[array.length-i-1]) {
                symmetric = false;
                break;
            }
        }
        System.out.println("Симетричен ли е масивът?: ");
        enteredArray(array);
        if(!symmetric){
            System.out.println("Не!");
        }else{
            System.out.println("Да!");
        }
    }

    /**
     * Обръщане на масива от числа
     * @param array масив
     */
    public static void reversedArray(int[] array){
    int[] reversed= new int[array.length];
        for(int i=array.length-1; i>=0; i--){
            System.out.println(array[i]+ " ");
        }
        System.out.println("Обръщане на масива от числа: ");
        enteredArray(array);
    }

    /**
     * Меню с опции
     */
    public static void menu(){
        System.out.println("1. Сортиране на въведените числа във възходящ ред!");
        System.out.println("2. Сортиране на въведените числа в низходящ ред!");
        System.out.println("3. Търсене на позиция на конкретно число!");
        System.out.println("4. Разбъркване на числата!");
        System.out.println("5. Изчисляване на сбора на всички числа!");
        System.out.println("6. Намиране на най-голямото число!");
        System.out.println("7. Намиране на най-малкото число!");
        System.out.println("8. Намиране средно-аритметично на числата!");
        System.out.println("9. Проверка за симетричност на масива от числа!");
        System.out.println("10. Обръщане на масива от числа!");
        System.out.println("11. Визуализирай въведените числа!");
        System.out.println("12. Изход!");
    }
}