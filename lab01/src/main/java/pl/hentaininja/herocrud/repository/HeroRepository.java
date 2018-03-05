public interface HeroRepository {
    public void initDatabase();
    public List<Hero> getAll();
    public void add(Hero h);
    public Hero getById(long id);
    public Hero getByName(String name);
}