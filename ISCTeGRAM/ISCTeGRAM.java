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
        FilterNoise noiseFilter = new FilterNoise(intensity);
        noiseFilter.apply(_img);
        _history.add(_img);
    }
    
    public void contrast(int intensity)
    {
        FilterContrast contrastFilter = new FilterContrast(intensity);
        contrastFilter.apply(_img);
        _history.add(_img);
    }
    
    public void vignette(int thresholdDistance)
    {
        FilterVignette vignetteFilter = new FilterVignette(thresholdDistance);
        vignetteFilter.apply(_img);
        _history.add(_img);
    }
    
    public void sepia()
    {
        FilterSepia sepiaFilter = new FilterSepia();
        sepiaFilter.apply(_img);
        _history.add(_img);
    }
    
    public void blur(int radius)
    {
        FilterBlur blurFilter = new FilterBlur(radius);
        blurFilter.apply(_img);
        _history.add(_img);
    }
    
    public void film(ColorImage film, int factor)
    {
        FilterFilm filmFilter = new FilterFilm(film, factor);
        filmFilter.apply(_img);
        _history.add(_img);
    }
    
    public void film(ColorImage film)
    {
        FilterFilm filmFilter = new FilterFilm(film);
        filmFilter.apply(_img);
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