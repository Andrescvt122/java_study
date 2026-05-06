import java.util.Scanner;
import java.util.ArrayList;
public static class Suministro{
    //atributos encapsulados
    private String nombre;
    private int cantidad;
    //getters
    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    //setters
    public void setNombre(String nombre){
       if(nombre == null || nombre.trim().isEmpty()){
           System.out.println("El nombre no puede estar vacio");
           return;
       }
       this.nombre = nombre;
    }
    public void setCantidad(int cantidad){
        if(cantidad <= 0 ){
            System.out.println("Cantidad no pueded ser igual a 0 o negativa");
            return;
        }
      this.cantidad = cantidad;
    };
    //comportamiento
    public void consumir(int cantidad){
        if(cantidad <= 0 ){
            System.out.println("Cantidad no pueded ser igual a 0 o negativa");
            return;
        }
        if(cantidad > this.cantidad){
            System.out.println("La cantidad no puede ser mayor a la cantidad actual del suminisstro");
            return;
        }
        this.cantidad -= cantidad;
    }
}
public static void practica1(){
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
    char rangoMilitar = sc.next().charAt(0);
    System.out.println("Ingrese su estado de alerta True/False");
    boolean estadoAlerta = sc.nextBoolean();
    boolean peligro = oxigenoDisponible <= 30 && estadoAlerta;
    System.out.printf("RESUMEN DE SU REGISTRo %n id de la cabina %s %n los dias que llevas en mision %d %n distancia recorrida en kms %d %n oxigeno disponible %.2f %n rango milifar %c estado de alerta %b %n MISION EN PELIGRO: %b %n FINAL DEL RESUMEN", Integer.toBinaryString(idCabina), diasEnMision, distanciaRecorrida, oxigenoDisponible, rangoMilitar, estadoAlerta, peligro);
}

public static void practica2(){
    //Ingresa variables fijas
    //Se inicia intensidad desde afuera del switch para poderlo usar en cualquier lugar de la funcion paracticas2();
    double intensidad;
    final double oxigeno = 90.982;
    final double combustible = 80.928;
    final double distancia = 182723123.92834;
    //inicia Scanner desde java.util.scanner;
    Scanner sc = new Scanner(System.in);
    //Ciclo para ingresar la intensidad
    do {
        intensidad=0.0;
        try {
            IO.println("Para comenzar con el control, primero ingresa la intensidad");
            intensidad = sc.nextDouble();
            if(Double.compare(intensidad, 0.0) <0){
                IO.println("La intensidad no puede ser negativa");
            }
            if (intensidad == 0.0 ) {
                IO.println("La intensidad no puede ser 0 o vacia, favor de diligence correctamente");
            }
        }catch(InputMismatchException e){
            IO.println("Ingresar un dato umero valido");
            sc.nextLine();
        }
    }while (intensidad == 0 || Double.compare(intensidad, 0.0)<0);
    //Nombramiento del ciclo del swtich
    cicloSwitch:
    do{
        System.out.printf("Indica la accion que quieres realizar %n 1.Acelerar %n 2.Rotar %n 3. Estado %n 4. Terminar registro");
        String accion = sc.nextLine().toLowerCase();
        //Swtich de las acciones
       switch (accion){
           //Caso 1. acelerar
           case "acelerar":
               do {
                   try {
                       IO.println("Ingresa el valor de la aceleracion");
                       int aceleracion = sc.nextInt();
                       //Validacion si aceleracion es mayor a 80
                       IO.println(aceleracion >= 80 ? "Combustion  maxima" : "Acelerando gradualmente");
                       break;
                       //control de error si se ingresa un dato no compatible en el sc.nextInt;
                   }catch (InputMismatchException e){
                       IO.println("El valor ingresado tiene que ser un entero, ejem: 10, 40 sin decimales, favor de ingresar nuevamente correctamente");
                   }
                   }while(true);
               break;
               //Caso 2. rotar
           case "rotar":
               do{
                   try{
                       IO.println("Ingresa el angulo de rotacion, sea un numero entero o decimal");
                       double angulo = sc.nextDouble();
                       //Validacion si es una rotacion estandar (90, 180) o personalizada
                       IO.println(angulo == 90 || angulo == 180 ? "Rotacion estandar establecida" : "Rotacion personalizada establecida");
                       break;
                       //control de error de valor ingresado no compatible
                   }catch(InputMismatchException e){
                       IO.println("El valor ingresado no corresponde a un entero o decimal, favor de ingresar el angulo con un valor decimal o un valor entero, ejem 10, 90, 80.3");
                   }
               }while(true);
               break;
           //Caso 3. Estado
           case "Estado":
               //resumen del estado con maximo 2 decimales
               System.out.printf("RESUMEN RAPIDO %n Oxigeno disponible: %.2f %n Combustible disponible: %.2f",oxigeno,combustible);
               break;
           //Caso 4. terminar
           case "terminar":
               //Informe sobre el estado del combustible
               if(combustible == 0 && combustible <= 20){
                   IO.println("Combustible critico a terminal");
               }else if (combustible >= 21 && combustible <= 50 ){
                   IO.println("Combustible moderado");
               }else if(combustible >= 51){
                   IO.println("Combustible optimo");
               }
               //Tiempo restante de dias
               System.out.printf("TIEMPO RESTANTE DEL VIAJE EN DIAS: %.3f dias", distancia/intensidad);
               //Ciierre del ciclo do-while principal
               break cicloSwitch;
           default:
               //Control
               System.out.printf("Ingresar una accion valida: %n 1. Acelerar %n 2. Rotar %n 3. Estado %n 4. Terminar");
       }
    }while(true);
}

