import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

class FilterVignette implements IFilter {

    protected static final int MAGIC_FACTOR = 3;
    protected int _threshold;

    FilterVignette(int threshold)
    {
        setThreshold(threshold);
    }
    
    public static FilterVignette factory(int threshold)
    {
        return new FilterVignette(threshold);
    }
    
    public void setThreshold(int threshold)
    {
        _threshold = threshold;
    }
    
    public void apply(ColorImage img)
    {
        int imgCenter = ImageUtil.imageCenter(img);

        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++) {
                int dist = ImageUtil.distanceFromCenter(img, i, j);
                if (dist > _threshold) {
                    Color darkerColor = ColorUtil.darkerColor(
	                        img.getColor(i, j),
	                        (dist / (double) imgCenter) / MAGIC_FACTOR
                        );
                    img.setColor(i, j, darkerColor);
                }
            }
    }

}