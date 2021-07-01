package com.coba.cobaspringweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Mahasiswa {

  @Id
  private Integer nim;
  private String nama;
  private String jurusan;
  private Integer angkatan;

  @Version
  @Column(name = "optVersion", columnDefinition = "Integer DEFAULT 0")
  private Integer version;

  public Integer getNim() {
    return this.nim;
  }

  public void setNim(Integer nim) {
    this.nim = nim;
  }

  public String getNama() {
    return this.nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getJurusan() {
    return this.jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public Integer getAngkatan() {
    return this.angkatan;
  }

  public void setAngkatan(Integer angkatan) {
    this.angkatan = angkatan;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

}
