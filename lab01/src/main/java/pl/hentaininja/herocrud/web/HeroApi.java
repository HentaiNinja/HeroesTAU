package pl.hentaininja.herocrud.web;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.hentaininja.herocrud.domain.Hero;
import pl.hentaininja.herocrud.repository.HeroRepository;

@RestController
public class HeroApi
{
    @Autowired
    HeroRepository heroRepository;

    @RequestMapping("/")
    public String index()
    {
        return "Just checking if everything works";
    }

    @RequestMapping(value = "/hero", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long addHero(@RequestBody Hero h)
    {
            return new Long(heroRepository.add(h));
    }
    
    @RequestMapping(value = "/hero", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hero> getHeroes() throws SQLException
    {
        List<Hero> hero = new LinkedList<Hero>();
        for(Hero h : heroRepository.getAll())
        {
                hero.add(h);
        }
        return hero;
    }

    @RequestMapping(value = "/hero/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Long deleteHero(@PathVariable("id") Long id) throws SQLException {
        return new Long(heroRepository.delete(id));
    }

    @RequestMapping(value= "/hero/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hero getHero(@PathVariable("id") Long id) throws SQLException
    {
        return heroRepository.getById(id);
    }

    @RequestMapping(value = "/hero/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long updateHero(@PathVariable("id") Long id ,@RequestBody Hero h ) throws SQLException
    {
        return new Long(heroRepository.update(h, id));
    }
}