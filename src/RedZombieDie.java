public class RedZombieDie extends ZombieDie
{

    public RedZombieDie()
    {
        super(ZombieDie.RED);
    }


    @Override
    public void roll()
    {
        int x = (int)(Math.random()*6) + 1;
        if (x == 1 || x == 2)
        {
            setValue(RUNNER);
        }
        else if (x == 3)
        {
            setValue(BRAIN);
        }
        else
        {
            setValue(SHOT);
        }
    }

}
