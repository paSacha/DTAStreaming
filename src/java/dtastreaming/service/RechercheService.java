/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Film;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class RechercheService {
    
    public Collection<Film> listerFilmAllParam(String genre, String pays, String casting, String titre, String annee) {
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        Collection<Film> cf;
        int a = 0; String kw;
        
        String requete = "SELECT DISTINCT f FROM Film f "
                + "JOIN f.genres g "
                + "JOIN f.pays p "
                + "JOIN f.filmCastings fc "
                + "JOIN fc.casting c ";
        
        if(!"".equals(genre) && !"Tous".equals(genre)) {
            requete += "WHERE g.id = '" + genre + "' ";
            a=1;
        }
        
        if(!"".equals(pays) && !"Tous".equals(pays)) {
            if (a==1) {kw="AND";} else {kw="WHERE";} //test si c'est la première instruction
            requete += kw + " p.id = '" + pays + "' ";
            a=1;
        }
        
        if(!"".equals(annee)) {
            if (a==1) {kw="AND";} else {kw="WHERE";}
            requete += kw + " f.annee = '" + annee + "' ";
            a=1;
        }
        
        if(!"".equals(titre)) {
            if (a==1) {kw="AND";} else {kw="WHERE";}
            requete += kw + " f.title LIKE '%" + titre + "%' ";
            a=1;
        }
        
        if(!"".equals(casting)) {
            if (a==1) {kw="AND";} else {kw="WHERE";}
            requete += kw + " c.nom = '" + casting + "' ";
            a=1;
        }
        
        cf = em.createQuery(requete).getResultList();

        return cf;
    }  

}
