package org.kersevanivan.vag.responseStationSearch;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * <p>Title: HaltestelleDto.</p>
 * <p>Description: A DTO for calling the webapi of the VAG - Verkehrsaktiengesellschaft public transport company in Nuernberg, Germany.
 * Follows the wording of VAG. Look at https://start.vag.de/dm/swagger/ui/index#!/Haltestellen/Haltestellen_GetByName </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:36
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HaltestelleDto {

    private String haltestellenname; // The names follow the fields returned by the VAG-Rest-API
    private String VAGKennung;
    private int VGNKennung;
    private double longitude;
    private double latitude;
    private String produkte;

    @JsonGetter("Haltestellenname")
    public String getHaltestellenname() {
        return haltestellenname;
    }
    @JsonSetter("Haltestellenname")
    public void setHaltestellenname(String haltestellenname) {
        this.haltestellenname = haltestellenname;
    }
    @JsonGetter("VAGKennung")
    public String getVAGKennung() {
        return VAGKennung;
    }
    @JsonSetter("VAGKennung")
    public void setVAGKennung(String VAGKennung) {
        this.VAGKennung = VAGKennung;
    }
    @JsonGetter("VGNKennung")
    public int getVGNKennung() {
        return VGNKennung;
    }
    @JsonSetter("VGNKennung")
    public void setVGNKennung(int VGNKennung) {
        this.VGNKennung = VGNKennung;
    }
    @JsonGetter("Longitude")
    public double getLongitude() {
        return longitude;
    }
    @JsonSetter("Longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @JsonGetter("Latitude")
    public double getLatitude() {
        return latitude;
    }
    @JsonSetter("Latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @JsonGetter("Produkte")
    public String getProdukte() {
        return produkte;
    }
    @JsonSetter("Produkte")
    public void setProdukte(String produkte) {
        this.produkte = produkte;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Haltestellenname: ") // TODO: This is not nice. Tell me why. Any idea?
                .append( this.haltestellenname)
                .append("\nVAG Kennung: ")
                .append( this.VAGKennung )
                .append("\nVGN Kennung: ")
                .append( this.VGNKennung )
                .append("\nBreitengrad: ")
                .append( this.latitude)
                .append("\nLängengrad: ")
                .append( this.longitude)
                .append("\nProdukte: ")
                .append( this.produkte)
                .append("\n");
        ;

        return  builder.toString();
    }
}

