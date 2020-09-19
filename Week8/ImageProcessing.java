import java.awt.Color;

public class ImageProcessing {
    public static void flipVertically(Picture pic) {
        int height = pic.height();
        int width = pic.width();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                Color c1 = pic.get(x, y);
                Color c2 = pic.get(width - x - 1, y);
                pic.set(x, y, c2);
                pic.set(width - x - 1, y, c1);
            }
        }
        pic.show();
    }

    public static void flipHorizontally(Picture pic) {
        int height = pic.height();
        int width = pic.width();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height / 2; y++) {
                Color c1 = pic.get(x, y);
                Color c2 = pic.get(x, height - y - 1);
                pic.set(x, y, c2);
                pic.set(x, height - y - 1, c1);
            }
        }
        pic.show();
    }

    public static void colorSeparation(Picture pic) {
        int height = pic.height();
        int width = pic.width();
        // Create 3 empty pictures of same dimensions
        Picture picR = new Picture(width, height);
        Picture picG = new Picture(width, height);
        Picture picB = new Picture(width, height);
        // separate colors
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = pic.get(x, y);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                picR.set(x, y, new Color(r, 0, 0));
                picG.set(x, y, new Color(0, g, 0));
                picB.set(x, y, new Color(0, 0, b));
            }
        }
        // display each picture in its own window
        picR.show();
        picG.show();
        picB.show();
    }

    public static void tilePicture(Picture input, int m, int n) {
        int height = input.height();
        int width = input.width();
        Picture output = new Picture(n * input.width(), m * input.height());
        // convert to black and white
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = input.get(col, row);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        output.set(width * j + col, height * i + row, color);
                    }
                }
            }
        }
        output.show();
    }

    public static void rotatePicture(Picture input, double theta) {
        int width = input.width();
        int height = input.height();
        int centerX = width / 2;
        int centerY = height / 2;
        Picture output = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int xx = (int) ((col - centerX) * Math.cos(theta) - (row - centerY) * Math.sin(theta) + centerX);
                int yy = (int) ((col - centerX) * Math.sin(theta) + (row - centerY) * Math.cos(theta) + centerY);
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    Color color = input.get(xx, yy);
                    output.set(col, row, color);
                }
            }
        }
        output.show();
    }

    public static void swirlFilter(Picture input) {
        int width = input.width();
        int height = input.height();
        int centerX = width / 2;
        int centerY = height / 2;
        Picture output = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int dx = (col - centerX);
                int dy = (row - centerY);
                double r = Math.sqrt(dx * dx + dy * dy);
                double angle = Math.PI * r / 256;
                int xx = (int) (dx * Math.cos(angle) - dy * Math.sin(angle) + centerX);
                int yy = (int) (dx * Math.sin(angle) + dy * Math.cos(angle) + centerY);
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    Color color = input.get(xx, yy);
                    output.set(col, row, color);
                }
            }
        }
        output.show();
    }
    public static void waveFilter(Picture input) {
        int width = input.width();
        int height = input.height();
        Picture output = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int xx = col;
                int yy = (int)(row + (20 * Math.sin(2 * Math.PI * col/ 64)));
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    Color color = input.get(xx, yy);
                    output.set(col, row, color);
                }
            }
        }
        output.show();
    }

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        pic.show();
        // double theta = Math.toRadians(Double.parseDouble(args[1]));
        // int m = Integer.parseInt(args[1]);
        // int n = Integer.parseInt(args[2]);
        // flipHorizontally(pic);
        // colorSeparation(pic);
        // tilePicture(pic, m, n);
        // rotatePicture(pic, theta);
        swirlFilter(pic);
        // waveFilter(pic);
    }
}