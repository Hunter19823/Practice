package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block<DATA> {
    private String hash;
    private DATA data;
    private String previousHash;
    private long timeStamp;

    public Block(DATA data, String previousHash, long timeStamp)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
    }
    public Block(DATA data, String previousHash)
    {
        this(data,previousHash, new Date().getTime());
    }

    public Block<DATA> link(DATA data, long timeStamp)
    {
        return new Block<>(data,this.getHash(),timeStamp);
    }

    public Block<DATA> link(DATA data)
    {
        return new Block<>(data,this.getHash());
    }

    public void calculateHash()
    {
        String dataToHash = previousHash
                + timeStamp
                + data.toString();

        MessageDigest digest = null;
        byte[] bytes = null;
        try{
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        for(byte b : bytes)
        {
            buffer.append(String.format("%02x",b));
        }
        hash = buffer.toString();
    }

    public String getHash()
    {
        if(hash == null)
            calculateHash();
        return hash;
    }

    public void setHash( String hash )
    {
        this.hash = hash;
        calculateHash();
    }

    public DATA getData()
    {
        return data;
    }

    public void setData( DATA data )
    {
        this.data = data;
        calculateHash();
    }

    public String getPreviousHash()
    {
        return previousHash;
    }

    public void setPreviousHash( String previousHash )
    {
        this.previousHash = previousHash;
        calculateHash();
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp( long timeStamp )
    {
        this.timeStamp = timeStamp;
        calculateHash();
    }

    @Override
    public String toString()
    {
        return String.format("Block: \"%s\"\n    previous: \"%s\"\n    timeStamp: %d\n    data: \"%s\"",
                getHash(),
                previousHash,
                timeStamp,
                data
        );
    }
}
