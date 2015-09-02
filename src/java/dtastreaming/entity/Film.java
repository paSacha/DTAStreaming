/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author ETY
 */
@Entity
@Table ( )
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 64, nullable = false)
    private String title;
    
    private String resume;
    private Integer annee;
    private Integer duree;

    public Film() {
    }

    public Film(Long id, String title, String resume, Integer annee, Integer duree) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.annee = annee;
        this.duree = duree;
    }

    public Collection<FilmCasting> getFilmCastings() {
        return filmCastings;
    }

    public void setFilmCastings(Collection<FilmCasting> filmCastings) {
        this.filmCastings = filmCastings;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @OneToMany (mappedBy = "film", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<Lien> liens = new ArrayList<Lien>();
    
    @ManyToMany 
    @JoinTable(
      name="genre_film",
      joinColumns={@JoinColumn(name="film_id")},
      inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Collection<Genre> genres = new ArrayList<Genre>();

    public Collection<Genre> getGenres() {
        return genres;
    }

    @OneToMany (mappedBy = "film", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<FilmCasting> filmCastings = new ArrayList<FilmCasting>();
    
    @ManyToOne
    private Pays pays;
    
    public Collection<Lien> getLiens() {
        return liens;
    }

    public void setLiens(Collection<Lien> liens) {
        this.liens = liens;
    }
      
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.Film[ id=" + id + " ]";
    }
    
}
