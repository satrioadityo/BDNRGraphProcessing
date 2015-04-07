/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.implementations.Graphs;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Satrio
 */
public class Main extends javax.swing.JFrame{

    /**
     * Creates new form Main
     */
    
    // Variable
    MultiGraph g;
    public Main() {
        initComponents();
        g = new MultiGraph("test");
//        Generator gn = new RandomGenerator(2);
//        gn.addSink(g);
//        gn.begin();
//        for(int i=0; i<100; i++)
//            gn.nextEvents();
//        gn.end();
//        g.display();
        
        
        g.addNode("0");
        g.getNode("0").addAttribute("name", "Dwi");
        g.getNode("0").addAttribute("password", "12345678");
        g.getNode("0").addAttribute("ui.class", "Person");
        g.getNode("0").addAttribute("ui.label", "Dwi");
        g.addNode("1");
        g.getNode("1").addAttribute("name", "Muhammad");
        g.getNode("1").addAttribute("password", "qwerty");
        g.getNode("1").addAttribute("ui.class", "Person");
        g.getNode("1").addAttribute("ui.label", g.getNode("1").getAttribute("name").toString());
        g.addNode("2");
        g.getNode("2").addAttribute("name", "Nur");
        g.getNode("2").addAttribute("password", "1234567890");
        g.getNode("2").addAttribute("ui.class", "Person");
        g.getNode("2").addAttribute("ui.label", g.getNode("2").getAttribute("name").toString());
        g.addNode("3");
        g.getNode("3").addAttribute("name", "Dewi");
        g.getNode("3").addAttribute("password", "1234");
        g.getNode("3").addAttribute("ui.class", "Person");
        g.getNode("3").addAttribute("ui.label", g.getNode("3").getAttribute("name").toString());
        g.addNode("4");
        g.getNode("4").addAttribute("name", "Tri");
        g.getNode("4").addAttribute("password", "baseball");
        g.getNode("4").addAttribute("ui.class", "Person");
        g.getNode("4").addAttribute("ui.label", g.getNode("4").getAttribute("name").toString());
        g.addNode("5");
        g.getNode("5").addAttribute("name", "Dian");
        g.getNode("5").addAttribute("password", "dragon");
        g.getNode("5").addAttribute("ui.class", "Person");
        g.getNode("5").addAttribute("ui.label", g.getNode("5").getAttribute("name").toString());
        g.addNode("6");
        g.getNode("6").addAttribute("name", "Sri");
        g.getNode("6").addAttribute("password", "football");
        g.getNode("6").addAttribute("ui.class", "Person");
        g.getNode("6").addAttribute("ui.label", g.getNode("6").getAttribute("name").toString());
        g.addNode("7");
        g.getNode("7").addAttribute("name", "Putri");
        g.getNode("7").addAttribute("password", "1234567");
        g.getNode("7").addAttribute("ui.class", "Person");
        g.getNode("7").addAttribute("ui.label", g.getNode("7").getAttribute("name").toString());
        g.addNode("8");
        g.getNode("8").addAttribute("name", "Eka");
        g.getNode("8").addAttribute("password", "monkey");
        g.getNode("8").addAttribute("ui.class", "Person");
        g.getNode("8").addAttribute("ui.label", g.getNode("8").getAttribute("name").toString());
        g.addNode("9");
        g.getNode("9").addAttribute("name", "Sari");
        g.getNode("9").addAttribute("password", "letmein");
        g.getNode("9").addAttribute("ui.class", "Person");
        g.getNode("9").addAttribute("ui.label", g.getNode("9").getAttribute("name").toString());
        g.addNode("10");
        g.getNode("10").addAttribute("name", "Ayu");
        g.getNode("10").addAttribute("password", "abc123");
        g.getNode("10").addAttribute("ui.class", "Person");
        g.getNode("10").addAttribute("ui.label", g.getNode("10").getAttribute("name").toString());
        g.addNode("11");
        g.getNode("11").addAttribute("name", "Wahyu");
        g.getNode("11").addAttribute("password", "111111");
        g.getNode("11").addAttribute("ui.class", "Person");
        g.getNode("11").addAttribute("ui.label", g.getNode("11").getAttribute("name").toString());
        g.addNode("12");
        g.getNode("12").addAttribute("name", "Indah");
        g.getNode("12").addAttribute("password", "mustang");
        g.getNode("12").addAttribute("ui.class", "Person");
        g.getNode("12").addAttribute("ui.label", g.getNode("12").getAttribute("name").toString());
        g.addNode("13");
        g.getNode("13").addAttribute("name", "Siti");
        g.getNode("13").addAttribute("password", "access");
        g.getNode("13").addAttribute("ui.class", "Person");
        g.getNode("13").addAttribute("ui.label", g.getNode("13").getAttribute("name").toString());
        g.addNode("14");
        g.getNode("14").addAttribute("name", "Ika");
        g.getNode("14").addAttribute("password", "shadow");
        g.getNode("14").addAttribute("ui.class", "Person");
        g.getNode("14").addAttribute("ui.label", g.getNode("14").getAttribute("name").toString());
        g.addNode("15");
        g.getNode("15").addAttribute("name", "Agus");
        g.getNode("15").addAttribute("password", "master");
        g.getNode("15").addAttribute("ui.class", "Person");
        g.getNode("15").addAttribute("ui.label", g.getNode("15").getAttribute("name").toString());
        g.addNode("16");
        g.getNode("16").addAttribute("name", "Fitri");
        g.getNode("16").addAttribute("password", "michael");
        g.getNode("16").addAttribute("ui.class", "Person");
        g.getNode("16").addAttribute("ui.label", g.getNode("16").getAttribute("name").toString());
        g.addNode("17");
        g.getNode("17").addAttribute("name", "Ratna");
        g.getNode("17").addAttribute("password", "superman");
        g.getNode("17").addAttribute("ui.class", "Person");
        g.getNode("17").addAttribute("ui.label", g.getNode("17").getAttribute("name").toString());
        g.addNode("18");
        g.getNode("18").addAttribute("name", "Andi");
        g.getNode("18").addAttribute("password", "696969");
        g.getNode("18").addAttribute("ui.class", "Person");
        g.getNode("18").addAttribute("ui.label", g.getNode("18").getAttribute("name").toString());
        g.addNode("19");
        g.getNode("19").addAttribute("name", "Agung");
        g.getNode("19").addAttribute("password", "123123");
        g.getNode("19").addAttribute("ui.class", "Person");
        g.getNode("19").addAttribute("ui.label", g.getNode("19").getAttribute("name").toString());
        g.addNode("20");
        g.getNode("20").addAttribute("name", "Ahmad");
        g.getNode("20").addAttribute("password", "batman");
        g.getNode("20").addAttribute("ui.class", "Person");
        g.getNode("20").addAttribute("ui.label", g.getNode("20").getAttribute("name").toString());
        g.addNode("21");
        g.getNode("21").addAttribute("name", "Kurniawan");
        g.getNode("21").addAttribute("password", "trustno1");
        g.getNode("21").addAttribute("ui.class", "Person");
        g.getNode("21").addAttribute("ui.label", g.getNode("21").getAttribute("name").toString());
        g.addNode("22");
        g.getNode("22").addAttribute("name", "I");
        g.getNode("22").addAttribute("password", "password");
        g.getNode("22").addAttribute("ui.class", "Person");
        g.getNode("22").addAttribute("ui.label", g.getNode("22").getAttribute("name").toString());
        g.addNode("23");
        g.getNode("23").addAttribute("name", "Budi");
        g.getNode("23").addAttribute("password", "12345");
        g.getNode("23").addAttribute("ui.class", "Person");
        g.getNode("23").addAttribute("ui.label", g.getNode("23").getAttribute("name").toString());
        g.addNode("24");
        g.getNode("24").addAttribute("name", "Adi");
        g.getNode("24").addAttribute("password", "123456");
        g.getNode("24").addAttribute("ui.class", "Person");
        g.getNode("24").addAttribute("ui.label", g.getNode("24").getAttribute("name").toString());
        g.addNode("25");
        g.getNode("25").addAttribute("name", "Eko");
        g.getNode("25").addAttribute("password", "12345678");
        g.getNode("25").addAttribute("ui.class", "Person");
        g.getNode("25").addAttribute("ui.label", g.getNode("25").getAttribute("name").toString());
        g.addNode("26");
        g.getNode("26").addAttribute("name", "Nurul");
        g.getNode("26").addAttribute("password", "qwerty");
        g.getNode("26").addAttribute("ui.class", "Person");
        g.getNode("26").addAttribute("ui.label", g.getNode("26").getAttribute("name").toString());
        g.addNode("27");
        g.getNode("27").addAttribute("name", "Putra");
        g.getNode("27").addAttribute("password", "1234567890");
        g.getNode("27").addAttribute("ui.class", "Person");
        g.getNode("27").addAttribute("ui.label", g.getNode("27").getAttribute("name").toString());
        g.addNode("28");
        g.getNode("28").addAttribute("name", "Ni");
        g.getNode("28").addAttribute("password", "1234");
        g.getNode("28").addAttribute("ui.class", "Person");
        g.getNode("28").addAttribute("ui.label", g.getNode("28").getAttribute("name").toString());
        g.addNode("29");
        g.getNode("29").addAttribute("name", "Arif");
        g.getNode("29").addAttribute("password", "baseball");
        g.getNode("29").addAttribute("ui.class", "Person");
        g.getNode("29").addAttribute("ui.label", g.getNode("29").getAttribute("name").toString());
        g.addNode("30");
        g.getNode("30").addAttribute("name", "Puspita");
        g.getNode("30").addAttribute("password", "dragon");
        g.getNode("30").addAttribute("ui.class", "Person");
        g.getNode("30").addAttribute("ui.label", g.getNode("30").getAttribute("name").toString());
        g.addNode("31");
        g.getNode("31").addAttribute("name", "Ari");
        g.getNode("31").addAttribute("password", "football");
        g.getNode("31").addAttribute("ui.class", "Person");
        g.getNode("31").addAttribute("ui.label", g.getNode("31").getAttribute("name").toString());
        g.addNode("32");
        g.getNode("32").addAttribute("name", "Indra");
        g.getNode("32").addAttribute("password", "1234567");
        g.getNode("32").addAttribute("ui.class", "Person");
        g.getNode("32").addAttribute("ui.label", g.getNode("32").getAttribute("name").toString());
        g.addNode("33");
        g.getNode("33").addAttribute("name", "Dyah");
        g.getNode("33").addAttribute("password", "monkey");
        g.getNode("33").addAttribute("ui.class", "Person");
        g.getNode("33").addAttribute("ui.label", g.getNode("33").getAttribute("name").toString());
        g.addNode("34");
        g.getNode("34").addAttribute("name", "Rizki");
        g.getNode("34").addAttribute("password", "letmein");
        g.getNode("34").addAttribute("ui.class", "Person");
        g.getNode("34").addAttribute("ui.label", g.getNode("34").getAttribute("name").toString());
        g.addNode("35");
        g.getNode("35").addAttribute("name", "Maria");
        g.getNode("35").addAttribute("password", "abc123");
        g.getNode("35").addAttribute("ui.class", "Person");
        g.getNode("35").addAttribute("ui.label", g.getNode("35").getAttribute("name").toString());
        g.addNode("36");
        g.getNode("36").addAttribute("name", "Ratih");
        g.getNode("36").addAttribute("password", "111111");
        g.getNode("36").addAttribute("ui.class", "Person");
        g.getNode("36").addAttribute("ui.label", g.getNode("36").getAttribute("name").toString());
        g.addNode("37");
        g.getNode("37").addAttribute("name", "Pratiwi");
        g.getNode("37").addAttribute("password", "mustang");
        g.getNode("37").addAttribute("ui.class", "Person");
        g.getNode("37").addAttribute("ui.label", g.getNode("37").getAttribute("name").toString());
        g.addNode("38");
        g.getNode("38").addAttribute("name", "Kartika");
        g.getNode("38").addAttribute("password", "access");
        g.getNode("38").addAttribute("ui.class", "Person");
        g.getNode("38").addAttribute("ui.label", g.getNode("38").getAttribute("name").toString());
        g.addNode("39");
        g.getNode("39").addAttribute("name", "Wulandari");
        g.getNode("39").addAttribute("password", "shadow");
        g.getNode("39").addAttribute("ui.class", "Person");
        g.getNode("39").addAttribute("ui.label", g.getNode("39").getAttribute("name").toString());
        g.addNode("40");
        g.getNode("40").addAttribute("name", "Fajar");
        g.getNode("40").addAttribute("password", "master");
        g.getNode("40").addAttribute("ui.class", "Person");
        g.getNode("40").addAttribute("ui.label", g.getNode("40").getAttribute("name").toString());
        g.addNode("41");
        g.getNode("41").addAttribute("name", "Bayu");
        g.getNode("41").addAttribute("password", "michael");
        g.getNode("41").addAttribute("ui.class", "Person");
        g.getNode("41").addAttribute("ui.label", g.getNode("41").getAttribute("name").toString());
        g.addNode("42");
        g.getNode("42").addAttribute("name", "Lestari");
        g.getNode("42").addAttribute("password", "superman");
        g.getNode("42").addAttribute("ui.class", "Person");
        g.getNode("42").addAttribute("ui.label", g.getNode("42").getAttribute("name").toString());
        g.addNode("43");
        g.getNode("43").addAttribute("name", "Anita");
        g.getNode("43").addAttribute("password", "696969");
        g.getNode("43").addAttribute("ui.class", "Person");
        g.getNode("43").addAttribute("ui.label", g.getNode("43").getAttribute("name").toString());
        g.addNode("44");
        g.getNode("44").addAttribute("name", "Muhamad");
        g.getNode("44").addAttribute("password", "123123");
        g.getNode("44").addAttribute("ui.class", "Person");
        g.getNode("44").addAttribute("ui.label", g.getNode("44").getAttribute("name").toString());
        g.addNode("45");
        g.getNode("45").addAttribute("name", "Kusuma");
        g.getNode("45").addAttribute("password", "batman");
        g.getNode("45").addAttribute("ui.class", "Person");
        g.getNode("45").addAttribute("ui.label", g.getNode("45").getAttribute("name").toString());
        g.addNode("46");
        g.getNode("46").addAttribute("name", "Rahmawati");
        g.getNode("46").addAttribute("password", "trustno1");
        g.getNode("46").addAttribute("ui.class", "Person");
        g.getNode("46").addAttribute("ui.label", g.getNode("46").getAttribute("name").toString());
        g.addNode("47");
        g.getNode("47").addAttribute("name", "Fitria");
        g.getNode("47").addAttribute("password", "password");
        g.getNode("47").addAttribute("ui.class", "Person");
        g.getNode("47").addAttribute("ui.label", g.getNode("47").getAttribute("name").toString());
        g.addNode("48");
        g.getNode("48").addAttribute("name", "Retno");
        g.getNode("48").addAttribute("password", "12345");
        g.getNode("48").addAttribute("ui.class", "Person");
        g.getNode("48").addAttribute("ui.label", g.getNode("48").getAttribute("name").toString());
        g.addNode("49");
        g.getNode("49").addAttribute("name", "Kurnia");
        g.getNode("49").addAttribute("password", "123456");
        g.getNode("49").addAttribute("ui.class", "Person");
        g.getNode("49").addAttribute("ui.label", g.getNode("49").getAttribute("name").toString());


        g.addNode("50");
        g.getNode("50").addAttribute("Isi Post", "BDNR Libur");
        g.getNode("50").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("51");
        g.getNode("51").addAttribute("Isi Post", "Kuliah Kamsis Libur");
        g.getNode("51").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("52");
        g.getNode("52").addAttribute("Isi Post", "Tugas BDNR dikumpul tgl 2");
        g.getNode("52").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("53");
        g.getNode("53").addAttribute("Isi Post", "Besok Libur");
        g.getNode("53").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("54");
        g.getNode("54").addAttribute("Isi Post", "Kuliah Kalkulus II hari ini tidka ada");
        g.getNode("54").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("55");
        g.getNode("55").addAttribute("Isi Post", "Praktikum dimulai seminggu setelah UTS");
        g.getNode("55").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("56");
        g.getNode("56").addAttribute("Isi Post", "Pengganti BDNR ditiadakan");
        g.getNode("56").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("57");
        g.getNode("57").addAttribute("Isi Post", "Kuliah Damin diganti hari Sabtu");
        g.getNode("57").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("58");
        g.getNode("58").addAttribute("Isi Post", "Kuliah Kamsis Libur");
        g.getNode("58").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("59");
        g.getNode("59").addAttribute("Isi Post", "Tugas BDNR dikumpul tgl 5");
        g.getNode("59").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("60");
        g.getNode("60").addAttribute("Isi Post", "Besok Tidak Libur");
        g.getNode("60").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("61");
        g.getNode("61").addAttribute("Isi Post", "Kuliah Kalkulus I hari ini tidka ada");
        g.getNode("61").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("62");
        g.getNode("62").addAttribute("Isi Post", "Praktikum dimulaitgl 1");
        g.getNode("62").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("63");
        g.getNode("63").addAttribute("Isi Post", "Pengganti BDNR hari Rabu");
        g.getNode("63").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("64");
        g.getNode("64").addAttribute("Isi Post", "Kuliah Damin diganti hari Kamis");
        g.getNode("64").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("65");
        g.getNode("65").addAttribute("Isi Post", "Besok Ada Perkuliahan");
        g.getNode("65").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("66");
        g.getNode("66").addAttribute("Isi Post", "Kuliah Fisika I hari ini tidka ada");
        g.getNode("66").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("67");
        g.getNode("67").addAttribute("Isi Post", "Praktikum dimulaitgl 3");
        g.getNode("67").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("68");
        g.getNode("68").addAttribute("Isi Post", "Pengganti BDNR hari Jumat");
        g.getNode("68").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
        g.addNode("69");
        g.getNode("69").addAttribute("Isi Post", "Kuliah Damin diganti hari Senin");
        g.getNode("69").addAttribute("Tanggal", "Tue Jan 28 16:02:31 ICT 1975");
//
//        g.addNode("70");
//        g.getNode("70").addAttribute("name", "Yulia");
//        g.getNode("70").addAttribute("age", "2");
//        g.getNode("70").addAttribute("language", "Bourne shell (sh) script");
//        g.addNode("71");
//        g.getNode("71").addAttribute("name", "Maya");
//        g.getNode("71").addAttribute("age", "5");
//        g.getNode("71").addAttribute("language", "Bourne-Again shell (bash) script");
//        g.addNode("72");
//        g.getNode("72").addAttribute("name", "Puji");
//        g.getNode("72").addAttribute("age", "41");
//        g.getNode("72").addAttribute("language", "Korn shell (ksh) script");
//        g.addNode("73");
//        g.getNode("73").addAttribute("name", "Utami");
//        g.getNode("73").addAttribute("age", "31");
//        g.getNode("73").addAttribute("language", "C shell (csh) script");
//        g.addNode("74");
//        g.getNode("74").addAttribute("name", "Amalia");
//        g.getNode("74").addAttribute("age", "17");
//        g.getNode("74").addAttribute("language", "C");
//        g.addNode("75");
//        g.getNode("75").addAttribute("name", "Dina");
//        g.getNode("75").addAttribute("age", "14");
//        g.getNode("75").addAttribute("language", "C++™");
//        g.addNode("76");
//        g.getNode("76").addAttribute("name", "Devi");
//        g.getNode("76").addAttribute("age", "48");
//        g.getNode("76").addAttribute("language", "C#™");
//        g.addNode("77");
//        g.getNode("77").addAttribute("name", "Citra");
//        g.getNode("77").addAttribute("age", "25");
//        g.getNode("77").addAttribute("language", "Visual C++");
//        g.addNode("78");
//        g.getNode("78").addAttribute("name", "Arief");
//        g.getNode("78").addAttribute("age", "42");
//        g.getNode("78").addAttribute("language", "ColdFusion");
//        g.addNode("79");
//        g.getNode("79").addAttribute("name", "M.");
//        g.getNode("79").addAttribute("age", "50");
//        g.getNode("79").addAttribute("language", "dBase dkk.");
//        g.addNode("80");
//        g.getNode("80").addAttribute("name", "Bagus");
//        g.getNode("80").addAttribute("age", "16");
//        g.getNode("80").addAttribute("language", "Clipper");
//        g.addNode("81");
//        g.getNode("81").addAttribute("name", "Hidayat");
//        g.getNode("81").addAttribute("age", "50");
//        g.getNode("81").addAttribute("language", "Foxbase");
//        g.addNode("82");
//        g.getNode("82").addAttribute("name", "Hendra");
//        g.getNode("82").addAttribute("age", "3");
//        g.getNode("82").addAttribute("language", "Visual FoxPro");
//        g.addNode("83");
//        g.getNode("83").addAttribute("name", "Eva");
//        g.getNode("83").addAttribute("age", "16");
//        g.getNode("83").addAttribute("language", "Eiffel");
//        g.addNode("84");
//        g.getNode("84").addAttribute("name", "Endah");
//        g.getNode("84").addAttribute("age", "3");
//        g.getNode("84").addAttribute("language", "Fortran");
//        g.addNode("85");
//        g.getNode("85").addAttribute("name", "Raden");
//        g.getNode("85").addAttribute("age", "9");
//        g.getNode("85").addAttribute("language", "Go");
//        g.addNode("86");
//        g.getNode("86").addAttribute("name", "Novi");
//        g.getNode("86").addAttribute("age", "11");
//        g.getNode("86").addAttribute("language", "Haskell");
//        g.addNode("87");
//        g.getNode("87").addAttribute("name", "Irma");
//        g.getNode("87").addAttribute("age", "21");
//        g.getNode("87").addAttribute("language", "Java");
//        g.addNode("88");
//        g.getNode("88").addAttribute("name", "Astuti");
//        g.getNode("88").addAttribute("age", "20");
//        g.getNode("88").addAttribute("language", "JavaScript");
//        g.addNode("89");
//        g.getNode("89").addAttribute("name", "Achmad");
//        g.getNode("89").addAttribute("age", "11");
//        g.getNode("89").addAttribute("language", "JSP");
//        g.addNode("90");
//        g.getNode("90").addAttribute("name", "Aulia");
//        g.getNode("90").addAttribute("age", "11");
//        g.getNode("90").addAttribute("language", "Lisp");
//        g.addNode("91");
//        g.getNode("91").addAttribute("name", "Surya");
//        g.getNode("91").addAttribute("age", "12");
//        g.getNode("91").addAttribute("language", "Logo");
//        g.addNode("92");
//        g.getNode("92").addAttribute("name", "Amelia");
//        g.getNode("92").addAttribute("age", "10");
//        g.getNode("92").addAttribute("language", "Pascal");
//        g.addNode("93");
//        g.getNode("93").addAttribute("name", "Prima");
//        g.getNode("93").addAttribute("age", "20");
//        g.getNode("93").addAttribute("language", "Delphi");
//        g.addNode("94");
//        g.getNode("94").addAttribute("name", "Angga");
//        g.getNode("94").addAttribute("age", "43");
//        g.getNode("94").addAttribute("language", "Perl");
//        g.addNode("95");
//        g.getNode("95").addAttribute("name", "Hadi");
//        g.getNode("95").addAttribute("age", "6");
//        g.getNode("95").addAttribute("language", "Prolog");
//        g.addNode("96");
//        g.getNode("96").addAttribute("name", "Diana");
//        g.getNode("96").addAttribute("age", "10");
//        g.getNode("96").addAttribute("language", "Python");
//        g.addNode("97");
//        g.getNode("97").addAttribute("name", "Anggraini");
//        g.getNode("97").addAttribute("age", "27");
//        g.getNode("97").addAttribute("language", "PHP");
//        g.addNode("98");
//        g.getNode("98").addAttribute("name", "Wulan");
//        g.getNode("98").addAttribute("age", "8");
//        g.getNode("98").addAttribute("language", "Pike");
//        g.addNode("99");
//        g.getNode("99").addAttribute("name", "Saputra");
//        g.getNode("99").addAttribute("age", "1");
//        g.getNode("99").addAttribute("language", "R");
//        
        g.addEdge("0", "0", "69").addAttribute("relation", "post");
        g.addEdge("1", "1", "68").addAttribute("relation", "post");
        g.addEdge("2", "2", "67").addAttribute("relation", "post");
        g.addEdge("3", "3", "66").addAttribute("relation", "post");
        g.addEdge("4", "4", "65").addAttribute("relation", "post");
        g.addEdge("5", "5", "64").addAttribute("relation", "post");
        g.addEdge("6", "6", "63").addAttribute("relation", "post");
        g.addEdge("7", "7", "62").addAttribute("relation", "post");
        g.addEdge("8", "8", "61").addAttribute("relation", "post");
        g.addEdge("9", "9", "60").addAttribute("relation", "post");
        g.addEdge("10", "10", "59").addAttribute("relation", "post");
        g.addEdge("11", "11", "58").addAttribute("relation", "post");
        g.addEdge("12", "12", "57").addAttribute("relation", "post");
        g.addEdge("13", "13", "56").addAttribute("relation", "post");
        g.addEdge("14", "14", "55").addAttribute("relation", "post");
        g.addEdge("15", "15", "54").addAttribute("relation", "post");
        g.addEdge("16", "16", "53").addAttribute("relation", "post");
        g.addEdge("17", "17", "52").addAttribute("relation", "post");
        g.addEdge("18", "18", "51").addAttribute("relation", "post");
        g.addEdge("19", "19", "50").addAttribute("relation", "post");
        g.addEdge("20", "20", "49").addAttribute("relation", "friends");
        g.addEdge("21", "21", "48").addAttribute("relation", "friends");
        g.addEdge("22", "22", "47").addAttribute("relation", "friends");
        g.addEdge("23", "23", "46").addAttribute("relation", "friends");
        g.addEdge("24", "24", "45").addAttribute("relation", "friends");
        g.addEdge("25", "25", "44").addAttribute("relation", "friends");
        g.addEdge("26", "26", "43").addAttribute("relation", "friends");
        g.addEdge("27", "27", "42").addAttribute("relation", "friends");
        g.addEdge("28", "28", "41").addAttribute("relation", "friends");
        g.addEdge("29", "29", "40").addAttribute("relation", "friends");
        g.addEdge("30", "30", "39").addAttribute("relation", "friends");
        g.addEdge("31", "31", "38").addAttribute("relation", "friends");
        g.addEdge("32", "32", "37").addAttribute("relation", "friends");
        g.addEdge("33", "33", "36").addAttribute("relation", "friends");
        g.addEdge("34", "34", "35").addAttribute("relation", "friends");
        g.addEdge("35", "35", "34").addAttribute("relation", "friends");
        g.addEdge("36", "36", "33").addAttribute("relation", "friends");
        g.addEdge("37", "37", "32").addAttribute("relation", "friends");
        g.addEdge("38", "38", "31").addAttribute("relation", "friends");
        g.addEdge("39", "39", "30").addAttribute("relation", "friends");
        g.addEdge("40", "40", "29").addAttribute("relation", "friends");
        g.addEdge("41", "41", "28").addAttribute("relation", "friends");
        g.addEdge("42", "42", "27").addAttribute("relation", "friends");
        g.addEdge("43", "43", "26").addAttribute("relation", "friends");
        g.addEdge("44", "44", "25").addAttribute("relation", "friends");
        g.addEdge("45", "45", "24").addAttribute("relation", "friends");
        g.addEdge("46", "46", "23").addAttribute("relation", "friends");
        g.addEdge("47", "47", "22").addAttribute("relation", "friends");
        g.addEdge("48", "48", "21").addAttribute("relation", "friends");
        g.addEdge("49", "49", "20").addAttribute("relation", "friends");
        g.addEdge("50", "50", "19").addAttribute("relation", "post");
        g.addEdge("51", "51", "18").addAttribute("relation", "post");
        g.addEdge("52", "52", "17").addAttribute("relation", "post");
        g.addEdge("53", "53", "16").addAttribute("relation", "post");
        g.addEdge("54", "54", "15").addAttribute("relation", "post");
        g.addEdge("55", "55", "14").addAttribute("relation", "post");
        g.addEdge("56", "56", "13").addAttribute("relation", "post");
        g.addEdge("57", "57", "12").addAttribute("relation", "post");
        g.addEdge("58", "58", "11").addAttribute("relation", "post");
        g.addEdge("59", "59", "10").addAttribute("relation", "post");
        g.addEdge("60", "60", "9").addAttribute("relation", "post");
        g.addEdge("61", "61", "8").addAttribute("relation", "post");
        g.addEdge("62", "62", "7").addAttribute("relation", "post");
        g.addEdge("63", "63", "6").addAttribute("relation", "post");
        g.addEdge("64", "64", "5").addAttribute("relation", "post");
        g.addEdge("65", "65", "4").addAttribute("relation", "post");
        g.addEdge("66", "66", "3").addAttribute("relation", "post");
        g.addEdge("67", "67", "2").addAttribute("relation", "post");
        g.addEdge("68", "68", "1").addAttribute("relation", "post");

//        g.addEdge("69", "69", "30").addAttribute("relation", "friends");
//        g.addEdge("70", "70", "29").addAttribute("relation", "friends");
//        g.addEdge("71", "71", "28").addAttribute("relation", "friends");
//        g.addEdge("72", "72", "27").addAttribute("relation", "friends");
//        g.addEdge("73", "73", "26").addAttribute("relation", "friends");
//        g.addEdge("74", "74", "25").addAttribute("relation", "friends");
//        g.addEdge("75", "75", "24").addAttribute("relation", "friends");
//        g.addEdge("76", "76", "23").addAttribute("relation", "friends");
//        g.addEdge("77", "77", "22").addAttribute("relation", "friends");
//        g.addEdge("78", "78", "21").addAttribute("relation", "friends");
//        g.addEdge("79", "79", "20").addAttribute("relation", "friends");
//        g.addEdge("80", "80", "19").addAttribute("relation", "friends");
//        g.addEdge("81", "81", "18").addAttribute("relation", "friends");
//        g.addEdge("82", "82", "17").addAttribute("relation", "friends");
//        g.addEdge("83", "83", "16").addAttribute("relation", "friends");
//        g.addEdge("84", "84", "15").addAttribute("relation", "friends");
//        g.addEdge("85", "85", "14").addAttribute("relation", "friends");
//        g.addEdge("86", "86", "13").addAttribute("relation", "friends");
//        g.addEdge("87", "87", "12").addAttribute("relation", "friends");
//        g.addEdge("88", "88", "11").addAttribute("relation", "friends");
//        g.addEdge("89", "89", "10").addAttribute("relation", "friends");
//        g.addEdge("90", "90", "9").addAttribute("relation", "friends");
//        g.addEdge("91", "91", "8").addAttribute("relation", "friends");
//        g.addEdge("92", "92", "7").addAttribute("relation", "friends");
//        g.addEdge("93", "93", "6").addAttribute("relation", "friends");
//        g.addEdge("94", "94", "5").addAttribute("relation", "friends");
//        g.addEdge("95", "95", "4").addAttribute("relation", "friends");
//        g.addEdge("96", "96", "3").addAttribute("relation", "friends");
//        g.addEdge("97", "97", "2").addAttribute("relation", "friends");
//        g.addEdge("98", "98", "1").addAttribute("relation", "friends");
//        
//        g.addEdge("99", "98", "68").addAttribute("relation", "comment");
//        g.addEdge("100", "98", "68").addAttribute("relation", "comment");
//        g.addEdge("101", "97", "68").addAttribute("relation", "comment");
//        g.addEdge("102", "96", "68").addAttribute("relation", "comment");
//        g.addEdge("103", "95", "68").addAttribute("relation", "comment");
//        g.addEdge("104", "94", "68").addAttribute("relation", "comment");
//        g.addEdge("105", "93", "68").addAttribute("relation", "comment");
//        g.addEdge("106", "92", "68").addAttribute("relation", "comment");
//        g.addEdge("107", "91", "68").addAttribute("relation", "comment");
//        g.addEdge("108", "90", "68").addAttribute("relation", "comment");
//        g.addEdge("109", "89", "68").addAttribute("relation", "comment");
//        g.addEdge("110", "88", "68").addAttribute("relation", "comment");
//        g.addEdge("111", "88", "90").addAttribute("relation", "summon");
//        g.addEdge("112", "88", "90").addAttribute("relation", "siblings");
//        g.getEdge("112").addAttribute("since", "12 March 2015");
        
    }

// Method    
//    public SingleGraph getG() {
//        return g;
//    }

