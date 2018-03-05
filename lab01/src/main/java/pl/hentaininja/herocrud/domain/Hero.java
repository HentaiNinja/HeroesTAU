package pl.hentaininja.com;

public class Hero {
    private Int Id = null;
    private String name = null;
    private String nickName = null;
    private String str = null;
    private String dex = null;
    private String mnd = null;

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

    public String getnickName()
    {
        return nickName;
    }
    public void setnickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getstr()
    {
        return str;
    }
    public void setstr(String str)
    {
        this.str = str;
    }

    public String getdex()
    {
        return dex;
    }
    public void setdex(String dex)
    {
        this.dex = dex;
    }

    public String getmnd()
    {
        return mnd;
    }
    public void setmnd(String mnd)
    {
        this.mnd = mnd;
    }
}