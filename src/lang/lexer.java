package lang;

import lang.*;

public class lexer {

    public String code;
    public String[][] tokens;

    public String[][] getTokens()
    {
        tokens = new String[code.length()][2];
        StringBuilder tmp_str = new StringBuilder();
        String[] symbols;
        boolean skipl = false;
        int token = 0;
        char chr;

        for (int chr_pos = 0; chr_pos < code.length(); chr_pos++)
        {
            chr = (char ) code.getBytes()[chr_pos];

            if(String.valueOf(chr).equals("\"") || String.valueOf(chr).equals("'"))
            {
                skipl = !skipl;
                if(!skipl) continue;
            }

            if(skipl)
            {
                continue;
            }

            symbols = checkSymbols.check(dictionary.symbols, tmp_str.toString().trim());

            if(!symbols[0].equals(""))
            {
                tokens[token] = symbols;
                token++;

                tmp_str = new StringBuilder();
            }

            symbols = checkSymbols.check(dictionary.symbols, String.valueOf(chr));
            if(!symbols[0].equals(""))
            {
                if(!tmp_str.toString().trim().equals(""))
                {
                    tokens[token] = new String[]{tmp_str.toString().trim(), "UNKNOWN"};
                    token++;

                    tmp_str = new StringBuilder();
                }

                tokens[token] = symbols;
                token++;
                continue;
            }

            tmp_str.append(chr);
        }

        return tokens;
    }

}
