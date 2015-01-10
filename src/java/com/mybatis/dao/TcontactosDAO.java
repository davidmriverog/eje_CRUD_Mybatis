package com.mybatis.dao;

import com.mybatis.models.Tcontactos;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TcontactosDAO {
    
    private SqlSessionFactory sqlSessionFactory;

    public TcontactosDAO() {
        
        // Inicializamos La SessionFactory
        sqlSessionFactory = MyBatisConnecctionFactory.getSqlSessionFactory();
    }
    
    @SuppressWarnings("unchecked")
    // Consulta de Todos los Datos
    public List<Tcontactos> selectAll(){
        /*
        En Este metodo llamandos la consulta desde el Mapper XML
        y almacenamos el resultado en una Lista de Arreglo
        "ArrayList"
        */
        
        // Abrimos Session
        SqlSession session = sqlSessionFactory.openSession();
        
        // Efectuamos el Llamado del Procedimiento de la Consulta
        try{
            List<Tcontactos> list = session.selectList("Tcontactos.getAll");
            return list;
        }finally{
            session.close();
        }
    }
    
    // Llama Solamente un Registro Mediante un ID
    public Tcontactos selectById(int id){
        
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            Tcontactos contact = (Tcontactos) session.selectOne("Tcontactos.getById",id);
            return contact;
        } finally {
            session.close();
        }
    }
    
    // Insercion de Datos
    public void insert(Tcontactos contact){
        
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            session.insert("Tcontactos.insert",contact);
            session.commit();
        }finally {
            session.close();
        }
    }
    
    // Actualizacion de Datos
    public void update(Tcontactos contact){
        
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            session.update("Tcontactos.update",contact);
            session.commit();
        }finally {
            session.close();
        }
        
    }
    
    // Eliminacion del Registro
    public void delete(int id){
        
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            
            session.delete("Tcontactos.delete", id);
            session.commit();
        } finally{
            session.close();
        }
    }
    
    
}
