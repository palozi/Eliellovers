package trabalho.trabalho.service;

import trabalho.trabalho.model.Campeonato;
import trabalho.trabalho.model.Time;
import trabalho.trabalho.repository.CampeonatoRepository;
import trabalho.trabalho.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepo;
    private final TimeRepository timeRepo;

    public CampeonatoService(CampeonatoRepository campeonatoRepo, TimeRepository timeRepo) {
        this.campeonatoRepo = campeonatoRepo;
        this.timeRepo = timeRepo;
    }

    public List<Campeonato> listar() {
        return campeonatoRepo.findAll();
    }

    public Campeonato criar(Campeonato campeonato) {
        return campeonatoRepo.save(campeonato);
    }

    public Optional<Campeonato> buscar(Long id) {
        return campeonatoRepo.findById(id);
    }

    public Campeonato adicionarTime(Long campeonatoId, Long timeId) {
        Campeonato campeonato = campeonatoRepo.findById(campeonatoId).orElseThrow();
        Time time = timeRepo.findById(timeId).orElseThrow();

        campeonato.getTimes().add(time);
        campeonato.getPontuacoes().put(timeId, 0);
        return campeonatoRepo.save(campeonato);
    }

    public Campeonato atualizarPontuacao(Long campeonatoId, Long timeId, int pontos) {
        Campeonato campeonato = campeonatoRepo.findById(campeonatoId).orElseThrow();
        campeonato.getPontuacoes().put(timeId, pontos);
        return campeonatoRepo.save(campeonato);
    }
}
