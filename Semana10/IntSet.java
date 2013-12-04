


public class IntSet {

    public static int INITIAL_SIZE = 5;

    private int[] vector;
    private int next;
    
    public IntSet()
    {
        vector = new int[INITIAL_SIZE];
    }
    
    public int getVectorSize()
    {
        return vector.length;
    }
    
    public int getCardinality()
    {
        return next;
    }
    
    public boolean isEmpty()
    {
        return next == 0;            
    }
    
    public boolean isFull()
    {
        return next == vector.length;
    }
    
    public boolean exists(int nail)
    {
        if (nail == 0)
            return false;

        for (int i = 0; i < vector.length; i++)
            if (nail == vector[i])
                return true;
        
        return false;
    }
    
    public int[] getElements()
    {
        return vector;
    }
    
    public int getIndex(int i)
    {
        return vector[i];
    }
    
    public int getLength()
    {
        return vector.length;
    }
    
    public void add(int n)
    {
        if (n == 0 || exists(n))
            return;
        
        if (next == vector.length)
            doubleSize();
        
        vector[next] = n;
        next++;
    }
    
    public void rem(int n)
    {
        if (n == 0)
            return;

        for (int i = 0; i < vector.length; i++)
            if (n == vector[i]) {
                vector[i] = 0;
                packVector();
                next--;
            }
    }
    
    private void doubleSize()
    {
        int[] doubleVector = new int[vector.length + INITIAL_SIZE];
        for (int i = 0; i < vector.length; i++) {
            doubleVector[i] = vector[i];
        }
        vector = doubleVector;
    }
    
    public IntSet union(IntSet set)
    {
        IntSet union = new IntSet();
        int[] setElements = set.getElements();
        
        for (int i = 0; i < vector.length; i++)
            union.add(vector[i]);
        
        for (int i = 0; i < setElements.length; i++)
            union.add(setElements[i]);
        
        return union;
    }
    
    public IntSet intersect(IntSet set)
    {
        if (isEmpty() || set.isEmpty())
            return new IntSet();
        
        IntSet intersect = new IntSet();
        IntSet largest, smallest;
        
        if (getLength() > set.getLength()) {
            largest = this;
            smallest = set;
        } else {
            largest = set;
            smallest = this;
        }
        
        for (int i = 0; i < smallest.getLength(); i++) {
            if (largest.exists(smallest.getIndex(i)))
                intersect.add(smallest.getIndex(i));
        }
        
        return intersect;
            
    }
    
    private void packVector()
    {
        int emptyIndex = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != 0)
                emptyIndex = i;
            else if (vector[i] == 0) {
                vector[emptyIndex] = vector[i];
                vector[i] = 0;
                emptyIndex = i;
            }
        }
    }

}