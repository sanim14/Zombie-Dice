import java.util.ArrayList;

public class ZombieDiceBucket
{
    private ArrayList<ZombieDie> bucket;

    public ZombieDiceBucket()
    {
        bucket = new ArrayList<ZombieDie> (13);
    }

    public void loadBucket()
    {
        bucket.clear();
        bucket.add(new GreenZombieDie());
        bucket.add(new GreenZombieDie());
        bucket.add(new GreenZombieDie());
        bucket.add(new GreenZombieDie());
        bucket.add(new GreenZombieDie());
        bucket.add(new GreenZombieDie());
        bucket.add(new YellowZombieDie());
        bucket.add(new YellowZombieDie());
        bucket.add(new YellowZombieDie());
        bucket.add(new YellowZombieDie());
        bucket.add(new RedZombieDie());
        bucket.add(new RedZombieDie());
        bucket.add(new RedZombieDie());
    }


    public ZombieDie draw()
    {
        ZombieDie x;

        if (bucket.size() == 0)
        {
            return null;
        }
        else
        {
            x =  bucket.remove((int)(Math.random()*bucket.size()));
            return x;
        }
    }
}
