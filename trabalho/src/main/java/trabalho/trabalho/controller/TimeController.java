package trabalho.trabalho.controller;

import trabalho.trabalho.model.Time;
import trabalho.trabalho.repository.TimeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeRepository repo;

    public TimeController(TimeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Time> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Time criar(@RequestBody Time time) {
        return repo.save(time);
    }
}
