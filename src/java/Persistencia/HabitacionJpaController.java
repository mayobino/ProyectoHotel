
package Persistencia;

import Logica.Habitacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HabitacionJpaController implements Serializable {

    public HabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public HabitacionJpaController() {
        emf = Persistence.createEntityManagerFactory("Obino_Mayra_TpfinalCom1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Habitacion habitacion) throws PreexistingEntityException, Exception {
        if (habitacion.getListaReservas() == null) {
            habitacion.setListaReservas(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Reserva> attachedListaReservas = new ArrayList<Reserva>();
            for (Reserva listaReservasReservaToAttach : habitacion.getListaReservas()) {
                listaReservasReservaToAttach = em.getReference(listaReservasReservaToAttach.getClass(), listaReservasReservaToAttach.getId_reserva());
                attachedListaReservas.add(listaReservasReservaToAttach);
            }
            habitacion.setListaReservas(attachedListaReservas);
            em.persist(habitacion);
            for (Reserva listaReservasReserva : habitacion.getListaReservas()) {
                Habitacion oldId_habitacionOfListaReservasReserva = listaReservasReserva.getId_habitacion();
                listaReservasReserva.setId_habitacion(habitacion);
                listaReservasReserva = em.merge(listaReservasReserva);
                if (oldId_habitacionOfListaReservasReserva != null) {
                    oldId_habitacionOfListaReservasReserva.getListaReservas().remove(listaReservasReserva);
                    oldId_habitacionOfListaReservasReserva = em.merge(oldId_habitacionOfListaReservasReserva);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHabitacion(habitacion.getIdHabitacion()) != null) {
                throw new PreexistingEntityException("Habitacion " + habitacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Habitacion habitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion persistentHabitacion = em.find(Habitacion.class, habitacion.getIdHabitacion());
            List<Reserva> listaReservasOld = persistentHabitacion.getListaReservas();
            List<Reserva> listaReservasNew = habitacion.getListaReservas();
            List<Reserva> attachedListaReservasNew = new ArrayList<Reserva>();
            for (Reserva listaReservasNewReservaToAttach : listaReservasNew) {
                listaReservasNewReservaToAttach = em.getReference(listaReservasNewReservaToAttach.getClass(), listaReservasNewReservaToAttach.getId_reserva());
                attachedListaReservasNew.add(listaReservasNewReservaToAttach);
            }
            listaReservasNew = attachedListaReservasNew;
            habitacion.setListaReservas(listaReservasNew);
            habitacion = em.merge(habitacion);
            for (Reserva listaReservasOldReserva : listaReservasOld) {
                if (!listaReservasNew.contains(listaReservasOldReserva)) {
                    listaReservasOldReserva.setId_habitacion(null);
                    listaReservasOldReserva = em.merge(listaReservasOldReserva);
                }
            }
            for (Reserva listaReservasNewReserva : listaReservasNew) {
                if (!listaReservasOld.contains(listaReservasNewReserva)) {
                    Habitacion oldId_habitacionOfListaReservasNewReserva = listaReservasNewReserva.getId_habitacion();
                    listaReservasNewReserva.setId_habitacion(habitacion);
                    listaReservasNewReserva = em.merge(listaReservasNewReserva);
                    if (oldId_habitacionOfListaReservasNewReserva != null && !oldId_habitacionOfListaReservasNewReserva.equals(habitacion)) {
                        oldId_habitacionOfListaReservasNewReserva.getListaReservas().remove(listaReservasNewReserva);
                        oldId_habitacionOfListaReservasNewReserva = em.merge(oldId_habitacionOfListaReservasNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = habitacion.getIdHabitacion();
                if (findHabitacion(id) == null) {
                    throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion habitacion;
            try {
                habitacion = em.getReference(Habitacion.class, id);
                habitacion.getIdHabitacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.", enfe);
            }
            List<Reserva> listaReservas = habitacion.getListaReservas();
            for (Reserva listaReservasReserva : listaReservas) {
                listaReservasReserva.setId_habitacion(null);
                listaReservasReserva = em.merge(listaReservasReserva);
            }
            em.remove(habitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Habitacion> findHabitacionEntities() {
        return findHabitacionEntities(true, -1, -1);
    }

    public List<Habitacion> findHabitacionEntities(int maxResults, int firstResult) {
        return findHabitacionEntities(false, maxResults, firstResult);
    }

    private List<Habitacion> findHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Habitacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Habitacion findHabitacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Habitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Habitacion> rt = cq.from(Habitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
