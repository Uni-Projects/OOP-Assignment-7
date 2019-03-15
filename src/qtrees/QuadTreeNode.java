package qtrees;

import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @version 11-03-2016
 */
public interface QuadTreeNode {

    public void fillBitmap(int x, int y, int width, Bitmap bitmap);

    public void writeNode(Writer out);
}
