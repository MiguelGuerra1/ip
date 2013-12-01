import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

class FilterContrast implements IFilter {

    public static final int CONTRAST_THRESHOLD = ImageUtil.RGB / 2;
    protected double _intensity;
    
    FilterContrast(int intensity)
    {
        setIntensity(intensity);
    }
    
    public static FilterContrast factory(int intensity)
    {
        return new FilterContrast(intensity);
    }
    
    protected void setIntensity(int intensity)
    {
        _intensity = intensity / 100.0;
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                img.setColor(i, j, contrastColor(img.getColor(i, j)));
    }
    
    protected Color contrastColor(Color c)
    {
        if (c.getLuminance() > CONTRAST_THRESHOLD)
            return ColorUtil.lighterColor(c, _intensity);
        
        return ColorUtil.darkerColor(c, _intensity);
    }

}