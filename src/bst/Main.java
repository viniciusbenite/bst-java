package bst;

public class Main {
    public static void main(String[] args) {

        System.out.println("Creating new tree");
        BinarySearchTree tree = new BinarySearchTree();

        /* Create tree
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("Search in the tree");
        System.out.println(tree.recursiveSearch(tree.root, 999));
        System.out.println(tree.recursiveSearch(tree.root, 80));
        System.out.println(tree.recursiveSearch(tree.root, 30));

        System.out.println("\nDelete 20");
        tree.delete(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.delete(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.delete(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}
