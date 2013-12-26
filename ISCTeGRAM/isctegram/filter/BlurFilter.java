package isctegram.filter;
import isctegram.util.ImageUtil;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class BlurFilter implements IFilter {

    private int radius;
    
    public BlurFilter(int radius)
    {
        setRadius(radius);
    }
    
    public void setRadius(int radius)
    {
        this.radius = radius <= 0 ? 1 : radius;
    }
    
    public void apply(ColorImage img)
    {
        ColorImage ci = new ColorImage(img.getWidth(), img.getHeight());
        
        for (int i = 0; i < ci.getWidth(); i++)
            for (int j = 0; j < ci.getHeight(); j++)
                ci.setColor(i, j, median(img, i, j));
        
        ImageUtil.copy(img, ci);
    }
    
    private Color median(ColorImage img, int x, int y)
    {
        int topX = Math.max(0, x - radius), // -1 -> 0
            topY = Math.max(0, y - radius), // -1 -> 0
            bottomX = Math.min(img.getWidth(), x + radius),
            bottomY = Math.min(img.getHeight(), y + radius),
            r, g, b,
            sum;

        r = g = b = sum = 0;
        
        for (int i = topX; i < bottomX; i++)
            for (int j = topY; j < bottomY; j++) {
                Color pColor = img.getColor(i, j);
                r += pColor.getR();
                g += pColor.getG();
                b += pColor.getB();
                sum++;
            }
        
        r /= sum;
        g /= sum;
        b /= sum;
        
        return new Color(r, g, b);
    }

}