class Procedimentos {

    // Prévio
    static char[] create(char c, int n)
    {
        char[] charSeq = new char[n];

        while (n > 0) {
            n--;
            charSeq[n] = c;
        }

        return charSeq;
    }

    static void fill(char c, char[] v)
    {
        for (int i = 0; i < v.length; i++) {
            v[i] = c;
        }
    }

    static void replace(char needle, char replace, char[] v)
    {
        for (int i = 0; i < v.length; i++) {
            if (needle == v[i])
                v[i] = replace;
        }
    }
    // /Prévio

    // Exercícios
    // a
    static char[] sequence(char c, int length)
    {
        char[] sequence = new char[length];

        while (length > 0) {
            length--;
            sequence[length] = (char)((int) c + length);
        }

        return sequence;
    }
    // b
    static void replaceFirstOccurrence(char needle, char replace, char[] v)
    {
        for (int i = 0; i < v.length; i++) {
            if (needle == v[i]) {
                v[i] = replace;
                return;
            }
        }
    }
    // c
    static void replaceLastOccurrence(char needle, char replace, char[] v)
    {
        for (int i = v.length - 1; i >= 0; i--) {
            if (needle == v[i]) {
                v[i] = replace;
                return;
            }
        }
    }
    // d
    static void shiftLeft(char[] v)
    {
        char first = v[0];

        for (int i = 0; i < v.length - 1; i++)
            v[i] = v[i + 1];
            
        v[v.length - 1] = first;
    }
    // e
    static void shiftRight(char[] v)
    {
        char last = v[v.length - 1];
        
        for (int i = v.length - 1; i > 0; i--)
            v[i] = v[i - 1];
        
        v[0] = last;
    }
    // f
    static void swap(int i, int j, char[] v)
    {
        char c = v[i];
        v[i] = v[j];
        v[j] = c;
    }
    // g
    static void invert(char[] v)
    {
        for (int i = 0; i < v.length / 2; i++)
            swap(i, v.length - i - 1, v);
    }
    // h (Algoritmo de Baralhação)
    static int randomIndex(int index)
    {
        return (int) (Math.random() * (index + 1));
    }

    static void fisherYates(char[] v)
    {
        for (int i = v.length - 1; i > 1; i--) {
            swap(i, randomIndex(i), v);
        }
    }
    // /h
    // i (Algoritmo de ordenação)
    // https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif
     static void bubbleSort(char[] v)
     {
        for (int i = v.length - 1; i > 0; i--) {

            boolean swapped = false;

            for (int j = 1; j <= i; j++) {
                if (v[j - 1] > v[j]) {
                    swap(j, j - 1, v);
                    swapped = true;
                }
            }
            // Se não houve trocas
            // excusamos percorrer o resto
            if ( ! swapped)
                return;
        }
    }
    // /i
    // /Exercícios

    // Extra
    // A.a
    static char[] concat(char[] v, char c)
    {
        char[] concat = new char[v.length + 1];

        for (int i = 0; i < v.length; i++) {
            concat[i] = v[i];
        }

        concat[v.length] = c;
        return concat;
    }
    // A.b
    static char[] concat(char c, char[] v)
    {
        char[] concat = new char[v.length + 1];

        concat[0] = c;

        for (int i = 0; i < v.length; i++) {
            concat[i + 1] = v[i];
        }

        return concat;
    }
    // B
    static void replaceRandom(char c, char[] v)
    {
        v[randomIndex(v.length - 1)] = c;
    }
    // C
    static void swapHalfs(char[] v)
    {
        int half = v.length / 2;
        int remainder = v.length % 2; // 0 ou 1
        
        for (int i = 0; i < half; i++)
            swap(i, half + remainder + i, v);
    }
    // / Extra
}