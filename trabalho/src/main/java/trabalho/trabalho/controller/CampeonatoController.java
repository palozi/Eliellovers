package trabalho.trabalho.controller;

import trabalho.trabalho.model.Campeonato;
import trabalho.trabalho.service.CampeonatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService service;

    public CampeonatoController(CampeonatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Campeonato> listar() {
        return service.listar();
    }

    @PostMapping
    public Campeonato criar(@RequestBody Campeonato campeonato) {
        return service.criar(campeonato);
    }

    @PostMapping("/{id}/times/{timeId}")
    public Campeonato adicionarTime(@PathVariable Long id, @PathVariable Long timeId) {
        return service.adicionarTime(id, timeId);
    }

    @PutMapping("/{id}/pontuacao/{timeId}")
    public Campeonato atualizarPontuacao(@PathVariable Long id, @PathVariable Long timeId, @RequestParam int pontos) {
        return service.atualizarPontuacao(id, timeId, pontos);
    }
}
