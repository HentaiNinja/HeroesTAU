package pl.hentaininja.domain;

public class Hero {
    private Int Id;
    private String name;
    private String class;

    public Hero(){}

    public Hero(int id, String name, String class){
        this.id = id;
        this.name = name;
        this.class = class;
    }

    public Int getid()
    {
        return id;
    }
    public void setid(Int id)
    {
        this.id = id;
    }    
    
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }

    public String getclass()
    {
        return class;
    }
    public void setclass(String class)
    {
        this.class = class;
    }
}