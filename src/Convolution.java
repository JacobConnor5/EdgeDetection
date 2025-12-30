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
        //ending at Imatrix-2
        int conv;
        for (int i = 1; i<(iMatrix.length-2);i++){
            for (int j = 1; j<(iMatrix[i].length-2);j++){
                conv = 0;

                for (int g = 0; g<vMatrix.length;g++){
                    for (int h = 0; h<vMatrix.length;h++){
                        System.out.println("\norigma:"+ iMatrix[i-1+g][j-1+h]);
                        System.out.println("\nconv:"+ conv);

                        conv += iMatrix[i-1+g][j-1+h] * vMatrix[Math.abs((g-cHeight+1)%cHeight)][Math.abs((h-cHeight+1)%cHeight)];
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
}
