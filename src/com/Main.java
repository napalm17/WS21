package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getInput();
    }
    public static void getInput(){
        Scanner sc = new Scanner(System.in);
        int[] inputs = new int[5];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < 6; j++) {
                System.out.print((int)Math.pow(inputs[i], 2));
                System.out.print(" ");
            }
            System.out.println();

        }
    }
}
