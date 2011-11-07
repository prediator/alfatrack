import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E46_InsertInSortedList {
    public static List<Integer> insert(List<Integer> list, Integer el) {
        int pos = posToInsert(list, el);
        return insertToPos(list, el, pos);
    }

    public static int posToInsert(List<Integer> list, Integer el) {
        int from = 0;
        int to = list.size() - 1;
        
        while (to - from > 1) {
            int pos = (to + from) / 2;
            if (el > list.get(pos)) {
                from = pos;
            } else {
                to = pos;
            }
        }
        return to;
    }
    
    public static <T> ArrayList<T> insertToPos(List<T> list, T el, int pos) {
        ArrayList<T> newList = new ArrayList<T>();
        newList.addAll(list.subList(0, pos));
        newList.add(el);
        newList.addAll(list.subList(pos, list.size()));
        return newList;
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] {3, 4, 5, 6, 7, 9, 12, 15, 17, 19});
        System.out.println(list);
        
        list = insert(list, 8);
        System.out.println(list);
    }
}
