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
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.graphstream.algorithm.BetweennessCentrality;
import org.graphstream.algorithm.Toolkit;
import org.graphstream.ui.swingViewer.DefaultView;
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
                m.getG().addNode(id);
                m.getG().getNode(id).setAttribute(key, value);
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
//                while(m.getG().getEdge(id).getAttributeKeyIterator().hasNext()){
//                    s += m.getG().getEdge(id).getAttribute(m.getG().getEdge(id).getAttributeKeySet().iterator().next());
//                    System.out.println(s);
//                }
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
            // button graph display in main performed
            BetweennessCentrality bcb = new BetweennessCentrality();
            bcb.setWeightAttributeName("weight");
//            bcb.setWeight(A, B, 1);
//            bcb.setWeight(B, E, 6);
//            bcb.setWeight(B, C, 5);
//            bcb.setWeight(E, D, 2);
//            bcb.setWeight(C, D, 3);
//            bcb.setWeight(A, E, 4);
            bcb.init(m.getG());
            bcb.compute();
            System.out.println("this this this is it");
        }
        else if (e.equals(m.getBtnDisplayGraph())){
            // button graph display in main performed
            m.getG().display();
//            int nEdge = m.getG().getEdgeCount(); // sm dgn 0;
//            while(m.getG().getNodeIterator().hasNext()){
//                if (m.getG().getEdgeCount() == 0){
//                    System.out.println(m.getG().getNodeIterator().next());
//                }
//            }
//            Viewer viewer = m.getG().display();
//            View v = viewer.getDefaultView();
//            v.resizeFrame(800, 600);
//            v.set
        }
    }
}
