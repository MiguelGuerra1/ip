package isctegram.effect;

import isctegram.filter.SepiaFilter;
import isctegram.filter.NoiseFilter;
import isctegram.filter.VignetteFilter;

public class OldEffect extends CompositeEffect {

    public OldEffect()
    {
        super(3);
        add(new SepiaFilter());
        add(new NoiseFilter(10));
        add(new VignetteFilter(10));
    }

}