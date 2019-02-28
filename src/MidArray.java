import java.util.ArrayList;
import java.util.List;

public class MidArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        List<Integer> longList = a.size() > b.size() ? a : b;
        List<Integer> shortList = a.size() <= b.size() ? a : b;

        int l = a.size() + b.size();

        boolean even = l % 2 == 0;

        if (l == longList.size()) {
            return calMean(even, longList.get(Math.max(l / 2 - 1, 0)), longList.get((Math.min(l / 2, l))));
        }


        int shortPos = Math.max(shortList.size() / 2, 1);
        int longPos = l / 2 - shortPos;


        while (true) {

            int v1 = longList.get(longPos - 1).intValue();
            int after_v1 = Integer.MAX_VALUE;
            if (longPos < longList.size())
                after_v1 = longList.get(longPos).intValue();

            int v2 = shortList.get(shortPos - 1);
            int after_v2 = Integer.MAX_VALUE;
            if (shortPos < shortList.size()) {
                after_v2 = shortList.get(shortPos);
            }

            if (v1 <= after_v2 && v2 <= after_v1) {
                int left = Math.max(v1, v2);
                int right = Math.min(after_v1, after_v2);
                return calMean(even, left, right);
            } else if (after_v1 < v2) {
                longPos++;
                shortPos--;
            } else {
                longPos--;
                shortPos++;
            }
        }

    }

    private double calMean(boolean even, int left, int right) {

        if (even)
            return (left + right) / 2.0;
        else
            return right;
    }


    public static void main(String[] args) {
        int[] aa = new int[]{-43, -25, -18, -15, -10, 9, 39, 40};
        int[] bb = new int[]{-2};
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<>();
        for (int ea : aa) {
            a.add(ea);
        }
        for (int eb : bb) {
            b.add(eb);
        }

        MidArray m = new MidArray();
        double k = m.findMedianSortedArrays(a, b);
        System.out.println(k);
    }
}
