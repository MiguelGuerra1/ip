import aguiaj.iscte.ColorImage;

class FilterFilm implements IFilter {

    protected ColorImage _film;
    protected int _factor = 1;
    
    FilterFilm(ColorImage film)
    {
        setFilm(film);
    }
    
    FilterFilm(ColorImage film, int factor)
    {
        setFilm(film);
        setFactor(factor);
    }
    
    public static FilterFilm factory(ColorImage film)
    {
        return new FilterFilm(film);
    }
    
    public static FilterFilm factory(ColorImage film, int factor)
    {
        return new FilterFilm(film, factor);
    }
    
    public void setFilm(ColorImage film)
    {
        _film = film;
    }
    
    public void setFactor(int factor)
    {
        _factor = factor;
    }
    
    public void apply(ColorImage img)
    {
        ColorImage film = getProcessedFilm();
        
        for (int i = 0; i < img.getHeight(); i += film.getHeight()) {
            ImageUtil.merge(img, film, 0, i);
            ImageUtil.merge(img, film, img.getWidth() - film.getWidth(), i);
        }
    }
    
    public ColorImage getProcessedFilm()
    {
        return (_factor > 1) ? ImageUtil.scale(_film, _factor) : _film;
    }

}

