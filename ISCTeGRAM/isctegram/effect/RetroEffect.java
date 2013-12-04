package isctegram.effect;

import isctegram.filter.ContrastFilter;
import isctegram.filter.BlurFilter;
import isctegram.filter.VignetteFilter;

public class RetroEffect extends CompositeEffect {

    public RetroEffect()
    {
        super(3);
        add(new ContrastFilter(5));
        add(new BlurFilter(1));
        add(new VignetteFilter(50));
    }

}