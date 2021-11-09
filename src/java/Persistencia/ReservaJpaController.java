package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Huesped;
import Logica.Habitacion;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ReservaJpaController() {
        emf = Persistence.createEntityManagerFactory("Obino_Mayra_TpfinalCom1PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped id_huesped = reserva.getId_huesped();
            if (id_huesped != null) {
                id_huesped = em.getReference(id_huesped.getClass(), id_huesped.getId_persona());
                reserva.setId_huesped(id_huesped);
            }
            Habitacion id_habitacion = reserva.getId_habitacion();
            if (id_habitacion != null) {
                id_habitacion = em.getReference(id_habitacion.getClass(), id_habitacion.getIdHabitacion());
                reserva.setId_habitacion(id_habitacion);
            }
            em.persist(reserva);
            if (id_huesped != null) {
                id_huesped.getListaReservas().add(reserva);
                id_huesped = em.merge(id_huesped);
            }
            if (id_habitacion != null) {
                id_habitacion.getListaReservas().add(reserva);
                id_habitacion = em.merge(id_habitacion);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error - " + ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId_reserva());
            Huesped id_huespedOld = persistentReserva.getId_huesped();
            Huesped id_huespedNew = reserva.getId_huesped();
            Habitacion id_habitacionOld = persistentReserva.getId_habitacion();
            Habitacion id_habitacionNew = reserva.getId_habitacion();
            if (id_huespedNew != null) {
                id_huespedNew = em.getReference(id_huespedNew.getClass(), id_huespedNew.getId_persona());
                reserva.setId_huesped(id_huespedNew);
            }
            if (id_habitacionNew != null) {
                id_habitacionNew = em.getReference(id_habitacionNew.getClass(), id_habitacionNew.getIdHabitacion());
                reserva.setId_habitacion(id_habitacionNew);
            }
            reserva = em.merge(reserva);
            if (id_huespedOld != null && !id_huespedOld.equals(id_huespedNew)) {
                id_huespedOld.getListaReservas().remove(reserva);
                id_huespedOld = em.merge(id_huespedOld);
            }
            if (id_huespedNew != null && !id_huespedNew.equals(id_huespedOld)) {
                id_huespedNew.getListaReservas().add(reserva);
                id_huespedNew = em.merge(id_huespedNew);
            }
            if (id_habitacionOld != null && !id_habitacionOld.equals(id_habitacionNew)) {
                id_habitacionOld.getListaReservas().remove(reserva);
                id_habitacionOld = em.merge(id_habitacionOld);
            }
            if (id_habitacionNew != null && !id_habitacionNew.equals(id_habitacionOld)) {
                id_habitacionNew.getListaReservas().add(reserva);
                id_habitacionNew = em.merge(id_habitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reserva.getId_reserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId_reserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Huesped id_huesped = reserva.getId_huesped();
            if (id_huesped != null) {
                id_huesped.getListaReservas().remove(reserva);
                id_huesped = em.merge(id_huesped);
            }
            Habitacion id_habitacion = reserva.getId_habitacion();
            if (id_habitacion != null) {
                id_habitacion.getListaReservas().remove(reserva);
                id_habitacion = em.merge(id_habitacion);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