public static void gestionSuministros(){
    Scanner sc = new Scanner(System.in);
    Suministro[] suministros = new Suministro[3];
    suministros[0] = new Suministro();
    suministros[0].setNombre("Comida");
    suministros[0].setCantidad(90);
    suministros[1] = new Suministro();
    suministros[1].setNombre("Agua");
    suministros[1].setCantidad(180);
    suministros[2] = new Suministro();
    suministros[2].setNombre("Medicos");
    suministros[2].setCantidad(50);
    int acc = 0;
    Runnable resumenMision = () ->{
        StringBuilder sb = new StringBuilder();
        for(Suministro s : suministros){
            sb.append("Nombre: " + s.getNombre());
            sb.append("\n Cantidad: " + s.getCantidad());
        }
        sb.append("\n Cantidad total: " + acc);
        System.out.println(sb.toString());
    };
    buclePrincipal:
    do{
        System.out.printf("SELECCIONE LAS OPCIONES QUE REQUIERES REALIZAR: %n 1. Ver inventario 2. Consumi 3. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1:
                System.out.println("Inventario actual:");
                resumenMision.run();
                break;
            case 2:
                bucleOpcion2:
                do{
                    try{
                    System.out.println("Ingrese la cantidad que quiere consumir");
                    int cantidadConsumir = sc.nextInt();
                    sc.nextLine();
                    if(cantidadConsumir <= 0){
                        System.out.println("La cantidad tiene que ser positiva");
                        continue;
                    }
                    bucleConsumir:
                    do{
                        try{
                            System.out.println("Ingrese el suministro que desea consumir, ingresa el id (identificador) (numero)");
                            for (int i=0; i < suministros.length; i ++){
                                System.out.printf("id: %d, %n nombre: %s, %n cantidad: %d", i ++, suministros[i].getNombre(), suministros[i].getCantidad());
                            }
                            int suministroAComsumir = sc.nextInt();
                            sc.nextLine();
                            suministros[suministroAComsumir].consumir(cantidadConsumir);
                            break bucleConsumir;
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Favor, ingresar un suminstro existente mediante su identificador");
                        }
                    }while(true);
                    break bucleOpcion2;
                }catch(InputMismatchException e){
                    System.out.println("La cantidad tiene que ser un entero (1,2,3.....");
                }
                }while(true);
            case 3:
               System.out.println("Resumen de la mision: ");
               resumenMision.run();

                break buclePrincipal;
            default:
                System.out.println("Ingresar una opcion valida");
        }
    }while(true);
}


void main() {
//    practica1();
//    practica2();
    gestionSuministros();

};