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
        String[] token;

        if(!errors[0].equals(""))
        {
            printingErrors.print(errors[0], errors[1]);
        }

        for(int i = 0; i < tokens.length; i++)
        {
            token = tokens[i];
            if(token[0] == null) continue;

            System.out.println(token[0] + " => " + typeSystem.getType(token[0]));

        }

        return tokens_pars;
    }

}
