package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types) {
        if (ImageTypes.BMP == types) {
            return new BmpReader();
        }
        else if (ImageTypes.JPG == types) {
            return new JpgReader();
        }
        else if (ImageTypes.PNG == types) {
            return new PngReader();
        }

        throw new IllegalArgumentException("Неизвестный тип картинки.");
    }
}
