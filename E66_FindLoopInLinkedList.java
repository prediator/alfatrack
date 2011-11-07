public class E66_FindLoopInLinkedList {
    public static boolean containsLoop(Item head) {
        for (Item item = head.link; item != null; item = item.link) {
            if (item == head) {
                return true;
            }

            item = item.link;
            head = head.link;

            if (item == head) {
                return true;
            }
            if (item == null) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Item item = new Item(null);
        Item item2 = new Item(new Item(item));
        Item head = new Item(new Item(new Item(item2)));
        System.out.println(containsLoop(head));

        item.link = item2;
        System.out.println(containsLoop(head));
    }

    public static class Item {
        Item link;

        public Item(Item link) {
            this.link = link;
        }
    }
}
