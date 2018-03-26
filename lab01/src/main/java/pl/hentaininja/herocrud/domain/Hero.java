package pl.hentaininja.herocrud.domain;

public class Hero {
    private int id;
    private String name;
    private String klasa;

    public Hero(){}

    public Hero(int id, String name, String klasa){
        this.id = id;
        this.name = name;
        this.klasa = klasa;
    }

    public int getid()
    {
        return id;
    }
    public void setid(int id)
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