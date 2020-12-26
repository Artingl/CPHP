package lang;

import java.util.Arrays;

public class translator {

    public static String header = "#include \"io.cpp\"\n" +
            "#include <string>\n" +
            "using namespace std;\n";
    public static StringBuilder functions = new StringBuilder();

    public static String getCppCode(String[][] tokens)
    {
        String cpp = "int main() {";
        int skip = 0;
        Variables gvariables = new Variables();

        for (int i = 0; i < tokens.length; i++)
        {
            if (skip != 0) {

                skip--;
                continue;
            }

            String[] token = tokens[i];
            if (token[0] == null) continue;

            if (token[1].equals("IDENT")) {
                int oc = 0;

                if (token[0].equals("function")) {
                    Variables variables = new Variables();
                    functions.append(" ").append(dictionary.translateIdent(token[0])).append(" ");

                    for (int j = i + 1; j < tokens.length; j++) {
                        String[] token1 = tokens[j];
                        if (token1[1] == null) continue;

                        if (token1[0].equals("{")) oc++;
                        else if (token1[0].equals("}") && oc > 0) oc--;
                        if (token1[0].equals("}") && oc == 0) {
                            //end of function
                            functions.append(" ").append(token1[0]).append(" ");
                            break;
                        }

                        if (token1[1].equals("CREATE_VARIABLE")) {
                            if (!variables.checkForExists(tokens[j + 1][0]))
                            {
                                variables.addVariable(tokens[j + 1][0]);
                                functions.append(" auto ");
                            }
                        }

                        if (token1[1].equals("IDENT"))
                        {
                            functions.append(" ").append(dictionary.translateIdent(token1[0])).append(" ");
                        }

                        if (token1[1].equals("UNKNOWN") || token1[1].equals("SIGN")) {
                            functions.append(" ").append(token1[0]).append(" ");
                        }
                        if (token1[1].equals("OPERATOR"))
                        {
                            functions.append(token1[0]);
                        }

                        skip++;
                    }

                    skip++;
                }
                else {
                    cpp += " " + token[0] + " ";
                }


            }
            else {
                if (token[1].equals("CREATE_VARIABLE")) {
                    if (!gvariables.checkForExists(tokens[i + 1][0]))
                    {
                        gvariables.addVariable(tokens[i + 1][0]);
                        cpp += " auto ";
                    }
                }

                if (token[1].equals("UNKNOWN") || token[1].equals("SIGN")) {
                    cpp += " " + token[0] + " ";
                }
                if (token[1].equals("OPERATOR"))
                {
                    cpp += token[0];
                }

            }
        }

        cpp += "\nreturn 0;\n}";
        return header + "\n" + functions + "\n" + cpp;
    }

}
