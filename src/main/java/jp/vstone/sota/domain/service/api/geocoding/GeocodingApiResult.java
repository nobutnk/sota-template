/**
 * 
 */
package jp.vstone.sota.domain.service.api.geocoding;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nobutnk
 *
 */
@XmlRootElement(name = "result")
public class GeocodingApiResult {

    private String version;
    
    private String address;
    
    private String url;
    
    private String needsToVerify;
    
    private String googleMaps;
    
    private Coordinate coordinate;

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the needsToVerify
     */
    @XmlElement(name = "needs_to_verify")
    public String getNeedsToVerify() {
        return needsToVerify;
    }

    /**
     * @param needsToVerify the needsToVerify to set
     */
    public void setNeedsToVerify(String needsToVerify) {
        this.needsToVerify = needsToVerify;
    }

    /**
     * @return the googleMaps
     */
    @XmlElement(name = "google_maps")
    public String getGoogleMaps() {
        return googleMaps;
    }

    /**
     * @param googleMaps the googleMaps to set
     */
    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }

    /**
     * @return the coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * @param coordinate the coordinate to set
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
