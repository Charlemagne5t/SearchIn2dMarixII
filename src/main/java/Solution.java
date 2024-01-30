public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return bs(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean bs(int[][] matrix, int target, int iStart, int jStart, int iEnd, int jEnd) {
        if (iStart > iEnd || jStart > jEnd) {
            return false;
        }

        int iMid = iStart + (iEnd - iStart) / 2;
        int jMid = jStart + (jEnd - jStart) / 2;

        if (matrix[iMid][jMid] == target) {
            return true;
        }

        if (target < matrix[iMid][jMid]) {
            return bs(matrix, target, iStart, jStart, iMid - 1, jEnd) ||
                    bs(matrix, target, iMid, jStart, iEnd, jMid - 1);
        } else {
            return bs(matrix, target, iStart, jMid + 1, iMid, jEnd) ||
                    bs(matrix, target, iMid + 1, jStart, iEnd, jEnd);
        }
    }
}
