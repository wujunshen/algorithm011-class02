package com.algorithm.class18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1122. 数组的相对排序
 *
 * <p>给你两个数组，arr1 和 arr2，
 *
 * <p>arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对 arr1 中的元素进行排序，使 arr1
 * 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * <p>
 *
 * <p>示例：
 *
 * <p>输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * <p>提示：
 *
 * <p>arr1.length, arr2.length <= 1000 0 <= arr1[i], arr2[i] <= 1000 arr2 中的元素 arr2[i] 各不相同 arr2
 * 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/12 22:54<br>
 */
public class RelativeSortArray {
  Map<Integer, Integer> record;

  /**
   * https://leetcode-cn.com/problems/relative-sort-array/solution/ming-que-bi-jiao-fang-shi-hou-xiang-zen-yao-pai-ji/#lambda%E8%A1%A8%E8%BE%BE%E5%BC%8F
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    record = new HashMap<>(arr2.length);
    for (int i = 0; i < arr2.length; i++) {
      record.put(arr2[i], i);
    }
    List<Integer> res =
        Arrays.stream(arr1)
            .boxed()
            .sorted(
                (num1, num2) -> {
                  if (record.containsKey(num1) || record.containsKey(num2)) {
                    return record.getOrDefault(num1, 1000) - record.getOrDefault(num2, 1000);
                  } else {
                    return num1 - num2;
                  }
                })
            .collect(Collectors.toList());

    return res.stream().mapToInt(i -> i).toArray();
  }
}
