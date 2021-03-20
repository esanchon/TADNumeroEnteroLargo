/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadnumeroenterolargo;

/**
 *
 * @author Eloy
 */
public class sumaArrays {
    


    public static int[] sumOfTwoArrays(int[] arr1, int[] arr2){

        int na = arr1.length;
        int nb = arr2.length;
        int nc;
        int min;

        if(na > nb){
            nc = na + 1;
            min = nb;
        }else{
            nc = nb + 1;
            min = na;
        }

        int[] c = new int[nc];
        int sum = 0;
        int carry = 0;
        int i = na - 1;
        int j = nb - 1;
        int k = nc - 1;

        while(i >= 0 && j>=0){
            sum  = arr1[i] + arr2[j] + carry;
            i--;
            j--;
            c[k] = sum % 10;
            sum = sum / 10;
            carry = sum % 10;
            k--;        
        }//end of while loop

        while(i >= 0){          //n2 has exhausted
            sum  = arr1[i] + carry;
            c[k] = sum % 10;
            sum = sum / 10;
            carry = sum % 10;
            i--;
            k--;
        }

        while(j >= 0){        //n1 has exhausted  
            sum  = arr2[j] + carry;
            c[k] = sum % 10;
            sum = sum / 10;
            carry = sum % 10;
            k--;        
            j--;
        }

        c[k] = carry;

        return c;
    }
}
    
