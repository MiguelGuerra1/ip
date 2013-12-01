import aguiaj.iscte.ColorImage;

class ISCTeGRAM {

    protected final ColorImage _img;

    ISCTeGRAM(ColorImage img)
    {
        _img = ImageUtil.copy(img);
    }
    
    public void noise(int intensity)
    {
        FilterNoise.factory(intensity).apply(_img);
    }
    
    public void contrast(int intensity)
    {
        FilterContrast.factory(intensity).apply(_img);
    }
    
    public void vignette(int thresholdDistance)
    {
        FilterVignette.factory(thresholdDistance).apply(_img);
    }
    
    public void sepia()
    {
        FilterSepia.factory().apply(_img);
    }
    
    public void blur(int radius)
    {
        FilterBlur.factory(radius).apply(_img);
    }
    
    public void film(ColorImage film, int factor)
    {
        FilterFilm.factory(film, factor).apply(_img);
    }
    
    public void film(ColorImage film)
    {
        FilterFilm.factory(film).apply(_img);
    }
    
    /*
    public int getLuminance(int x, int y)
    {
        return _img.getColor(x, y).getLuminance();
    }*/

}