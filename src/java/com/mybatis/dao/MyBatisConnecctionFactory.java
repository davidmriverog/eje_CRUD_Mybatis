package com.mybatis.dao;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConnecctionFactory {
    
    private static SqlSessionFactory sqlSessionFactory;
    
    static{
        
        try {
            
            String resource="com/mybatis/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            
            if(sqlSessionFactory==null){
                
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Implementamos los metodos para llamar la Conexion
    public static SqlSessionFactory getSqlSessionFactory(){ 
        
        return sqlSessionFactory;
    }
}
