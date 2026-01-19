import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class KnuthShuffle {

    public static void shuffle(int[] array){

        for (int i = 0; i < array.length-1; i++) {
            int randomIndex = StdRandom.uniformInt(i+1);
            swap(array,i,randomIndex);
        }

    }

    private static void swap(int[] array, int i ,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


    public static void main(String[] args) {
        int[] array = {12,34,45,23,3,1,51};
        System.out.println(Arrays.toString(array));
        shuffle(array);
        System.out.println(Arrays.toString(array));
    }
}
