import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    static int maxDiff(int[] ar) {

        int diff = -1;
        int min = ar[0];

        for(int i = 0; i < ar.length; i++){

//            if(ar[i] < min)
//                min = ar[i];
//            if((ar[i] - min) > diff)
//                diff = ar[i] - min;


            min = (ar[i] < min)? ar[i]:min;

            diff = ((ar[i] - min) > diff) ? ar[i] - min : diff;
        }

        if(diff == 0) return -1;
        return diff;
    }

    public static void main(String[] args) {

        Integer[] ar = {-6,-3,-1};
        //System.out.println( maxDiff(ar));
        
        Arrays.asList(ar).stream().sorted().forEach(System.out::print);
        

    }
}
