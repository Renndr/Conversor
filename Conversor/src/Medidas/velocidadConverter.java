package Medidas;

public class velocidadConverter {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double metro = toMetro(amount, fromUnit);
        return fromMetro(metro, toUnit);
    }
    private Double toMetro(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Metro por segundo":
                return amount;
            case "Kilometro por hora":
                return amount / 3.6;
            case "Milla por hora":
                return amount / 2.23694;
            case "Pie por segundo":
                return amount / 3.28084;
            case "Nudo":
                return amount / 1.944;  
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }

    private Double fromMetro(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Metro por segundo":
                return amount;
            case "Kilometro por hora":
                return amount * 3.6;
            case "Milla por hora":
                return amount * 2.23694;
            case "Pie por segundo":
                return amount * 3.28084;
            case "Nudo":
                return amount * 1.944; 
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}

