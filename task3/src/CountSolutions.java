import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * Статический класс решения поставленной задачи - считать и возвращать чего больше
 */
public class CountSolutions {

    private static String[] selfPronouns = {
            "я", "мы"
    };

    private static String[] otherPronouns = {
            "ты", "вы", "он", "она", "оно", "они", // личные других лиц
            "себя", // возвратные
            "мой", "твой", "наш", "ваш", "свой", // притяжательные
            "сам", "весь", "всякий", "каждый", "иной", "другой", "любой", // определительные
            "кто", "что", "какой", "чей", "который", "сколько", "каков", // вопросительные, относительные
            "никто", "ничто", "некого", "нечего", "никакой", "ничей", // отрицательные
            "некто", "нечто", "некоторый", "несколько", "кто-то", "что-то", "кто-нибудь", // неопределенные
            "этот", "тот", "такой", "таков", "столько" // указательные
    };

    private static List<String> selfPronsList = Arrays.asList(selfPronouns);
    private static List<String> otherPronsList = Arrays.asList(otherPronouns);

    private static final String PUNCTUACTION_SIGNS_REGEX = "[/[.,\\/\'\"#!?><$%\\^&\\*;:{}=\\-_`~()\t]/g]";

    public static long countPronouns(String line) {
        line = String.join(" ", line.split(PUNCTUACTION_SIGNS_REGEX));
        return Arrays.stream(line.split(" ")).filter(selfPronsList::contains).count();
    }

    public static long countOtherPronouns(String line) {
        line = String.join(" ", line.split(PUNCTUACTION_SIGNS_REGEX));
        return Arrays.stream(line.split(" ")).filter(otherPronsList::contains).count();
    }

    /**
     * Читает весь буффер, считает количество местоимений и выводит каких больше
     * @param reader Ссылка на объект Buffered Reader
     * @return Если количество слов в буфере из selfPronount больше, чем из otherPronouns
     * @throws IOException
     */
    public static long[] isSelfMore(BufferedReader reader) throws IOException {
        String curLine;
        long cntSelf = 0, cntOther = 0;
        while ((curLine = reader.readLine()) != null) {
            cntSelf += countPronouns(curLine.toLowerCase());
            cntOther += countOtherPronouns(curLine.toLowerCase());
        }
        return new long[] {cntSelf > cntOther ? 1l : 0l, cntSelf, cntOther};
    }

}
