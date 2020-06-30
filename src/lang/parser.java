package lang;

import lang.*;

public class parser {

    public String[][] tokens_pars;

    public String[] checkErrors(String[][] tokens) {
        String[] result = {"", "no"};
        //Soon
        return result;
    }

    public String[][] parse(String[][] tokens)
    {
        String[] errors = checkErrors(tokens);
        if(!errors[0].equals(""))
        {
            printingErrors.print(errors[0], errors[1]);
        }

        

        return tokens_pars;
    }

}
