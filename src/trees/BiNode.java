package trees;

import java.awt.*;

public class BiNode<DATA extends Comparable<DATA>> {
    private DATA data;
    private BiNode<DATA> left;
    private BiNode<DATA> right;

    public BiNode(DATA data){
        this(data,null,null);
    }
    public BiNode(DATA data, BiNode<DATA> left){
        this(data,left,null);
    }
    public BiNode(DATA data, BiNode<DATA> left, BiNode<DATA> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public DATA getData()
    {
        return data;
    }

    public void setData(DATA data)
    {
        this.data = data;
    }

    public BiNode<DATA> getLeft()
    {
        return left;
    }

    public void setLeft(BiNode<DATA> left)
    {
        this.left = left;
    }

    public BiNode<DATA> getRight()
    {
        return right;
    }

    public void setRight(BiNode<DATA> right)
    {
        this.right = right;
    }

    public BiNode<DATA> findMin()
    {
        BiNode<DATA> current = this;
        while(current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    public BiNode<DATA> findMax()
    {
        BiNode<DATA> current = this;
        while(current.getRight() != null)
            current = current.getRight();
        return current;
    }

    public Dimension findDimensions()
    {
        return new Dimension(findWidth(),findDepth());
    }

    public int findDepth()
    {
        return this.findDepth(1);
    }

    private int findDepth(int depth)
    {
        int tempDepth = depth;
        if(this.getRight() != null)
            depth = Math.max(depth,this.getRight().findDepth(tempDepth+1));
        if(this.getLeft() != null)
            depth = Math.max(depth,this.getLeft().findDepth(tempDepth+1));
        return depth;
    }

    public int findWidth()
    {
        int left=0,right=0;
        BiNode<DATA> current = this;
        do{
            left++;
            current = current.getLeft();
        }while(current != null);
        current = this;
        do{
            right++;
            current = current.getRight();
        }while(current != null);
        return left+right-1;
    }

    public int compareTo(BiNode<DATA> other)
    {
        if(other == null)
            throw new NullPointerException("Attempting to Compare Node to null.");
        return this.getData().compareTo(other.getData());
    }

    public boolean equal(BiNode<DATA> node)
    {
        boolean result = false;

        result |= node.compareTo(this) == 0;

        return result;
    }
    public boolean lessThan(BiNode<DATA> node)
    {
        boolean result = false;

        result |= node.compareTo(this) < 0;

        return result;
    }
    public boolean lessThanEqual(BiNode<DATA> node)
    {
        boolean result = false;

        result |= node.compareTo(this) <= 0;

        return result;
    }
    public boolean greaterThan(BiNode<DATA> node)
    {
        boolean result = false;

        result |= node.compareTo(this) > 0;

        return result;
    }
    public boolean greaterThanEqual(BiNode<DATA> node)
    {
        boolean result = false;

        result |= node.compareTo(this) >= 0;

        return result;
    }

    public void print()
    {
        System.out.println(buildTree());
    }
    public String buildTree()
    {
        StringBuilder builder = new StringBuilder();
        buildTree(builder,"    ");
        return builder.toString();
    }
    public void buildTree(StringBuilder builder)
    {
        buildTree(builder, "");
    }
    public void buildTree(StringBuilder builder, String pattern)
    {
        buildTree(builder, pattern,0);
    }
    public void buildTree(StringBuilder builder, String pattern, int spacing)
    {
        if (this.getLeft() != null){
            this.getLeft().buildTree(builder,pattern,spacing + 1);
        }
        builder.append(String.format("%s%-"+(spacing+1)+"d%n",pattern.repeat(spacing),this.getData()));
        if (this.getRight() != null) {
            this.getRight().buildTree(builder,pattern,spacing + 1);
        }
    }


    @Override
    public String toString()
    {
        return "BiNode{" +
                "data=" + data +
                ", left=" + (left!=null) +
                ", right=" + (right!=null) +
                '}';
    }
}
