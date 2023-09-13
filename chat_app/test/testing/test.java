/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import com.pfa.swing.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author safae
 */
public class test {
    public static void main(String[] args){
        try{
            BufferedImage image = ImageIO.read(new File("C:\\Users\\safae\\OneDrive\\Bureau\\image\\test2.jpg"));
String blurhashStr = BlurHash.encode(image); 
System.out.println(blurhashStr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
