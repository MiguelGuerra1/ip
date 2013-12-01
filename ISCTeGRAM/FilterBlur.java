import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

class FilterBlur implements IFilter {

    protected int _radius;
    
    FilterBlur(int radius)
    {
        setRadius(radius);
    }
    
    public void setRadius(int radius)
    {
        _radius = radius <= 0 ? 1 : radius;
    }
    
    public void apply(ColorImage img)
    {
        ColorImage ci = new ColorImage(img.getWidth(), img.getHeight());
        
        for (int i = 0; i < ci.getWidth(); i++)
            for (int j = 0; j < ci.getHeight(); j++)
                ci.setColor(i, j, median(img, i, j));
        
        ImageUtil.copy(img, ci);
    }
    
    protected Color median(ColorImage img, int x, int y)
    {
        int topX = Math.max(0, x - _radius); // -1 -> 0
        int topY = Math.max(0, y - _radius); // -1 -> 0

        int bottomX = Math.min(img.getWidth(), x + _radius);
        int bottomY = Math.min(img.getHeight(), y + _radius);
        
        int r, g, b;
        r = g = b = 0;
        int sum = 0;
        
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