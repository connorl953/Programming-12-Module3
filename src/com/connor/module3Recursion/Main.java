package com.connor.module3Recursion;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generate which term?");
        int j = scanner.nextInt();
        System.out.println("Term #" + j + " is " + calcFibonacci(j));
    }

    public static int calcFibonacci(int j) {

        switch (j) {
            case 0:
            {
                return 0;
            }

            case 1:
            {
                return 1;
            }

            default:
            {
                return (calcFibonacci(j - 1) + calcFibonacci(j - 2));
            }
        }

    }

}
