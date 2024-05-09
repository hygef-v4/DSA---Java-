package Search;

public class Search {
    public static int linear_search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int Binary_search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (target == arr[mid])
                return mid;
            if (target > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
