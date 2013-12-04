package isctegram.effect;
import isctegram.filter.IFilter;
import aguiaj.iscte.ColorImage;

public class CompositeEffect implements IFilter {

    public static final int DEFAULT_LENGTH = 10;
    
    private final IFilter[] filterStack;
    
    public CompositeEffect()
    {
        filterStack = new IFilter[DEFAULT_LENGTH];
    }
    
    public CompositeEffect(int filterCount)
    {
        filterStack = new IFilter[filterCount];
    }
    
    public void add(IFilter filter)
    {
        for (int i = 0; i < filterStack.length; i++)
            if (filterStack[i] == null) {
                filterStack[i] = filter;
                return;
            }
    }
    
    public void apply(ColorImage img)
    {
        for (int i = 0; i < filterStack.length; i++) {
        
            if (filterStack[i] == null)
                return;
        
            filterStack[i].apply(img);
        
        }
    }
}