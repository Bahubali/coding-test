import java.util.List;
import java.util.ListIterator;

/**
 * Created by bahubali.n on 27/12/16.
 */
public class BinaryTreeTest {
    public static void main(String[] args) throws Exception {
        int[] inputArray = {5, 2, 9, 12, 3, 22, 40, 8};
        int sizeOfArray = inputArray.length;
        int d = 10, diff = 0;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < sizeOfArray; i++) {
            diff = (inputArray[i] > d)? (inputArray[i]-d): (d - inputArray[i]);
            binarySearchTree.addNode(diff, inputArray[i]);
        }

        binarySearchTree.traverse(binarySearchTree.getRoot());
    }
}
