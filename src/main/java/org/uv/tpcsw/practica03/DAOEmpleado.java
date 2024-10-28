package org.uv.tpcsw.practica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author josegtz
**/
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public boolean save(Empleado pojo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(pojo);
        t.commit();
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                session.delete(empleado);
                t.commit();
                return true;
            } else {
                t.rollback();
                return false;
            }
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Empleado pojo, Long id) {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction t = session.beginTransaction();
    try {
        Empleado empleado = session.get(Empleado.class, id);
        if (empleado != null) {
            empleado.setClave(pojo.getClave());
            empleado.setNombre(pojo.getNombre());
            empleado.setDireccion(pojo.getDireccion());
            empleado.setTelefono(pojo.getTelefono());
            
            if (pojo.getDepto() != null) {
                Departamento nuevoDepto = session.get(Departamento.class, pojo.getDepto().getClave());
                empleado.setDepto(nuevoDepto);
            } else {
                empleado.setDepto(null);  // Si no hay departamento seleccionado, asigna null
            }
            session.update(empleado);
            t.commit();
            return true;
        } else {
            t.rollback();
            return false;
        }
    } catch (Exception e) {
        t.rollback();
        e.printStackTrace();
        return false;
    } finally {
        session.close();
    }
    }

    @Override
    public List<Empleado> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);

            List<Empleado> empleados = query.getResultList();
            t.commit();
            return empleados;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public Empleado findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Empleado empleado = session.get(Empleado.class, id);
            t.commit();
            return empleado;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
