interface IRenderable
{
    public void render();
}

class HTMLRenderer implements IRenderable
{
    public void render()
    {
        System.out.println("HTML Renderer rendering");
    }
}

class WindowRenderer implements IRenderable
{
    public void render()
    {
        System.out.println("Window Renderer rendering");
    }
}

interface IClickable
{
    public void onClick();
}

class HTMLClickable implements IClickable 
{
    public void onClick() 
    {
        System.out.println("HTML click handler");
    }
}

class WindowClickable implements IClickable
{
    public void onClick()
    {
        System.out.println("Window click handler");
    }
}

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
    IRenderable iRenderable = new WindowRenderer();
    IClickable iClickable = new WindowClickable();
    public void render()
    {
        iRenderable.render();
    }

    public void onClick()
    {
        iClickable.onClick();
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

public class FactoryNStrategy
{
    public static void main(String args[])
    {
        WindowDialog wd = new WindowDialog();
        HTMLDialog hd = new HTMLDialog();
        wd.render();
        hd.render();
    }
}