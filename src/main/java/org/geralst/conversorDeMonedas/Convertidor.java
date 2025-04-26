package org.geralst.conversorDeMonedas;

public class Convertidor {
    private final ApiMonedas ServicioApi = new ApiMonedas();

    public void convert(int option, double amount) {
        String from = "";
        String to = "";

        switch (option) {
            case 1 -> { from = "USD"; to = "CLP"; }
            case 2 -> { from = "CLP"; to = "USD"; }
            case 3 -> { from = "USD"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "USD"; }
            case 5 -> { from = "EUR"; to = "USD"; }
            case 6 -> { from = "USD"; to = "EUR"; }
            case 7 -> { from = "USD"; to = "COP"; }
            case 8 -> { from = "COP"; to = "USD"; }
        }

        double rate = ServicioApi.getExchangeRate(from, to);
        double result = amount * rate;

        System.out.printf("El valor de %.2f %s corresponde a %.2f %s\n",
                amount, from, result, to);
    }
}
