public class E69_TheMiddleOfTheSingleLinkedList {
    public static Item middleOfLinkedList(Item item) {
        for (Item fastItem = item.link; fastItem != null; fastItem = fastItem.link) {
            if ((fastItem = fastItem.link) == null) {
                break;
            }
            item = item.link;
        }
        return item;
    }

    public static void main(String[] args) {
        Item item = createLinkedListRecursively(new String[]{"b", "c", "d", "e", "f", "g", "h", "i"});
        System.out.println(middleOfLinkedList(item));


        item = new Item("a", item);
        System.out.println(middleOfLinkedList(item));
    }

    private static Item createLinkedListRecursively(String[] arr) {
        return createItem(arr, 0);
    }

    private static Item createItem(String[] arr, int i) {
        return new Item(arr[i], i < arr.length - 1 ? createItem(arr, i + 1) : null);
    }

    private static class Item {
        String content;
        Item link;

        private Item(String content, Item link) {
            this.content = content;
            this.link = link;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
