package datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Ken Kousen on 7/14/16.
 */
public class ConvertDateTest {
    private ConvertDate cd = new ConvertDate();

    @Test
    public void convertFromDateToLD() {
        Date now = new Date();
        LocalDate localDate = cd.convertFromDateToLD(now);
        System.out.println(now + " " + localDate);
    }

    @Test
    public void convertFromDateToLDUsingString() {
        Date now = new Date();
        LocalDateTime localDateTime = cd.convertFromDateToLDUsingString(now);
        System.out.println(now + " " + localDateTime);
    }

}