package isctegram.filter;
import isctegram.filter.sepiafilter.SepiaFactor;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class SepiaFilter implements IFilter {

    private final SepiaFactor r;
    private final SepiaFactor g;
    private final SepiaFactor b;

    public SepiaFilter(SepiaFactor r, SepiaFactor g, SepiaFactor b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public SepiaFilter()
    {
        this.r = new SepiaFactor(.4, .77, .2);
        this.g = new SepiaFactor(.35, .69, .17);
        this.b = new SepiaFactor(.27, .53, .13);
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                img.setColor(i, j, factorize(img.getColor(i, j)));
    }
    
    private Color factorize(Color c)
    {
        return new Color(
                r.factorize(c),
                g.factorize(c),
                b.factorize(c)
            );
    }

}