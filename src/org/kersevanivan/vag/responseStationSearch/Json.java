package org.kersevanivan.vag.responseStationSearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * <p>Title: Json</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 17:43
 */
public class Json {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public HaltestellenAPIResponse getStation(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, HaltestellenAPIResponse.class);
    }
}
