/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_module;

import java.awt.Container;
import java.util.HashMap;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import mycode.Dbconnect;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Dell
 */
public class IReport extends JFrame{
    
    java.sql.Connection con=null;
    
    public IReport(String fileName)
    {
        this(fileName, null);
    }
    public IReport(String fileName, HashMap para)
    {
        super("Terranova Inn Employee Management");

        con=Dbconnect.connect(); 

        try
        {
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            
        }
        setBounds(10, 10, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        HashMap param =new HashMap();
       // param.put("abc",empid)
        
        
        
        
        
    }
    
    
    
    
}
