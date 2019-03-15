/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */
public class GreyNode implements QuadTreeNode {

    private QuadTreeNode [] children;

    public GreyNode(Reader input) throws IOException {
        children = new QuadTreeNode[4];
        
        for (int i = 0; i < 4; i++) {
            int v = input.read();
            if ( v == 48) {
                if (input.read() == 48) {
                    children[i] = new BlackLeaf();
                }
                else{
                    children[i] = new WhiteLeaf();
                }
            } else if (v != -1){
                children[i] = new GreyNode(input);
            }
        }
    }
    public GreyNode(int x, int y, int width, Bitmap bitmap) { 
        
        children = new QuadTreeNode[4];
        
        //child 1 is created.
        if (bitmap.isBlack(x, y, width/2))
            children[0] = new BlackLeaf();          
        else if (bitmap.isWhite (x, y, width/2))
            children[0] = new WhiteLeaf();    
        else 
            children[0] = new GreyNode(x,y, width/2,bitmap); 
        
        //child 2 is created.
        if (bitmap.isBlack(x+(width/2), y, width/2))
            children[1] = new BlackLeaf();   
        else if (bitmap.isWhite (x+(width/2), y , width/2))
            children[1] = new WhiteLeaf();
        else 
            children[1] = new GreyNode(x+(width/2), y, width/2,bitmap);
        
        //child 3 is created.
        if (bitmap.isBlack(x+(width/2), y+(width / 2), width/2))
            children[2] = new BlackLeaf();               
        else if (bitmap.isWhite (x+(width/2), y+(width / 2), width/2))
            children[2] = new WhiteLeaf();         
        else 
            children[2] = new GreyNode(x+(width/2), y+(width / 2), width/2,bitmap);        
          
        //child 4 is created.
        if (bitmap.isBlack(x, y+(width/2), width/2))
            children[3] = new BlackLeaf();        
        else if (bitmap.isWhite (x, y+(width/2), width/2))
            children[3] = new WhiteLeaf();          
        else 
            children[3] = new GreyNode(x, y+(width/2), width/2,bitmap);     
    }    
    
    @Override
    public void fillBitmap (int x, int y, int width, Bitmap bitmap) {
        
            children[0].fillBitmap( x, y, width/2, bitmap);
            children[1].fillBitmap( x, y +(width/2), width/2, bitmap);
            children[2].fillBitmap( x+(width/2), y+(width / 2), width / 2, bitmap);
            children[3].fillBitmap( x+(width/2), y, width / 2, bitmap);
        }

    @Override
    public void writeNode(Writer out) {
        try {
                out.append("1");
            } catch (IOException ex) {
                Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (QuadTreeNode c : children) {
                c.writeNode(out);
            }
        }
    }
