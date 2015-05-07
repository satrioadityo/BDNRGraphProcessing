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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public Controller() {
        m = new Main();
        anv = new AddNodeView();
        aev = new AddEdgeView();
        atv = new AddAttributeView();
        dnv = new DeleteNodeView();
        dev = new DeleteEdgeView();
        dav = new DeleteAttributeView();
        vnv = new ViewNodeView();
        vev = new ViewEdgeView();
        
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
            String name = aev.getTxtName().getText();
            String source = aev.getTxtSource().getText();
            String dest = aev.getTxtDest().getText();
            try {
                if (!"".equals(aev.getTxtName().getText()) && !"".equals(aev.getTxtSource().getText())
                        && !"".equals(aev.getTxtDest().getText())){
                    m.getG().addEdge(name, source, dest);
                    JOptionPane.showMessageDialog(aev, "Edge berhasil ditambahkan", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    aev.setVisible(false);
                    aev.getTxtName().setText("");
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
                if ((Double)n.getAttribute("Cb")>200){
                    n.addAttribute("ui.class", "between");
                }
                System.out.println(n.getAttribute("name")+", "+n.getAttribute("Cb"));
            }
//            m.getG().display();
        }
        else if (e.equals(m.getBtnCloseness())){
            // button closeness graph display in main performed
            ClosenessCentrality cc = new ClosenessCentrality("Cc");
            cc.init(m.getG());
            cc.compute();
            for(Node n : m.getG().getEachNode()){
                if ("Infinity".equals(n.getAttribute("Cc").toString())){
                    n.setAttribute("Cc", 0);
                }
                System.err.println(n.getId()+", "+n.getAttribute("Cc").toString());
            }
            Double maxCc = m.getG().getNode("1").getAttribute("Cc");
            Node temp = null;
            for(Node n : m.getG().getEachNode()){
                if (Double.parseDouble(n.getAttribute("Cc"))>maxCc){
                    temp = n;
                }
                System.out.println(n.getId()+", "+n.getAttribute("Cc").toString());
            }
            temp.addAttribute("ui.class", "closeness");
//            System.out.println(temp.getAttribute("name")+", "+temp.getAttribute("Cc"));
//            m.getG().display();
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
                " fill-color: black;"+
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
            
            m.getG().display();
        }
        else if (e.equals(m.getBtnCluster())){
            // button cluster node graph display in main performed
            for(Node n : m.getG().getEachNode()){
                if(n.hasAttribute("name")){
                    System.out.println(n.getId()+", "+n.getAttribute("name"));
                    n.addAttribute("ui.class", "Person");
                }
                else if(n.hasAttribute("tweet")){
                    System.out.println(n.getId()+", "+n.getAttribute("tweet"));
                    n.addAttribute("ui.class", "Tweet");
                }
            }
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
    }
}
