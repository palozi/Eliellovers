package trabalho.trabalho.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "times")
    private Set<Campeonato> campeonatos = new HashSet<>();


    public Time(Long id, String nome, Set<Campeonato> campeonatos) {
        this.id = id;
        this.nome = nome;
        this.campeonatos = campeonatos;
    }

    public Time() {
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

    public Set<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Set<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }
}