    public MultiGraph getG() {
        return g;
    }

    public JButton getBtnDiameter() {
        return btnDiameter;
    }
    
    public JTextArea getTxtPresent() {
        return txtPresent;
    }

    public JButton getBtnViewEdge() {
        return btnViewEdge;
    }

    public JButton getBtnAddNode() {
        return btnAddNode;
    }

    public JButton getBtnAddEdge() {
        return btnAddEdge;
    }

    public JButton getBtnAddAttribute() {
        return btnAddAttribute;
    }

    public JButton getBtnDeleteNode() {
        return btnDeleteNode;
    }

    public JButton getBtnDeleteEdge() {
        return btnDeleteEdge;
    }

    public JButton getBtnDeleteAttribute() {
        return btnDeleteAttribute;
    }

    public JButton getBtnDisplayGraph() {
        return btnDisplayGraph;
    }

    public JButton getBtnViewNode() {
        return btnViewNode;
    }

    public JButton getBtnBetweeness() {
        return btnBetweeness;
    }
    
    
    public void addListener(ActionListener a){
        btnAddNode.addActionListener(a);
        btnAddEdge.addActionListener(a);
        btnAddAttribute.addActionListener(a);
        btnDeleteNode.addActionListener(a);
        btnDeleteEdge.addActionListener(a);
        btnDeleteAttribute.addActionListener(a);
        btnDisplayGraph.addActionListener(a);
        btnViewNode.addActionListener(a);
        btnViewEdge.addActionListener(a);
        btnDiameter.addActionListener(a);
        btnBetweeness.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings(value = "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaneMain = new javax.swing.JPanel();
        PaneTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        PaneUtama = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPresent = new javax.swing.JTextArea();
        PaneMenu = new javax.swing.JPanel();
        btnAddNode = new javax.swing.JButton();
        btnAddEdge = new javax.swing.JButton();
        btnDeleteNode = new javax.swing.JButton();
        btnAddAttribute = new javax.swing.JButton();
        btnDeleteEdge = new javax.swing.JButton();
        btnDeleteAttribute = new javax.swing.JButton();
        btnDisplayGraph = new javax.swing.JButton();
        btnViewNode = new javax.swing.JButton();
        btnViewEdge = new javax.swing.JButton();
        btnDiameter = new javax.swing.JButton();
        btnBetweeness = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 650));

