public class E67_PrintOutContentsOfLinkedListInReverseOrderWithoutAnyExtraSpace {
    public static String toString(Item item) {
        return item == null ? "" : toString(item.link) + " " + item.content;
    }

    public static void main(String[] args) {
        Item item = createLinkedList(new String[] {"a", "b", "c", "d", "e"});
        System.out.println(toString(item));
    }

    public static Item createLinkedList(String[] arr) {
        Item item = null;
        for (int i = arr.length - 1; i > -1; item = new Item(arr[i--], item));
        return item;
    }

    private static class Item {
        String content;
        Item link;

        private Item(String content, Item link) {
            this.content = content;
            this.link = link;
        }
    }
}
