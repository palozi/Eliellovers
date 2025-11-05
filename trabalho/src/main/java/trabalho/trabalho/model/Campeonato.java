package trabalho.trabalho.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToMany
    @JoinTable(
            name = "campeonato_time",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private Set<Time> times = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "pontuacao", joinColumns = @JoinColumn(name = "campeonato_id"))
    @MapKeyColumn(name = "time_id")
    @Column(name = "pontos")
    private Map<Long, Integer> pontuacoes = new HashMap<>();

    public Campeonato() {
    }

    public Campeonato(Long id, String nome, LocalDate dataInicio, LocalDate dataFim, Set<Time> times, Map<Long, Integer> pontuacoes) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.times = times;
        this.pontuacoes = pontuacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Set<Time> getTimes() {
        return times;
    }

    public void setTimes(Set<Time> times) {
        this.times = times;
    }

    public Map<Long, Integer> getPontuacoes() {
        return pontuacoes;
    }

    public void setPontuacoes(Map<Long, Integer> pontuacoes) {
        this.pontuacoes = pontuacoes;
    }


}
