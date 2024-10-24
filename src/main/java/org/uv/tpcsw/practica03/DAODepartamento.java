/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcsw.practica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author josegtz
 */
public class DAODepartamento implements IDAOGeneral<Departamento, Long>{
    @Override
    public boolean save(Departamento pojo) {
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
            Departamento departamento = session.get(Departamento.class, id);
            if (departamento != null) {
                session.delete(departamento);
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
    public boolean update(Departamento pojo, Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Departamento departamento = session.get(Departamento.class, id);
            if (departamento != null) {
                departamento.setNombre(pojo.getNombre()); // Aquí puedes modificar según los campos que necesites actualizar
                session.update(departamento);
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
    public List<Departamento> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Query<Departamento> query = session.createQuery("FROM Departamento", Departamento.class);
            List<Departamento> departamentos = query.getResultList();
            t.commit();
            return departamentos;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public Departamento findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Departamento departamento = session.get(Departamento.class, id);
            t.commit();
            return departamento;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
//comenatario
