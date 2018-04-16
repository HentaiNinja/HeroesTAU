package pl.hentaininja.herocrud.domain;

public class Battle
{
    private String heroes;
    private String foes;
    private String fightResult;


    public Battle(String heroes,String foes, String fightResult) {
        this.heroes = heroes;
        this.foes = foes;
        this.fightResult = fightResult;    
    }
}