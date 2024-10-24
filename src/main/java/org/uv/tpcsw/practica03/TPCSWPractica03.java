package org.uv.tpcsw.practica03;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class TPCSWPractica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Empleado empleado = new Empleado();
        empleado.setClave(2);
        empleado.setNombre("Habacuc hibernate");
        empleado.setDireccion("Calle 2 Av Pinos");
        empleado.setTelefono("274154465");

        /* Departamento depto = new Departamento();
        depto.setNombre("depto2"); */
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Departamento depto2 = session.get(Departamento.class, 1l);
        if (depto2!=null) {
            System.out.println("Departamento: " + depto2.getNombre()+ " Clave: " + depto2.getClave());
            Set<Empleado> empleados = depto2.getEmpleados();
            for (Empleado e : empleados) {
                System.out.println("Empleado: " + e.getNombre());
            }


            /* empleado.setDepto(depto2);
        } else {
            System.out.println("No se encontro el departamento");
        }

        session.save(empleado); */
        t.commit();
    }
}

}
//comenatario