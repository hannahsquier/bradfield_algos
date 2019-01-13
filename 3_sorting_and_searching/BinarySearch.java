public class BinarySearch {
    
    public static boolean search(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == num) {
                return true;
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[]{11, 28, 44, 76, 83, 100}, 76) ? "PASS" : "FAIL");
        System.out.println(!BinarySearch.search(new int[]{11, 28, 76, 83, 100}, 26) ? "PASS" : "FAIL");
        System.out.println(!BinarySearch.search(new int[]{11, 28, 76, 83, 100}, 21010) ? "PASS" : "FAIL");
        System.out.println(!BinarySearch.search(new int[]{}, 21010) ? "PASS" : "FAIL");
        System.out.println(BinarySearch.search(new int[]{11}, 11) ? "PASS" : "FAIL");
    }
}