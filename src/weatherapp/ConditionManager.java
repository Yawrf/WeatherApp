
package weatherapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author rewil
 */
public class ConditionManager {
    
    private final ConfigReader cr = new ConfigReader();
    private Map<String, Condition> conditions = new HashMap<>(); 
    private String[] seasons;
    private String[] genres;
    private Random rand = new Random();
    
    private ArrayList<String> enabledSeasons = new ArrayList<>();
    private ArrayList<String> enabledGenres = new ArrayList<>();
    
    public ConditionManager() {
        seasons = parseSimple(cr.readSeasons());
        genres = parseSimple(cr.readGenres());
        for(Condition c : parseConditions(cr.readConditions())) {
            conditions.put(c.getName(), c);
        }
    }
    
    /**
     * Returns null if 100 tries go by without finding a valid Condition
     * @return 
     */
    public Condition getCondition() {
        int max = 100;
        Condition c = getRandomCondition();
        while(!isValid(c)) {
            --max;
            if(max == 0) return null;
            c = getRandomCondition();
        }
        return c;
    }
    /**
     * Returns null if 100 tries to by without finding a valid Condition
     * @param before
     * @return 
     */
    public Condition getCondition(Condition before) {
        int max = 100;
        Condition c = getFollowingCondition(before);
        while(!isValid(c)) {
            --max;
            if(max == 0) return null;
            c = getFollowingCondition(before);
        }
        return c;
    }
    
    private Condition getRandomCondition() {
        return conditions.values().toArray(new Condition[conditions.size()])[rand.nextInt(conditions.size())];
    }
    private Condition getFollowingCondition(Condition c) {
        return conditions.get(c.getRandomOption());
    }
    private boolean isValid(Condition c) {
        return (c.isInSeason(getEnabledSeasons()) && c.isInGenre(getEnabledGenres()));
    }
    
  //----------------------------------------------------------------------------
    
    public String[] getSeasons() {
        return seasons;
    }
    public String[] getGenres() {
        return genres;
    }
    public String[] getEnabledSeasons() {
        return enabledSeasons.toArray(new String[enabledSeasons.size()]);
    }
    public String[] getEnabledGenres() {
        return enabledGenres.toArray(new String[enabledGenres.size()]);
    }
    
    public void enableSeason(String season) {
        if(!enabledSeasons.contains(season)) enabledSeasons.add(season);
    }
    public void disableSeason(String season) {
        enabledSeasons.remove(season);
    }
    public void enableGenre(String genre) {
        if(!enabledGenres.contains(genre)) enabledGenres.add(genre);
    }
    public void disableGenre(String genre) {
        enabledGenres.remove(genre);
    }
    
  //----------------------------------------------------------------------------
    
    /**
     * For parsing Seasons and Genres
     * @param s
     * @return 
     */
    private String[] parseSimple(String s) {
        String[] split = s.split("\n");
        ArrayList<String> out = new ArrayList<>();
        for(String t : split) {
            if(t.startsWith("-")) {
                out.add(t.substring(1).trim());
            }
        }
        return out.toArray(new String[out.size()]);
    }
    
    private ArrayList<Condition> parseConditions(String s) {
        ArrayList<Condition> out = new ArrayList<>();
        Condition current = null;
        
        String[] split = s.split("\n");
        for(int i = 0; i < split.length; ++i) {
            if(split[i].isEmpty()) continue;
            switch(split[i].charAt(0)) {
                case '-': {
                    if(current != null) out.add(current);
                    current = new Condition(split[i].substring(1).trim());
                }   break;
                case '$': current.addSeason(split[i].substring(1).trim());
                    break;
                case '&': current.addGenre(split[i].substring(1).trim());
                    break;
                case '>': {
                    String[] temp = split[i].substring(1).split("%");
                    int weight = 0;
                    try {
                        weight = Integer.parseInt(temp[1].trim());
                    } catch (Exception e) {
                        System.out.println(temp[0].trim() + " has an invalid weight: " + temp[1]);
                    }
                    current.addOption(temp[0].trim(), weight);
                }   break;
            }
        }
        out.add(current);
        
        return out;
    }
    
}
