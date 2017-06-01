/**
 * 
 */
package jp.vstone.sota.domain.service.api.simpleapi;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nobutnk
 *
 */
@XmlRootElement(name = "station")
public class Station {

    private String name;
    private String furigana;
    private String line;
    private String url; 
    private String city;
    private String prefecture;
    private String direction;
    private String directionReverse;
    private String distance;
    private String distanceM;
    private String distanceKm;
    private String traveltime;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the furigana
     */
    public String getFurigana() {
        return furigana;
    }
    /**
     * @param furigana the furigana to set
     */
    public void setFurigana(String furigana) {
        this.furigana = furigana;
    }
    /**
     * @return the line
     */
    public String getLine() {
        return line;
    }
    /**
     * @param line the line to set
     */
    public void setLine(String line) {
        this.line = line;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the prefecture
     */
    public String getPrefecture() {
        return prefecture;
    }
    /**
     * @param prefecture the prefecture to set
     */
    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }
    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }
    /**
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    /**
     * @return the directionReverse
     */
    public String getDirectionReverse() {
        return directionReverse;
    }
    /**
     * @param directionReverse the directionReverse to set
     */
    public void setDirectionReverse(String directionReverse) {
        this.directionReverse = directionReverse;
    }
    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }
    /**
     * @param distance the distance to set
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }
    /**
     * @return the distanceM
     */
    public String getDistanceM() {
        return distanceM;
    }
    /**
     * @param distanceM the distanceM to set
     */
    public void setDistanceM(String distanceM) {
        this.distanceM = distanceM;
    }
    /**
     * @return the distanceKm
     */
    public String getDistanceKm() {
        return distanceKm;
    }
    /**
     * @param distanceKm the distanceKm to set
     */
    public void setDistanceKm(String distanceKm) {
        this.distanceKm = distanceKm;
    }
    /**
     * @return the traveltime
     */
    public String getTraveltime() {
        return traveltime;
    }
    /**
     * @param traveltime the traveltime to set
     */
    public void setTraveltime(String traveltime) {
        this.traveltime = traveltime;
    }
}
