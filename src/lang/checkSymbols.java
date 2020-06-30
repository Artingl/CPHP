package lang;

public class checkSymbols {

    public static String[] check(String[][] dict, String value)
    {
        for (String[] strings : dict) {
            if (strings[0].equals(value.toLowerCase())) {
                return strings;
            }
        }

        return new String[]{""};
    }

}
