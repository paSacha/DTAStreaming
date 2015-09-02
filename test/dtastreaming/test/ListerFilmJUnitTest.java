package dtastreaming.test;

import dtastreaming.entity.Film;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ETY
 */
public class ListerFilmJUnitTest {
    
    @Test
    public void listerFilmUsa() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
       Collection<Film> cf = em.createQuery("SELECT f FROM Film f WHERE f.pays.id = 'usa'").getResultList(); 
        System.out.println("Film réalisé au USA: " + cf);
    }
    
    @Test
    public void listerFilmDrole() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
       Collection<Film> cf = em.createQuery("SELECT f FROM Film f JOIN f.genres g WHERE g.id = 'Drole'").getResultList(); 
        System.out.println("Film drôle: " + cf);
    }
    
    @Test
    public void listerFilmDroleEtUsa() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
//      Collection<Film> cf = em.createQuery("SELECT f FROM Film f JOIN f.genres g WHERE g.id = 'Drole' AND f.pays.id = 'usa'").getResultList(); 
        
        Collection<Film> cf = em.createQuery("SELECT f FROM Film f JOIN f.genres g JOIN f.pays p WHERE g.id = 'Drole' AND p.id = 'usa'").getResultList(); 
        System.out.println("Film drôle et réalisé au USA: " + cf);
    }
    
    @Test
    public void listerFilmNoLien() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf = em.createQuery("SELECT f FROM Film f WHERE 0=(SELECT COUNT (l) FROM f.liens l)").getResultList(); 
        System.out.println("Film avec zéro lien: " + cf);
    }
    
    @Test
    public void listerFilmAvecNoLien() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf = em.createQuery("SELECT f2 FROM Film f2 WHERE f2.id NOT IN (SELECT f.id FROM Film f WHERE 0=(SELECT COUNT (l) FROM f.liens l))").getResultList(); 
        System.out.println("Film avec pas zéro lien: " + cf);
    }
    
    @Test
    public void listerFilmPasGenreQT() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf; 

        cf = em.createQuery("SELECT f2 FROM Film f2 JOIN f2.genres g WHERE g.id  NOT IN "
               + "(SELECT g FROM Genre g JOIN g.films f JOIN f.filmCastings fc JOIN fc.casting c WHERE c.nom = 'Boby' AND fc.role=dtastreaming.entity.RoleEnum.REAL)").getResultList();

        System.out.println("Film dont le genre n'est pas réalisé par Boby: " + cf);
    }
    
    @Test
    public void listerFilmDroleWithAlex() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf; 

        cf = em.createQuery("SELECT f FROM Film f JOIN f.genres g JOIN f.filmCastings fc JOIN fc.casting c WHERE c.nom = 'Alexander' AND g.id = 'Drole' AND fc.role=dtastreaming.entity.RoleEnum.ACTOR").getResultList();

        System.out.println("Film drole avec Alexander: " + cf);
    }
    
    @Test
    public void listerFilmAllParam() {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf; 

        cf = em.createQuery("SELECT f FROM Film f "
                + "JOIN f.genres g "
                + "JOIN f.pays p "
                + "JOIN f.filmCastings fc "
                + "JOIN fc.casting c "
                + "WHERE c.nom = 'Bruce Lee' "
                + "AND g.id = 'Kung Fu' "
                + "AND f.title LIKE '%Dragon%' " //permet de chercher un mot dans un chaine de carac
                + "AND f.annee = 2005 "
                + "AND p.id = 'Coree' "
                + "AND fc.role=dtastreaming.entity.RoleEnum.ACTOR").getResultList();

        System.out.println("Film avec tous les params: " + cf);
    }
}
