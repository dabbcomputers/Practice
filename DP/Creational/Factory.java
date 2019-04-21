interface IDialog
{
    public void render();
    public IButton createButton();
}

class WindowDialog implements IDialog
{
    public void render()
    {
        IButton button = createButton();
        button.render();
        button.onClick();
    }

    public IButton createButton()
    {
        return new WindowButton();
    }
}

class HTMLDialog implements IDialog
{
    public void render()
    {
        IButton button = createButton();
        button.render();
        button.onClick();
    }

    public IButton createButton()
    {
        return new HTMLButton();
    }
}


interface IButton
{
    public void render();
    public void onClick();
}

class WindowButton implements IButton
{
    public void render()
    {
        System.out.println("Window button rendered");
    }

    public void onClick()
    {
        System.out.println("Window button clicked");
    }
}

class HTMLButton implements IButton
{
    public void render()
    {
        System.out.println("HTML button rendered");
    }

    public void onClick()
    {
        System.out.println("HTML button clicked");
    }
}

public class Factory
{
    public static void main(String args[])
    {
        WindowDialog wd = new WindowDialog();
        HTMLDialog hd = new HTMLDialog();
        wd.render();
        hd.render();
    }
}