package qtrees;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */
public class Qtrees {

    public static void main(String[] args) throws IOException {

        String test_tekst = "10011010001010010001010101100011000101000000";

        StringReader input = new StringReader(test_tekst);

        QTree qt = new QTree(input);                                            //from serialization to qtree
        Writer sb = new PrintWriter(System.out);
        qt.writeQTree(sb);                                                      //from qtree to serialization
        System.out.println("\n");
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap(bitmap);                                                  //from qtree to bitmap
        System.out.println(bitmap);

        Writer sb2 = new PrintWriter(System.out);
        QTree qt2 = new QTree(bitmap);                                          //from bitmap to qtree
        qt2.writeQTree(sb2);                                                    //from qtree to serialization
        System.out.println();

    }

}
