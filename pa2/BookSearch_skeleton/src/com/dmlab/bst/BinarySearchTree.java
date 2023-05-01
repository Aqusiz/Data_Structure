package com.dmlab.bst;

public class BinarySearchTree<Key extends Comparable<? super Key>, E> {

    /**
     * root of this tree
     */
    private BinaryNode<Key, E> root;
    private int nodeCount = 0;

    // Declare more variables HERE

    /**
     * Constructor
     * Do not modify this function.
     */
    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * This function returns the root of the BST.
     * Do not modify this function.
     *
     * @return root of the BinarySearchTree
     */
    public BinaryNode<Key, E> getRoot() {
        return root;
    }

    /**
     * Reinitialize tree
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Insert an item into the tree.
     *
     * @param key   of the item
     * @param value of the item
     */
    public void insert(Key key, E value) {
        // TODO: Fill in this function
        root = insertHelp(root, key, value);
        nodeCount++;
    }

    /**
     * Insert the item <key,value> into the tree rt.
     *
     * @param rt    of the tree.
     * @param key   of the item to be inserted.
     * @param value of the item to be inserted.
     * @return the tree after insertion
     */
    private BinaryNode<Key, E> insertHelp(BinaryNode<Key, E> rt, Key key, E value) {
        // TODO: Fill in this function
        if(rt == null) {
            return new BinaryNode<Key, E>(key, value);
        } else if (rt.getKey().compareTo(key) > 0) {
            rt.setLeft(insertHelp(rt.getLeft(), key, value));
        } else {
            rt.setRight(insertHelp(rt.getRight(), key, value));
        }
        rt.increaseSize();
        return rt;
    }

    /**
     * Remove an item from the tree.
     *
     * @param key of the item to be removed.
     * @return the value of the removed item. If no such item, return null.
     */
    public E remove(Key key) {
        // TODO: Fill in this function
        E temp = findHelp(root, key);
        if (temp != null) {
            root = this.removeHelp(root, key);
            nodeCount--;
        }
        return temp;
    }

    /**
     * Remove a node with given key from the tree rt.
     *
     * @param rt  of the tree.
     * @param key of the item to be removed.
     * @return the tree after removing.
     */
    private BinaryNode<Key, E> removeHelp(BinaryNode<Key, E> rt, Key key) {
        // TODO: Fill in this function
        if (rt == null) return null;
        else if (rt.getKey().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.getLeft(), key));
        }
        else if (rt.getKey().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.getRight(), key));
        }
        else {
            if (rt.getLeft() == null) return rt.getRight();
            else if (rt.getRight() == null) return rt.getLeft();
            else {
                BinaryNode<Key, E> temp = getMin(rt.getRight());
                rt.setValue(temp.getValue());
                rt.setKey(temp.getKey());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
        rt.decreaseSize();
        return rt;
    }

    /**
     * Given a tree rt, get its smallest node.
     * The smallest node is the node with the minimum key.
     *
     * @param rt
     * @return the smallest node.
     */
    public BinaryNode<Key, E> getMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        if (rt == null) return null;
        if (rt.getLeft() == null) return rt;
        else return getMin(rt.getLeft());
    }

    /**
     * Given a tree rt, get its largest node.
     * The largest node is the node with the maximum key.
     *
     * @param rt
     * @return the largest node.
     */
    public BinaryNode<Key, E> getMax(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        if (rt == null) return rt;
        if (rt.getRight() == null) return rt;
        else return getMax(rt.getRight());
    }

    /**
     * Given a tree rt, delete the smallest node and return this tree.
     *
     * @param rt is the root of the tree
     * @return the tree after deletion.
     */
    private BinaryNode<Key, E> deleteMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        if (rt == null) return null;
        else if (rt.getLeft() == null) return rt.getRight();
        else rt.setLeft(deleteMin(rt.getLeft()));
        rt.decreaseSize();
        return rt;
    }


    /**
     * Find the item with given key.
     *
     * @param key of the item
     * @return the value if the item. If no such item, return null.
     * Do not modify this function.
     */
    public E find(Key key) {
        return findHelp(root, key);
    }

    /**
     * @return The number of nodes in the tree.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * Find the item with given key in the tree rt.
     *
     * @param rt  is the root of the tree.
     * @param key is the key that we want to find in tree rt.
     * @return the value of the wanted item. If no such item, return null.
     */
    private E findHelp(BinaryNode<Key, E> rt, Key key) {
        // TODO: Fill in this function
        if (rt == null) return null;
        else if (rt.getKey().compareTo(key) > 0) return findHelp(rt.getLeft(), key);
        else if (rt.getKey().compareTo(key) < 0) return findHelp(rt.getRight(), key);
        else return rt.getValue();
    }

    /**
     * Prints all keys in the tree in ascending order.
     * Do not modify this function.
     */
    public void printBookList() {
        printBookListHelper(root);
    }

    /**
     * Prints all keys in the tree with given root using inorder traversal.
     *
     * @param rt is the root of the tree. This param is used for the recursion.
     */
    public void printBookListHelper(BinaryNode<Key, E> rt) {
        ///TODO: Fill in this function
        if (rt == null) return;
        printBookListHelper(rt.getLeft());
        System.out.println("BOOK:\t"+ rt.getKey());
        printBookListHelper(rt.getRight());
    }

    /**
     * Given the order of the item, find the key of the corresponding item.
     *
     * @param order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    public Key orderSearch(int order) {
        ///TODO: Fill in this function
        return orderSearchHelper(root, order);
    }

    /**
     * Given the order of the item and rt of the tree,
     * find the key of the corresponding item in the tree.
     *
     * @param rt    is the root of the tree.
     * @param order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    private Key orderSearchHelper(BinaryNode<Key, E> rt, int order) {
        ///TODO: Fill in this function
        if (rt == null) return null;
        int now_order = (rt.getRight() == null) ? rt.getSize() : rt.getSize() - rt.getRight().getSize();
        if (now_order == order) return rt.getKey();
        else if (now_order > order) {
            return orderSearchHelper(rt.getLeft(), order);
        }
        else {
            return orderSearchHelper(rt.getRight(), order - now_order);
        }
    }

    /**
     * Given the key of the item, find the order of the item.
     *
     * @param key of the item
     * @return the order of the item. If no such item, return 0.
     */

    public int orderSearch(Key key) {
        ///TODO: Fill in this function
        return orderSearchHelper(root, key, 0);
    }

    /**
     * Given the key of the item and the root of the tree,
     * find the order of the item in the tree.
     *
     * @param rt    of the tree
     * @param key   of the item
     * @param count is the number of small items found before.
     * @return the order of the item. If no such item, return 0.
     */
    private int orderSearchHelper(BinaryNode<Key, E> rt, Key key, int count) {
        ///TODO: Fill in this function
        if (rt == null) return 0;
        int left_size = (rt.getLeft() == null) ? 0 : rt.getLeft().getSize();
        if (rt.getKey().compareTo(key) > 0) {
            return orderSearchHelper(rt.getLeft(), key, count);
        }
        else if (rt.getKey().compareTo(key) < 0) {
            return orderSearchHelper(rt.getRight(), key, count + left_size + 1);
        }
        return count + left_size + 1;
    }
    // Implement more functions HERE
}
