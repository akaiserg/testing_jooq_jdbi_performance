package com.myproject.test.queries.app;


import java.util.Scanner;

public class Menu {

    public volatile boolean infiniteLoop = true;

    public void menu(char letter) {

        Scanner scanner = new Scanner(System.in);
        while (infiniteLoop) {
            System.out.println("\nMenu Options\n");
            System.out.println("(1) - Run  test with JDBI");
            System.out.println("(2) - Run  test with JOOQ");
            System.out.println("(3) - Quit");

            System.out.print("Please enter your selection:\t");
            int selection = scanner.nextInt();

            if (selection == 1) {
                JdbiTest jdbiTest = new JdbiTest();
                System.out.println(jdbiTest.getMessage(letter));
                //gc
                jdbiTest = null;
                System.out.println("\n");
            } else if (selection == 2) {
                JooqTest jooqTest = new JooqTest();
                System.out.println(jooqTest.getMessage(letter));
                //gc
                jooqTest = null;
                System.out.println("\n");
            } else if (selection == 3) {
                break;
            }
        }

    }
}
