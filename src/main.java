import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import lang.*;

public class main {

    public static void main(String[] args) throws Exception {
        String code = read_code("code.php");
        String[][] tokens;
        String[][] tokens_parser;

        lexer lex = new lexer();
        parser pars = new parser();

        lex.code = code;
        tokens = lex.getTokens();

        tokens_parser = pars.parse(tokens);


/*        for (String[] token : tokens) {
            if(token[0] != null)
                System.out.println(Arrays.toString(token));
        }*/
    }

    private static String read_code(String file_name) throws Exception {
        StringBuilder s = new StringBuilder();

        try {
            BufferedReader br = null;
            String line = "";

            br = new BufferedReader(new FileReader(file_name));
            while((line = br.readLine()) != null)
            {
                s.append(line).append("\n");
            }

            br.close();
        } catch (IOException e) {
            throw new Exception("file not found!");
        }


        return s.toString();
    }

}
