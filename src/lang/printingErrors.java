package lang;

public class printingErrors {

    public static void print(String message, String exit)
    {
        System.out.println(message);
        if(!exit.equals("no")) System.exit(-1);
    }

}
