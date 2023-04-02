package Temperatura;

public class conversorTemp {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double celsius = toCelsius(amount, fromUnit);
        return fromCelsius(celsius, toUnit);
    }
    
    private Double toCelsius(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Celsius":
                return amount;
            case "Fahrenheit":
                return (amount - 32) * 5 / 9;
            case "Kelvin":
                return amount - 273.15;
            case "Rankine":
                return (amount - 491.67) * 5 / 9;
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }
    
    private Double fromCelsius(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Celsius":
                return amount;
            case "Fahrenheit":
                return amount * 9 / 5 + 32;
            case "Kelvin":
                return amount + 273.15;
            case "Rankine":
                return (amount + 273.15) * 9 / 5;
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}
