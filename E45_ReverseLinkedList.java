public class E45_ReverseLinkedList {
    public static Item reverseLinkedList(Item item) {
        Item last = null;
        Item next;
        
        while (item != null) {
            next = item.link;
            item.link = last;
            last = item;
            item = next;
        }
        return last;
    }
    
    public static void main(String[] args) {
        Item item = createLinkedList(new String[] {"a", "b", "c", "d", "e"});
        System.out.println("Before: " + item.printList());
        
        item = reverseLinkedList(item);
        System.out.println("After: " + item.printList());
    }

    public static Item createLinkedList(String[] arr) {
        Item item = null;
        for (int i = arr.length - 1; i > -1; i--) {
            Item newItem = new Item();
            newItem.content = arr[i];
            newItem.link = item;
            item = newItem;
        }
        return item;
    }
    
    private static class Item {
        String content;
        Item link;
        
        public String printList() {
            return content + (link != null ? ", " + link.printList() : "");
        }
    }
}
