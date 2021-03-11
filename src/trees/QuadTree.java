package trees;

import java.awt.*;
import java.util.ArrayList;

public class QuadTree<TYPE extends Point> {
    public static void main(String[] args)
    {

    }
    public enum Direction
    {
        NORTH_WEST(0), NORTH_EAST(1), SOUTH_WEST(2), SOUTH_EAST(3);
        public final int index;
        Direction(int index)
        {
            this.index = index;
        }

        public int getIndex()
        {
            return index;
        }
    }

    public static final int CAPACITY = 4;

    private Rectangle boundary;

    private QuadTree<TYPE> northWest;
    private QuadTree<TYPE> northEast;
    private QuadTree<TYPE> southWest;
    private QuadTree<TYPE> southEast;

    private Point[] data;

    public QuadTree(Rectangle boundary)
    {
        this.boundary = boundary;
        this.data = new Point[CAPACITY];
        northWest = null;
        northEast = null;
        southWest = null;
        southEast = null;
    }

    public Rectangle getBoundary()
    {
        return boundary;
    }

    public void setBoundary(Rectangle boundary)
    {
        this.boundary = boundary;
    }

    public TYPE getData(Direction direction)
    {
        TYPE data = null;
        if(direction != null) data = (TYPE) this.data[direction.index];
        return data;
    }

    public void setData(Point[] data)
    {
        this.data = data;
    }
}
