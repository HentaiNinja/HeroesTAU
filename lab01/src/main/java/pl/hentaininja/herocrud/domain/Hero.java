package pl.hentaininja.herocrud.domain;

public class Hero {
    private int Id;
    private String name;
    private String klasa;

    public Hero(){}

    public Hero(int id, String name, String klasa){
        this.Id = id;
        this.name = name;
        this.klasa = klasa;
    }

    public int getid()
    {
        return Id;
    }
    public void setid(int id)
    {
        this.Id = id;
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