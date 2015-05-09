/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import View.AddAttributeView;
import View.AddEdgeView;
import View.AddNodeView;
import View.DeleteAttributeView;
import View.DeleteEdgeView;
import View.DeleteNodeView;
import View.Main;
import View.ViewEdgeView;
import View.ViewNodeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.graphstream.algorithm.BetweennessCentrality;
import org.graphstream.algorithm.Toolkit;
import org.graphstream.algorithm.measure.ClosenessCentrality;
import org.graphstream.graph.Node;
import org.graphstream.stream.file.FileSinkDGS;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

/**
 *
 * @author Ima
 */
public class Controller implements ActionListener{
    private Main m;
    private AddNodeView anv;
    private AddEdgeView aev;
    private AddAttributeView atv;
    private DeleteNodeView dnv;
    private DeleteEdgeView dev;
    private DeleteAttributeView dav;
    private ViewNodeView vnv;
    private ViewEdgeView vev;
    private Iterator<String> key;
    Viewer viewer;
    View view;

    public Controller(){
        m = new Main();
        anv = new AddNodeView();
        aev = new AddEdgeView();
        atv = new AddAttributeView();
        dnv = new DeleteNodeView();
        dev = new DeleteEdgeView();
        dav = new DeleteAttributeView();
        vnv = new ViewNodeView();
        vev = new ViewEdgeView();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        viewer = new Viewer(m.getG(), Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
        
        m.setVisible(true);
        m.addListener(this);
        anv.addListener(this);
        aev.addListener(this);
        atv.addListener(this);
        dnv.addListener(this);
        dev.addListener(this);
        dav.addListener(this);
        vnv.addListener(this);
        vev.addListener(this);
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e.equals(m.getBtnAddNode())){
            // button add node in main performed
            anv.setVisible(true);
        }
        else if (e.equals(m.getBtnAddEdge())){
            // button add edge in main performed
            aev.setVisible(true);
        }
        else if (e.equals(m.getBtnAddAttribute())){
            // button add attribute in main performed
            atv.setVisible(true);
        }
        else if (e.equals(m.getBtnDeleteNode())){
            // button delete node in main performed
            dnv.setVisible(true);
        }
        else if (e.equals(m.getBtnDeleteEdge())){
            // button delete edge in main performed
            dev.setVisible(true);
        }
        else if (e.equals(m.getBtnDeleteAttribute())){
            // button delete attribute in main performed
            dav.setVisible(true);
        }
        else if (e.equals(m.getBtnViewNode())){
            // button view node in main performed
            vnv.setVisible(true);
        }
        else if (e.equals(m.getBtnViewEdge())){
            // button view node in main performed
            vev.setVisible(true);
        }
        else if (e.equals(anv.getBtnAdd())){
            // button add node in add view node performed
            String id = anv.getTxtID().getText();
            String key = anv.getTxtKey().getText();
            String value = anv.getTxtValue().getText();
            
            if (!"".equals(anv.getTxtID().getText())){
                if("name".equals(key)){
                    m.getG().addNode(id).addAttribute("ui.class", "Person");
                }
                else if("tweet".equals(key)){
                    m.getG().addNode(id).addAttribute("ui.class", "Tweet");
                }
                
                m.getG().getNode(id).setAttribute(key, value);
                m.getG().getNode(id).setAttribute("ui.label", m.getG().getNode(id).getAttribute(key).toString());
                JOptionPane.showMessageDialog(anv, "Node berhasil ditambahkan", "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                anv.setVisible(false);
                anv.getTxtID().setText("");
                anv.getTxtKey().setText("");
                anv.getTxtValue().setText("");
            }
            else{
                JOptionPane.showMessageDialog(anv, "Masukkan ID", "Failed", 
                        JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if (e.equals(aev.getBtnAdd())){
            // button add edge in add view edge performed
            String id = aev.getTxtID().getText();
            String label = aev.getTxtLabel().getText();
            String source = aev.getTxtSource().getText();
            String dest = aev.getTxtDest().getText();
            try {
                if (!"".equals(aev.getTxtID().getText()) 
                        && !"".equals(aev.getTxtLabel().getText()) 
                        && !"".equals(aev.getTxtSource().getText())
                        && !"".equals(aev.getTxtDest().getText())){
                    m.getG().addEdge(id, source, dest);
                    m.getG().getEdge(id).setAttribute("ui.label", label);
                    JOptionPane.showMessageDialog(aev, "Edge berhasil ditambahkan", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    aev.setVisible(false);
                    aev.getTxtID().setText("");
                    aev.getTxtLabel().setText("");
                    aev.getTxtSource().setText("");
                    aev.getTxtDest().setText("");
                }
                else{
                    JOptionPane.showMessageDialog(aev, "Lengkapi inputan", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                }   
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(aev, "Node tidak ada", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.equals(atv.getBtnAdd())){
            // button add in add attribute view performed
            String idNode = atv.getTxtIDNode().getText();
            String key = atv.getTxtKey().getText();
            String value = atv.getTxtValue().getText();
            try {
                if (!"".equals(atv.getTxtKey().getText()) && !"".equals(atv.getTxtKey().getText())
                        && !"".equals(atv.getTxtIDNode().getText())){
                    m.getG().getNode(idNode).addAttribute(key, value);
                    JOptionPane.showMessageDialog(atv, "Attribute berhasil ditambahkan", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    atv.setVisible(false);
                    atv.getTxtIDNode().setText("");
                    atv.getTxtKey().setText("");
                    atv.getTxtValue().setText("");
                }
                else{
                    JOptionPane.showMessageDialog(atv, "Lengkapi inputan", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(atv, "Node tidak ada", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.equals(dnv.getBtnDelete())){
            // button delete node in delete node view performed
            String id = dnv.getTxtID().getText();
            try {
                if (!"".equals(dnv.getTxtID().getText())){
                    m.getG().removeNode(id);
                    JOptionPane.showMessageDialog(dnv, "Node berhasil dihapus", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    dnv.setVisible(false);
                    dnv.getTxtID().setText("");
                }
                else{
                    JOptionPane.showMessageDialog(dnv, "Masukkan ID", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(dnv, "Node tidak ada", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.equals(dev.getBtnDelete())){
            // button delete edge in delete edge view performed
            String source = dev.getTxtSource().getText();
            String dest = dev.getTxtDest().getText();
            try {
                if (!"".equals(dev.getTxtSource().getText()) && 
                        !"".equals(dev.getTxtSource().getText())){
                  m.getG().removeEdge(source, dest);
                    JOptionPane.showMessageDialog(dev, "Edge berhasil dihapus", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(dev, "Lengkapi input", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(dnv, "Node tidak ada", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.equals(dav.getBtnDelete())){
            // button delete attribut in delete attribute view performed
            try {
                if (!"".equals(dav.getTxtKey().getText()) && !"".equals(dav.getTxtIDNode().getText())){
                    String id = dav.getTxtIDNode().getText();
                    String key = dav.getTxtKey().getText();
                    System.out.println(m.getG().getNode(id).getAttribute(key).toString());
                    m.getG().getNode(id).removeAttribute(key);
                    JOptionPane.showMessageDialog(dav, "Attribute berhasil dihapus", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    dav.setVisible(false);
                    dav.getTxtIDNode().setText("");
                    dav.getTxtKey().setText("");
                }
                else{
                    JOptionPane.showMessageDialog(dav, "Lengkapi input", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(dav, "Attribute tidak ada", "Failed", 
                            JOptionPane.ERROR_MESSAGE);
                System.err.println("masuk exception");
            }
        }
        else if(e.equals(vnv.getBtnView())){
            // menampilkan node beserta edge dan attributenya
            String id = vnv.getTxtID().getText();
            key = m.getG().getNode(id).getAttributeKeySet().iterator();
            ArrayList<String> listKey = new ArrayList<>();
            while(key.hasNext()){
                listKey.add(key.next());
            }
            String listValue = "[";
            for(String s : listKey){
                
                listValue+=(m.getG().getNode(id).getAttribute(s)+", ");
            }
            listValue += "]";
            m.getTxtPresent().setText(
                    "ID Node : "+m.getG().getNode(id).getId()+"\n"+
                    "Edge : "+m.getG().getNode(id).getEdgeSet()+"\n"+
                    "Key : "+m.getG().getNode(id).getAttributeKeySet()+"\n"+
                    "Value : "+listValue);
            vnv.setVisible(false);
        }
        else if(e.equals(vev.getBtnView())){
            // menampilkan node beserta edge dan attributenya
            String id = vev.getTxtID().getText();
            String s = " ";
            try {
                m.getTxtPresent().setText(
                    "ID Edge : "+m.getG().getEdge(id).getId()+"\n"+
                    "Relation : "+m.getG().getEdge(id).getAttribute("relation")+"\n"/*+
                    "Attibute : "+s*/);
                m.getG().getEdge(id).getAttribute(id);
            } catch (Exception ee) {
                System.err.println("no no noo exception");
            }
            vev.setVisible(false);
        }
        else if (e.equals(m.getBtnDiameter())){
            // button graph display in main performed
            m.getTxtPresent().setText("Diameter graph : "+Toolkit.diameter(m.getG()));
        }
        else if (e.equals(m.getBtnBetweeness())){
            // button betweeness graph display in main performed
            BetweennessCentrality bcb = new BetweennessCentrality();
            bcb.setWeightAttributeName("weight");
            bcb.init(m.getG());
            bcb.compute();
            for(Node n : m.getG().getEachNode()){
                if ((Double)n.getAttribute("Cb")>40){
                    n.addAttribute("ui.class", "between");
                }
                System.out.println(n.getAttribute("name")+", "+n.getAttribute("Cb"));
            }
            m.getG().display();
        }
        else if (e.equals(m.getBtnCloseness())){
            // button closeness graph display in main performed
            ClosenessCentrality cc = new ClosenessCentrality("Cc");
            cc.init(m.getG());
            cc.compute();
            for(Node n : m.getG().getEachNode()){
//                if ("Infinity".equalsIgnoreCase(n.getAttribute("Cc").toString())){
//                    n.setAttribute("Cc", -1);
//                }
                System.err.println(n.getId()+", "+n.getAttribute("Cc").toString());
            }
            Double maxCc = m.getG().getNode("1").getAttribute("Cc");
            Node temp = m.getG().getNode("1");
            for(Node n : m.getG().getEachNode()){
                if (Double.parseDouble(n.getAttribute("Cc").toString())>maxCc){
                    temp = n;
                }
                System.out.println(n.getId()+" "+n.getAttribute("Cc").toString());
            }
            // node dgn closeness terbesar set classnya jd closeness
            temp.addAttribute("ui.class", "closeness");
            System.out.println(temp.getAttribute("name")+", "+temp.getAttribute("Cc"));
            m.getG().display();
        }
        else if (e.equals(m.getBtnColoringNode())){
            // button coloring node graph display in main performed
            ArrayList<Integer> listDegree = new ArrayList<>();
            for(Node n : m.getG().getEachNode()){
                System.out.println(n.getId()+", "+n.getInDegree());
                if(n.hasAttribute("name")){
                    if(n.getInDegree()==0){
                        n.addAttribute("ui.class", "PersoninDegree0");
                    }
                    else if(n.getInDegree()==1){
                        n.addAttribute("ui.class", "PersoninDegree1");
                    }
                    else if (n.getInDegree()==2){
                        n.addAttribute("ui.class", "PersoninDegree2");
                    }
                    else if (n.getInDegree()==3){
                        n.addAttribute("ui.class", "PersoninDegree3");
                    }
                    else if (n.getInDegree()==4){
                        n.addAttribute("ui.class", "PersoninDegree4");
                    }
                    else if (n.getInDegree()==5){
                        n.addAttribute("ui.class", "PersoninDegree5");
                    }
                    else if (n.getInDegree()>5){
                        n.addAttribute("ui.class", "PersoninDegreeLebihDari5");
                    }
                }
                else if(n.hasAttribute("tweet")){
                    if(n.getInDegree()==0){
                        n.addAttribute("ui.class", "TweetinDegree0");
                    }
                    else if(n.getInDegree()==1){
                        n.addAttribute("ui.class", "TweetinDegree1");
                    }
                    else if (n.getInDegree()==2){
                        n.addAttribute("ui.class", "TweetinDegree2");
                    }
                    else if (n.getInDegree()==3){
                        n.addAttribute("ui.class", "TweetinDegree3");
                    }
                    else if (n.getInDegree()==4){
                        n.addAttribute("ui.class", "TweetinDegree4");
                    }
                    else if (n.getInDegree()==5){
                        n.addAttribute("ui.class", "TweetinDegree5");
                    }
                    else if (n.getInDegree()>5){
                        n.addAttribute("ui.class", "TweetinDegreeLebihDari5");
                    }
                }
            }
        }
        else if (e.equals(m.getBtnDisplayGraph())){
            // button graph display in main performed
            String styleSheet="node {"+
                " fill-color: black;"+
                " size: 10px;"+
                " stroke-mode: plain;"+
                " stroke-color: black;"+
                " stroke-width: 1px;"+
                "}"+
                "node.Person {"+
                " fill-color: blue;"+
                " fill-mode: gradient-diagonal1;"+
                " size: 10px;"+
                "}"+
                "node.Tweet {"+
                " fill-color: green;"+
                " size: 10px;"+
                "}"+
                "node.between {"+
                " fill-color: red;"+
                " size: 20px;"+
                "}"+
                "node.closeness {"+
                " fill-color: yellow;"+
                " size: 20px;"+
                "}"+
                "node.PersoninDegree0 {"+
                " fill-color: #E0F5FF;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegree1 {"+
                " fill-color: #66CCFF;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegree2 {"+
                " fill-color: #3399FF;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegree3 {"+
                " fill-color: #0066FF;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegree4 {"+
                " fill-color: #0000FF;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegree5 {"+
                " fill-color: #0000CC;"+
                " size: 10px;"+
                "}"+
                "node.PersoninDegreeLebihDari5 {"+
                " fill-color: #0000CC;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree0 {"+
                " fill-color: #EBFFEB;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree1 {"+
                " fill-color: #99FF99;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree2 {"+
                " fill-color: #8AE68A;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree3 {"+
                " fill-color: #6BB26B;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree4 {"+
                " fill-color: #5C995C;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegree5 {"+
                " fill-color: #4C804C;"+
                " size: 10px;"+
                "}"+
                "node.TweetinDegreeLebihDari5 {"+
                " fill-color: #2E4C2E;"+
                " size: 10px;"+
                "}"+
                "edge {"+
                " fill-color: black;"+
                " arrow-shape: arrow;"+
                " arrow-size: 5px,5px;"+
                "}";
            
            m.getG().addAttribute("ui.stylesheet", styleSheet);
//            m.getG().display().disableAutoLayout();
//            double x=0, y=0;
//            double a=100, b=10;
//            for(Node n : m.getG()){
//                
//                if (n.hasAttribute("tweet")){
//                    n.setAttribute("xy", x,y);
//                    x=x+10;
//                    if(x % 50==0){
//                        x=0;
//                        y=y+10;
//                    }
//                }else{
//                    n.setAttribute("xy", a,b);
//                    a=a+10;
//                    if(a % 150==0){
//                        a=100;
//                        b=b+10;
//                    }
//                }
            

            m.getG().display();
    }   
    
        else if (e.equals(m.getBtnCluster())){
            // button cluster node graph display in main performed
            double x=0, y=0;
            double a=100, b=10;
            for(Node n : m.getG().getEachNode()){
                if(n.hasAttribute("name")){
                    System.out.println(n.getId()+", "+n.getAttribute("name"));
                    n.addAttribute("ui.class", "Person");
                    n.setAttribute("xy", a,b);
                    a=a+10;
                    if(a % 150==0){
                        a=100;
                        b=b+10;
                    }
                }
                else if(n.hasAttribute("tweet")){
                    System.out.println(n.getId()+", "+n.getAttribute("tweet"));
                    n.addAttribute("ui.class", "Tweet");
                    n.setAttribute("xy", x,y);
                    x=x+10;
                    if(x % 50==0){
                        x=0;
                        y=y+10;
                    }
                }
            }
            m.getG().display(false);
        }
//        else if (e.equals(m.getBtnSaveGraph())){
//            FileSinkDGS fsdgs = new FileSinkDGS();
//            try {
//                fsdgs.writeAll(m.getG(), "graphtweet.dgs");
//                System.out.println("success");
//            } catch (IOException ex) {
//                System.err.println("no no nooooo!");
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else if (e.equals(m.getBtnLoadGraph())){
//            FileSourceDGS fs = new FileSourceDGS();
//
//            fs.addSink(m.getG());
//
//            try {
//              fs.readAll("graphtweet.dgs");
//            } catch( IOException ee) {
//                System.err.println("no no nooooo!");
//            } finally {
//              fs.removeSink(m.getG());
//            }
//        }
        else if(e.equals(m.getMenuLoad())){
            // load graph from file chooser
            int returnVal = m.getChooser().showOpenDialog(m);
            if (returnVal == m.getChooser().APPROVE_OPTION){
                File file = m.getChooser().getSelectedFile();
                try {
                    m.getTxtPresent().read(new FileReader(file.getAbsolutePath()), null);
                } catch (Exception ee) {
                    System.err.println("no no not loaded !");
                }
                FileSourceDGS fs = new FileSourceDGS();
                fs.addSink(m.getG());
                try {
                  fs.readAll(file.getAbsolutePath());
                } catch( IOException ee) {
                    System.err.println("no no nooooo!");
                } finally {
                  fs.removeSink(m.getG());
                }
            }
        }
        else if (e.equals(m.getMenuSave())){
            //save graph to a file
            int returnVal = m.getChooser().showSaveDialog(m.getChooser());
            if (returnVal == m.getChooser().APPROVE_OPTION ){
                File file = m.getChooser().getSelectedFile();
                FileSinkDGS fsdgs = new FileSinkDGS();
                try {
                    fsdgs.writeAll(m.getG(), file.getAbsolutePath());
                    System.out.println("success");
                } catch (IOException ex) {
                    System.err.println("no no nooooo!");
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("save as a file "+ file.getAbsolutePath());
            }
        }
        else if (e.equals(m.getMenuExit())){
            // exit from apps
            System.exit(1);
            
        }
        else if (e.equals(m.getBtnExecute())){
            String query = m.getTxtInputQuery().getText(); // dapatkan query inputan user
            query+="#"; // # = sentinel
            if("#".equals(query)){
                //kalo null
                JOptionPane.showMessageDialog(m.getTxtInputQuery(), "Input query anda", 
                        "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int i = 0; //untuk mengiterasi setiap character dalam query
                String temp = ""; //untuk menampung sementara tiap kata dalam query
                ArrayList<String> tempQuery = new ArrayList<String>();
                while(query.charAt(i)!='#'){
                    if (query.charAt(i) != ' ' && query.charAt(i)!= '*' && 
                        query.charAt(i) != '.' && query.charAt(i)!= ',' &&
                        query.charAt(i) != '=' && query.charAt(i)!= '(' && 
                        query.charAt(i) != ')' && query.charAt(i)!= ';' && 
                        query.charAt(i)!= '\"' && query.charAt(i)!= '<' && 
                        query.charAt(i)!= '>') {
                            temp += query.charAt(i);
                    }
                    else if(query.charAt(i) == ' '){
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == '*'){
                        tempQuery.add(temp);
                        temp = "*";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == '.'){
                        tempQuery.add(temp);
                        temp = ".";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == ','){
                        tempQuery.add(temp);
                        temp = ",";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == '='){
                        if(query.charAt(i+1)=='>' || query.charAt(i+1)=='<' ){
                            JOptionPane.showMessageDialog(m.getTxtInputQuery(), "Input yang Anda masukkan salah!", 
                                    "Terjadi Kesalahan!", JOptionPane.ERROR_MESSAGE);
                            break;
                        }else{
                            tempQuery.add(temp);
                            temp = "=";
                            tempQuery.add(temp);
                            temp = "";
                        }
                    }
                    else if(query.charAt(i) == '('){
                        tempQuery.add(temp);
                        temp = "(";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == ')'){
                        tempQuery.add(temp);
                        temp = ")";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == ';'){
                        tempQuery.add(temp);
                        temp = ";";
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == '\"'){
                        tempQuery.add(temp);
                        temp = "";
                        //cari tanda " kedua
                        int i2 = 0;
                        boolean search = true;
                        int index2 = i+1;
                        while (search && query.charAt(index2)!='#'){
                            if (query.charAt(index2)=='\"'){
                                i2 = index2;
                                search = false;
                            }
                            index2++;
                        }
                        if(search){
                            JOptionPane.showMessageDialog(m.getTxtInputQuery(), "Input Anda kurang tanda \"", "Terjadi Kesalahan!", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        for (int j = i; j<=i2;j++){
                            temp += query.charAt(j);
                        }
                        i = i2;
                    }
                    else if(query.charAt(i) == '<'){
                        tempQuery.add(temp);
                        temp = "<";
                        if(query.charAt(i+1)=='='){
                            temp+="=";
                            i++;
                        }
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else if(query.charAt(i) == '>'){
                        tempQuery.add(temp);
                        temp = ">";
                        if(query.charAt(i+1)=='='){
                            temp+="=";
                            i++;
                        }
                        tempQuery.add(temp);
                        temp = "";
                    }
                    else{
                        tempQuery.add(temp);
                        temp = "";
                    }
                    if(query.charAt(i+1) == '#'){
                        tempQuery.add(temp);
                        temp = "";
                    }
                    System.out.println(query.charAt(i));
                    i++;
                } // end of while
                
                //melakukan minimasi arraylist
                ArrayList<String> listWordQuery = new ArrayList<>();
                //menelusuri list tempQuery, mencari list yg tidak kosong
                for (String s : tempQuery){
                    if (!"".equals(s)){
                        listWordQuery.add(s);
                    }
                } 
                
                ArrayList<Integer> listToken = new ArrayList<>();
                //conversi dari listwordquery ke token lexic
                for(String s : listWordQuery){
                    if (isFAFind(s)){
                        listToken.add(1);
                    }
                    else if(isFANode(s)){
                        listToken.add(2);
                    }
                    else if(isFAWhere(s)){
                        listToken.add(4);
                    }
                    else if(isFAFO(s)){
                        listToken.add(5);
                    }
                    else if(isFAFOF(s)){
                        listToken.add(6);
                    }
                    else if(isFAReturn(s)){
                        listToken.add(12);
                    }
                    else if(isFATitik(s)){
                        listToken.add(7);
                    }
                    else if(isFASamaDengan(s)){
                        listToken.add(9);
                    }
                    else if(isFATitikKoma(s)){
                        listToken.add(13);
                    }
                    else if(isFAAND(s)){
                        listToken.add(11);
                    }
                    else if(isFAOR(s)){
                        listToken.add(11);
                    }
                    else if(isFAString(s)){
                        listToken.add(10);
                    }
                    else if(isFANumber(s)){
                        listToken.add(10);
                    }
                    else if(isFAVariable(s)){
                        if(listToken.get(listToken.size()-1)==7){
                            listToken.add(8);
                            System.err.println("yes");
                        }
                        else{
                            listToken.add(3);
                            System.err.println("no");
                        }
                    }
                    System.out.println(s);
                } // end for conversi
                String token = "";
                int[] simbolis = new int[listToken.size()+1];
                int j = 0;
                for(int n : listToken){
                    token+=n+" ";
                    m.getTxtPresent().setText(token);
                    simbolis[j++] = n;
                }
                simbolis[j] = 999; //sentinel
                // proses iterasi list token untuk validasi query
                
                boolean stop = false;
                j = 0;
                Stack st = new Stack();
                int state = 0; st.push("#"); state = 1; st.push("S");
                while(st.peek().toString()!="#" && !stop){
                    switch(st.peek().toString()){
                        case "S" :
                            if(simbolis[j]==1){
                                if(st.peek().toString()=="S"){
                                    st.pop();
                                    st.push("m"); st.push("c"); st.push("P"); st.push("j");
                                    st.push("i"); st.push("h"); st.push("g"); st.push("c");
                                    st.push("O"); st.push("c"); st.push("b"); st.push("a");
                                    System.out.println("pop S , push abcOcghijPcm, stack = "+st);
                                }
                            }
                            else{
                                stop = true;
                            }
                        break;
                        case "O" :
                            if(simbolis[j] == 4){
                                if(st.peek().toString()=="O"){
                                    st.pop();
                                    st.push("d");
                                    System.out.println("pop O, push d");
                                    System.out.println(st);
                                }
                            }
                            else if(simbolis[j] == 5){
                                if(st.peek().toString()=="O"){
                                    st.pop();
                                    st.push("d"); st.push("c"); st.push("b"); st.push("e");
                                    System.out.println("pop O, push ebcd, stack = "+st);
                                }
                            }
                            else if(simbolis[j] == 6){
                                if(st.peek().toString()=="O"){
                                    st.pop();
                                    st.push("d"); st.push("c"); st.push("b"); st.push("f");
                                    System.out.println("pop O, push ebcf, stack = "+st);
                                }
                            }
                            else{
                                stop = true;
                            }
                        break;
                        case "P" :
                            if(simbolis[j] == 11){
                                if(st.peek().toString()=="P"){
                                    st.pop();
                                    st.push("A"); st.push("k");
                                    System.out.println("pop P, push kA");
                                    System.out.println(st);
                                }
                            }
                            else if(simbolis[j] == 12){
                                if(st.peek().toString()=="P"){
                                    st.pop();
                                    st.push("l");
                                    System.out.println("pop P, push l, stack = "+st);
                                }
                            }
                            else{
                                stop = true;
                            }
                        break;
                        case "A" :
                            if(simbolis[j] == 3){
                                if(st.peek().toString()=="A"){
                                    st.pop();
                                    st.push("l"); st.push("j"); st.push("i"); st.push("h"); st.push("g"); st.push("c");
                                    System.out.println("pop A, push cgihjl");
                                    System.out.println(st);
                                }
                            }
                            else{
                                stop = true;
                            }
                        break;
                        case "a" :
                            if(simbolis[j]==1){ //baca find
                                st.pop();
                                j=j+1;
                                System.out.println("pop a , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 1, tidak bisa pop a, query salah, stack tidak kosong");
                            }
                        break;
                        case "b" :
                            if(simbolis[j]==2){ //baca node
                                st.pop();
                                j=j+1;
                                System.out.println("pop b , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 2, tidak bisa pop b, query salah, stack tidak kosong");
                            }
                        break;
                        case "c" :
                            if(simbolis[j]==3){ //baca variable
                                st.pop();
                                j=j+1;
                                System.out.println("pop c , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 3, tidak bisa pop c, query salah, stack tidak kosong");
                            }
                        break;
                        case "d" :
                            if(simbolis[j]==4){ // baca where
                                st.pop();
                                j=j+1;
                                System.out.println("pop d , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 4, tidak bisa pop d, query salah, stack tidak kosong");
                            }
                        break;
                        case "e" :
                            if(simbolis[j]==5){ // baca friend of
                                st.pop();
                                j=j+1;
                                System.out.println("pop e , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 5, tidak bisa pop e, query salah, stack tidak kosong");
                            }
                        break;
                        case "f" :
                            if(simbolis[j]==6){ // baca friend of friend
                                st.pop();
                                j=j+1;
                                System.out.println("pop f , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 6, tidak bisa pop f, query salah, stack tidak kosong");
                            }
                        break;
                        case "g" :
                            if(simbolis[j]==7){ // baca .
                                st.pop();
                                j=j+1;
                                System.out.println("pop g , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 7, tidak bisa pop g, query salah, stack tidak kosong");
                            }
                        break;
                        case "h" :
                            if(simbolis[j]==8){ // baca atribut
                                st.pop();
                                j=j+1;
                                System.out.println("pop h , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 8, tidak bisa pop h, query salah, stack tidak kosong");
                            }
                        break;
                        case "i" :
                            if(simbolis[j]==9){ // baca =
                                st.pop();
                                j=j+1;
                                System.out.println("pop i , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 9, tidak bisa pop i, query salah, stack tidak kosong");
                            }
                        break;
                        case "j" :
                            if(simbolis[j]==10){ // baca constanta
                                st.pop();
                                j=j+1;
                                System.out.println("pop j , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 10, tidak bisa pop j, query salah, stack tidak kosong");
                            }
                        break;
                        case "k" :
                            if(simbolis[j]==11){ // baca constanta
                                st.pop();
                                j=j+1;
                                System.out.println("pop k , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 11, tidak bisa pop k, query salah, stack tidak kosong");
                            }
                        break;
                        case "l" :
                            if(simbolis[j]==12){ // baca constanta
                                st.pop();
                                j=j+1;
                                System.out.println("pop l , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 12, tidak bisa pop l, query salah, stack tidak kosong");
                            }
                        break;
                        case "m" :
                            if(simbolis[j]==13){ // baca constanta
                                st.pop();
                                j=j+1;
                                System.out.println("pop m , current symbol =  "+simbolis[j]);
                                System.out.println(st);
                            }
                            else {
                                stop = true;
                                System.out.println("current symbol bukan 13, tidak bisa pop m, query salah, stack tidak kosong");
                            }
                        break;
                    }
                } // end while, checking top stack
                if(st.peek().toString()=="#"){
                    st.pop();
                    System.out.println(st);
                }

                if(st.empty()){
                    JOptionPane.showMessageDialog(m, "Query is VALID", "Validation", 
                            JOptionPane.INFORMATION_MESSAGE);
                    //kalau querynya valid, cek polanya, tampilkan hasilnya.
                    if(listToken.get(3)==4){
//                        JOptionPane.showMessageDialog(m, "Pola where", "Pola", 
//                            JOptionPane.INFORMATION_MESSAGE);
                        //variable penampung list node hasil query
                        ArrayList<Node> resultNode = new ArrayList<>();
                        if (listWordQuery.size()==12){
                            String[] value;
                            for(Node n : m.getG().getEachNode()){
                                if(n.hasAttribute(listWordQuery.get(6))){
                                    String pembanding = "\"" + n.getAttribute(listWordQuery.get(6)) + "\"";
                                    System.out.println(pembanding + " ?= "+ listWordQuery.get(8).toString());
                                    if(pembanding.equals(listWordQuery.get(8).toString())){
                                        resultNode.add(n);
                                    }
                                }
                            } // end for
                        }
                        // output the result
                        if (!listWordQuery.get(2).equals(listWordQuery.get(4)) ||
                                !listWordQuery.get(2).equals(listWordQuery.get(10)) ||
                                !listWordQuery.get(4).equals(listWordQuery.get(10))){
                            JOptionPane.showMessageDialog(m, "Cek kembali inputan anda !", "Error Variable", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            String hasil = "";
                            for(Node n : resultNode){
                                hasil+="ID Node : "+n.getId()+"\n";

                                for (Iterator<String> it = n.getAttributeKeyIterator(); it.hasNext();) {
                                    String s = it.next();
                                    hasil += s + " = " + n.getAttribute(s) + "\n";
                                }
                                hasil+="\n";
                                m.getTxtPresent().setText(hasil);
                            }
                        }
                    }
                    else if(listToken.get(3)==5){
//                        JOptionPane.showMessageDialog(m, "Pola fo", "Pola", 
//                            JOptionPane.INFORMATION_MESSAGE);
                        //variable penampung list node hasil query
                        ArrayList<Node> resultNode = new ArrayList<>();
                        ArrayList<Node> tempNode = new ArrayList<>();
                        if (listWordQuery.size()==15){
                            System.err.println("masuk");
                            String[] value;
                            for(Node n : m.getG().getEachNode()){
                                if(n.hasAttribute(listWordQuery.get(9))){
                                    System.err.println("ininin" + listWordQuery.get(9));
                                    String pembanding = "\"" + n.getAttribute(listWordQuery.get(9)) + "\"";
                                    System.out.println(pembanding + " ?= "+ listWordQuery.get(11).toString());
                                    if(pembanding.equals(listWordQuery.get(11).toString())){
                                        tempNode.add(n); //pointer pertama
                                    }
                                }
                            } // end for
                            for (Iterator<Node> it  = tempNode.get(0).getNeighborNodeIterator(); it.hasNext();) {
                                Node node = it.next();
                                resultNode.add(node);
                                System.out.println(node);
                            }
                            
                            // output the result
                            if (!listWordQuery.get(2).equals(listWordQuery.get(13)) ||
                                    !listWordQuery.get(5).equals(listWordQuery.get(7)) ||
                                    listWordQuery.get(2).equals(listWordQuery.get(5))){
                                JOptionPane.showMessageDialog(m, "Cek kembali inputan anda !", "Error Variable", 
                                    JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                String hasil = "";
                                for(Node n : resultNode){
                                    hasil+="ID Node : "+n.getId()+"\n";

                                    for (Iterator<String> it = n.getAttributeKeyIterator(); it.hasNext();) {
                                        String s = it.next();
                                        hasil += s + " = " + n.getAttribute(s) + "\n";
                                    }
                                    hasil+="\n";
                                    m.getTxtPresent().setText(hasil);
                                }
                            }
                        }
                    }
                    else if(listToken.get(3)==6){
//                        JOptionPane.showMessageDialog(m, "Pola fof", "Pola", 
//                            JOptionPane.INFORMATION_MESSAGE);
                        ArrayList<Node> resultNode = new ArrayList<>();
                        ArrayList<Node> temp1Node = new ArrayList<>();
                        ArrayList<Node> temp2Node = new ArrayList<>();
                        if (listWordQuery.size()==15){
                            System.err.println("masuk");
                            String[] value;
                            for(Node n : m.getG().getEachNode()){
                                if(n.hasAttribute(listWordQuery.get(9))){
                                    System.err.println("ininin" + listWordQuery.get(9));
                                    String pembanding = "\"" + n.getAttribute(listWordQuery.get(9)) + "\"";
                                    System.out.println(pembanding + " ?= "+ listWordQuery.get(11).toString());
                                    if(pembanding.equals(listWordQuery.get(11).toString())){
                                        temp1Node.add(n); //pointer pertama
                                    }
                                }
                            } // end for
                            for (Iterator<Node> it  = temp1Node.get(0).getNeighborNodeIterator(); it.hasNext();) {
                                Node node = it.next();
                                temp2Node.add(node); // temannya pointer pertama
                                System.err.println(node+"aaa");
                            }
                            for(Node n : temp2Node){
                                for (Iterator<Node> it  = n.getNeighborNodeIterator(); it.hasNext();) {
                                    Node node = it.next();
                                    if(node!=temp1Node.get(0)){
                                        resultNode.add(node); // temannya teman pointer pertama
                                    }
                                    System.out.println(node);
                                }
                            }
                            
                            // output the result
                            if (!listWordQuery.get(2).equals(listWordQuery.get(13)) ||
                                    !listWordQuery.get(5).equals(listWordQuery.get(7)) ||
                                    listWordQuery.get(2).equals(listWordQuery.get(5))){
                                JOptionPane.showMessageDialog(m, "Cek kembali inputan anda !", "Error Variable", 
                                    JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                String hasil = "";
                                for(Node n : resultNode){
                                    hasil+="ID Node : "+n.getId()+"\n";

                                    for (Iterator<String> it = n.getAttributeKeyIterator(); it.hasNext();) {
                                        String s = it.next();
                                        hasil += s + " = " + n.getAttribute(s) + "\n";
                                    }
                                    hasil+="\n";
                                    m.getTxtPresent().setText(hasil);
                                }
                            }
                        }
                    } // end of if listtoken 6
                }
                else{
                    JOptionPane.showMessageDialog(m, "TOKEN query is NOT VALID", "Validation", 
                            JOptionPane.ERROR_MESSAGE);
                    m.getTxtPresent().setText("no result");
                }
            }
        }
    }
    public boolean isFANumber(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || 
                        s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' ||
                        s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || 
                        s.charAt(i)=='9'){
                        state = 1;
                    }
                    else{
                        state = 2;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || 
                        s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || 
                        s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || 
                        s.charAt(i)=='9' || s.charAt(i)=='9'){
                        state = 1;
                    }
                    else{
                        state = 2;
                    }
                break;
                default:
                    state = 2;
            }
        }
        if(state == 1){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    
    public boolean isFAVariable(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)!='0' && s.charAt(i)!='1' && s.charAt(i)!='2' && 
                        s.charAt(i)!='3' && s.charAt(i)!='4' && s.charAt(i)!='5' && 
                        s.charAt(i)!='6' && s.charAt(i)!='7' && s.charAt(i)!='8' && 
                        s.charAt(i)!='9' && s.charAt(i)!='!' && s.charAt(i)!='@' &&
                        s.charAt(i)!='#' && s.charAt(i)!='$' && s.charAt(i)!='%' &&
                        s.charAt(i)!='^' && s.charAt(i)!='&' && s.charAt(i)!='*' &&
                        s.charAt(i)!='(' && s.charAt(i)!=')' && s.charAt(i)!='-' &&
                        s.charAt(i)!='_' && s.charAt(i)!='+' && s.charAt(i)!='=' )
                    {
                        state = 1;
                    }
                    else{
                        state = 3;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || 
                        s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || 
                        s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || 
                        s.charAt(i)=='9'){
                        state = 1;
                    }
                    else{
                        state = 1;
                    }
                break;
                default:
                    state = 3;
            }
        }
        if(state == 0 || state == 1){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAString(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='\"'){
                        state = 1;
                    }
                break;
                case 1:
                    if (s.charAt(i)!='\"'){
                        state = 2;
                    }
                break;
                case 2:
                    if (s.charAt(i)=='\"'){
                        state = 3;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 3){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAAND(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='a'){
                        state = 1;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='n'){
                        state = 2;
                    }
                break;
                case 2:
                    if (s.charAt(i)=='d'){
                        state = 3;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 3){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    
    //fungsi untuk mengecek apakah string itu or
    public boolean isFAOR(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='o'){
                        state = 1;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='r'){
                        state = 2;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 2){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAFO(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='f'){
                        state = 1;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='o'){
                        state = 2;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 2){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAFOF(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='f'){
                        state = 1;
                    }
                break;
                case 1:
                    if (s.charAt(i)=='o'){
                        state = 2;
                    }
                break;
                case 2:
                    if (s.charAt(i)=='f'){
                        state = 3;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 3){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFATitikKoma(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)==';'){
                        state = 1;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 1){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFASamaDengan(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='='){
                        state = 1;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 1){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFATitik(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='.'){
                        state = 1;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 1){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAReturn(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='r'){
                        state = 1;
                    }
                break;
                case 1:
                    if(s.charAt(i)=='e'){
                        state = 2;
                    }
                break;
                case 2:
                    if(s.charAt(i)=='t'){
                        state = 3;
                    }
                break;
                case 3:
                    if(s.charAt(i)=='u'){
                        state = 4;
                    }
                break;
                case 4:
                    if(s.charAt(i)=='r'){
                        state = 5;
                    }
                break;
                case 5:
                    if(s.charAt(i)=='n'){
                        state = 6;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 6){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAFind(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='f'){
                        state = 1;
                    }
                break;
                case 1:
                    if(s.charAt(i)=='i'){
                        state = 2;
                    }
                break;
                case 2:
                    if(s.charAt(i)=='n'){
                        state = 3;
                    }
                break;
                case 3:
                    if(s.charAt(i)=='d'){
                        state = 4;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 4){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFANode(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='n'){
                        state = 1;
                    }
                break;
                case 1:
                    if(s.charAt(i)=='o'){
                        state = 2;
                    }
                break;
                case 2:
                    if(s.charAt(i)=='d'){
                        state = 3;
                    }
                break;
                case 3:
                    if(s.charAt(i)=='e'){
                        state = 4;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 4){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    public boolean isFAWhere(String s){
        int state = 0;
        boolean status = false;
        for (int i = 0; i<s.length(); i++){
            switch (state) {
                case 0:
                    if (s.charAt(i)=='w'){
                        state = 1;
                    }
                break;
                case 1:
                    if(s.charAt(i)=='h'){
                        state = 2;
                    }
                break;
                case 2:
                    if(s.charAt(i)=='e'){
                        state = 3;
                    }
                break;
                case 3:
                    if(s.charAt(i)=='r'){
                        state = 4;
                    }
                break;
                case 4:
                    if(s.charAt(i)=='e'){
                        state = 5;
                    }
                break;
                default:
                    state = 0;
            }
        }
        if(state == 5){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
}
