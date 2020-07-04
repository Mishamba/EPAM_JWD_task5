package com.mishamba.day5.console;

import java.util.Scanner;

public class ConsoleProcessor {
    public String readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter line");
        String line = scanner.nextLine();
        return line;
    }
}
