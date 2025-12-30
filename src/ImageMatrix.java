import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageMatrix {
    int w;
    int h;
    int[][] pixels;
    public ImageMatrix(File f) throws IOException {
        BufferedImage img = ImageIO.read(f);
        Raster r = img.getData();
        w = r.getWidth();
        h = r.getHeight();
        pixels = new int[w][h];

        for(int i =0;i<w;i++){
            for(int j =0;j<h;j++){
                pixels[i][j] = r.getSample(i,j,0);
            }
        }

    }

    public void backToImage(){
        BufferedImage image = new BufferedImage(pixels.length, pixels[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i =0; i<w;i++){
            for(int j=0;j<h;j++){
                image.setRGB(i,j,pixels[i][j]);
            }
        }
        File f = new File("./testOutput.png");
        try {
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPixels(int [][] p){
        pixels = p;
    }
}

