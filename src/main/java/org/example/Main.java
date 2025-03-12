package org.example;

import org.apache.commons.cli.ParseException;
import org.example.CommandHandler.Helper.Helper;

public class Main {
    public static void main(String[] args) throws ParseException {

        Helper helper = new Helper();
        helper.helpCommands(args);

    }
}