import java.util.Scanner;
void main(){
    void practica1 {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Vamos a gestionar los datos basicos: " +
                "Ingresa el id de la cabina");
        byte idCabina = sc.nextByte();
        sc.nextLine();
        System.out.println("Ingresa el numero de dias que llevas en mision: ");
        int diasEnMision = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa la distancia recorrida en kms");
        long distanciaRecorrida = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingresa el valor actual del oxigeno que tienes");
        double oxigenoDisponible = sc.nextFloat();
        sc.nextLine();
        System.out.println("ingrese el rango militar");
        char rangoMilitar = 'A';
        System.out.println("Ingrese su estado de alerta True/False");
        boolean estadoAlerta = sc.nextBoolean();
        System.out.println("RESUMEN DE SUS");
        sb.append("Id de la cabina ").append(idCabina).append(" Dias en mision ").append(diasEnMision).append(" Distancia recorrida ").append(distanciaRecorrida).append(" Oxigeno disponible ").append(oxigenoDisponible).append(" Rango militar ").append(rangoMilitar).append(" Estado de alerta ").append(estadoAlerta);
        String resumen = sb.toString();
        System.out.println("RESUMEN DEL REGISTRO:" + System.lineSeparator() + resumen);
    }
    void practica2{
        
    }
}
