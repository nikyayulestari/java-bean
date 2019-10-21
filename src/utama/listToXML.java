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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author zain
 */
public class listToXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Nilai_Siswa> mahasiswa = new ArrayList ();
        mahasiswa.add(new Nilai_Siswa("Nikeisha","Matematika",'A'));
        mahasiswa.add(new Nilai_Siswa("Deandra","Fisika",'B'));
        mahasiswa.add(new Nilai_Siswa("Kanaya","Biologi",'C'));

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("mahasiswa");
       doc.appendChild(rootElement);
       
       for(int i=0; i<mahasiswa.size();i++){
           Element elemen_mahasiswa = doc.createElement("mahasiswa");
           elemen_mahasiswa.removeAttribute("");
           rootElement.appendChild(elemen_mahasiswa);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(mahasiswa.get(i).getNama());
           elemen_mahasiswa.appendChild(fieldNama);

           
           Element fieldPelajaran = doc.createElement("Pelajaran");
           fieldPelajaran.setTextContent(mahasiswa.get(i).getPelajaran());
           elemen_mahasiswa.appendChild(fieldPelajaran);
           
           Element fieldNilai = doc.createElement("Nilai");
           String stringNilai = String.valueOf(mahasiswa.get(i).getNilai());
           fieldNilai.setTextContent(stringNilai);
           elemen_mahasiswa.appendChild(fieldNilai);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("mahasiswa.xml"));
       transformer.transform(dom, result);
    }
}
