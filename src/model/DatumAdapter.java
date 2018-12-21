package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 8/12/2018<br/>
 * Time: 9:15<br/>
 * To change this template use File | Settings | File Templates.
 */
public class DatumAdapter extends DatumReporter implements DatumInfo {

    @Override
    public String getDatumIso() {
        return datumIso;
    }

    @Override
    public void setDatumIso(String datumIso){

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {

            Date date= formatter.parse(datumIso);
        }
        catch (ParseException e) {

        }
            this.datumIso = datumIso;
    }



    @Override
    public String getDatumEuro() {
        return IsoToEuro(datumIso);
    }


    @Override
    public String getDatumUsa() {
        return IsoToUsa(datumIso);
    }


    @Override
    public String getDatumDmy() {
        return IsoToDmy(datumIso);
    }


    @Override
    public String getDatumMdy() {
        return IsoToMdy(datumIso);
    }


    public String IsoToEuro(String Iso) {

        return DatumConversie("dd.MM.yyyy", Iso);
    }

    public String IsoToUsa(String Iso) {

        return DatumConversie("MM.dd.yyyy", Iso);

    }

    public String IsoToDmy(String Iso) {

        return DatumConversie("dd/MM/yy", Iso);

    }

    public String IsoToMdy(String Iso) {

        return DatumConversie("MM/dd/yy", Iso);

    }

    public String DatumConversie(String conversieFormaat, String Iso) {
        try {

            LocalDate datum = LocalDate.parse(Iso);
            DateTimeFormatter formaat = DateTimeFormatter.ofPattern(conversieFormaat);

            return formaat.format(datum);

       } catch (DateTimeParseException ex) {
            throw ex;
        }

    }

}
