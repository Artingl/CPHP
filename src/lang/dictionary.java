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
            {"for", "IDENT"},
            {"whiile", "IDENT"},
            {"foreach", "IDENT"},
            {"$", "IDENT"},

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

}
