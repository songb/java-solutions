import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {

    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            if (amount == 0) return 1;
            else return 0;
        }
        int[][] r = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) r[i][0] = 1;


        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 0) {
                    if (j % coins[0] == 0) r[0][j] = 1;

                } else {
                    if (j >= coins[i])
                        r[i][j] = r[i - 1][j] + r[i][j - coins[i]];
                    else
                        r[i][j] = r[i - 1][j];
                }
            }
        }

        return r[coins.length - 1][amount];

    }


    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int n = c.change(5, new int[]{1, 2, 5});
        System.out.println(n);
    }
}
