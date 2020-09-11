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

    public void searchStation(MouseEvent mouseEvent) throws IOException {
        VAGRequest request = new VAGRequest();
        request.register(this);
        request.requestStations( station.getText() );
    }

    @Override
    public void update(String value) {
        try {
            Json json = new Json();
            HaltestellenAPIResponse stations = json.getStation(value);
            response.setText( stations.getHaltestellenAsString() );
            metadata_timestamp.setText("Abfragezeitpunkt: " + stations.getMetadata().getTimestamp()); //TODO: That is not nice! Any Idea why?
            metadata_version.setText("Version: " + stations.getMetadata().getVersion());
        } catch (IOException e) {
            e.printStackTrace(); // TODO: Log the error somehow.
        }
    }

}
