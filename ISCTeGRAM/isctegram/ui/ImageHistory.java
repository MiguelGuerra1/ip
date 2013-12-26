package isctegram.ui;
import isctegram.util.ImageUtil;
import aguiaj.iscte.ColorImage;

public class ImageHistory {

    public static final int DEFAULT_LENGTH = 10;

    private final ColorImage[] history;
    
    private int pointer = -1;

    public ImageHistory(ColorImage img)
    {
        history = new ColorImage[DEFAULT_LENGTH];
        push(img);
    }

    public ImageHistory(ColorImage img, int length)
    {
        history = new ColorImage[length];
        push(img);
    }
    
    public void add(ColorImage img)
    {
        if (lastPosition())
            return;

        push(img);
        
        // remover resto do histórico para novos eventos
        for (int i = pointer + 1; i < history.length; i++) {
            if (history[i] == null)
                return;
            
            history[i] = null;
        }
    }
    
    private void push(ColorImage img)
    {
        pointer++;
        history[pointer] = ImageUtil.copy(img);
    }
    
    public ColorImage undo()
    {
        pointer--;
        return history[pointer];
    }
    
    public ColorImage redo()
    {
        pointer++;
        return history[pointer];
    }
    
    public boolean canRedo()
    {
        return ! lastPosition() && history[pointer + 1] != null;
    }
    
    public boolean canUndo()
    {
        return ! firstPosition() && history[pointer - 1] != null;
    }
    
    public boolean firstPosition()
    {
        return pointer == 0;
    }
    
    public boolean lastPosition()
    {
        return pointer == (history.length - 1);
    }
    
    public ColorImage[] getHistory()
    {
        return history;
    }
}