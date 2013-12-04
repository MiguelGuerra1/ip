package isctegram.util;
import aguiaj.iscte.Color;

public class ColorUtil {

    public static int maxPrimary(Color c)
    {
        return Math.max(c.getR(), Math.max(c.getG(), c.getB()));
    }
    
    public static int minPrimary(Color c)
    {
        return Math.min(c.getR(), Math.min(c.getG(), c.getB()));
    }
    
    // Cor enclarecida com o mesmo tom
    // Usado em Noise
    public static Color lighterColorKeepHue(Color c, double intensity)
    {
        int grey = (int)((ImageUtil.RGB - ColorUtil.maxPrimary(c)) * intensity);
        
        return new Color(
                c.getR() + grey,
                c.getG() + grey,
                c.getB() + grey
            );
    }
    
    // Cor escurecida com o mesmo tom
    // Usado em Noise
    public static Color darkerColorKeepHue(Color c, double intensity)
    {
        int grey = (int)(ColorUtil.minPrimary(c) * intensity);
        
        return new Color(
                c.getR() - grey,
                c.getG() - grey,
                c.getB() - grey
            );
    }
    
    // cor enclarecida, altera o tom
    // Usado em Contrast
    public static Color lighterColor(Color c, double intensity)
    {
        return new Color(
                (int) Math.min(ImageUtil.RGB, c.getR() + c.getR() * intensity),
                (int) Math.min(ImageUtil.RGB, c.getG() + c.getG() * intensity),
                (int) Math.min(ImageUtil.RGB, c.getB() + c.getB() * intensity)
            );
    }
    
    // Cor escurecida, altera o tom
    // Usado em Contrast
    public static Color darkerColor(Color c, double intensity)
    {
        return new Color(
            (int) Math.max(0, c.getR() - c.getR() * intensity),
            (int) Math.max(0, c.getG() - c.getG() * intensity),
            (int) Math.max(0, c.getB() - c.getB() * intensity)
        );
    }


}