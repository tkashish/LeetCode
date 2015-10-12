import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private int curr;
    private Iterator<Integer> it;
    boolean peeked;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    peeked = false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(!peeked){
	        peeked = true;
            curr = it.next();
	    }
	    return curr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peeked){
	        peeked = false;
	        return curr;
	    }else{
	        return it.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if(peeked){
	        return true;
	    }else{
	        return it.hasNext();
	    }
	}
}