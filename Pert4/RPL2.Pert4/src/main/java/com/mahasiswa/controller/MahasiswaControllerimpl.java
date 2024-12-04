/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.ModelMahasiswa;
import com.mahasiswa.model.HibernateUtil;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;

/**
 *
 * @author ZWEI
 */
public class MahasiswaControllerimpl implements MahasiswaController{

    @Override
    public void addMhs(ModelMahasiswa mhs) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

          Transaction trx = null;
          
          try (Session session = HibernateUtil.getSessionFactory().openSession()){
              trx = session.beginTransaction();
              session.save(mhs);
              trx.commit();
          }catch(Exception e){
              if (trx != null){
                  trx.rollback();
              }
              e.printStackTrace();  
          }
    }

    @Override
    public ModelMahasiswa getMhs(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMhs(ModelMahasiswa mhs) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

         Transaction trx = null;
          
          try (Session session = HibernateUtil.getSessionFactory().openSession()){
              trx = session.beginTransaction();
              session.update(mhs);
              trx.commit();
          }catch(Exception e){
              if (trx != null){
                  trx.rollback();
              }
              e.printStackTrace();  
          }
    }

    @Override
    public void deleteMhs(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Transaction trx = null;
          
          try (Session session = HibernateUtil.getSessionFactory().openSession()){
              trx = session.beginTransaction();
              ModelMahasiswa mhs = session.get(ModelMahasiswa.class, id);
              session.delete(mhs);
              trx.commit();
          }catch(Exception e){
              if (trx != null){
                  trx.rollback();
              }
              e.printStackTrace();  
          }
    }
    
     public List<ModelMahasiswa> searchMhs (String query){
        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            Query<ModelMahasiswa> queryObj = session.createQuery("FROM mahasiswa WHERE npm LIKE :query OR nama LIKE :query", ModelMahasiswa.class);
            queryObj.setParameter("query", "%" + query + "%");
            listMhs = queryObj.list();
            trx.commit();
        } catch (Exception e){
            if (trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
        return listMhs;
    }

    @Override
    public List<ModelMahasiswa> getAllMahasiswa() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null;
          
          try (Session session = HibernateUtil.getSessionFactory().openSession()){
              trx = session.beginTransaction();
              Query<ModelMahasiswa> query = session.createQuery("from mahasiswa", ModelMahasiswa.class);
              listMhs = query.list();
              
          }catch(Exception e){
              if (trx != null){
                  trx.rollback();
              }
              e.printStackTrace();  
          }
          
          return listMhs;
    }

}

