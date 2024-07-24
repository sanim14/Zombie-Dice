public class ZombieDie
{
    public static final int NOT_ROLLED = 0;
    public static final int RUNNER = 1;
    public static final int BRAIN = 2;
    public static final int SHOT = 3;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int YELLOW = 3;
    private int dieColor;
    private int value;

    public ZombieDie(int dieColor)
    {
        this.dieColor = dieColor;
        value = NOT_ROLLED;
    }

    public int getValue()
    {
        return value;
    }

    public int getDieColor()
    {
        return dieColor;
    }

    public void setDieColor(int dieColor)
    {
        this.dieColor = dieColor;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public String toString()
    {
        if (value == NOT_ROLLED)
        {
            if (dieColor == RED)
            {
                return "RED";
            }
            else if (dieColor == GREEN)
            {
                return "GREEN";
            }
            else
            {
                return "YELLOW";
            }
        }
        else
        {
            if (dieColor == RED)
            {
                if (value == 1)
                {
                    return "RED - " + "RUNNER";
                }
                else if (value == 2)
                {
                    return "RED - " + "BRAIN";
                }
                else
                {
                    return "RED - " + "SHOT";
                }
            }
            else if (dieColor == GREEN)
            {
                if (value == 1)
                {
                    return "GREEN - " + "RUNNER";
                }
                else if (value == 2)
                {
                    return "GREEN - " + "BRAIN";
                }
                else
                {
                    return "GREEN - " + "SHOT";
                }
            }
            else
            {
                if (value == 1)
                {
                    return "YELLOW - " + "RUNNER";
                }
                else if (value == 2)
                {
                    return "YELLOW - " + "BRAIN";
                }
                else
                {
                    return "YELLOW - " + "SHOT";
                }
            }
        }
    }


    public void roll()
    {
        value = NOT_ROLLED;
    }
}
