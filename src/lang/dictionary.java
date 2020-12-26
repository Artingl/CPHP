package lang;

public class dictionary {

    public static String[][] symbols = {
            {"function", "IDENT"},
            {"class", "IDENT"},
            {"public", "IDENT"},
            {"private", "IDENT"},
            {"return", "IDENT"},
            {"echo", "IDENT"},
            {"if", "IDENT"},
            {"else", "IDENT"},
            {"for", "IDENT"},
            {"while", "IDENT"},
            {"foreach", "IDENT"},
            {"break", "IDENT"},

            {"$", "CREATE_VARIABLE"},

            {"(", "SIGN"},
            {")", "SIGN"},
            {"{", "SIGN"},
            {"}", "SIGN"},
            {"[", "SIGN"},
            {"]", "SIGN"},
            {".", "SIGN"},
            {",", "SIGN"},
            {";", "SIGN"},

            {"=", "OPERATOR"},
            {"+", "OPERATOR"},
            {"-", "OPERATOR"},
            {"*", "OPERATOR"},
            {"/", "OPERATOR"},
            {"%", "OPERATOR"},

            {"<?php", "BOF"},
            {"?>", "EOF"},
    };

    public static String translateIdent(String s){
        if (s.toLowerCase().equals("function"))
            return "auto";

        return s;
    }

    public static String[][] translate = {


    };

}
