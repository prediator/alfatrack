public class E50_DeleteElementFromDoublyLinkedList {
    public static void delete(Item item) {
        if (item.next != null) {
            item.next.prev = item.prev;
        }
        if (item.prev != null) {
            item.prev.next = item.next;
        }
    }
    
    public static void main(String[] args) {
        Item toDelete;
        Item head;
        Item tail;
        
        Item item = new Item("d");
        tail = item;
        item = new Item("c", item);
        toDelete = item;
        item = new Item("b", item); 
        item = new Item("a", item);
        head = item;
        
        print(head);
        printReverse(tail);
        
        delete(toDelete);
        
        print(head);
        printReverse(tail);
    }
    
    public static void print(Item item) {
        StringBuilder builder = new StringBuilder(item.content);
        while (item.next != null) {
            builder.append(",");
            builder.append(item.next.content);
            item = item.next;
        }
        System.out.println(builder.toString());
    }
    
    public static void printReverse(Item item) {
        StringBuilder builder = new StringBuilder(item.content);
        while (item.prev != null) {
            builder.append(",");
            builder.append(item.prev.content);
            item = item.prev;
        }
        System.out.println(builder.toString());
    }
    
    public static class Item {
        String content;
        Item prev;
        Item next;
        
        public Item(String content) {
            this.content = content;
        }
        
        public Item(String content, Item next) {
            this.content = content;
            this.next = next;
            next.prev = this;
        }
    }
}
