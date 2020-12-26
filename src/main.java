import java.io.*;
import java.util.Arrays;

import lang.*;

public class main {

    public static void main(String[] args) throws Exception {
        String code = deleteComments(read_code("code.php"));
        String[][] tokens;
        String[][] tokens_parser;
        String cpp;

        lexer lex = new lexer();
        parser pars = new parser();

        lex.code = code;
        tokens = lex.getTokens();
        //tokens_parser = pars.parse(tokens);
        cpp = translator.getCppCode(tokens);

        FileWriter fileWriter = new FileWriter(new File("test.cpp"));
        fileWriter.write(cpp);
        fileWriter.close();

        for (String[] token : tokens) {
            if(token[0] != null)
                System.out.println(Arrays.toString(token));
        }
    }

    public static String deleteComments(String code) {
        String[] codeLines = code.split("\n");

        String inStringString = "";
        boolean inString = false;
        char inStringChar = ' ';

        boolean bigComment = false;
        String result = "";

        for (int i = 0; i < codeLines.length; i++)
        {
            String line = codeLines[i];
            int skipCounter = 0;
            for (int j = 0; j < line.length(); j++)
            {
                if (skipCounter != 0)
                {
                    skipCounter--;
                    continue;
                }

                char chr = (char) line.getBytes()[j];
                char nextChr = ' ';
                if (j < line.length() - 1)
                    nextChr = (char) line.getBytes()[j + 1];

                if (chr == '"' || chr == '\'' &&  !bigComment)
                {
                    inString = !inString;
                    if (inString)
                    {
                        inStringChar = chr;
                        inStringString = "";
                    }
                    else {
                        if (chr != inStringChar)
                        {
                            inString = true;
                        }
                        else {
                            result += inStringString + chr;
                            continue;
                        }
                    }
                }

                if (inString)
                {
                    inStringString += chr;
                    continue;
                }
                if (chr == '/' && nextChr == '/' || chr == '#' && !bigComment) break;
                if (chr == '/' && nextChr == '*') bigComment = true;
                if (chr == '*' && nextChr == '/' && bigComment)
                {
                    skipCounter = 2;
                    bigComment = false;
                    continue;
                }
                if (bigComment)
                {
                    continue;
                }

                result += chr;
            }

            result += "\n";
        }

        return result.trim();
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
