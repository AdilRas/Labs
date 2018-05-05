public class binarySearch {
    public static void main(String[] args) {
        int[] list = {1, 2, 5, 6, 9, 23, 25, 34};
        System.out.println(binSearch(23, list));
    }

    private static int binSearch(int i, int[] list) {
        int lo = 0, hi = list.length-1;
        int mid = (lo + hi)/2;
        while(lo <= hi) {
            mid = (lo + hi)/2;
            if(list[mid] == i) {
                return mid;
            } else if(list[mid] < i) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
}
