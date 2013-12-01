import aguiaj.iscte.ColorImage;

class ISCTeGRAM {

    protected final ColorImage _img;
    protected final ImageHistory _history;

    ISCTeGRAM(ColorImage img)
    {
        _img = ImageUtil.copy(img);
        _history = new ImageHistory(_img);
    }
    
    public void noise(int intensity)
    {
        FilterNoise.factory(intensity).apply(_img);
        _history.add(_img);
    }
    
    public void contrast(int intensity)
    {
        FilterContrast.factory(intensity).apply(_img);
        _history.add(_img);
    }
    
    public void vignette(int thresholdDistance)
    {
        FilterVignette.factory(thresholdDistance).apply(_img);
        _history.add(_img);
    }
    
    public void sepia()
    {
        FilterSepia.factory().apply(_img);
        _history.add(_img);
    }
    
    public void blur(int radius)
    {
        FilterBlur.factory(radius).apply(_img);
        _history.add(_img);
    }
    
    public void film(ColorImage film, int factor)
    {
        FilterFilm.factory(film, factor).apply(_img);
        _history.add(_img);
    }
    
    public void film(ColorImage film)
    {
        FilterFilm.factory(film).apply(_img);
        _history.add(_img);
    }
    
    public void old()
    {
        CompositeEffect.OLD.apply(_img);
        _history.add(_img);
    }
    
    public void retro()
    {
        CompositeEffect.RETRO.apply(_img);
        _history.add(_img);
    }
    
    public void undo()
    {
        if (_history.canUndo())
            ImageUtil.copy(_img, _history.undo());
    }
    
    public void redo()
    {
        if (_history.canRedo())
            ImageUtil.copy(_img, _history.redo());
    }

}