public class Knapsack {
    private int value[];
    private int weight[];
    private int w;


    public Knapsack(int[] value, int[] weight, int w) {
        this.value = value;
        this.weight = weight;
        this.w = w;
    }

    public int maxValue() {
        int max_value = 0;
        int[][] mv = new int[value.length][w + 1];
        for (int j = 0; j < value.length; j++) {
            for (int i = 1; i <= w; i++) {

                if (i - weight[j] >= 0) {
                    if (j == 0) {
                        mv[j][i] = value[j];
                        max_value = Math.max(max_value, mv[j][i]);
                    } else {
                        int localMax = Math.max(mv[j - 1][i - weight[j]] + value[j], mv[j - 1][i]);

                        mv[j][i] = localMax;
                        max_value = Math.max(max_value, localMax);

                    }
                }else{
                    if(j>0)
                        mv[j][i] = mv[j-1][i];
                }
            }
        }
        return max_value;
    }

    public static void main(String[] args) {
        int values[] = new int[]{60,100,120 };
        int weights[] = new int[]{10,20,30};
        int capacity = 50;
        Knapsack k = new Knapsack(values, weights, capacity);
        int v = k.maxValue();
        System.out.println(v);
    }
}
