package org.kersevanivan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.kersevanivan.request.VAGRequest;
import org.kersevanivan.vag.responseStationSearch.HaltestellenAPIResponse;
import org.kersevanivan.vag.responseStationSearch.Json;

import java.io.IOException;

public class Controller implements Observer {

    @FXML
    public TextField station;
    @FXML
    public TextArea response;
    @FXML
    public Label metadata_version;
    @FXML
    public Label metadata_timestamp;
    // Our call to the rest api.
    private final VAGRequest request = new VAGRequest();

    public void searchStation(MouseEvent mouseEvent) throws IOException {
        //TODO: This is called when the search button is pressed. Make a request. The Controller must react somehow
        // when a response is sent. At least update must be called from somewhere to achieve this. Make it work!
    }

    @Override
    public void update(String value) {
        try {
            Json json = new Json();
            HaltestellenAPIResponse stations = json.getStation(value);
            String stationsAsText =  stations.getHaltestellenAsString();
            // TODO: Now we have got the response from the webservice. Insert it into the text area, and metadata_*
            // fields.
        } catch (IOException e) {
            e.printStackTrace(); // TODO: Log the error somehow.
        }
    }

}
