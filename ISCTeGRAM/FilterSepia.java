import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

class FilterSepia implements IFilter {

    protected final SepiaFactor _r;
    protected final SepiaFactor _g;
    protected final SepiaFactor _b;

    FilterSepia(SepiaFactor r, SepiaFactor g, SepiaFactor b)
    {
        _r = r;
        _g = g;
        _b = b;
    }
    
    FilterSepia()
    {
        _r = new SepiaFactor(.4, .77, .2);
        _g = new SepiaFactor(.35, .69, .17);
        _b = new SepiaFactor(.27, .53, .13);
    }
    
    public static FilterSepia factory()
    {
        return new FilterSepia();
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                img.setColor(i, j, factorize(img.getColor(i, j)));
    }
    
    protected Color factorize(Color c)
    {
        return new Color(
                _r.factorize(c),
                _g.factorize(c),
                _b.factorize(c)
            );
    }

}

class SepiaFactor {

    protected final double _r;
    protected final double _g;
    protected final double _b;
    
    SepiaFactor(double r, double g, double b)
    {
        _r = r;
        _g = g;
        _b = b;
    }
    
    public int factorize(Color c)
    {
        return Math.min(ImageUtil.RGB, (int)((c.getR() * _r) + (c.getG() * _g) + (c.getB() * _b)));
    }

}