package com.coba.cobaspringweb.controller;

import com.coba.cobaspringweb.model.Mahasiswa;
import com.coba.cobaspringweb.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MahasiswaController {

  private MahasiswaService mahasiswaService;

  @Autowired
  public void setMahasiswaService(MahasiswaService mahasiswaService) {
    this.mahasiswaService = mahasiswaService;
  }

  @RequestMapping("/")
  public String ReadMahasiswa(Model model) {
    model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());

    return "mahasiswa";
  }

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String ShowFormCreate(Model model) {
    model.addAttribute("mahasiswa", new Mahasiswa());

    return "form";
  }

  @RequestMapping(value = "/form", method = RequestMethod.POST)
  public String CreateMahasiswa(Model model, Mahasiswa mahasiswa) {
    model.addAttribute("mahasiswa", mahasiswaService.saveMahasiswa(mahasiswa));

    return "redirect:/";
  }

  @RequestMapping(value = "/edit/{nim}", method = RequestMethod.GET)
  public String EditMahasiswa(@PathVariable Integer nim, Model model) {
    model.addAttribute("mahasiswa", mahasiswaService.getNim(nim));

    return "form";
  }

  @RequestMapping(value = "/hapus/{nim}")
  public String HapusMahasiswa(@PathVariable int nim) {
    mahasiswaService.hapusMahasiswa(nim);

    return "redirect:/";
  }

}
