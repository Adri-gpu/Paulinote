package fichiersreu;

/**
 * @author M0riz
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.io.IOException;
import src.main.*;

public class SaveLogo {
    
    static String destinationFile = Main.PathApp+"\\Logo_IUT.png";
    static File img = new File(destinationFile);
    
    public static void main(String[] args) throws Exception {
        String imageUrl = "https://www.zupimages.net/up/21/11/m365.png";
        if(img.createNewFile()){
            System.out.println("L'image a été créé.");
            saveImage(imageUrl);
        }
        else{
            System.out.println("L'image existe déja.");
        }
    }

    public static void saveImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        FileOutputStream os = new FileOutputStream(destinationFile);
       
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        
        is.close();
        os.close();
    }
}