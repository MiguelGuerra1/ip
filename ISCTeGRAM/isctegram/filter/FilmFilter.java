package isctegram.filter;
import isctegram.util.ImageUtil;
import aguiaj.iscte.ColorImage;

public class FilmFilter implements IFilter {

    private ColorImage film;
    
    public FilmFilter(ColorImage film)
    {
        setFilm(film);
    }
    
    public void setFilm(ColorImage film)
    {
        this.film = film;
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < img.getHeight(); i += film.getHeight()) {
            ImageUtil.merge(img, film, 0, i);
            ImageUtil.merge(img, film, img.getWidth() - film.getWidth(), i);
        }
    }

}

