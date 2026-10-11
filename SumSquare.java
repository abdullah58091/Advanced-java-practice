public class SumSquare {

    public static void main(String[] args) {
        SumSquare obj = new SumSquare();
        int[] nums = {1, 2, 3, 4, 5};
        int result = obj.sumOfSquares(nums);
        System.out.println("Sum of squares of divisors: " + result);
    }
    public int sumOfSquares(int[] nums) {
        int  n = nums.length;
        int ans = 0;
        for(int i = 1; i <= n ; i++){
            if( n % i == 0){
                ans += nums[i - 1] * nums[i - 1];
            }
        }
        return ans;

    }
}