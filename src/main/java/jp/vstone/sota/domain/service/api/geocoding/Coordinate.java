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
@XmlRootElement(name = "coordinate")
public class Coordinate {

    private String lat;
    
    private String lng;
    
    
    private String latDms;
    
    
    private String lngDms;

    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return the latDms
     */
    @XmlElement(name = "lat_dms")
    public String getLatDms() {
        return latDms;
    }

    /**
     * @param latDms the latDms to set
     */
    public void setLatDms(String latDms) {
        this.latDms = latDms;
    }

    /**
     * @return the lngDms
     */
    @XmlElement(name = "lng_dms")
    public String getLngDms() {
        return lngDms;
    }

    /**
     * @param lngDms the lngDms to set
     */
    public void setLngDms(String lngDms) {
        this.lngDms = lngDms;
    }
}
