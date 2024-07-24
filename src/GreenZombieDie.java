public class GreenZombieDie extends ZombieDie
{

    public GreenZombieDie()
    {
        super(ZombieDie.GREEN);
    }

    @Override
    public void roll()
    {
        int x = (int)(Math.random()*6) + 1;
        if (x == 1 || x == 2)
        {
            setValue(RUNNER);
        }
        else if (x == 3 || x == 4 || x == 5)
        {
            setValue(BRAIN);
        }
        else
        {
            setValue(SHOT);
        }
    }
}
