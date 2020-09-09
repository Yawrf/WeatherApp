
package weatherapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author rewil
 */
public class Condition {
    
    private String name;
    private ArrayList<String> seasons = new ArrayList<>();
    private ArrayList<String> genres = new ArrayList<>();
    private Map<String, Integer> options = new HashMap<>();
    
    public Condition(String name) {
        this.name = name;
    }
    public void addSeason(String season) {
        seasons.add(season);
    }
    public void addGenre(String genre) {
        genres.add(genre);
    }
    public void addOption(String name, Integer weight) {
        options.put(name, weight);
    }
    
    public String getName() {
        return name;
    }
    
    public String[] getSeasons() {
        return seasons.toArray(new String[seasons.size()]);
    }
    public boolean isInSeason(String... s) {
        for(String t : s) if(seasons.contains(t)) return true;
        return false;
    }
    
    public String[] getGenres() {
        return genres.toArray(new String[genres.size()]);
    }
    public boolean isInGenre(String... s) {
        for(String t : s) if(genres.contains(t)) return true;
        return false;
    }
    
    public Map<String, Integer> getOptions() {
        return options;
    }
    
    @Override
    public String toString() {
        String out = "";
        out += getName() + " | " + Arrays.toString(getSeasons()) + " | " + Arrays.toString(getGenres()) + " | " + options.size() + " options";
        return out;
    }
    
  //----------------------------------------------------------------------------
    
    private int getTotalWeight() {
        int out = 0;
        for(Integer i : options.values()) {
            out += i;
        }
        return out;
    }
    
        private Random rand = new Random();
    private int getRandomWeight() {
        return rand.nextInt(getTotalWeight()) + 1;
    }
    
    private String getOptionByWeight(int weight) {
        String out = "";
        for(String s : options.keySet()) {
            if(options.get(s) < weight) {
                weight -= options.get(s);
            } else {
                out = s;
                break;
            }
        }
        return out;
    }
    
    public String getRandomOption() {
        return getOptionByWeight(getRandomWeight());
    }
    
}
