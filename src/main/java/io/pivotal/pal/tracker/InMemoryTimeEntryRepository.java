package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    Map<Long,TimeEntry> timeEntryMap = new HashMap<Long,TimeEntry>();
    private Long privateId = 0L;


    @Override
    public TimeEntry create(TimeEntry any) {
        any.setId(++privateId);
        timeEntryMap.put(any.getId(),any);
        return any;
    }

    @Override
    public TimeEntry find(long timeEntryId) {


        return  timeEntryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry any) {
        if(timeEntryMap.containsKey(timeEntryId)){
            any.setId(timeEntryId);
            timeEntryMap.replace(timeEntryId,any);
        }
        else {

            //timeEntryMap.put(timeEntryId,any);
        }

        return timeEntryMap.get(timeEntryId);
    }

    @Override
    public TimeEntry delete(long timeEntryId) {
        TimeEntry localTimeEntry = timeEntryMap.remove(timeEntryId);
        return localTimeEntry;
    }
}
