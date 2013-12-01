import aguiaj.iscte.BinaryImage;

class BinaryImageEffects {
    // Prévio
    static void invert(BinaryImage img)
    {
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (img.isBlack(i, j))
                    img.setWhite(i, j);
                else
                    img.setBlack(i, j);
    }
    
    // generic
    static int countPixels(BinaryImage img, boolean blackPixels)
    {
        int pixels = 0;
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (img.isBlack(i, j) == blackPixels)
                    pixels++;
                    
        return pixels;
    }
    
    static int countBlackPixels(BinaryImage img)
    {
        return countPixels(img, true);
    }
    
    static int countWhitePixels(BinaryImage img)
    {
        return countPixels(img, false);
    }
    
    static BinaryImage copy(BinaryImage img)
    {
        BinaryImage copy = new BinaryImage(img.getWidth(), img.getHeight());
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (img.isBlack(i, j))
                    copy.setBlack(i, j);
        
        return copy;
    }
    // /Prévio
    
    // Exercícios
    // a
    static void pixelBorder(BinaryImage img)
    {
        for (int i = 0; i < img.getWidth(); i++) {
            img.setBlack(i, 0); // Margem superior
            img.setBlack(i, img.getHeight() - 1); // Margem inferior
        }
        
        for (int i = 1; i < img.getHeight(); i++) {
            img.setBlack(0, i); // Margem esquerda
            img.setBlack(img.getWidth() - 1, i); // Margem direita
        }
    }
    // b
    // generic
    static void fillRectangle(BinaryImage img, int x, int y, int width,
        int height
    ) {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                img.setBlack(x + i, y + j);
    }
    
    static void fillSquare(BinaryImage img, int x, int y, int length)
    {
        fillRectangle(img, x, y, length, length);
    }
    // c
    static BinaryImage scale(BinaryImage img, int scale)
    {
        BinaryImage scaled = new BinaryImage(
	            img.getWidth() * scale,
	            img.getHeight() * scale
            );
        
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++)
                if (img.isBlack(i, j))
                    fillSquare(scaled, i * scale, j * scale, scale);
        
        return scaled;
    }
    // d
    static BinaryImage merge(BinaryImage img1, BinaryImage img2)
    {
        int width = img1.getWidth() > img2.getWidth()
	            ? img1.getWidth()
	            : img2.getWidth();
        int height = img1.getHeight() > img2.getHeight()
	            ? img1.getHeight()
	            : img2.getHeight();

        BinaryImage merge = new BinaryImage(width, height);
        
        for (int i = 0; i < img1.getWidth(); i++)
            for (int j = 0; j < img1.getHeight(); j++)
                if (img1.isBlack(i, j))
                    merge.setBlack(i, j);
        
        for (int i = 0; i < img2.getWidth(); i++)
            for (int j = 0; j < img2.getHeight(); j++)
                if (img2.isBlack(i, j))
                    merge.setBlack(i, j);
        
        return merge;
    }
    // e
    static BinaryImage createChessBoard(int posLength)
    {
        int linePositions = 8;
        BinaryImage chessBoard = new BinaryImage(
                linePositions * posLength + 2,
                linePositions * posLength + 2
            );
        
        for (int i = 1; i < linePositions - 1; i++) {
            for (int j = 1; j < linePositions - 1; j++)
                fillSquare(chessBoard, i * posLength - 1, j * posLength - 1, posLength);
        }
        
        pixelBorder(chessBoard);
        return chessBoard;
    }
    // /Exercícios

}