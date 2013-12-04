package isctegram.util;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class ImageUtil {

    public static final int RGB = 255;
    
    public static ColorImage copy(ColorImage img)
    {
        ColorImage copy = new ColorImage(img.getWidth(), img.getHeight());
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                copy.setColor(i, j, img.getColor(i, j));
        
        return copy;
    }
    
    public static void copy(ColorImage target, ColorImage orig)
    {
        for (int i = 0; i < orig.getWidth(); i++)
            for (int j = 0; j < orig.getHeight(); j++)
                target.setColor(i, j, orig.getColor(i, j));
    }
    
    // Aproveito este momento para agradecer a Pitágoras
    public static double distanceFromCenter(ColorImage img, int x, int y)
    {
        double distX = Math.pow((img.getWidth() / 2) - x, 2);
        double distY = Math.pow((img.getHeight() / 2) - y, 2);
        return Math.sqrt(distX + distY);
    }
    
    public static int imageCenter(ColorImage img)
    {
        return (img.getWidth() / 2) + (img.getHeight() / 2);
    }
    
    public static ColorImage scale(ColorImage img, int factor)
    {
        ColorImage s = new ColorImage(
	            img.getWidth() * factor,
	            img.getHeight() * factor
            );
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                fillSquare(s, img.getColor(i, j), i * factor, j * factor, factor);
        
        return s;
    }
    
    public static void fillRectangle(ColorImage img, Color c, int x, int y,
        int width, int height
    ) {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                img.setColor(x + i, y + j, c);
    }
    
    public static void fillSquare(ColorImage img, Color c, int x, int y,
        int length
    ) {
        fillRectangle(img, c, x, y, length, length);
    }
    
    public static void fillLeftieTriangle(ColorImage img, Color c, int x, int y,
        int width)
    {
        for (int i = 0; i < width; i++) {
            fillRectangle(img, c, x, y + i, width - i, 1);
        }
    }
    
    public static void merge(ColorImage orig, ColorImage ovw, int x, int y)
    {
        for (int i = 0; i < ovw.getWidth(); i++)
            for (int j = 0; j < ovw.getHeight(); j++) {
                if ((x + i) >= orig.getWidth() || (y + j) >= orig.getHeight())
                    continue;
                
                orig.setColor(x + i, y + j, ovw.getColor(i, j));
            }
    }

}