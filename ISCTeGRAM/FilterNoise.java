import java.util.Random;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

class FilterNoise implements IFilter {

    protected double _intensity;

    FilterNoise(int intensity)
    {
        setIntensity(intensity);
    }
    
    public void setIntensity(int intensity)
    {
        _intensity = intensity / 100.0;
    }
    
    public void apply(ColorImage img)
    {
        Random rm = new Random();
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (rm.nextBoolean()) {
                    Color crrntClr = img.getColor(i, j);
                    Color nwClr = rm.nextBoolean()
                        ? ColorUtil.lighterColorKeepHue(crrntClr, _intensity)
                        : ColorUtil.darkerColorKeepHue(crrntClr, _intensity);
                    
                    img.setColor(i, j, nwClr);
                }
    }

}