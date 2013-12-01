import aguiaj.iscte.ColorImage;

class ImageHistory {

    public static final int DEFAULT_LENGTH = 10;

    protected final ColorImage[] _history;
    
    protected int _pointer = -1;

    ImageHistory(ColorImage img)
    {
        _history = new ColorImage[DEFAULT_LENGTH];
        push(img);
    }

    ImageHistory(ColorImage img, int length)
    {
        _history = new ColorImage[length];
        push(img);
    }
    
    public void add(ColorImage img)
    {
        if (lastPosition())
            return;

        push(img);
        
        // remover resto do histórico para novos eventos
        for (int i = _pointer + 1; i < _history.length; i++) {
            if (_history[i] == null)
                return;
            
            _history[i] = null;
        }
    }
    
    protected void push(ColorImage img)
    {
        _pointer++;
        _history[_pointer] = ImageUtil.copy(img);
    }
    
    public ColorImage undo()
    {
        _pointer--;
        return _history[_pointer];
    }
    
    public ColorImage redo()
    {
        _pointer++;
        return _history[_pointer];
    }
    
    public boolean canRedo()
    {
        return ! lastPosition() && _history[_pointer + 1] != null;
    }
    
    public boolean canUndo()
    {
        return ! firstPosition() && _history[_pointer - 1] != null;
    }
    
    public boolean firstPosition()
    {
        return _pointer == 0;
    }
    
    public boolean lastPosition()
    {
        return _pointer == _history.length - 1;
    }
}