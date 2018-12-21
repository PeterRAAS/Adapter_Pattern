package model;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 7/12/2018<br/>
 * Time: 20:07<br/>
 * To change this template use File | Settings | File Templates.
 */
public class DatumReporter {

    String datumIso;

    public DatumReporter() {

    }

    public String getDatum() {
        return datumIso;
    }

    public void setDatum(String datumIso) {

        this.datumIso = datumIso;

    }



}
