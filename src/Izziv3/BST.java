package Izziv3;

public class BST<Tip extends Comparable<Tip>> implements Seznam<Tip> {
    class Node<Tip extends Comparable<Tip>> {
        Tip data;
        Node<Tip> left;
        Node<Tip> right;
        Node<Tip> parent;

        public Node(Tip data, Node<Tip> parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public Node<Tip> root;

    public BST() {
        this.root = null;
    }

    public void insert(Tip data) throws java.util.InputMismatchException {
        if (this.root == null) {
            this.root = new Node<Tip>(data, null);
        } else {
            this.recursiveInsert(data, this.root);
        }
    }

    private void recursiveInsert(Tip data, Node<Tip> node) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null)
                node.left = new Node<Tip>(data, node);
            else
                this.recursiveInsert(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            if (node.right == null)
                node.right = new Node<Tip>(data, node);
            else
                this.recursiveInsert(data, node.right);
        }
        else
            throw new java.util.InputMismatchException("Element already exists in the tree");
    }

    public void delete(Tip data){
        if (this.root == null)
            throw new java.util.EmptyStackException();
        if (!this.recursiveDelete(data, this.root, "root"))
            throw new java.util.NoSuchElementException();
    }

    private boolean recursiveDelete(Tip data, Node<Tip> node, String direction){
        if (node == null)
            return false;
        if (data.compareTo(node.data) < 0)
            return this.recursiveDelete(data, node.left, "left");
        else if (data.compareTo(node.data) > 0)
            return this.recursiveDelete(data, node.right, "right");
        else {
            if (node.left == null)
                if (direction.equals("root")) {
                    this.root = node.right;
                    if (this.root != null)
                        this.root.parent = null;
                }
                else if (direction.equals("left")) {
                    node.parent.left = node.right;
                    if (node.right != null)
                        node.right.parent = node.parent;
                }
                else {
                    node.parent.right = node.right;
                    if (node.right != null)
                        node.right.parent = node.parent;
                }
            else if (node.right == null)
                if (direction.equals("root")) {
                    this.root = node.left;
                    if (this.root != null)
                        this.root.parent = null;
                }
                else if (direction.equals("left")) {
                    node.parent.left = node.left;
                    if (node.left != null)
                        node.left.parent = node.parent;
                }
                else {
                    node.parent.right = node.left;
                    if (node.left != null)
                        node.left.parent = node.parent;
                }
            else {
                Node<Tip> min = this.findMin(node.right);
                node.data = min.data;
                recursiveDelete(min.data, node.right, "right");
            }
            return true;
        }
    }

    private Node<Tip> findMin(Node<Tip> node){
        if (node.left == null)
            return node;
        return this.findMin(node.left);
    }

    public boolean member(Tip data) {
        if (this.root == null)
            throw new java.util.EmptyStackException();
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

    @Override
    public int size() {
        return this.countNodes(this.root);
    }

    private int countNodes(Node<Tip> node){
        if (node == null)
            return 0;
        return 1 + this.countNodes(node.left) + this.countNodes(node.right);
    }

    @Override
    public int depth() {
        return this.getDepth(this.root);
    }

    private int getDepth(Node<Tip> node){
        if (node == null)
            return 0;
        return 1 + Math.max(this.getDepth(node.left), this.getDepth(node.right));
    }

    @Override
    public void add(Tip e) throws java.util.InputMismatchException{
        this.insert(e);
    }

    @Override
    public Tip removeFirst() throws java.util.NoSuchElementException, java.util.EmptyStackException {
        if (this.root == null)
            throw new java.util.EmptyStackException();
        Tip tmp = this.root.data;
        this.delete(tmp);
        return tmp;
    }

    @Override
    public Tip getFirst() {
        if (this.root == null)
            throw new java.util.EmptyStackException();
        return this.root.data;
    }


    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Tip remove(Tip e) throws java.util.NoSuchElementException, java.util.EmptyStackException {
        this.delete(e);
        return e;
    }

    @Override
    public boolean exists(Tip e) throws java.util.EmptyStackException {
        return this.member(e);
    }

    public void inOrder(Node<Tip> node){
        if (node == null)
            return;
        this.inOrder(node.left);
        System.out.println(node.data);
        this.inOrder(node.right);
    }

    public void preOrder(Node<Tip> node){
        if (node == null)
            return;
        System.out.println(node.data);
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void postOrder(Node<Tip> node){
        if (node == null)
            return;
        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.println(node.data);
    }
}
