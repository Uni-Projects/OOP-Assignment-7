package qtrees;

/**
 * Bitmap: A class for representing bitmap;
 *
 * @author Sjaak Smetsers
 * @version 15-03-2016
 */
public class Bitmap {

    // each bit is stored into an two dimensional array
    private final boolean[][] raster;
    private final int bmWidth, bmHeight;

    /**
     * Creates an empty bitmap of size width * height
     *
     * @param width
     * @param height
     */
    public Bitmap(int width, int height) {
        raster = new boolean[width][height];
        bmWidth = width;
        bmHeight = height;
    }

    /**
     * Gets a bit at the specified position
     *
     * @param x: x coordinate
     * @param y: y coordinate
     * @return value at coordinates(x,y)
     */
    public boolean getBit(int x, int y) {
        return raster[x][y];
    }

    /**
     * Sets a bit at the specified position
     *
     * @param x: x coordinate
     * @param y: y coordinate
     * @param val: the bit value
     */
    public void setBit(int x, int y, boolean val) {
        raster[x][y] = val;
    }

    /**
     * Converts a bitmap into a string 1 is represented by '*'; 0 by 'O'
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < bmHeight; y++) {
            for (int x = 0; x < bmWidth; x++) {
                sb.append(raster[y][x] ? '*' : 'O');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * @return the width of the bitmap
     */
    public int getWidth() {
        return bmWidth;
    }

    /**
     * @param x starting coordinate x.
     * @param y starting coordinate y.
     * @param width the width of the part of bitmap to check.
     * @return true if every bit is black, false otherwise.
    */
    public boolean isBlack(int x, int y, int width) {
        for (int c = x; c < x + width; c++) {
            for (int r = y; r < y + width; r++) {
                if (raster[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * @param x starting coordinate x.
     * @param y starting coordinate y.
     * @param width the width of the part of bitmap to check.
     * @return true if every bit is white, false otherwise.
    */
    public boolean isWhite(int x, int y, int width) {
        for (int c = x; c < x + width; c++) {
            for (int r = y; r < y + width; r++) {
                if (!raster[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the height of the bitmap
     */
    public int getHeight() {
        return bmHeight;
    }

    /**
     * Fills a square area of a bitmap with value val
     *
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val: the bit value
     */
    public void fillArea(int x, int y, int size, boolean val) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setBit(x + i, y + j, val);
            }
        }
    }
}
