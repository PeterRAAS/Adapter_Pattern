import model.DatumAdapter;
import model.DatumInfo;
import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 9/12/2018<br/>
 * Time: 15:29<br/>
 * To change this template use File | Settings | File Templates.
 */
public class DatumAdapterTest {

    private DatumAdapter datumAdapter;
    private DatumInfo datumInfo;
    private String isoDatum = "2018-12-08";
    private String euroFormaat = "dd.MM.yyyy";

    @Before
    public void setUp() throws Exception {

        datumAdapter = new DatumAdapter();
        datumInfo = new DatumAdapter();
        datumInfo.setDatumIso(isoDatum);

    }


    @Test
    public void test_getDatumIso_waarde_ok() {

        assertEquals("2018-12-08", datumInfo.getDatumIso());
    }

    @Test
    public void test_getDatumEuro_waarde_ok() {

        assertEquals("08.12.2018", datumInfo.getDatumEuro());
    }

    @Test
    public void test_getDatumUsa_waarde_ok() {

        assertEquals("12.08.2018", datumInfo.getDatumUsa());
    }

    @Test
    public void test_getDatumDmy_waarde_ok() {

        assertEquals("08/12/18", datumInfo.getDatumDmy());
    }

    @Test
    public void test_getDatumMdy_waarde_ok() {

        assertEquals("12/08/18", datumInfo.getDatumMdy());
    }

    @Test
    public void test_isoToEuro_conversie_ok() {

        assertEquals("08.12.2018", datumAdapter.IsoToEuro("2018-12-08"));
    }

    @Test
    public void test_isoToUsa_conversie_ok() {

        assertEquals("12.08.2018", datumAdapter.IsoToUsa("2018-12-08"));
    }

    @Test
    public void test_isoToDmy_conversie_ok() {

        assertEquals("08/12/18", datumAdapter.IsoToDmy("2018-12-08"));

    }

    @Test
    public void test_isoToMdy_conversie_ok() {

        assertEquals("12/08/18", datumAdapter.IsoToMdy("2018-12-08"));
    }

    @Test
    public void test_datumConversie_conversie_ok() {

        assertEquals("08.12.2018", datumAdapter.DatumConversie(euroFormaat, isoDatum));
    }

    @Test
    public void test_datumConversie_conversie_maand_niet_ok() {

        try {

            assertEquals("08.12.2018", datumAdapter.DatumConversie(euroFormaat, "2012-20-01"));

        } catch (DateTimeParseException ex) {

            //ex.printStackTrace();
        }
    }

    @Test
    public void test_datumConversie_conversie_dag_niet_ok() {

        try {

            assertEquals("08.12.2018", datumAdapter.DatumConversie(euroFormaat, "2012-12-35"));

        } catch (DateTimeParseException ex) {

            //ex.printStackTrace();
        }
    }

}