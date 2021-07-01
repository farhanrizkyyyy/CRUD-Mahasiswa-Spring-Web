package com.coba.cobaspringweb.services;

import java.util.List;

import com.coba.cobaspringweb.model.Mahasiswa;

public interface MahasiswaService {
  List<Mahasiswa> listMahasiswa();
  Mahasiswa saveMahasiswa(Mahasiswa mahasiswa);
  Mahasiswa getNim(Integer nim);
  public void hapusMahasiswa(Integer nim);
}
