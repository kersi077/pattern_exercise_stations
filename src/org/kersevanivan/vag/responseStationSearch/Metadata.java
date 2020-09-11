package org.kersevanivan.vag.responseStationSearch;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * <p>Title: Metadata</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:36
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metadata {
    private String Version;
    private String Timestamp;
    @JsonGetter("Version")
    public String getVersion() {
        return Version;
    }
    @JsonSetter("Version")
    public void setVersion(String version) {
        Version = version;
    }
    @JsonGetter("Timestamp")
    public String getTimestamp() {
        return Timestamp;
    }
    @JsonSetter("Timestamp")
    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }
}
