import javax.swing.text.Segment;
import java.util.*;

public class SumTreeAttempt {

    SegmentNode root;
    int[] elements;

    public SumTreeAttempt(int... elements) {
        this.elements = elements;
        constructSumTree();
    }

    private <T> T handleRemove(Queue<T> queue) {
        try {
            return queue.remove();
        }
        catch(NoSuchElementException e) {
            return null;
        }
    }

    private void constructSumTree() {
        root = new SegmentNode(null, 0, elements.length-1);
        Queue<SegmentNode> queue = new LinkedList<>();
        queue.add(root);
        SegmentNode next = handleRemove(queue);
        while(next != null) {
            if(next.upper-next.lower <= 0) {
                next = handleRemove(queue);
                continue;
            }
            int difference = next.upper - next.lower;
            next.left = new SegmentNode(next, next.lower, next.lower+(difference/2));
            next.right = new SegmentNode(next, next.left.upper+1, next.upper);
            queue.add(next.left);
            queue.add(next.right);
            next = handleRemove(queue);
        }

    }

    public static void main(String[] args) {
        SumTreeAttempt test = new SumTreeAttempt(3,4,7,6,5);
        System.out.println("Debug");
    }

    

    public int getValue(int index) {
        int value = elements[index];
        int finalValue = value;
        SegmentNode current = root;
        while(current != null) {
            value += current.incremental;
            if(current.lower == current.upper) {
                current = null;
            }
            else if(index <= current.left.upper) {
                current = current.left;
            }
            else if(index >= current.right.lower) {
                current = current.right;
            }
        }

        return finalValue;
    }


    private static class SegmentNode {
        SegmentNode parent;
        SegmentNode left, right;
        int lower, upper;
        int incremental = 0;
        SegmentNode(SegmentNode parent, int lower, int upper) {
            this.parent = parent;
            this.lower = lower;
            this.upper = upper;
        }

        @Override
        public String toString() {
            return lower+":"+upper;
        }
    }
}
