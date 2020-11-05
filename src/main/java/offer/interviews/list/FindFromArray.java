package offer.interviews.list;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 例如输入 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 * @author kingflag
 */
public class FindFromArray {
    public boolean find(int target, int[][] array) {
        boolean res = false;
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == 0) {
                continue;
            }
            if (array[i][0] <= target && array[i][array[i].length - 1] >= target) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] < target) {
                    } else {
                        if (array[i][j] == target) {
                            res = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindFromArray findFromArray = new FindFromArray();
        int[][] array = new int[][]{{1}};
        int target = 1;
        boolean result = findFromArray.find(target, array);
        System.out.println(result);
    }
}
