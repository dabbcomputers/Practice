
interface INavigator
{
    public void BuildRoute();
}

interface IRouter 
{
    void BuildRoute();
}

class CarRouter implements IRouter 
{
    public void BuildRoute()
    {
        System.out.println("CarRouter");
    }
}

class BikeRouter implements IRouter 
{
    public void BuildRoute()
    {
        System.out.println("BikeRouter");
    }
}

class Navigator implements INavigator
{
    public IRouter router = null;
    public void SetRouter(IRouter r)
    {
        router = r;
    }
    public void BuildRoute()
    {
        router.BuildRoute();
    }
}

public class Strategy
{
    public static void main(String args[])
    {
        Navigator navtigator  = new Navigator();
        navtigator.SetRouter(new BikeRouter());
        navtigator.BuildRoute();
        navtigator.SetRouter(new CarRouter());
        navtigator.BuildRoute();
    }
}