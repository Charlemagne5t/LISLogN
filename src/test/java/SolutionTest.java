import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int expected = 4;
        int actual = new Solution().lengthOfLIS(nums);

        Assert.assertEquals(expected, actual);
    }
}
