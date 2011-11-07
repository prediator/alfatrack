public class E48_LinkedListManipulation {
    /**
     * All the operations don't check illegal input arguments
     */
    public static class LinkedList {
        private Item first;

        public void add(Item item, int pos) {
            if (pos == 0) {
                item.link = first;
                first = item;
            } else {
                Item found = get(pos - 1);
                item.link = found.link;
                found.link = item;
            }
        }

        public void add(Item item) {
            if (first == null) {
                first = item;
            } else {
                Item found = first;

                while (found.link != null) {
                    found = found.link;
                }

                found.link = item;
            }
        }

        public void delete(int pos) {
            if (pos == 0) {
                first = first.link;
            } else {
                Item found = get(pos - 1);
                found.link = found.link.link;
            }
        }

        public Item get(int pos) {
            Item found = first;
            for (; pos > 0 && found != null; pos--) {
                found = found.link;
            }
            return found;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[" + first);
            for (Item item = first.link; item != null; item = item.link) {
                sb.append(",").append(item);
            }
            return sb.append("]").toString();
        }
    }

    public static class Item {
        String content;
        Item link;

        public Item(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = createLinkedList(new String[]{"a", "b", "d"});
        System.out.println("initial: " + linkedList);

        linkedList.add(new Item("e"));
        linkedList.add(new Item("f"));
        System.out.println("added to end 2 items: " + linkedList);

        linkedList.add(new Item("c"), 2);
        linkedList.add(new Item("g"), 6);
        System.out.println("added to positions 2, 6: " + linkedList);

        linkedList.delete(0);
        System.out.println("deleted position 0: " + linkedList);
        linkedList.delete(4);
        System.out.println("deleted position 4: " + linkedList);
        linkedList.delete(4);
        System.out.println("deleted position 4: " + linkedList);

        System.out.println("item at position 0: " + linkedList.get(0));
        System.out.println("item at position 3: " + linkedList.get(3));
        System.out.println("item at position 4: " + linkedList.get(4));
    }

    public static LinkedList createLinkedList(String[] arr) {
        Item item = null;
        for (int i = arr.length - 1; i > -1; i--) {
            Item newItem = new Item(arr[i]);
            newItem.link = item;
            item = newItem;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.first = item;
        return linkedList;
    }
}
