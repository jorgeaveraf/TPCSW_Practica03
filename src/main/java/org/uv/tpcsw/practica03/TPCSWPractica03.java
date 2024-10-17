package org.uv.tpcsw.practica03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TPCSWPractica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /* Empleado empleado = new Empleado();
        empleado.setClave(2);
        empleado.setNombre("Habacuc hibernate");
        empleado.setDireccion("Calle 2 Av Pinos");
        empleado.setTelefono("274154465"); */

        Departamento depto = new Departamento();
        depto.setNombre("depto1");
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(depto);
        t.commit();
    }
}
