public class RotatedSortedArray {
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

    public static void main(String[] args) {
        RotatedSortedArray r = new RotatedSortedArray();
        System.out.println(r.findPivot(new int[]{11, 12, 15, 18, 2, 5, 6, 8}));
    }

}
