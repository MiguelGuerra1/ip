package isctegram.filter;
import isctegram.util.ColorUtil;

import java.util.Random;

import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class NoiseFilter implements IFilter {

    private double intensity;

    public NoiseFilter(int intensity)
    {
        setIntensity(intensity);
    }
    
    public void setIntensity(int intensity)
    {
        this.intensity = intensity / 100.0;
    }
    
    public void apply(ColorImage img)
    {
        Random rm = new Random();
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (rm.nextBoolean()) {
                    Color crrntClr = img.getColor(i, j);
                    Color nwClr = rm.nextBoolean()
                        ? ColorUtil.lighterColorKeepHue(crrntClr, intensity)
                        : ColorUtil.darkerColorKeepHue(crrntClr, intensity);
                    
                    img.setColor(i, j, nwClr);
                }
    }

}