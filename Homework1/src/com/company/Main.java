package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double bytes;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        bytes = scanner.nextDouble();
        printBytes(bytes);
    }
    public static void printBytes(double bytes){
        if (bytes<1024) System.out.println(bytes + " B");
        else if (bytes < Math.pow(2,20)) System.out.println(String.format("%.1f",bytes/1024)+" KB");
        else if (bytes < Math.pow(2,30)) System.out.println(String.format("%.1f",bytes/Math.pow(1024,2))+" MB");
        else if (bytes < Math.pow(2,40)) System.out.println(String.format("%.1f",bytes/Math.pow(1024,3))+" GB");
        else if (bytes < Math.pow(2,50)) System.out.println(String.format("%.1f",bytes/Math.pow(1024,4))+" TB");
        else if (bytes < Math.pow(2,60)) System.out.println(String.format("%.1f",bytes/Math.pow(1024,5))+" PB");
    }
}
