import java.util.List;

public class RotatedSortedArray {
    public static void main(String[] args) {
        RotatedSortedArray r = new RotatedSortedArray();
        System.out.println(r.findPivot(new int[]{11, 12, 15, 18, 2, 5, 6, 8}));
    }

    public int findPivot(int[] input) {
        if (input.length < 1) return 0;
        int min = 0, max = input.length - 1;
        while (min <= max) {
            if (input[min] < input[max]) return min;
            int mid = (min + max) / 2;
            if (input[mid] < input[(mid + 1) % input.length] && input[mid] < input[(mid - 1 + input.length) % input.length])
                return mid;
            if (input[min] < input[mid]) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return -1;

    }

    public int search(final List<Integer> a, int b) {
        int low = 0, high = a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midV = a.get(mid).intValue();
            if (midV == b) return mid;
            int lowV = a.get(low).intValue();
            int highV = a.get(high).intValue();
            if (lowV > midV) {
                //in second half
                if (midV < b && highV > b) {
                    low = mid + 1;
                    continue;
                } else {
                    //first half
                    high = mid - 1;
                }
            } else if (midV > highV) {
                if (lowV < b && midV > b) {
                    high = mid - 1;
                    continue;
                } else {
                    //second half
                    low = mid + 1;
                }
            } else if (midV > b) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

}
