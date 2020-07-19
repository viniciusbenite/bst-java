package bst;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = recursiveInsert(root, data);
    }

    void delete(int data) {
        root = recursiveDelete(root, data);
    }

    void inorder()  {
        inorderRecursive(root);
    }

    Node recursiveInsert(Node root, int data) {
        // Empty tree
        if (root == null) {
            System.out.println("New node created With data= " + data);
            root = new Node(data);
            return root;
        }
        // Transverse the tree to find a leaf node to insert new data
        if (data < root.data) {
            root.left = recursiveInsert(root.left, data);
        } else if (data > root.data) {
            root.right = recursiveInsert(root.right, data);
        }
        return root;
    }

    Node recursiveSearch(Node root, int data) {
        // Empty tree or data found
        if (root == null || root.data == data) {
            return root;
        }
        // If not, transverse the tree
        // Smaller: go left. Otherwise, go right
        if (data < root.data) {
            return recursiveSearch(root.right, data);
        }
        return recursiveSearch(root.left, data);
    }

    Node recursiveDelete(Node root, int data) {
        // Check if tree is empty
        if (root == null) {
            return null;
        }
        // Transverse the tree
        if (data < root.data) {
            root.left = recursiveDelete(root.left, data);
        } else if (data > root.data) {
            root.right = recursiveDelete(root.right, data);
        } else {
            // We find the node to be deleted
            // Node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children
            root.data  = findMinValue(root.right);
            root.right = recursiveDelete(root.right, root.data);

            // Keep track of parent node
        }
        return root;
    }

    // Successor is the smaller node in the right sub tree of the node to be deleted.
    int findMinValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Keep track of the parent node to avoid recursive calls to recursiveDelete()
    Node getSuccessor(Node root) {
        Node successor = null;
        Node successorParent = null;
        Node current = root.right;
        while (current != null) {
            // Walk down
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        // Check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        if (successor != root.right) {
            successorParent.left = successor.right;
            successor.right = root.right;
        }
        return successor;
    }

    // Inorder traversal of BST. This will produce a sorted output.
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.data);
            inorderRecursive(root.right);
        }
    }
}
