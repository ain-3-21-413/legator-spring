package kg.inai.legator.controller;


import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.service.PatronService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/patrons")
@RestController
public class PatronController {

    final PatronService patronService;

    @GetMapping("/{patron-group-name}")
    public List<PatronDto> getPatronsByGroup(@PathVariable("patron-group-name") String patronGroupName) {
        return patronService.getPatronsByGroup(patronGroupName);
    }

    @GetMapping
    public List<PatronDto> getPatrons() {
        return patronService.getPatrons();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveOrUpdatePatron(@RequestBody PatronDto patronDto) {
        patronService.saveOrUpdatePatron(patronDto);
    }

    @GetMapping("/exists")
    public boolean existsPatronByStudentNumber(@RequestParam("student-number") String studentNumber) {
        return patronService.existsPatronByStudentNumber(studentNumber);
    }
}
