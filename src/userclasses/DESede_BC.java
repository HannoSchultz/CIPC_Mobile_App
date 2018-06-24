/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.ui.Display;
import com.codename1.ui.html.HTMLUtils;
import com.codename1.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 *
 * @author Blessing
 */
public class DESede_BC {

    PaddedBufferedBlockCipher encryptCipher;
    PaddedBufferedBlockCipher decryptCipher;

    // Buffers used to transport the bytes from one stream to another
    byte[] buf = new byte[8];       //input buffer - block size length
    byte[] obuf = new byte[512];    //output buffer

    byte[] key = null;              //the key

    public DESede_BC() {
        //use a default 192 bit key
        String sb = "";
        try {
            //InputStream in = FileSystemStorage.getInstance().openInputStream(FileSystemStorage.getInstance().getAppHomePath() + "/Security.bin");
           
            InputStream in = Display.getInstance().getResourceAsStream(getClass(), "/Security.bin");
            
            key = Util.readInputStream(in);
            
            //String byteStr = new String(key);
            //Log.p("bytestr ="+byteStr, Log.DEBUG);
            
        } catch (IOException ioe) {
            Log.e(ioe);
        }
        
                
        
        //key = "SECRET_1SECRET_2SECRET_3".getBytes();
        //key = "7fc56270e7a70fa81a5935b72".getBytes() ;
        InitCiphers();
    }

    public DESede_BC(byte[] keyBytes) {
        key = new byte[keyBytes.length];
        System.arraycopy(keyBytes, 0, key, 0, keyBytes.length);
        InitCiphers();
    }

    private void InitCiphers() {
        encryptCipher = new PaddedBufferedBlockCipher(new DESedeEngine());
        encryptCipher.init(true, new KeyParameter(key));
        decryptCipher = new PaddedBufferedBlockCipher(new DESedeEngine());
        decryptCipher.init(false, new KeyParameter(key));
    }

    public void ResetCiphers() {
        if (encryptCipher != null) {
            encryptCipher.reset();
        }
        if (decryptCipher != null) {
            decryptCipher.reset();
        }
    }

    public String encrypt(InputStream in, OutputStream out) throws InvalidCipherTextException {
        String encryptedValue = "";
        try {
            // Bytes written to out will be encrypted
            // Read in the cleartext bytes from in InputStream and
            //      write them encrypted to out OutputStream

            int noBytesRead = 0;        //number of bytes read from input
            int noBytesProcessed = 0;   //number of bytes processed

            while ((noBytesRead = in.read(buf)) >= 0) {
                noBytesProcessed
                        = encryptCipher.processBytes(buf, 0, noBytesRead, obuf, 0);
                out.write(obuf, 0, noBytesProcessed);
            }
            noBytesProcessed
                    = encryptCipher.doFinal(obuf, 0);
            
            byte []newByteArray = new byte[noBytesProcessed];
            
             for(int i=0;i<noBytesProcessed; i++) {
                newByteArray[i] = obuf[i];
            }

            String stringOut = Base64.encode(newByteArray);
            String htmlEncoded = HTMLUtils.encodeString(stringOut);
            
            Log.p("output="+stringOut+", htmlEncoded=" + htmlEncoded, Log.DEBUG);
     
            encryptedValue = htmlEncoded;
            
            out.write(obuf, 0, noBytesProcessed);

            out.flush();
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
        
        return encryptedValue;
    }

    public void decrypt(InputStream in, long length, OutputStream out) throws InvalidCipherTextException {
        try {
            // Bytes read from in will be decrypted
            // Read in the decrypted bytes from in InputStream and and
            //      write them in cleartext to out OutputStream

            int noBytesRead = 0;        //number of bytes read from input
            int noBytesProcessed = 0;   //number of bytes processed

            while ((noBytesRead = in.read(buf)) >= 0) {
                noBytesProcessed = decryptCipher.processBytes(buf, 0, noBytesRead, obuf, 0);
                out.write(obuf, 0, noBytesProcessed);
            }
            noBytesProcessed = decryptCipher.doFinal(obuf, 0);
            out.write(obuf, 0, noBytesProcessed);

            out.flush();
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
