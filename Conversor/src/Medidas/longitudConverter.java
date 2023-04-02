package Medidas;

public class longitudConverter {
    public Double convertTemperature(Double amount, String fromUnit, String toUnit) throws IllegalArgumentException {
        if (amount == null || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Los argumentos de conversión no pueden ser nulos");
        }
        Double km = toKm(amount, fromUnit);
        return fromKm(km, toUnit);
    }
    private Double toKm(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Kilómetro (km)":
            return amount;
            case "Metro (m)":
            return amount*0.001;
            case "Centímetro (cm)":
            return amount*0.00001;
            case "Milímetro (mm)":
            return amount*0.000001;
            case "Pie (ft)":
            return amount * 0.000305;  
            case "Pulgada (in)":
            return amount * 0.0000254;
            case "Milla":
            return amount * 1.61; 
            default:
                throw new IllegalArgumentException("Unidad de origen no válida: " + unit);
        }
    }
    
    private Double fromKm(Double amount, String unit) throws IllegalArgumentException {
        switch (unit) {
            case "Kilómetro (km)":
                return amount;
            case "Metro (m)":
                return amount*1000;
            case "Centímetro (cm)":
                return amount*10000;
            case "Milímetro (mm)":
                return amount*1000000;
            case "Pie (ft)":
                return amount * 3280.84;  
            case "Pulgada (in)":
                return amount * 39370.08;
            case "Milla":
                return amount * 0.62; 
            default:
                throw new IllegalArgumentException("Unidad de destino no válida: " + unit);
        }
    }
}



