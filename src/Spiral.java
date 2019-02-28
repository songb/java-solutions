import java.util.ArrayList;

public class Spiral {

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int[][] temp = new int[A][A];

        int current = 1;

        for (int i = 0; i < A / 2 + 1; i++) {
            //top row
            for (int a = i; a < A - i; a++) {
                if (temp[i][a] == 0) {
                    temp[i][a] = current;
                    current++;
                }
            }
            //right column
            for (int a = i; a < A - i; a++) {
                if (temp[a][A - 1 - i] == 0) {
                    temp[a][A - 1 - i] = current;
                    current++;
                }
            }
            //bottom row
            for (int a = A-i-1; a > i; a--) {
                if (temp[A-1-i][a] == 0) {
                    temp[A-1-i][a] = current;
                    current++;
                }
            }

            //left column
            for (int a = A-i-1; a > i; a--) {
                if (temp[a][i] == 0) {
                    temp[a][i] = current;
                    current++;
                }
            }
        }

        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        for(int i=0; i<A; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0; j<A; j++){
                row.add(temp[i][j]);
            }
            r.add(row);
        }

        return r;
    }

    public static void main(String[] args) {
        Spiral s = new Spiral();
        s.generateMatrix(7);
    }

}
