package Moneda;
import java.text.DecimalFormat;

public class Mconversor {
    
    public String operatorCurrency(String from, String to, Double cantidad){
        double value1 = Double.parseDouble(libraryValues(from));
        double value2 = Double.parseDouble(libraryValues(to));
        double result = value2 / value1 * cantidad;
        DecimalFormat format = new DecimalFormat("0.00");

        return format.format(result) +" "+ to;
    }
    public String libraryValues(String moneda){
        String[] values = {"54.04", "1", "0.94", "136.69", "0.84", "1305.68","18.01"};
        switch (moneda) {
            case "Peso Dominicano (DOP)": {
                return values[0];
            }
            case "Dolar Estadounidense (USD)": {
                return values[1];
            }
            case "Euro (EUR)": {
                return values[2];
            }
            case "Yen (JPY)": {
                return values[3];
            }
            case "Libra Esterlina (GBP)": {
                return values[4];
            }
            case "Won Coreano (KRW)": {
                return values[5];
            }
            case "Peso Mexicano (MXN)": {
                return values[6];
            }
        }
        return "No hay valor";
    }
}


