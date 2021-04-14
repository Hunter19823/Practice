package blockchain;

public class BlockChain {
    public static void main( String[] args )
    {
        long timeStamp = 0;
        Block<String> block = new Block<String>("Pie gave Spiker $5","0000000000001",timeStamp);
        System.out.println(block);
        block = block.link("Spike robbed Pie for $5",++timeStamp);
        System.out.println(block);
        block = block.link("Pie shot Spike for $5",++timeStamp);
        System.out.println(block);
        block = block.link("Spike came back and slapped Pie for $5",++timeStamp);
        System.out.println(block);
    }
}
