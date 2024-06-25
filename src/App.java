import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        // collectionsTest();
        // notExceptionTest();
        exceptionTest();

        System.out.println("The end!");
    }

    public static void collectionsTest() {

        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Hello");
        list.add("World");
        list.add("!");

        System.out.println("List: " + list);

        Set<String> set = new HashSet<>();

        set.add("Hello");
        set.add("World");
        set.add("!");
        set.add("Hello");
        set.add("World");
        set.add("!");

        System.out.println("Set: " + set);

        Map<String, Integer> map = new HashMap<>();

        map.put("Hello", 2);
        map.put("World", 5);
        map.put("!", 1);
        map.put("Hello", 10);

        System.out.println("Map: " + map);

        for (String key : map.keySet()) {

            Integer value = map.get(key);

            System.out.println(key + " --> " + value);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " --> " + value);
        }

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        Map<Character, Integer> charCounter = new HashMap<>();

        for (char c : lorem.toLowerCase().toCharArray()) {

            if (charCounter.containsKey(c)) {

                int actualValue = charCounter.get(c);
                charCounter.put(c, actualValue + 1);
            } else
                charCounter.put(c, 1);
        }

        System.out.println("\n" + lorem + "\n");
        System.out.println("Char counter:");
        for (Entry<Character, Integer> entry : charCounter.entrySet()) {

            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public static void notExceptionTest() {

        int val1 = 5;
        int val2 = 0;
        int res = divNE(val1, val2);

        System.out.println(val1 + " / " + val2 + " = " + res);
    }

    public static int divNE(int x, int y) {

        return x / y;
    }

    public static void exceptionTest() {

        try {
            int val1 = 5;
            int val2 = 0;
            int res = div(val1, val2);

            System.out.println(val1 + " / " + val2 + " = " + res);
        } catch (Exception e) {

            System.out.println("Error: divisione per 0!!\n" + e.getMessage());
            // e.printStackTrace();
        } finally {

            System.out.println("Finally block");
        }

        System.out.println("end of method block");
    }

    public static int div(int x, int y) throws Exception {

        if (y == 0)
            throw new Exception("Divisione per 0!!");

        return x / y;
    }

    public static void funA() {
        try {
            funB();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void funB() throws Exception {
        try {
            funC();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void funC() throws Exception {
        funD();
    }

    public static void funD() throws Exception {

        throw new Exception("Exception from funD");
    }
}
