package ua.pogodin.poker.cards;

import java.util.Arrays;
import java.util.Iterator;

class CardsToReplaceIterator implements Iterator<int[]> {
    private int[] arr = new int[]{-1, -1, -1, -1, -1};
    int pos = arr.length - 1;
    int digitsNumber = 0;

    public boolean hasNext() {
        return pos > -1;
    }

    public int[] next() {
        arr[pos] = arr[pos] + 1;
        movePos();
        return Arrays.copyOfRange(arr, arr.length - digitsNumber, arr.length);
    }

    private void movePos() {
        if (arr[pos] == 0) {
            digitsNumber++;
            pos = arr.length - 1;
        }

        if (arr[pos] == arr.length - 1 || pos < arr.length - 1 && arr[pos] == arr[pos + 1] - 1) {
            pos--;

            int value = arr[pos];
            for (int i = pos + 1; i < arr.length; i++) {
                arr[i] = ++value;
            }
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
