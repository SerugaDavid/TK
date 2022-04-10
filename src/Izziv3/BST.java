package Izziv3;

public class BST<Tip extends Comparable<Tip>> {
    class Node<Tip extends Comparable<Tip>> {
        Tip data;
        Node<Tip> left;
        Node<Tip> right;

        public Node(Tip data) {
            this.data = data;
        }
    }

    private Node<Tip> root;

    public BST() {
        this.root = null;
    }

    public void insert(Tip data) throws java.util.InputMismatchException {
        if (this.root == null) {
            this.root = new Node<Tip>(data);
        } else {
            this.recursiveInsert(data, this.root);
        }
    }

    private void recursiveInsert(Tip data, Node<Tip> node) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null)
                node.left = new Node<Tip>(data);
            else
                this.recursiveInsert(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            if (node.right == null)
                node.right = new Node<Tip>(data);
            else
                this.recursiveInsert(data, node.right);
        }
        else
            throw new java.util.InputMismatchException("Element already exists in the tree");
    }

    public void delete(Tip data){
        this.recursiveDelete(data, this.root);
    }

    private void recursiveDelete(Tip data, Node<Tip> node){
        if (node == null)
            return;
        if (data.compareTo(node.data) < 0)
            this.recursiveDelete(data, node.left);
        else if (data.compareTo(node.data) > 0)
            this.recursiveDelete(data, node.right);
        else {
            if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                Node<Tip> min = this.findMin(node.right);
                node.data = min.data;
                min = null;
            }
        }
    }

    private Node<Tip> findMin(Node<Tip> node){
        if (node.left == null)
            return node;
        return this.findMin(node.left);
    }

    public boolean member(Tip data) {
        return this.recursiveMember(data, this.root);
    }

    private boolean recursiveMember(Tip data, Node<Tip> node) {
        if (node == null)
            return false;
        if (data.compareTo(node.data) < 0)
            return this.recursiveMember(data, node.left);
        else if (data.compareTo(node.data) > 0)
            return this.recursiveMember(data, node.right);
        else
            return true;
    }

    public int size() {
        return this.countNodes(this.root);
    }

    private int countNodes(Node<Tip> node){
        if (node == null)
            return 0;
        return 1 + this.countNodes(node.left) + this.countNodes(node.right);
    }

    public int depth() {
        return this.getDepth(this.root);
    }

    private int getDepth(Node<Tip> node){
        if (node == null)
            return 0;
        return 1 + Math.max(this.getDepth(node.left), this.getDepth(node.right));
    }
}
