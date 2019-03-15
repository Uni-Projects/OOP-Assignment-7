package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */
public class QTree {

    QuadTreeNode root;

    public QTree(Reader input) throws IOException {
        root = readQTree(input);
    }

    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }

    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }

    private static QuadTreeNode readQTree(Reader input) throws IOException {

        if (input.read() == 48) {
            if (input.read() == 48) {
                return new BlackLeaf();
            } else {
                return new WhiteLeaf();
            }
        } else {
            return new GreyNode(input);
        }
    }

    public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        return new GreyNode(x, y, width, bitmap);
    }

}
