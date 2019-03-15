/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */
public class WhiteLeaf implements QuadTreeNode {

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x, y, width, true);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.append("01");
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(BlackLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
