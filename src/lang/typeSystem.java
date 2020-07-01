package lang;

public class typeSystem {

    public static String getType(String str)
    {
        if(str.equals("")) return "unknown";

        if(str.endsWith("'") || str.endsWith("\"")) return "String";

        if(str.equals("true") || str.equals("false")) return "boolean";

        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f"};

        if(str.startsWith("0x") && str.length() > 2)
        {
            boolean check = false;
            for (int i = 2; i < str.length(); i++)
            {
                for (String num : nums) {
                    if (String.valueOf((char) str.toLowerCase().getBytes()[i]).equals(num))
                    {
                        check = true;
                        break;
                    }
                }

                if(!check) break;

            }

            if(check) return "int";

        }
        else {

            boolean check = false;
            char chr;
            for (int i = 0; i < str.length(); i++)
            {
                chr = (char ) str.toLowerCase().getBytes()[i];

                if(chr == 'a' || chr == 'b' || chr == 'c' || chr == 'd' || chr == 'e' || chr == 'f')
                {
                    check = false;
                    break;
                }

                for (String num : nums) {
                    if (String.valueOf((char) str.getBytes()[i]).equals(num))
                    {
                        check = true;
                        break;
                    }
                }

                if(!check) break;

            }

            if(check) return "int";
        }
        

        return "unknown";
    }

}
