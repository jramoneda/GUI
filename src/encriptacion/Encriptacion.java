/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author tarda
 */
public class Encriptacion {

    /**
     * @param args the command line arguments
     */
public static SecretKey keygenKeyGeneration(int keySize) {

    SecretKey sKey = null;

    if ((keySize == 128)||(keySize == 192)||(keySize == 256)) {

        try {

            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(keySize);

            sKey = kgen.generateKey();


        } catch (NoSuchAlgorithmException ex) {

            System.err.println("Generador no disponible.");

        }

    }

    return sKey;

}


public static byte[] encryptData(SecretKey sKey, byte[] data) {

    byte[] encryptedData = null;

    try {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, sKey);

        encryptedData =  cipher.doFinal(data);

    } catch (Exception  ex) {

        System.err.println("Error xifrant les dades: " + ex);

    }

    return encryptedData;

} 
    
public static byte[] dencryptData(SecretKey sKey, byte[] data) {

    byte[] dencryptedData = null;

    try {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, sKey);

        dencryptedData =  cipher.doFinal(data);

    } catch (Exception  ex) {

        System.err.println("Error xifrant les dades: " + ex);

    }

    return dencryptedData;

} 
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       
       byte[] cadena = null;
       byte[] cadenaEncriptada = null;
       byte[] cadenaDencriptada = null;
       String cadena2="Hola, bona tarda!, com estas? qqoepoepoepoepooepoepoepoepoepoe";
       
       SecretKey key=null;
       
        cadena=cadena2.getBytes();
        key=keygenKeyGeneration(128);
        cadenaEncriptada=encryptData(key,cadena);
        System.out.println(cadena2);
        cadena2=cadenaEncriptada.toString();
        System.out.println(cadena2);
        cadenaDencriptada=dencryptData(key,cadenaEncriptada);
        String misstageDencriptat = new String(cadenaDencriptada);
        System.out.println(misstageDencriptat);
        
    }
    
}
