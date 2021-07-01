package com.coba.cobaspringweb.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.coba.cobaspringweb.model.Mahasiswa;
import com.coba.cobaspringweb.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaImplement implements MahasiswaService {

  private EntityManagerFactory entityManagerFactory;

  @Autowired
  public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @Override
  public List<Mahasiswa> listMahasiswa() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    return entityManager.createQuery("FROM Mahasiswa", Mahasiswa.class).getResultList();
  }

  @Override
  public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    Mahasiswa simpan = entityManager.merge(mahasiswa);
    entityManager.getTransaction().commit();

    return simpan;
  }

  @Override
  public Mahasiswa getNim(Integer nim) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    return entityManager.find(Mahasiswa.class, nim);
  }

  @Override
  public void hapusMahasiswa(Integer nim) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.remove(entityManager.find(Mahasiswa.class, nim));
    entityManager.getTransaction().commit();
  }

}
