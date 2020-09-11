package org.kersevanivan.request;

import org.kersevanivan.Observer;
import org.kersevanivan.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: VAGRequest.</p>
 * <p>Description: Makes a call against the VAG Web-API for public transportservices in region Nürnberg.
 * Have a look at
 * https://start.vag.de/dm/swagger/ui/index#!/Haltestellen/Haltestellen_GetByName
 * for more information.
 * </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 07.09.20 16:51
 */
public class VAGRequest implements Subject {

    private static final String URL_SCHEMA = "https://start.vag.de/dm/api/v1/haltestellen/VGN?name=";
    private List<Observer> observers = new ArrayList<>();
    private StringBuffer content = null;

    public void requestStations(String stationname) throws IOException {
        HttpURLConnection con = connect(stationname);
        int status = con.getResponseCode();
        if( status == 200 ) { // TODO: Implement other states!
            readResponse(con);
        }
        con.disconnect();
    }

    private void readResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()) );
        String inputLine;
        content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        this.callObservers();
    }

    private HttpURLConnection connect(String stationname) throws IOException {
        //https://start.vag.de/dm/api/v1/haltestellen/VGN?name=Hauptbahnhof
        URL url = new URL(URL_SCHEMA + stationname);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        return con;
    }

    @Override
    public void callObservers() {
        this.observers.stream().forEach(observer -> observer.update(content.toString()));
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }
}
