import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 *
 * Permutation.Given two integer arrays of size n
 * design a subquadratic algorithm
 * to determine whether one is a permutation of the other.
 * That is,do they contain exactly the same entries but, possibly, in a different order.
 * */

public class PermutationCheck {

    public static boolean arePermutations(int[] a, int[] b) {
        if (a == null || b == null){
            throw new NoSuchElementException("Can not pass null to function.");
        }
        // using hashmap to record
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int item : a) {
            hashMap.put(item,hashMap.getOrDefault(item,0)+1);
        }
        // check
        for (int item : b) {
            // did not contain item
            if (!hashMap.containsKey(item)){
                return false;
            }
            // contain more than it should be
            int count = hashMap.get(item);
            if (count == 0){
                return false;
            }
            hashMap.put(item, count-1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 2};

        boolean arePermutations = arePermutations(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (arePermutations) {
            System.out.println("Permutations.");
        } else {
            System.out.println("Not Permutations.");
        }
    }
}
