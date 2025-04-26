package org.geralst.conversorDeMonedas;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Convertidor converter;

    public Menu(Scanner scanner, Convertidor converter) {
        this.scanner = scanner;
        this.converter = converter;
    }

    public void start() {
        int option;
        do {
            showOptions();
            option = Integer.parseInt(scanner.nextLine());

            if (option >= 1 && option <= 8) {
                System.out.print("Ingresa el valor que deseas convertir: ");
                double amount = Double.parseDouble(scanner.nextLine());
                converter.convert(option, amount);
            } else if (option != 9) {
                System.out.println("Opción inválida.");
            }

        } while (option != 9);

        System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
    }

    private void showOptions() {
        System.out.println("\nBienvenido/a al conversor de monedas");

        System.out.println("1. Dolar(USD) a Peso Chileno(CLP)");
        System.out.println("2. Peso Chileno(CLP) a Dolar(USD)");
        System.out.println("3. Dolar(USD) a Real Brasileño(BRL)");
        System.out.println("4. Real Brasileño(BRL) a Dolar(USD)");
        System.out.println("5. Euro(EUR) a Dolar(USD)");
        System.out.println("6. Dolar(USD) a Euro(EUR)");
        System.out.println("7. Dolar(USD) a Peso Colombiano(COP)");
        System.out.println("8. Peso Colombiano(COP) a Dolar(USD)");
        System.out.println("9. Salir");
        System.out.print("Selecciona una opción: ");
    }
}
