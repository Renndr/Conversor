package Medidas;

public class masaConverter {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double kg = toKg(amount, fromUnit);
        return fromKg(kg, toUnit);
    }
    private Double toKg(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Kilogramo (kg)":
                return amount;
            case "Tonelada (t)":
                return amount * 1000;
            case "Libra (lb)":
                return amount / 2.20462;
            case "Miligramo (mg)":
                return amount / 1e+6;
            case "Nanogramo (ng)":
                return amount / 1e+12;  
            case "Gramos (g)":
                return amount / 1000;
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }

    private Double fromKg(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Kilogramo (kg)":
                return amount;
            case "Tonelada (t)":
                return amount / 1000;
            case "Libra (lb)":
                return amount * 2.20462;
            case "Miligramo (mg)":
                return amount * 1e+6;
            case "Nanogramo (ng)":
                return amount * 1e+12;  
            case "Gramos (g)":
                return amount * 1000; 
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}
