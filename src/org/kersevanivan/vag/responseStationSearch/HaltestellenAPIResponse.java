package org.kersevanivan.vag.responseStationSearch;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * <p>Title: StationResponse</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:36
 */
public class HaltestellenAPIResponse {

    private Metadata metadata;
    private List<HaltestelleDto> haltestellen; // The names follow the fields returned by the VAG-Rest-API

    @JsonGetter("Metadata")
    public Metadata getMetadata() {
        return metadata;
    }
    @JsonSetter("Metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonGetter("Haltestellen")
    public List<HaltestelleDto> getHaltestellen() {
        return haltestellen;
    }

    public String getHaltestellenAsString() {
       StringBuilder builder = new StringBuilder();
       haltestellen.stream().forEach(haltestelleDto -> builder.append( haltestelleDto.toString() ).append("\n") );
       return builder.toString();
    }
    @JsonSetter("Haltestellen")
    public void setHaltestellen(List<HaltestelleDto> haltestellen) {
        this.haltestellen = haltestellen;
    }

}
