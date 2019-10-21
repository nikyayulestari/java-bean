/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zain
 */
public class Nilai_Siswa {
    String Nama = null;
    String Pelajaran = null;
    char Nilai = 0;
    
    public Nilai_Siswa(String _Nama, String _Pelajaran, char _Nilai)
    {
        this.Nama = _Nama;
        this.Pelajaran = _Pelajaran;
        this.Nilai = _Nilai;
    }
    
    public String getNama()
    {
        return Nama;
    }
     public String getPelajaran()
    {
        return Pelajaran;
    }
      public char getNilai()
    {
        return Nilai;
    }
}
