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
public class NumeroEnteroLargo {

    String numeroEnteroLargo;
    int[] arrayNum;
    int largo;

    public NumeroEnteroLargo(String numeroEnteroLargo) {
        this.numeroEnteroLargo = numeroEnteroLargo;
        this.largo = numeroEnteroLargo.length();
        this.arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = numeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);
        }
    }

    public NumeroEnteroLargo() {
        this("0");
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < this.largo; i++) {
            aux += arrayNum[i];
        }
        return aux;
    }

    public int getLargo() {
        return largo;
    }

    public void cambiarValor(String nuevoNumeroEnteroLargo) {
        this.numeroEnteroLargo = nuevoNumeroEnteroLargo;
        this.largo = nuevoNumeroEnteroLargo.length();
        this.arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = numeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);

        }
    }

    public void cambiarValor(int nuevoValor) {
        this.numeroEnteroLargo = Integer.toString(nuevoValor);
        this.largo = numeroEnteroLargo.length();
        this.arrayNum = new int[largo];

        for (int i = 0; i < arrayNum.length; i++) {
            String cadaNumero = numeroEnteroLargo.substring(i, i + 1);
            arrayNum[i] = Integer.parseInt(cadaNumero);

        }
    }

    public Boolean esMayor(NumeroEnteroLargo otro) {
        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();

        if (largo1 > largo2) {
            return true;
        } else if (largo2 > largo1) {
            return false;
        } else {
            for (int i = 0; i < largo1; i++) {
                if (this.arrayNum[i] > otro.arrayNum[i]) {
                    return true;
                } else if (this.arrayNum[i] < otro.arrayNum[i]) {
                    return false;
                }
            }
        }
        return false;
    }

    public Boolean esIgual(NumeroEnteroLargo otro) {
        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();
        Boolean esIgual = false;

        if (largo1 != largo2) {
            return false;
        } else {
            for (int i = 0; i < largo1; i++) {
                if (this.arrayNum[i] != otro.arrayNum[i]) {
                    return false;
                } else {
                    esIgual = true;
                }
            }
        }
        return esIgual;
    }

    public NumeroEnteroLargo suma(NumeroEnteroLargo otro) {
        NumeroEnteroLargo resultadoSuma = new NumeroEnteroLargo();

        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();
        int largoSuma;

        if (largo1 > largo2) {
            largoSuma = largo1 + 1;
        } else {
            largoSuma = largo2 + 1;
        }

        resultadoSuma.largo = largoSuma;
        resultadoSuma.arrayNum = new int[largoSuma];

        int suma = 0;
        int llevo = 0;
        int i = largo1 - 1;
        int j = largo2 - 1;
        int k = largoSuma - 1;

        while (i >= 0 && j >= 0) {
            suma = this.arrayNum[i] + otro.arrayNum[j] + llevo;
            i--;
            j--;
            resultadoSuma.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            k--;
        }

        while (i >= 0) {            //si numero1 es mayor que numero2
            suma = this.arrayNum[i] + llevo;
            resultadoSuma.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            i--;
            k--;

        }
        while (j >= 0) {            //si numero2 es mayor que numero1
            suma = otro.arrayNum[j] + llevo;
            resultadoSuma.arrayNum[k] = suma % 10;
            suma = suma / 10;
            llevo = suma % 10;
            j--;
            k--;

        }

        resultadoSuma.arrayNum[k] = llevo;

        resultadoSuma = quitarCeros(resultadoSuma);

        return resultadoSuma;

    }

    public NumeroEnteroLargo resta(NumeroEnteroLargo otro) throws Exception {
        NumeroEnteroLargo resultadoResta = new NumeroEnteroLargo();

        int largo1 = this.getLargo();
        int largo2 = otro.getLargo();
        int largoResta = largo1;

        if (otro.esMayor(this)) {
            throw new NumeroNegativoException("No es posible restar, resultado numero negativo");
        }

        resultadoResta.largo = largoResta;
        resultadoResta.arrayNum = new int[largoResta];

        //restamos los valores numero a número según la posición en el array
        int resta = 0;
        int llevoUna = 0;
        int i = largo1 - 1;
        int j = largo2 - 1;
        int k = largoResta - 1;

        while (i >= 0 && j >= 0) {
            if (this.arrayNum[i] >= otro.arrayNum[j] + llevoUna) {
                resta = this.arrayNum[i] - otro.arrayNum[j] - llevoUna;
                llevoUna = 0;
                i--;
                j--;
                resultadoResta.arrayNum[k] = resta;
                k--;
            } else {
                resta = this.arrayNum[i] + 10 - otro.arrayNum[j] - llevoUna;
                llevoUna = 1;
                i--;
                j--;
                resultadoResta.arrayNum[k] = resta;
                k--;
            }
        }

        while (i >= 0) {            //si numero1 es mayor que numero2
            if (this.arrayNum[i] >= llevoUna) {
                resta = this.arrayNum[i] - llevoUna;
                resultadoResta.arrayNum[k] = resta;
                llevoUna = 0;
                i--;
                k--;
            } else {
                resta = this.arrayNum[i] + 10 - llevoUna;
                resultadoResta.arrayNum[k] = resta;
                llevoUna = 1;
                i--;
                k--;
            }
        }

        resultadoResta = quitarCeros(resultadoResta);

        return resultadoResta;

    }

    public NumeroEnteroLargo multiplica(NumeroEnteroLargo otro) {

        NumeroEnteroLargo resultadoMult = new NumeroEnteroLargo();
        NumeroEnteroLargo faltaPorSumar = otro;
        NumeroEnteroLargo uno = new NumeroEnteroLargo("1");
        NumeroEnteroLargo cero = new NumeroEnteroLargo("0");

            while (faltaPorSumar.esMayor(cero)) {
                
                resultadoMult = resultadoMult.suma(this);

            try {
                faltaPorSumar = faltaPorSumar.resta(uno);
            } catch (Exception ex) {
                Logger.getLogger(NumeroEnteroLargo.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
       
        return resultadoMult;
    }

    private NumeroEnteroLargo quitarCeros(NumeroEnteroLargo resultado) {
        if (resultado.arrayNum.length > 0 & resultado.arrayNum[0] == 0) {
            NumeroEnteroLargo resultadoSinCero = new NumeroEnteroLargo();
            resultadoSinCero.arrayNum = new int[resultado.arrayNum.length - 1];

            for (int i = 0; i < resultadoSinCero.arrayNum.length; i++) {
                resultadoSinCero.arrayNum[i] = resultado.arrayNum[i + 1];
            }
            resultado = resultadoSinCero;
            resultado.largo = resultadoSinCero.arrayNum.length;

        }
        return resultado;
    }
}
