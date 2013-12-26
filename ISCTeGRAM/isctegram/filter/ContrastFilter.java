package isctegram.filter;
import isctegram.util.ColorUtil;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class ContrastFilter implements IFilter {

    public static final int CONTRAST_THRESHOLD = 128; // RGB (255) / 2
    private double intensity;
    
    public ContrastFilter(int intensity)
    {
        setIntensity(intensity);
    }
    
    private void setIntensity(int intensity)
    {
        this.intensity = intensity / 100.0;
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                img.setColor(i, j, contrastColor(img.getColor(i, j)));
    }
    
    private Color contrastColor(Color c)
    {
        if (c.getLuminance() > CONTRAST_THRESHOLD)
            return ColorUtil.lighterColor(c, intensity);
        
        return ColorUtil.darkerColor(c, intensity);
    }

}