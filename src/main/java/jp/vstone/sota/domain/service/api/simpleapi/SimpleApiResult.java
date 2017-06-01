/**
 * 
 */
package jp.vstone.sota.domain.service.api.simpleapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nobutnk
 *
 */
@XmlRootElement(name = "result")
public class SimpleApiResult {

    private Station[] stations;

    /**
     * @return the stations
     */
    @XmlElement(name="station")
    public Station[] getStations() {
        return stations;
    }

    /**
     * @param stations the stations to set
     */
    public void setStations(Station[] stations) {
        this.stations = stations;
    }
}
