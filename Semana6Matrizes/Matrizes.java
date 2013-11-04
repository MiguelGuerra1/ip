class Matrizes {

    // Prévio
    static int[][] createRandomMatrix(int lines, int columns)
    {
        int randomTop = 10;
        int[][] matrix = new int[lines][columns];
        
        for (int i = 0; i < lines; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = (int) (Math.random() * randomTop);
        
        return matrix;
    }
    
    static int[][] squaredMatrix(int length)
    {
        return createRandomMatrix(length, length);
    }
    
    static int matrixSum(int[][] m)
    {
        int sum = 0;
    
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                sum += m[i][j];
        
        return sum;
    }
    
    static int matrixCount(int[][] m)
    {
        int sum = 0;
        
        for (int i = 0; i < m.length; i++)
            sum += m[i].length;
        
        return sum;
    }
    // /Prévio
    
    // Exercícios
    // a
    static int[] unroll(int[][] m)
    {
        int[] v = new int[matrixCount(m)];
        int x = 0;
        
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++, x++)
                v[x] += m[i][j];
        
        return v;
    }
    // b
    static int[][] createMatrix(int[] v, int lines, int columns)
    {
        int[][] m = new int[lines][columns];
        int x = 0;
        
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length && x < v.length; j++, x++)
                m[i][j] = v[x];
                
        return m;
    }
    // c
    static boolean algebraicMatrix(int[][] m)
    {
        for (int i = 1; i < m.length; i++)
            if (m[i].length != m[i - 1].length)
                return false;

        return true;
    }
    // d
    static boolean algebraicSquaredMatrix(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
            if (m[i].length != m.length)
                return false;
        
        return true;
    }
    // e
    static boolean equalMatrices(int[][] m, int[][] n)
    {
        if (matrixCount(m) != matrixCount(n))
            return false;
        
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m.length; j++)
                if (m[i][j] != n[i][j])
                    return false;
        
        return true;
    }
}