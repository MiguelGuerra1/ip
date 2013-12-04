package isctegram.filter.sepiafilter;

import aguiaj.iscte.Color;
import isctegram.util.ImageUtil;

public class SepiaFactor {

    private final double r;
    private final double g;
    private final double b;
    
    public SepiaFactor(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public int factorize(Color c)
    {
        return Math.min(ImageUtil.RGB, (int)((c.getR() * r) + (c.getG() * g) + (c.getB() * b)));
    }

}