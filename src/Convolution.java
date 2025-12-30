import java.util.Arrays;

public class Convolution {
    int [][] vMatrix = {{1,0,-1},{1,0,-1},{1,0,-1}};
    int [][] hMatrix = {{1,1,1},{0,0,0},{0,0,0}};
    int cHeight;
    int [][] newMatrix;
    int [][] iMatrix;
    public Convolution(){
        //iMatrix = new int[][]{
//                {10, 10, 10, 0, 0, 0},
//                {10, 10, 10, 0, 0, 0},
//                {10, 10, 10, 0, 0, 0},
//                {10, 10, 10, 0, 0, 0},
//                {10, 10, 10, 0, 0, 0},
//                {10, 10, 10, 0, 0, 0},
//        };
        cHeight = vMatrix.length;
    }

    public void Vertical(){
        //dont do outskirts
        //exclude the outmost two pixels
        //loop through starting at 2
        //ending at Imatrix-size of c matrix
        int conv;
        System.out.println(iMatrix[0].length-(cHeight/2)-1);
        for (int i = (cHeight/2); i<(iMatrix.length-(cHeight/2)-1);i++){
            for (int j = (cHeight/2); j<(iMatrix[i].length-(cHeight/2)-1);j++){
                conv = 0;

                for (int g = 0; g<vMatrix.length;g++){
                    for (int h = 0; h<vMatrix.length;h++){
                        //System.out.println(iMatrix[i-1+g][j-1+h]);
                        int var = (j-1+h);
                        conv += iMatrix[i-(cHeight/2)+g][j-(cHeight/2)+h] * vMatrix[Math.abs((g-cHeight+1)%cHeight)][Math.abs((h-cHeight+1)%cHeight)];
                    }
                }
            newMatrix[i][j] = Math.abs(conv);

            }
    }
    }

    public void setIMatrix(int [][] image){
        iMatrix = image;
        newMatrix = new int[iMatrix.length][iMatrix[0].length];

    }

    public void setvMatrix(int size){
        //integer division by 2
        //make 1s that many times and -1 that many times
        cHeight = size;
        vMatrix = new int[size][size];
        for (int i = 0;i<(size);i++){
            for (int j=0;j<(size/2);j++){
                vMatrix[i][j] = 1;
                vMatrix[i][size-j-1] = -1;
            }

        }

        System.out.println(Arrays.deepToString(vMatrix));
    }
}
