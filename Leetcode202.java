import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int slow = n;
        int fast = sum(n);

        while(true){
            if(fast == 1){
                return true;
            }else if(set.contains(fast)){
                return false;
            }else{
                set.add(slow);
                slow = fast;
                fast = sum(sum(fast));
            }
        }
    }

    // TC is same as above but the SC is O(1)
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = sum(n);

        while(fast != 1 && fast != slow) {
            slow = sum(slow);
            fast = sum(sum(fast));
        }

        return fast == 1;
    }
    private int sum(int number){
        int sum = 0;
        while(number > 0){
            int temp = number % 10;
            sum += temp * temp;
            number = number / 10;
        }

        return sum;
    }
}
