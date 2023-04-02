package Medidas;

public class volumenConverter {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double gal = toGal(amount, fromUnit);
        return fromGal(gal, toUnit);
    }
    private Double toGal(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Galón (gal)":
                return amount;
            case "Metro cúbico":
                return amount*219.97;
            case "Litro (l)":
                return amount/3.785;
            case "Onza líquida (oz)":
                return amount/128;
            case "Centímetro cúbico":
                return amount / 3785;  
            case "Milímetro cúbico":
                return amount / 3.785e+6; 
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }

    private Double fromGal(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Galón (gal)":
                return amount;
            case "Metro cúbico":
                return amount / 264.2;
            case "Litro (l)":
                return amount*3.785;
            case "Onza líquida (oz)":
                return amount*128;
            case "Centímetro cúbico":
                return amount * 3785;  
            case "Milímetro cúbico":
                return amount * 3.785e+6;
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}