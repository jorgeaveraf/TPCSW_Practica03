/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.tpcsw.practica03;

import java.util.List;

/**
 *
 * @author habacuc
 */
public interface IDAOGeneral <T, ID>{
      public boolean save(T pojo);
    public boolean delete(ID id);
    public boolean update(T pojo, ID id);
    public List<T> findAll();
    public T findById(ID id);
}