import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Входной класс
 *
 * @author Анастасия Вязьмина
 * @version 0.1
 * @since 20.07.2017
 */
public class Base {
    /*
    Есть входной файл с набором слов, написанных через пробел
    Необходимо:
        Прочитать слова из файла.
        + Отсортировать в алфавитном порядке.
        + Посчитать сколько раз каждое слово встречается в файле.
        + Вывести статистику на консоль
        + Найти слово с максимальным количеством повторений.
        + Вывести на консоль это слово и сколько раз оно встречается в файле
     */
    public static void main(String[] args) {
        Scanner scanner = null;

        // Читаем файл
        try {
            scanner = new Scanner(new File("src\\main\\java\\text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Для подсчета слов, по пути отсортирует
        Map<String, Integer> wordsNumbers = new TreeMap<>();

        // Для хранения наиболее повторяющихся слов (список, на случай, если будет несколько)
        List<String> maxWords = new ArrayList<>();
        Integer maxNumber = 0;

        // Флаг на случай пустого файла
        Boolean fileIsEmpty = true;

        while (scanner.hasNext()) {
            String currentWord = scanner.useDelimiter("\\s+").next();
            fileIsEmpty = false;
            // Считаем слова
            Integer countWord = wordsNumbers.get(currentWord);
            if (countWord == null) {
                countWord = 0;
            }
            wordsNumbers.put(currentWord, ++countWord);

            // Ищем часто повторяющиеся
            if (maxNumber < countWord) {
                maxNumber = countWord;
                maxWords.clear();
                maxWords.add(currentWord);
            } else if (maxNumber.equals(countWord)) {
                maxWords.add(currentWord);
            }
        }

        if (!fileIsEmpty) {
            System.out.println("Список слов и их количество:");
            // TreeMap выводит слова в естественном лексикографическом порядке (алфавитном)
            System.out.println(wordsNumbers);
            System.out.printf("Чаще всего встречается слово/а: %s.\n", maxWords);
            System.out.printf("Количество повторений: %d.\n", maxNumber);
        } else {
            System.out.println("Файл пуст.");
        }

        scanner.close();
    }
}
