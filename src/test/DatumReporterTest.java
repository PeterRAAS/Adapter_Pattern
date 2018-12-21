import model.DatumAdapter;
import model.DatumReporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 9/12/2018<br/>
 * Time: 15:26<br/>
 * To change this template use File | Settings | File Templates.
 */
public class DatumReporterTest {

    DatumReporter reporter = new DatumReporter();

    @Before
    public void setUp() throws Exception {

        reporter.setDatum("2018-12-05");

    }

    @Test
    public void getDatum() {

        assertEquals("2018-12-05",reporter.getDatum());

    }


}