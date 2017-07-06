import java.util.Arrays;
import java.util.Scanner;

/**
 * Входной класс
 *
 * @author Анастасия Вязьмина
 * @version 0.1
 * @since 27.06.2017
 */
public class Base {
    public static void main(String[] args) {
        int[] numbers = userSelectApp(20, -10, 10);
        System.out.print("Сформированный массив: ");
        System.out.println(Arrays.toString(numbers));

        int[] maxNegativeNumber = searchMaxNegativeNumber(numbers);
        System.out.printf("Первый максимальный отрицательный элемент %d (номер элемента %d).\n",
                maxNegativeNumber[0], maxNegativeNumber[1] + 1);

        int[] minPositiveNumber = searchMinPositiveNumber(numbers);
        System.out.printf("Первый минимальный положительный элемент %d (номер элемента %d).\n",
                minPositiveNumber[0], minPositiveNumber[1] + 1);

        System.out.printf("Меняем местами элементы №%d и №%d.\n",
                maxNegativeNumber[1] + 1, minPositiveNumber[1] + 1);

        numbers = swapItems(numbers, maxNegativeNumber[1], minPositiveNumber[1]);
        System.out.print("Сформированный массив: ");
        System.out.println(Arrays.toString(numbers));

    };

    /**
     * Возращает массив целых случайных чисел
     *
     * @param sizeArray длинна массива со случайными числами
     * @param minNumber минимальная величина случайного числа
     * @param maxNumber максимальная величина случайного числа
     * @return массив случайных чисел
     */
    private static int[] userSelectApp(int sizeArray, int minNumber, int maxNumber) {
        int[] numbers = new int[sizeArray];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * (maxNumber - minNumber) + minNumber);
        }
        return numbers;
    };

    /**
     * Ищет максимальный отрицательный элемент
     *
     * @param numbers массив целых чисел
     * @return массив [максимальный отрицательный элемент, индекс]
     */
    private static int[] searchMaxNegativeNumber(int[] numbers) {
        int махNegativeNumber = -100;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 && махNegativeNumber < numbers[i]) {
                махNegativeNumber = numbers[i];
                index = i;
            }
        }
        int[] result = {махNegativeNumber, index};
        return result;
    };

    /**
     * Ищет минимальный положительный элемент
     *
     * @param numbers массив целых чисел
     * @return массив [минимальный положительный элемент, индекс]
     */
    private static int[] searchMinPositiveNumber(int[] numbers) {
        int minPositiveNumber = 100;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && minPositiveNumber > numbers[i]) {
                minPositiveNumber = numbers[i];
                index = i;
            }
        }
        int[] result = {minPositiveNumber, index};
        return result;
    };

    /**
     * Меняет два элемента местами в массиве
     *
     * @param numbers массив целых чисел
     * @param index1 индекс 1-го элемента
     * @param index2 индекс 2-го элемента
     * @return массив целых чисел
     */
    private static int[] swapItems(int[] numbers, int index1, int index2) {
        int value = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = value;
        return numbers;
    };
}