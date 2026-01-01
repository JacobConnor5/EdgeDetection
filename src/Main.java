import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Convolution conv = new Convolution();

        ImageMatrix image = new ImageMatrix("skyscraper.jpg");
        conv.setIMatrix(image.pixels);
        conv.Diagonal(3);
        image.setPixels(conv.newMatrix);

        image.backToImage(Integer.toString(conv.cHeight));



        //System.out.println(Arrays.deepToString(conv.newMatrix));

    }
}