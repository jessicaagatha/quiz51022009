/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022009;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Asus
 */
public class QuizSimpanData {
    public void simpanData(String Nama, String nim, String nilaitugas, String nilaiquiz, String nilaimid, String nilaifinal, String nilaiakhir, String hitung, String lulus){
        /*Try dibuat untuk mengantisipasi error sehingga 
        program dapat berjalan walaupun ada error*/
        try{
            FileOutputStream fout=new FileOutputStream("mahasiswa.dat",true);
            DataOutputStream out=new DataOutputStream(fout);   
            /* Dibawah ini merupakan program untuk mengisi data ke dalam file mahasiswa.dat*/
            out.writeUTF(Nama);
            out.writeUTF(nim);
            out.writeUTF(nilaitugas);
            out.writeUTF(nilaiquiz);
            out.writeUTF(nilaimid);
            out.writeUTF(nilaifinal);
            out.writeUTF(nilaiakhir);
            out.writeUTF(hitung);
            out.writeUTF(lulus);
            out.close();
        }catch(IOException e){
        }
    }
    // Metode Fungsi
    public Object[][] getDataFromFile() {
    try {
        /*object*/
        FileInputStream fin = new FileInputStream("mahasiswa.dat");
        DataInputStream in = new DataInputStream(fin);
        ArrayList<Object[]> data = new ArrayList<>();
        
        /* Perulangan untuk menampilkan data mahasiswa*/
        while (in.available() > 1) {
            String Nama = in.readUTF();
            String nim = in.readUTF();
            String nilaitugas = in.readUTF();
            String nilaiquiz = in.readUTF();
            String nilaimid = in.readUTF();
            String nilaifinal = in.readUTF();
            String nilaiakhir = in.readUTF();
            String hitung = in.readUTF();
            String lulus = in.readUTF();

            /*membuat array*/
            Object[] row = {Nama, nim, nilaitugas, nilaiquiz, nilaimid, nilaifinal, nilaiakhir, hitung, lulus};
            /*Menambahkan item dalam array*/
            data.add(row);
        }
        in.close();
        //mengubah data yang disimpan dalam ArrayList ke bentuk matriks dua dimensi (array dua dimensi). 
        //Ini berguna jika kita ingin mengelola data dalam format matriks dalam bentuk ArrayList.
        Object[][] dataArray = new Object[data.size()][];
        data.toArray(dataArray);

       //Perulangan untuk menampilkan array dalam bentuk string
        for (Object[] row : dataArray) {
            System.out.println(Arrays.toString(row));
        }

        return dataArray;
    } catch (IOException e) {
        System.out.println(e.toString());
    }
    return null;
}

}
