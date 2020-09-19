/******************************************************************************
 * Compilation: javac KernelFilter.java 
 * Execution: java KernelFilter baboon.png 
 * 
 *
 * applies various kernel filters to images, such as Gaussian blur, sharpen, Laplacian, emboss, and motion blur. 
 * A kernel filter modifies the pixels in an image by replacing each pixel with a linear combination of its neighboring pixels. 
 *To apply a kernel filter to a color image, perform the above operation to the red, green, and blue components of each pixel p separately, and combine the results.
 ******************************************************************************/
import java.awt.Color;

public class KernelFilter {
    private static int format(double v) {
        if (v < 0)
            return 0;
        if (v > 255)
            return 255;
        return (int) Math.round(v);
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given
    // picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture target = new Picture(picture);

        for (int tcol = 0; tcol < picture.width(); tcol++) {
            for (int trow = 0; trow < picture.height(); trow++) {
                double sumR = 0;
                double sumG = 0;
                double sumB = 0;
                int wLen = weights.length;
                int center = wLen / 2;

                for (int i = 0; i < wLen; i++) {
                    for (int j = 0; j < wLen; j++) {
                        double coefficient = weights[i][j];

                        // Periodic pixels & their colors.
                        int scol = Math.floorMod(tcol - center + i, picture.width());
                        int srow = Math.floorMod(trow - center + j, picture.height());

                        Color color = picture.get(scol, srow);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        sumR += r * coefficient;
                        sumG += g * coefficient;
                        sumB += b * coefficient;
                    }
                }

                Color c = new Color(format(sumR), format(sumG), format(sumB));
                target.set(tcol, trow, c);
            }
        }
        return target;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = { { 1 / 16.0, 2 / 16.0, 1 / 16.0 }, { 2 / 16.0, 4 / 16.0, 2 / 16.0 },
                { 1 / 16.0, 2 / 16.0, 1 / 16.0 }, };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = { { 0.0, -1.0, 0.0 }, { -1.0, 5.0, -1.0 }, { 0.0, -1.0, 0.0 }, };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = { { -1.0, -1.0, -1.0 }, { -1.0, 8.0, -1.0 }, { -1.0, -1.0, -1.0 }, };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = { { -2.0, -1.0, 0.0 }, { -1.0, 1.0, 1.0 }, { 0.0, 1.0, 2.0 }, };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = { { 1 / 9.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 1 / 9.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 1 / 9.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 1 / 9.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 1 / 9.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 1 / 9.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1 / 9.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1 / 9.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1 / 9.0 }, };
        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture source = new Picture(filename);
        Picture g = gaussian(source);
        Picture s = sharpen(source);
        Picture i = identity(source);
        Picture lp = laplacian(source);
        Picture e = emboss(source);
        Picture m = motionBlur(source);

        s.show();
        i.show();
        g.show();
        lp.show();
        e.show();
        m.show();

    }

}