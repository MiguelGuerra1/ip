import aguiaj.iscte.ColorImage;

class CompositeEffect implements IFilter {

    public static final int NOISE       = 0;
    public static final int CONTRAST    = 1;
    public static final int VIGNETTE    = 2;
    public static final int SEPIA       = 3;
    public static final int BLUR        = 4;
    
    public static final CompositeEffect OLD;
    public static final CompositeEffect RETRO;
    
    static {
        OLD = new CompositeEffect();
        OLD.add(SEPIA);
        OLD.add(NOISE, 10);
        OLD.add(VIGNETTE, 10);
        
        RETRO = new CompositeEffect();
        RETRO.add(CONTRAST, 10);
        RETRO.add(BLUR, 2);
        RETRO.add(VIGNETTE, 20);
    }
    
    protected SingleEffect[] _filterStack = new SingleEffect[10];
    
    public void add(int filter, int param)
    {
        for (int i = 0; i < _filterStack.length; i++)
            if (_filterStack[i] == null) {
                _filterStack[i] = new SingleEffect(filter, param);
                return;
            }
    }
    
    public void add(int filter)
    {
        add(filter, 0);
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < _filterStack.length; i++) {
        
            if (_filterStack[i] == null)
                return;
        
            
            fetchFilter(_filterStack[i].getFilter(), _filterStack[i].getParam())
                .apply(img);
        
        }
    }
    
    protected IFilter fetchFilter(int filter, int param)
    {
        switch (filter) {
            
            case CONTRAST:
                return new FilterContrast(param);
            
            case VIGNETTE:
                return new FilterVignette(param);
            
            case SEPIA:
                return new FilterSepia();
            
            case BLUR:
                return new FilterBlur(param);
        
            case NOISE:
                return new FilterNoise(param);
            
            default:
                return new FilterNoise(0);
        }
    }
}

class SingleEffect {

    protected int _filter;
    protected int _param;
    
    SingleEffect(int filter, int param)
    {
        setFilter(filter);
        setParam(param);
    }
    
    public void setFilter(int filter)
    {
        _filter = filter;
    }
    
    public int getFilter()
    {
        return _filter;
    }
    
    public void setParam(int param)
    {
        _param = param;
    }
    
    public int getParam()
    {
        return _param;
    }

}