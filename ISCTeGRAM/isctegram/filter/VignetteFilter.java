package isctegram.filter;
import isctegram.util.ColorUtil;
import isctegram.util.ImageUtil;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class VignetteFilter implements IFilter {

    private int threshold;

    public VignetteFilter(int threshold)
    {
        setThreshold(threshold);
    }
    
    public void setThreshold(int threshold)
    {
        this.threshold = threshold;
    }
    
    public void apply(ColorImage img)
    {
        int imgCenter = ImageUtil.imageCenter(img);

        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++) {
                int dist = (int)ImageUtil.distanceFromCenter(img, i, j);
                
                if (dist <= threshold) {
                    continue;
                }
                
                Color currentColor = img.getColor(i, j);
                // Distância subtraída do limiar dá-nos um efeito aceitável
                double intensity = (dist - threshold) / (double)imgCenter;

                Color darkerColor = ColorUtil.darkerColor(
                        currentColor, intensity
                    );
                img.setColor(i, j, darkerColor);
            }
    }

}