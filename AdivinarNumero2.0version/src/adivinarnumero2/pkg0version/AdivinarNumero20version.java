/*
Demo tipo juego, que permita generar un número aleatorio y le rete al usuario que lo adivine. Si no 
adivina el número, el juego debe sugerirle lo intente nuevamente con pistas (es mayor, menor, es par, 
impar, es primo, pertenece a la serie de fibonacy, es multiplo de N, etc.), el usuario es quien deberá 
ir pidiendo repetitivamente que el sistema le muestre o no, más pistas, solo que, si el usuario pide 
más pistas, el sistema automáticamente le resta un intento y le informa cuantos intentos le quedan. 
Al finalizar el juego, se debe felicitar al usuario si gana y como, o pedir que lo intente de nuevo.
 */
package adivinarnumero2.pkg0version;
/**
 * @author Ricardo Espinosa y Juan Diego Camargo
 */
import java.util.Scanner;
public class AdivinarNumero20version {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int numAdivinar = (int) (Math.random() * 100) + 1;
        int intentos = 5, vueltas = 1, numIngresado;
        boolean adivino = false, esPrimo = true;
        String pista = null, seguir = null;
        System.out.println("***ADIVINA EL NUMERO QUE PIENSO (0 - 100)***");
        System.out.println("TIENES 20 INTENTOS");
        do{
            while (intentos >= 0){
                System.out.println("Ingresa el numero que creas que estoy pensando");
                numIngresado = tc.nextInt();
                if (numIngresado == numAdivinar){
                    adivino = true;
                    break; //Si adivino se modifica la variable booleana y sale del ciclo
                } else if (intentos == 0)
                    break; //Si no adivino y es el ultimo intento sale del ciclo para que no se muestre lo demas
                System.out.println("Incorrecto, quieres pistas? (si/no)");
                System.out.println("!!RECUERDA QUE SI PIDES UNA PISTA SE TE RESTA UN INTENTO!!");
                pista = tc.next();
                if (pista.equals("si")){
                    System.out.println("UN INTENTO MENOS :O");
                    intentos--; //Se le quita un intento por pedir las pistas
                }
                
                //Se valida la pista de si el numero es mayor o menor
                if ((numAdivinar < numIngresado) && (pista.equals("si"))){
                    System.out.println("EL NUMERO ES MENOR AL QUE INGRESASTE");
                } else if ((numAdivinar > numIngresado) && (pista.equals("si"))){
                    System.out.println("EL NUMERO ES MAYOR AL QUE INGRESASTE");
                }
                
                //Se valida la pista de si el numero es par o impar
                if ((numAdivinar % 2 == 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES PAR");
                else if ((numAdivinar % 2 != 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES IMPAR");
                
                //Se valida la pista de si el numero es o no primo
                if (numAdivinar == 1)            
                    esPrimo = false;
                for (int i = 2; i < numAdivinar; i++) {
                    if ((numAdivinar % i) == 0){
                        esPrimo = false;
                    }
                }
                if (esPrimo && (pista.equals("si")))
                    System.out.println("EL NUMERO ES PRIMO");
                else if ((esPrimo == false) && (pista.equals("si")))
                    System.out.println("EL NUMERO NO ES PRIMO");
                
                //Se valida la pista de si el numero pertenece o no a la serie de Fibonacci
                if ((esNumeroDeFibonacci(numAdivinar)) && (pista.equals("si"))) //Se invoca la funcion al final de codigo
                System.out.println("EL NUMERO PERTENECE A LA SERIE DE FIBONACCI");
                else if ((esNumeroDeFibonacci(numAdivinar) == false) && (pista.equals("si"))) 
                System.out.println("EL NUMERO NO PERTENECE A LA SERIE DE FIBONACCI");
                
                //Se valida la pista de si el numero es multiplo de 3,5,7,11,12;
                if (numAdivinar % 3 == 0 && pista.equals("si"))
                    System.out.println("EL NUMERO ES MULTIPLO DE 3"); 
                else if ((numAdivinar % 5 == 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES MULTIPLO DE 5");
                else if ((numAdivinar % 7 == 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES MULTIPLO DE 7");
                else if ((numAdivinar % 11 == 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES MULTIPLO DE 11");
                else if ((numAdivinar % 12 == 0) && (pista.equals("si")))
                    System.out.println("EL NUMERO ES MULTIPLO DE 12");
                    
                //Se notifica cuantos intentos quedan y se modifican los contadores
                System.out.println("Te quedan: " + intentos + " intentos");
                intentos--;
                vueltas++;
            }
            //Se notifica al usuario en caso de ganar o perder
            if (adivino)
                System.out.println("FELICIDADES lo lograste en " + vueltas + " intentos");
            else{
                System.out.println("!!!!! GAME OVER !!!!!");
                System.out.println("EL NUMERO ERA " + numAdivinar + " :(");
            }
            //Se le pregunta si desea volver a jugar
            System.out.println("**********************************");
            System.out.println("Quieres volver a jugar? :) (si/no)");
            seguir = tc.next();
        } while (seguir.equals("si"));
        System.out.println("GRACIAS, VUELVE PRONTO!");
    }
    public static boolean esNumeroDeFibonacci(int numero) {
        if (numero < 0) {
            return false; //Los numeros negativos no son de la serie de Fibonacci
        }
        int a = 0;
        int b = 1;
        while (a < numero) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a == numero;
    }
}