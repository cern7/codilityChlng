public class FloodDepth {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 1, 2, 1, 6, 3, 3, 4, 6};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int size = A.length;
        if (size < 3) {
            return 0;
        }

        int leftPointer = 0;
        int rightPointer = A.length - 1;
        int leftMaxH = A[0];
        int rightMaxH = A[rightPointer];
        int maxHeight = 0;
        while (leftPointer < rightPointer) {
            if (leftMaxH < rightMaxH) {
                leftPointer++;
                leftMaxH = Math.max(leftMaxH, A[leftPointer]);
                maxHeight = Math.max(maxHeight, leftMaxH - A[leftPointer]);
            } else {
                rightPointer--;
                rightMaxH = Math.max(rightMaxH, A[rightPointer]);
                maxHeight = Math.max(maxHeight, rightMaxH - A[rightPointer]);
            }
        }
        return maxHeight;
    }
}
