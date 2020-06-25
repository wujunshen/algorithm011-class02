/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 22:31<br>
 */
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int p = 0;
    int q = 1;

    while (q < nums.length) {
      if (nums[p] != nums[q]) {
        if (q - p > 1) {
          nums[p + 1] = nums[q];
        }

        p++;
      }
      q++;
    }
    return p + 1;
  }
}
