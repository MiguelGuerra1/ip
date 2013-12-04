package isctegram;
import isctegram.effect.OldEffect;
import isctegram.effect.RetroEffect;
import isctegram.filter.BlurFilter;
import isctegram.filter.ContrastFilter;
import isctegram.filter.FilmFilter;
import isctegram.filter.filmfilter.DefaultFilm;
import isctegram.filter.NoiseFilter;
import isctegram.filter.SepiaFilter;
import isctegram.filter.VignetteFilter;
import isctegram.ui.ImageHistory;
import isctegram.util.ImageUtil;
import aguiaj.iscte.Color;
import aguiaj.iscte.ColorImage;

public class ISCTeGRAM {

    private final ColorImage img;
    private final ImageHistory history;

    public ISCTeGRAM(ColorImage img)
    {
        this.img = ImageUtil.copy(img);
        this.history = new ImageHistory(this.img);
    }
    
    public void fNoise(int intensity)
    {
        NoiseFilter noiseFilter = new NoiseFilter(intensity);
        noiseFilter.apply(img);
        history.add(img);
    }
    
    public void fContrast(int intensity)
    {
        ContrastFilter contrastFilter = new ContrastFilter(intensity);
        contrastFilter.apply(img);
        history.add(img);
    }
    
    public void fVignette(int thresholdDistance)
    {
        VignetteFilter vignetteFilter = new VignetteFilter(thresholdDistance);
        vignetteFilter.apply(img);
        history.add(img);
    }
    
    public void fSepia()
    {
        SepiaFilter sepiaFilter = new SepiaFilter();
        sepiaFilter.apply(img);
        history.add(img);
    }
    
    public void fBlur(int radius)
    {
        BlurFilter blurFilter = new BlurFilter(radius);
        blurFilter.apply(img);
        history.add(img);
    }
    
    public void fFilm(ColorImage film, int factor)
    {
        ColorImage scaledFilm = ImageUtil.scale(film, factor);
        FilmFilter filmFilter = new FilmFilter(scaledFilm);
        filmFilter.apply(img);
        history.add(img);
    }
    
    public void fFilm(ColorImage film)
    {
        FilmFilter filmFilter = new FilmFilter(film);
        filmFilter.apply(img);
        history.add(img);
    }
    
    public void fFilm()
    {
        fFilm(DefaultFilm.factory());
    }
    
    public void fFilm(int squareWidth, int borderWidth)
    {
        fFilm(DefaultFilm.factory(squareWidth, borderWidth));
    }
    
    public void fFilm(int squareWidth, int borderWidth, Color c)
    {
        fFilm(DefaultFilm.factory(squareWidth, borderWidth, c));
    }
    
    public void effectOld()
    {
        OldEffect oldEffect = new OldEffect();
        oldEffect.apply(img);
        history.add(img);
    }
    
    public void effectRetro()
    {
        RetroEffect retroEffect = new RetroEffect();
        retroEffect.apply(img);
        history.add(img);
    }
    
    public void historyUndo()
    {
        if (history.canUndo())
            ImageUtil.copy(img, history.undo());
    }
    
    public void historyRedo()
    {
        if (history.canRedo())
            ImageUtil.copy(img, history.redo());
    }
    
    public ColorImage getImg()
    {
        return img;
    }
    
    public ImageHistory getHistory()
    {
        return history;
    }

}