        PaneMain.setBackground(new java.awt.Color(0, 0, 0));

        PaneTitle.setBackground(new java.awt.Color(255, 255, 255));
        PaneTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Graph Processing");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PaneTitleLayout = new javax.swing.GroupLayout(PaneTitle);
        PaneTitle.setLayout(PaneTitleLayout);
        PaneTitleLayout.setHorizontalGroup(
            PaneTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneTitleLayout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PaneTitleLayout.setVerticalGroup(
            PaneTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtPresent.setColumns(20);
        txtPresent.setRows(5);
        jScrollPane1.setViewportView(txtPresent);

        javax.swing.GroupLayout PaneUtamaLayout = new javax.swing.GroupLayout(PaneUtama);
        PaneUtama.setLayout(PaneUtamaLayout);
        PaneUtamaLayout.setHorizontalGroup(
            PaneUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        PaneUtamaLayout.setVerticalGroup(
            PaneUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        PaneMenu.setBackground(new java.awt.Color(0, 0, 0));
        PaneMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));

        btnAddNode.setText("Add Node");

        btnAddEdge.setText("Add Edge");

        btnDeleteNode.setText("Delete Node");

        btnAddAttribute.setText("Add Attribute");

        btnDeleteEdge.setText("Delete Edge");

        btnDeleteAttribute.setText("Delete Attribute");

        btnDisplayGraph.setText("Display Graph");

        btnViewNode.setText("View Node");

        btnViewEdge.setText("View Edge");

        btnDiameter.setText("Diameter");

        btnBetweeness.setText("Betweeness");

        javax.swing.GroupLayout PaneMenuLayout = new javax.swing.GroupLayout(PaneMenu);
        PaneMenu.setLayout(PaneMenuLayout);
        PaneMenuLayout.setHorizontalGroup(
            PaneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteNode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDisplayGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewNode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDiameter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBetweeness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PaneMenuLayout.setVerticalGroup(
            PaneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddEdge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddAttribute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteNode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteEdge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteAttribute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewNode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewEdge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDiameter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBetweeness)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PaneMainLayout = new javax.swing.GroupLayout(PaneMain);
        PaneMain.setLayout(PaneMainLayout);
        PaneMainLayout.setHorizontalGroup(
            PaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneMainLayout.createSequentialGroup()
                        .addComponent(PaneUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PaneTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PaneMainLayout.setVerticalGroup(
            PaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PaneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaneUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneMain;
    private javax.swing.JPanel PaneMenu;
    private javax.swing.JPanel PaneTitle;
    private javax.swing.JPanel PaneUtama;
    private javax.swing.JButton btnAddAttribute;
    private javax.swing.JButton btnAddEdge;
    private javax.swing.JButton btnAddNode;
    private javax.swing.JButton btnBetweeness;
    private javax.swing.JButton btnDeleteAttribute;
    private javax.swing.JButton btnDeleteEdge;
    private javax.swing.JButton btnDeleteNode;
    private javax.swing.JButton btnDiameter;
    private javax.swing.JButton btnDisplayGraph;
    private javax.swing.JButton btnViewEdge;
    private javax.swing.JButton btnViewNode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtPresent;
    // End of variables declaration//GEN-END:variables

    

}
