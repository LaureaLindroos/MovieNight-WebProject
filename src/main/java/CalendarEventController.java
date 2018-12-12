import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CalendarEventController {

    public static Event event () {
        Instant now = LocalDateTime.of(2018, 12, 13, 10, 10).toInstant(ZoneOffset.UTC);
        DateTime now2 = new DateTime(Date.from(now));

        Instant end = LocalDateTime.of(2018, 12, 16,10, 10).toInstant(ZoneOffset.UTC);
        DateTime end2 = new DateTime(Date.from(end));

        Event event = new Event();

        event.setStart(new EventDateTime().setDateTime(now2));
        event.setEnd(new EventDateTime().setDateTime(end2));
        event.setDescription("Middag");
        event.setLocation("Malmö");

        return event;
    }

}
