class Algebra {
    // f
    static int[][] createIdentity(int n)
    {
        int[][] m = new int[n][n];
        
        for (int i = 0; i < n; i++)
            m[i][i] = 1;
        
        return m;
    }
    // g
    static void scalarMultiplication(int [][] m, int c)
    {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] *= c;
    }
    // h
    static void matrixAddition(int[][] m1, int[][] m2)
    {
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[i].length; j++)
                m1[i][j] += m2[i][j]; 
    }
    // i
    static boolean isIdentity(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                if (i != j && m[i][j] != 0)
                    return false;
                else if (m[i][i] != 1)
                    return false;
        
        return true;
    }
    // j
    static int[] column(int[][] m, int columnIndex)
    {
        int[] column = new int[m.length];
        
        for (int i = 0; i < m.length; i++)
            column[i] = m[columnIndex][i];
        
        return column;
    }
    // k
    static int[][] transposedMatrix(int[][] m)
    {
        int[][] transposed = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                transposed[j][i] = m[i][j];

        return transposed;
    }
    // l
    static boolean isSymmetric(int[][] m)
    {
        return Matrizes.equalMatrices(m, transposedMatrix(m));
    }
    // extra
    static int[][] matrixMultiplication(int[][] m1, int[][] m2)
    {
        int[][] multiple = new int[m1.length][m1.length];

        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[i].length; j++)
                multiple[i][j] = m1[i][j] * m2[i][j];

        return multiple;
    }

}