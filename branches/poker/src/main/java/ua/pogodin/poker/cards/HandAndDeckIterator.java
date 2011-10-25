package ua.pogodin.poker.cards;

import java.util.Iterator;

class HandAndDeckIterator implements Iterator<Hand> {
    private HandAndDeck handAndDeck;

    public HandAndDeckIterator(HandAndDeck handAndDeck) {
        this.handAndDeck = handAndDeck;
    }

    public boolean hasNext() {
        return false;
    }

    public Hand next() {
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
