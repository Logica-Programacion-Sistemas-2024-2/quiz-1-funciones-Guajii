package quiz1sistemasg2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        // Solicito tipo de transporte
        System.out.print("Ingrese el tipo de vehículo estacionado (C: Carro, M: Moto, B: Bicicleta): ");
        char tipoMediodeTransporte = usuario.next().toUpperCase().charAt(0);

        // Ingrese # de horas
        System.out.print("Ingrese el número de horas de estancia: ");
        int horas = usuario.nextInt();

        // Solicitar si es estudiante
        System.out.print("¿Es estudiante? (1: Sí, 2: No): ");
        int esEstudiante = usuario.nextInt();
        boolean esEstudianteBoolean = (esEstudiante == 1);

        // Calcular valor inicial del parqueo
        double valorBase = calcularValorBase(tipoMediodeTransporte, horas);

        // Calcular valor total antes de descuentos
        double valorAntesDescuentos = valorBase;

        // Calcular Valor Final de Descuento 1
        double valorConDescuento = calcularDescuento(valorAntesDescuentos, horas, esEstudianteBoolean);

        // Calcular IVA (19%)
        double iva = valorConDescuento * 0.19;
        double valorTotalFactura = valorConDescuento + iva;

        // Factura
        System.out.println("\nFactura del parqueadero:");
        System.out.println("Tipo de vehículo estacionado: " + tipoMediodeTransporte);
        System.out.println("Horas de permanencia: " + horas);
        System.out.println("Valor total antes de descuentos: $" + valorAntesDescuentos);
        System.out.println("Valor total después de descuentos: $" + valorConDescuento);
        System.out.println("Valor total de la factura (incluyendo IVA 19%): $" + valorTotalFactura);

        usuario.close();
    }

    public static double calcularValorBase(char tipoMediodeTransporte, int horas) {
        try {
            double tarifaPorHora;
            switch (tipoMediodeTransporte) {
                case 'C':
                    tarifaPorHora = 5000;
                    break;
                case 'M':
                    tarifaPorHora = 3000;
                    break;
                case 'B':
                    tarifaPorHora = 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de vehículo no válido.");
                    
                    
            }

            double valorTotal;
            if (horas <= 3) {
                valorTotal = tarifaPorHora * horas;
            } else {
                valorTotal = (tarifaPorHora * 3) + ((horas - 3) * (tarifaPorHora + 2000));
            }

            return valorTotal;
        } catch (Exception e) {

            return -1;

        }
    }

    public static double calcularDescuento(double valorTotal, int horas, boolean esEstudiante){
        try {
            if (horas > 4) {
                valorTotal *= 0.3;  // Aplicar descuento del 30%
            }
            if (esEstudiante) {
                valorTotal *= 0.05;  // Aplicar descuento del 5%
            }
            return valorTotal;
            
        } catch (Exception e) {
        
        return -1;


        }
    }
}





