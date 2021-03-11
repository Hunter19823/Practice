package trees;

import java.awt.*;

public class BinarySearchTree<TYPE extends Comparable<TYPE>> {

    public static void main(String[] args)
    {
        BinarySearchTree<Integer> exampleTree = new BinarySearchTree<>(8);
        exampleTree.add(3);
        exampleTree.add(10);
        exampleTree.add(1);
        exampleTree.add(6);
        exampleTree.add(14);
        exampleTree.add(4);
        exampleTree.add(7);
        exampleTree.add(13);
        exampleTree.print();

        System.out.println("Searching for 10...");
        System.out.println(exampleTree.recursive_search(10));
        System.out.println(exampleTree.iterative_search(10));

        System.out.println("Searching for 9...");
        System.out.println(exampleTree.recursive_search(9));
        System.out.println(exampleTree.iterative_search(9));

        System.out.println("Searching for 3...");
        System.out.println(exampleTree.recursive_search(3));
        System.out.println(exampleTree.iterative_search(3));

        System.out.println("Finding Dimensions...");
        System.out.println(exampleTree.getHead().findDimensions());
    }

    private BiNode<TYPE> head;

    public BinarySearchTree(TYPE head)
    {
        this.head = new BiNode<>(head);
    }

    public BiNode<TYPE> getHead()
    {
        return head;
    }

    public void add(TYPE data)
    {
        insert(new BiNode<TYPE>(data));
    }

    public void insert(BiNode<TYPE> node)
    {
        BiNode<TYPE> current = head;
        while(current!=null){
            if(current.equal(node)) break;
            if(current.lessThan(node)){
                if(current.getRight() == null) {
                    current.setRight(node);
                    break;
                }
                current = current.getRight();
            }else{
                if(current.getLeft() == null) {
                    current.setLeft(node);
                    break;
                }
                current = current.getLeft();
            }
        }
    }

    public BiNode<TYPE> recursive_search(TYPE data)
    {
        return this.recursive_search(new BiNode<TYPE>(data));
    }

    public BiNode<TYPE> recursive_search(BiNode<TYPE> data)
    {
        return this.recursive_search(data,head);
    }

    private BiNode<TYPE> recursive_search(BiNode<TYPE> data, BiNode<TYPE> node)
    {
        if(node == null || data.equal(node)) return node;
        if(data.lessThan(node)) return recursive_search(data,node.getLeft());
        if(data.greaterThan(node)) return recursive_search(data,node.getRight());
        return null;
    }

    public BiNode<TYPE> iterative_search(TYPE data)
    {
        return this.iterative_search(new BiNode<TYPE>(data),head);
    }

    public BiNode<TYPE> iterative_search(BiNode<TYPE> data)
    {
        return this.iterative_search(data,head);
    }

    private BiNode<TYPE> iterative_search(BiNode<TYPE> data, BiNode<TYPE> startingNode)
    {
        BiNode<TYPE> currentNode = startingNode;
        while (currentNode != null)
        {
            if (data.equal(currentNode)) break;
            if (data.lessThan(currentNode)) currentNode = currentNode.getLeft();
            else currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    public void print()
    {
        this.head.print();
    }
}
