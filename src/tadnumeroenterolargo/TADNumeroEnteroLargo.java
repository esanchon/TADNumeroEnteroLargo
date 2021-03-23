/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadnumeroenterolargo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eloy
 */
public class TADNumeroEnteroLargo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creamos 2 NumeroEnteroLargo
        NumeroEnteroLargo numero1 = new NumeroEnteroLargo("100");
        System.out.println("numero1: " + numero1);

        NumeroEnteroLargo numero2 = new NumeroEnteroLargo("9");
        System.out.println("numero2: " + numero2);

        boolean igual = numero1.esIgual(numero2);
        boolean mayor = numero1.esMayor(numero2);

        System.out.println("¿son iguales numero1 y numero2?: " + igual);
        System.out.println("¿es mayor numero1 que numero2?: " + mayor);


        //Sumamos los 2 NumeroEnteroLargo
        NumeroEnteroLargo resultadoSuma = numero1.suma(numero2);
        System.out.println("numero1 + numero2: " + resultadoSuma);

        
        //Restamos los 2 NumeroEnteroLargo
        try {
            NumeroEnteroLargo resultadoResta = numero1.resta(numero2);
            System.out.println("numero1 - numero2: " + resultadoResta);
        } catch (Exception ex) {
            Logger.getLogger(TADNumeroEnteroLargo.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //Multiplicamos los 2 NumeroEnteroLargo
        NumeroEnteroLargo resultadoMult = numero1.multiplica(numero2);
        System.out.println("numero1 * numero2: " + resultadoMult);

    }

}
