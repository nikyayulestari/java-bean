/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utama;

import model.Nilai_Siswa;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// transform untuk save
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


/**
 *
 * @author zain
 */
public class xmlToList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Nilai_Siswa> mahasiswa = new ArrayList ();
        String Nama, Pelajaran, RootElemen, RowElemen;
        char Nilai;
        
        
       File fileXML = new File("mahasiswa.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("mahasiswa");

       for (int i = 1; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          //System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             Nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             Pelajaran = eElement.getElementsByTagName("Pelajaran").item(0).getTextContent();
             Nilai = eElement.getElementsByTagName("Nilai").item(0).getTextContent().charAt(0);
             mahasiswa.add(new Nilai_Siswa(Nama, Pelajaran, Nilai));
             System.out.println("\nNama      : " + Nama);
             System.out.println("Pelajaran : " + Pelajaran);
             System.out.println("Nilai     : " + Nilai);
             

          }
       }
    }
}
