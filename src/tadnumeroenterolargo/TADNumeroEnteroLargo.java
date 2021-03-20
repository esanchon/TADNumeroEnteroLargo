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
        NumeroEnteroLargo numero1 = new NumeroEnteroLargo("10");
        System.out.println("numero1: " + numero1);

        NumeroEnteroLargo numero2 = new NumeroEnteroLargo("11");
        System.out.println("numero2: " + numero2);

        //Sumamos los 2 NumeroEnteroLargo
        NumeroEnteroLargo resultadoSuma = numero1.suma(numero2);
        System.out.println("Resultado numero1 + numero2: " + resultadoSuma);

        //Restamos los 2 NumeroEnteroLargo
        try {
            NumeroEnteroLargo resultadoResta = numero1.resta(numero2);
            System.out.println(resultadoResta);
        } catch (Exception ex) {
            Logger.getLogger(TADNumeroEnteroLargo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

}
