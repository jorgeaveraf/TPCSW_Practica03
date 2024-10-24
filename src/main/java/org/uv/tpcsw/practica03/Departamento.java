package org.uv.tpcsw.practica03;
import java.io.Serializable;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamentos_clave_seq")
    @SequenceGenerator(name = "departamentos_clave_seq", sequenceName = "departamentos_clave_seq", allocationSize = 1)
    @Column(name = "clave")

    private long clave;
    private String nombre;
    
    @OneToMany(mappedBy = "depto", fetch = FetchType.LAZY)
    private Set<Empleado> empleados;

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepto(this);
    }

    public void removeEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setDepto(null);
    }


    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public long getClave() {
        return clave;
    }
    public void setClave(long clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    


}
//comenatario