import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E58_ExtractingUniqueElementsFromSortedLinkedList {
    public static List<Integer> extractUniqueElements(List<Integer> list) {
        boolean wasNewDigit = true;
        ArrayList<Integer> uniqueList = new ArrayList<Integer>();
        
        for (int i = 1; i < list.size(); i++) {
            boolean newDigit = !list.get(i).equals(list.get(i - 1));
            if (newDigit && wasNewDigit) {
                uniqueList.add(list.get(i - 1));
            }
            wasNewDigit = newDigit;
        }
        
        if (wasNewDigit) {
            uniqueList.add(list.get(list.size() - 1));
        }
        
        return uniqueList;
    }
    
    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(0,1,2,2,3,4,5,5,6,6,7,7,7,8,9,9,9,10);
        System.out.println(extractUniqueElements(sortedList));
    }
}
