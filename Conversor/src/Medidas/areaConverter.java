package Medidas;

public class areaConverter {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double metro = toMetro(amount, fromUnit);
        return fromMetro(metro, toUnit);
    }
    private Double toMetro(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Metro cuadrado":
                return amount;
            case "Kilometro cuadrado":
                return amount * 1e+6;
            case "Yarda cuadrada":
                return amount / 1.196;
            case "Pie cuadrado":
                return amount / 10.7639;
            case "Pulgada cuadrada":
                return amount * 1550;  
            case "Hectarea":
                return amount * 1e+4;    
            case "Milla cuadrada":
                return amount * 2.59e+6; 
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }

    private Double fromMetro(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Metro cuadrado":
                return amount;
            case "Kilometro cuadrado":
                return amount / 1e+6;
            case "Yarda cuadrada":
                return amount * 1.196;
            case "Pie cuadrado":
                return amount * 10.7639;
            case "Pulgada cuadrada":
                return amount / 1550;  
            case "Hectarea":
                return amount * 1e-4;  
            case "Milla cuadrada":
                return amount / 2.59e+6; 
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}
