package isctegram.filter.filmfilter;

import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;
import isctegram.util.ImageUtil;

public class DefaultFilm {
    
    public static final int SQUARE_WIDTH = 35;
    public static final int BORDER_WIDTH = 5;
    public static final Color COLOR = Color.BLACK;
    
    public static ColorImage factory(int squareWidth, int borderWidth, Color c)
    {
        ColorImage img = new ColorImage(squareWidth, squareWidth);
        
        // Border lateral
        ImageUtil.fillRectangle(img, c,
                0,                                  // x
                0,                                  // y
                borderWidth,                        // width
                squareWidth                         // height
            );
        ImageUtil.fillRectangle(img, c,
                squareWidth - borderWidth,          // x
                0,                                  // y
                borderWidth,                        // width
                squareWidth                         // height
            );
       
        // Border vertical
        ImageUtil.fillRectangle(img, c,
                borderWidth,                        // x
                0,                                  // y
                squareWidth - (borderWidth * 2),   // width
                borderWidth                         // height
            );
        ImageUtil.fillRectangle(img, c,
                borderWidth,                       // x
                squareWidth - borderWidth,         // y
                squareWidth - (borderWidth * 2),  // width
                borderWidth
            );
        
        ImageUtil.fillLeftieTriangle(img, c,
                borderWidth,                        // x
                borderWidth,                        // y
                borderWidth                         // width
            );
        
        return img;
    }
    
    public static ColorImage factory(int squareWidth, int borderWidth)
    {
        return factory(squareWidth, borderWidth, COLOR);
    }
    
    public static ColorImage factory()
    {
        return factory(SQUARE_WIDTH, BORDER_WIDTH, COLOR);
    }

}