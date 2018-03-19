package pl.hentaininja.domain;

public class Hero {
    private Int Id;
    private String name;
    private String klasa;

    public Hero(){}

    public Hero(int id, String name, String klasa){
        this.id = id;
        this.name = name;
        this.klasa = klasa;
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

    public String getklasa()
    {
        return klasa;
    }
    public void setklasa(String klasa)
    {
        this.klasa = klasa;
    }
}