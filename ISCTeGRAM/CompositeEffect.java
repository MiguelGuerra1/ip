import aguiaj.iscte.ColorImage;

class CompositeEffect implements IFilter {

    public static final int DEFAULT_LENGTH = 10;
    
    public static final CompositeEffect OLD;
    public static final CompositeEffect RETRO;
    
    static {
        OLD = new CompositeEffect(3);
        OLD.add(new FilterSepia());
        OLD.add(new FilterNoise(10));
        OLD.add(new FilterVignette(10));
        
        RETRO = new CompositeEffect(3);
        RETRO.add(new FilterContrast(10));
        RETRO.add(new FilterBlur(2));
        RETRO.add(new FilterVignette(20));
    }
    
    protected final IFilter[] _filterStack;
    
    CompositeEffect()
    {
        _filterStack = new IFilter[DEFAULT_LENGTH];
    }
    
    CompositeEffect(int filterCount)
    {
        _filterStack = new IFilter[filterCount];
    }
    
    public void add(IFilter filter)
    {
        for (int i = 0; i < _filterStack.length; i++)
            if (_filterStack[i] == null) {
                _filterStack[i] = filter;
                return;
            }
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < _filterStack.length; i++) {
        
            if (_filterStack[i] == null)
                return;
        
            _filterStack[i].apply(img);
        
        }
    }
}