import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class E65_FindElementsOfFixedListInAnyOtherList {
    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static List<Integer> findElements1(List<Integer> elementsToFind, List<Integer> listToSearch) {
        HashSet<Integer> hashSet = new HashSet<Integer>(elementsToFind); // space O(n)
        ArrayList<Integer> found = new ArrayList<Integer>();

        for (Integer integer : listToSearch) { // time O(n)
            if (hashSet.contains(integer)) { // time O(1)
                found.add(integer);
            }
        }
        return found;
    }

    /**
     * time complexity O(nlogn)
     * space complexity O(1)
     */
    public static List<Integer> findElements2(List<Integer> elementsToFind, List<Integer> listToSearch) {
        Collections.sort(elementsToFind); // time O(nlogn)

        ArrayList<Integer> found = new ArrayList<Integer>();
        for (Integer integer : listToSearch) { // time O(nlogn)
            if (Collections.binarySearch(elementsToFind, integer) > -1) { // time O(logn)
                found.add(integer);
            }
        }

        return found;
    }

    public static void main(String[] args) {
        List<Integer> elementsToFind = Arrays.asList(3,7,5,6,9);
        List<Integer> listToSearch = Arrays.asList(4,3,5,6,7,8,2,3,4,8,0,9,8,9,1);

        System.out.println("method1: " + findElements1(elementsToFind, listToSearch));
        System.out.println("method2: " + findElements2(elementsToFind, listToSearch));
    }
}
