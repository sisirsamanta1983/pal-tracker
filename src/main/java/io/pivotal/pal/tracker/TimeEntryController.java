package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
    //return new ResponseEntity();

        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);

    }

    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry != null)
        {

            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);

        }
        //return new ResponseEntity<>(timeEntryRepository.find(timeEntryId),HttpStatus.OK);
        //return null;
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        //return new ResponseEntity<>("list",HttpStatus.OK);
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
        //return null;
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry updated = timeEntryRepository.update(timeEntryId,expected);
        if(updated==null){
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
else
        return new ResponseEntity<TimeEntry>(updated,HttpStatus.OK);



      /*  TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry != null)
        {


        }
        else
        {


        }
*/
        //return null;
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        return new ResponseEntity<TimeEntry>(timeEntryRepository.delete(timeEntryId),HttpStatus.NO_CONTENT);
        //return null;
    }
}
