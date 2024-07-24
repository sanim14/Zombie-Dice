public class YellowZombieDie extends ZombieDie
{
    public YellowZombieDie()
    {
        super(ZombieDie.YELLOW);
    }

    @Override
    public void roll()
    {
        int x = (int)(Math.random()*6) + 1;
        if (x == 1 || x == 2)
        {
            setValue(RUNNER);
        }
        else if (x == 3 || x == 4)
        {
            setValue(BRAIN);
        }
        else
        {
            setValue(SHOT);
        }
    }
}

