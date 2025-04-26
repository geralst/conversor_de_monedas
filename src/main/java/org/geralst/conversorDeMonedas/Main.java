package org.geralst.conversorDeMonedas;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Convertidor converter = new Convertidor();
        Menu menu = new Menu(scanner, converter);

        menu.start();
    }
}