/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Random;
import static weatherapp.Season.*;

/**
 *
 * @author rewil
 */
public class weatherPicker {
    
    private static Category lastCat = Category.Clear;
    private static String lastOut = "Clear";
    
    /**
     * Returns a completely random weather condition
     * @return 
     */
    public String pick() {
        return pick(All, true, true, true, true, true, true, true);
    }
    
    /**
     * Returns a random weather condition from within a given Season list
     * @param season
     * @return 
     */
    public String pick(Season season) {
        return pick(season, true, true, true, true, true, true, true);
    }
    
    /**
     * Returns a random weather condition from within a given Season list, but only including extremes if true
     * @param season
     * @param extremes
     * @return 
     */
    public String pick(Season season, boolean extremes) {
        return pick(season, extremes, true, true, true, true, true, true);
    }
    
    /**
     * Returns a random weather condition from within a given Season list, only allowing subsections as marked true
     * @param season
     * @param extremes
     * @param clear
     * @param windy
     * @param cloudy
     * @param rainy
     * @param snowy
     * @param condition
     * @return 
     */
    public String pick(Season season, boolean extremes, boolean clear, boolean windy, boolean cloudy, boolean rainy, boolean snowy, boolean condition) {
        Random rand = new Random();
        String output = "";
        Boolean done = false;
        switch(season) {
            case Summer: { //<editor-fold>
                while(!done) {
                    int i = rand.nextInt(weatherapp.Summer.values().length);
                    if(i < 4 && clear) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Clear;
                    } else if(i < 7 && windy) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Windy;
                    } else if(i < 12 && cloudy) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Cloudy;
                    } else if(i < 21 && rainy) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Rainy;
                    } else if(i < 33 && condition) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Condition;
                    } else if(extremes) {
                        output = weatherString(weatherapp.Summer.values()[i].name());
                        done = true;
                        lastCat = Category.Extreme;
                        lastOut = output;
                    }
                    if(snowy && !extremes && !clear && !windy && !cloudy && !rainy && !condition) {
                        output = "No Snow in Summer";
                        done = true;
                    }
                } //</editor-fold>
            } break;
            case Autumn: { //<editor-fold>
                while(!done) {
                    int i = rand.nextInt(weatherapp.Autumn.values().length);
                    if(i < 4 && clear) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Clear;
                    } else if(i < 7 && windy) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Windy;
                    } else if(i < 12 && cloudy) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Cloudy;
                    } else if(i < 21 && rainy) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Rainy;
                    } else if(i < 25 && snowy) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Snowy;
                    } else if(i < 36 && condition) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Condition;
                    } else if(i < 38 && extremes) {
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                        done = true;
                        lastCat = Category.Extreme;
                        lastOut = output;
                    } 
                } //</editor-fold>
            } break;
            case Winter: { //<editor-fold>
                while(!done) {
                    int i = rand.nextInt(weatherapp.Winter.values().length);
                    if(i < 4 && clear) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Clear;
                    } else if(i < 7 && windy) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Windy;
                    } else if(i < 9 && cloudy) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Cloudy;
                    } else if(i < 12 && rainy) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Rainy;
                    } else if(i < 19 && snowy) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Snowy;
                    } else if(i < 27 && condition) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Condition;
                    } else if(i < 28 && extremes) {
                        output = weatherString(weatherapp.Winter.values()[i].name());
                        done = true;
                        lastCat = Category.Extreme;
                        lastOut = output;
                    } 
                } //</editor-fold>
            } break;
            case Spring: { //<editor-fold>
                while(!done) {
                    int i = rand.nextInt(weatherapp.Spring.values().length);
                    if(i < 4 && clear) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Clear;
                    } else if(i < 7 && windy) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Windy;
                    } else if(i < 12 && cloudy) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Cloudy;
                    } else if(i < 21 && rainy) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Rainy;
                    } else if(i < 24 && snowy) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Snowy;
                    } else if(i < 35 && condition) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Condition;
                    } else if(i < 38 && extremes) {
                        output = weatherString(weatherapp.Spring.values()[i].name());
                        done = true;
                        lastCat = Category.Extreme;
                        lastOut = output;
                    } 
                } //</editor-fold>
            } break;
            case All: { //<editor-fold>
                while(!done) {
                    int i = rand.nextInt(weatherapp.All.values().length);
                    if(i < 4 && clear) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Clear;
                    } else if(i < 7 && windy) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Windy;
                    } else if(i < 13 && cloudy) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Cloudy;
                    } else if(i < 22 && rainy) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Rainy;
                    } else if(i < 29 && snowy) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Snowy;
                    } else if(i < 42 && condition) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Condition;
                    } else if(i < 48 && extremes) {
                        output = weatherString(weatherapp.All.values()[i].name());
                        done = true;
                        lastCat = Category.Extreme;
                        lastOut = output;
                    } 
                } //</editor-fold>
            } break;
        }
        return output;
    }
    
    /**
     * Returns a random weather condition from within a given Season list, only allowing subsections as marked true, and following a smooth transition between picks
     * @param season
     * @param extremes
     * @param clear
     * @param windy
     * @param cloudy
     * @param rainy
     * @param snowy
     * @param condition
     * @return 
     */
    public String pickSmooth(Season season, boolean extremes, boolean clear, boolean windy, boolean cloudy, boolean rainy, boolean snowy, boolean condition) {
        Random rand = new Random();
        String output = "";
        Category current = lastCat;
        //<editor-fold>
            int temp = 0;
            temp += clear ? 1 : 0;
            temp += windy ? 1 : 0;
            temp += cloudy ? 1 : 0;
            temp += rainy ? 1 : 0;
            temp += snowy ? 1 : 0;
            if(temp == 1) {
                if(current == Category.Snowy && rainy) {
                    current = Category.Rainy;
                } else if(current == Category.Rainy && snowy) {
                    current = Category.Snowy;
                }
            } else if(temp == 0 && extremes) {
                if(!condition) {
                    current = Category.Extreme;
                    switch(season) {
                        case Summer: {
                            int i = rand.nextInt(5) + 34;
                            output = weatherString(weatherapp.Summer.values()[i].name());
                        } break;
                        case Autumn: {
                            int i = rand.nextInt(2) + 37;
                            output = weatherString(weatherapp.Autumn.values()[i].name());
                        } break;
                        case Winter: {
                            int i = 28;
                            output = weatherString(weatherapp.Winter.values()[i].name());
                        } break;
                        case Spring: {
                            int i = rand.nextInt(3) + 36;
                            output = weatherString(weatherapp.Spring.values()[i].name());
                        } break;
                        case All: {
                            int i = rand.nextInt(6) + 43;
                            output = weatherString(weatherapp.All.values()[i].name());
                        } break;
                    }
                    lastOut = output;
                } else {
                    current = Category.Condition;
                }
            }
        //</editor-fold>
        if(current != Category.Extreme) {
            if(current != Category.Condition || !condition) { //<editor-fold>
                if(condition) {
                    current = clear ? Category.Clear : windy ? Category.Windy : cloudy ? Category.Cloudy : rainy ? Category.Rainy : snowy ? Category.Snowy : Category.Clear;
                }
                boolean perm = false;
                switch (current) {
                    case Clear:
                        //<editor-fold>
                        while(!perm) {
                            switch(rand.nextInt(10) + 1) {
                                case 1: case 2: case 3: case 4: case 5: {
                                    if(clear) {
                                        perm = true;
                                    }
                                } break;
                                case 6: case 7: {
                                    if(cloudy) {
                                        current = Category.Cloudy;
                                        perm = true;
                                    }
                                } break;
                                case 8: {
                                    if(windy) {
                                        current = Category.Windy;
                                        perm = true;
                                    }
                                } break;
                                case 9: {
                                    if(rainy) {
                                        current = Category.Rainy;
                                        perm = true;
                                    }
                                } break;
                                case 10: {
                                    if(snowy) {
                                        current = Category.Snowy;
                                        perm = true;
                                    }
                                } break;
                            }
                        }
                        //</editor-fold>
                        break;
                    case Cloudy:
                        //<editor-fold>
                        while(!perm) {
                            switch(rand.nextInt(10) + 1) {
                                case 1: case 2: case 3: case 4: {
                                    if(cloudy) {
                                        perm = true;
                                    }
                                } break;
                                case 6: case 7: {
                                    if(clear) {
                                        current = Category.Clear;
                                        perm = true;
                                    }
                                } break;
                                case 5: case 8: {
                                    if(windy) {
                                        current = Category.Windy;
                                        perm = true;
                                    }
                                } break;
                                case 9: {
                                    if(rainy) {
                                        current = Category.Rainy;
                                        perm = true;
                                    }
                                } break;
                                case 10: {
                                    if(snowy) {
                                        current = Category.Snowy;
                                        perm = true;
                                    }
                                } break;
                            }
                        }
                        //</editor-fold>
                        break;
                    case Windy:
                        //<editor-fold>
                        while(!perm){
                            switch(rand.nextInt(10) + 1) {
                                case 1: case 2: case 3: case 4: {
                                    if(windy) {
                                        perm = true;
                                    }
                                } break;
                                case 6: case 7: {
                                    if(cloudy) {
                                        current = Category.Cloudy;
                                        perm = true;
                                    }
                                } break;
                                case 5: case 8: {
                                    if(clear) {
                                        current = Category.Clear;
                                        perm = true;
                                    }
                                } break;
                                case 9: {
                                    if(rainy) {
                                        current = Category.Rainy;
                                        perm = true;
                                    }
                                } break;
                                case 10: {
                                    if(snowy) {
                                        current = Category.Snowy;
                                        perm = true;
                                    }
                                } break;
                            }
                        }
                        //</editor-fold>
                        break;
                    case Rainy:
                        //<editor-fold>
                        while(!perm) {
                            switch(rand.nextInt(10) + 1) {
                                case 1: case 2: case 3: {
                                    if(rainy) {
                                        perm = true;
                                    }
                                } break;
                                case 4: case 6: case 7:  {
                                    if(cloudy) {
                                        current = Category.Cloudy;
                                        perm = true;
                                    }
                                } break;
                                case 5: case 8: case 9: {
                                    if(windy) {
                                        current = Category.Windy;
                                        perm = true;
                                    }
                                } break;
                                case 10: {
                                    if(clear) {
                                        current = Category.Clear;
                                        perm = true;
                                    }
                                } break;
                            }
                        }
                        //</editor-fold>
                        break;
                    case Snowy: 
                        //<editor-fold>
                        while(!perm) {
                            switch(rand.nextInt(10) + 1) {
                                case 1: case 2: case 3: {
                                    if(snowy) {
                                        perm = true;
                                    }
                                } break;
                                case 4: case 6: case 7: {
                                    if(cloudy) {
                                        current = Category.Cloudy;
                                        perm = true;
                                    }
                                } break;
                                case 5: case 8: case 9: {
                                    if(windy) {
                                        current = Category.Windy;
                                        perm = true;
                                    }
                                } break;
                                case 10: {
                                    if(clear) {
                                        current = Category.Clear;
                                        perm = true;
                                    }
                                } break;
                            }
                        }
                        //</editor-fold>
                        break;
                } //</editor-fold>
            } else { //<editor-fold>
                switch(season) {
                    case Summer: {
                        int i = rand.nextInt(12) + 21;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Autumn: {
                        int i = rand.nextInt(11) + 25;
                        output = weatherString(weatherapp.Autumn.values()[i].name());
                    } break;
                    case Winter: {
                        int i = rand.nextInt(8) + 19;
                        output = weatherString(weatherapp.Winter.values()[i].name());
                    } break;
                    case Spring: {
                        int i = rand.nextInt(11) + 24;
                        output = weatherString(weatherapp.Spring.values()[i].name());
                    } break;
                    case All: {
                        int i = rand.nextInt(13) + 29;
                        output = weatherString(weatherapp.All.values()[i].name());
                    } break;
                }
            } //</editor-fold>
        } else {
            output = lastOut;
        }
        switch(season) {
            case Summer: { //<editor-fold>
                switch(current) {
                    case Clear: {
                        int i = rand.nextInt(4) + 0;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Windy: {
                        int i = rand.nextInt(3) + 4;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Cloudy: {
                        int i = rand.nextInt(5) + 7;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Rainy: {
                        int i = rand.nextInt(9) + 12;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                }
            } break; //</editor-fold>
            case Autumn: { //<editor-fold>
                switch(current) {
                    case Clear: {
                        int i = rand.nextInt(4) + 0;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Windy: {
                        int i = rand.nextInt(3) + 4;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Cloudy: {
                        int i = rand.nextInt(5) + 7;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Rainy: {
                        int i = rand.nextInt(9) + 12;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Snowy: {
                        int i = rand.nextInt(4) + 21;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                }
            } break; //</editor-fold>
            case Winter: { //<editor-fold>
                switch(current) {
                    case Clear: {
                        int i = rand.nextInt(4) + 0;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Windy: {
                        int i = rand.nextInt(3) + 4;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Cloudy: {
                        int i = rand.nextInt(2) + 7;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Rainy: {
                        int i = rand.nextInt(3) + 9;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Snowy: {
                        int i = rand.nextInt(7) + 12;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                }
            } break; //</editor-fold>
            case Spring: { //<editor-fold>
                switch(current) {
                    case Clear: {
                        int i = rand.nextInt(4) + 0;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Windy: {
                        int i = rand.nextInt(3) + 4;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Cloudy: {
                        int i = rand.nextInt(5) + 7;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Rainy: {
                        int i = rand.nextInt(9) + 12;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Snowy: {
                        int i = rand.nextInt(3) + 21;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                }
            } break; //</editor-fold>
            case All: { //<editor-fold>
                switch(current) {
                    case Clear: {
                        int i = rand.nextInt(4) + 0;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Windy: {
                        int i = rand.nextInt(3) + 4;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Cloudy: {
                        int i = rand.nextInt(6) + 7;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Rainy: {
                        int i = rand.nextInt(9) + 13;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                    case Snowy: {
                        int i = rand.nextInt(7) + 22;
                        output = weatherString(weatherapp.Summer.values()[i].name());
                    } break;
                }
            } break; //</editor-fold>
        }
        lastCat = current;
        lastOut = output;
        return output;
    }
    
    public void resetLimits() {
        lastCat = Category.Clear;
    }
    
    public String getLastCategory() {
        return lastCat.name();
    }
    
    private String weatherString(String in) {
        String out = "You shouldn't see this";
        //<editor-fold>
        switch(in) {
            case "Clear": out = "Clear"; break;
            case "Sunny": out = "Sunny"; break;
            case "Bright": out = "Bright"; break;
            case "PartlyCloudy": out = "Partly Cloudy"; break;
            case "Wind": out = "Windy"; break;
            case "HighWind": out = "High Winds"; break;
            case "Breezy": out = "Breezy"; break;
            case "Cloudy": out = "Cloudy"; break;
            case "Overcast": out = "Overcast"; break;
            case "Fog": out = "Fog"; break;
            case "HeavyFog": out = "Heavy Fog"; break;
            case "LightFog": out = "Light Fog"; break;
            case "Sandstorm": out = "Sandstorm"; break;
            case "Rain": out = "Rain"; break;
            case "LightRain": out = "Light Rain"; break;
            case "Showers": out = "Showers"; break;
            case "HeavyRain": out = "Heavy Rain"; break;
            case "Downpour": out = "Downpour"; break;
            case "Deluge": out = "Deluge"; break;
            case "Storm": out = "Storm"; break;
            case "Hail": out = "Hail"; break;
            case "Mist": out = "Mist"; break;
            case "Sleet": out = "Sleet"; break;
            case "Snow": out = "Snow"; break;
            case "LightSnow": out = "Light Snow"; break;
            case "HeavySnow": out = "Heavy Snow"; break;
            case "WetSnow": out = "Wet Snow"; break;
            case "Thundersnow": out = "Thundersnow"; break;
            case "Icy": out = "Icy"; break;
            case "Hot": out = "Hot"; break;
            case "Warm": out = "Warm"; break;
            case "Cold": out = "Cold"; break;
            case "Chilly": out = "Chilly"; break;
            case "Frigid": out = "Frigid"; break;
            case "Humid": out = "Humid"; break;
            case "Muggy": out = "Muggy"; break;
            case "Dry": out = "Dry"; break;
            case "Arid": out = "Arid"; break;
            case "Parched": out = "Parched"; break;
            case "Pleasant": out = "Pleasant"; break;
            case "Mild": out = "Mild"; break;
            case "Miserable": out = "Miserable"; break;
            case "Tornados": out = "Tornados"; break;
            case "Blizzard": out = "Blizzard"; break;
            case "Hurricane": out = "Hurricane"; break;
            case "Flood": out = "Flood"; break;
            case "Drought": out = "Drought"; break;
            case "Wildfires": out = "Wildfires"; break;
        }
        //</editor-fold>
        if(out.equals("You shouldn't see this")) {
            System.out.println(in);
        }
        return out;
    }
    
}
