/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummy.q.Modelo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import rummy.q.Vista.AplicacionUsuario;

/**
 *
 * @author herick
 */
public class Movimiento {
    
    public AplicacionUsuario aplicacion;
    public JButton[] botonesPrincipales1;
    
    
    public Movimiento(AplicacionUsuario aplicacion1){
        aplicacion = aplicacion1;
    }
    
    public void PonerFichas (JButton[] botonesPrincipales , Teclas aleatorio){

        for (int i=0; i<19; i++){
            if("".equals(botonesPrincipales[i].getText())){
                botonesPrincipales[i].setText(aleatorio.numero);
                
                if("rojo".equals(aleatorio.color)){
                    botonesPrincipales[i].setBackground(Color.red);
                    ImageIcon img = new ImageIcon("src//imagenes/Red"+aleatorio.numero+".png");                    
                    botonesPrincipales[i].setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
                }    
                
                if("azul".equals(aleatorio.color)){
                    botonesPrincipales[i].setBackground(Color.blue);
                    ImageIcon img = new ImageIcon("src//imagenes/Blu"+aleatorio.numero+".png");                   
                    botonesPrincipales[i].setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                                 
                }  
                
                if("amarillo".equals(aleatorio.color)){
                    botonesPrincipales[i].setBackground(Color.yellow);
                     ImageIcon img = new ImageIcon("src//imagenes/Yel"+aleatorio.numero+".png");                
                    botonesPrincipales[i].setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
                }  
                if("negro".equals(aleatorio.color)){
                    botonesPrincipales[i].setBackground(Color.black);  
                     ImageIcon img = new ImageIcon("src//imagenes/Blk"+aleatorio.numero+".png");               
                    botonesPrincipales[i].setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
                }  
                break;
            }
            
        }
        
    }
    
    public boolean espaciosVacioParaFichas (JButton[] botonesPrincipales ){
        for (int i=0; i<19; i++)
            if("".equals(botonesPrincipales[i].getText()))
                return true;   
        
        return false;
    }
    
    
    public void BotonPresionado(java.awt.event.MouseEvent evt, JButton boton){
            if(aplicacion.Seleccionado_mouse == 0){
                String imagen= StringDeLa_imagen(boton);
                aplicacion.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon(imagen).getImage(), 
                        new Point(0,0), ""));
                aplicacion.Seleccionado_mouse=1;
                aplicacion.BotonSeleccionado= boton;
                                
            }else{
                    if("".equals(boton.getText())){
                        boton.setText(aplicacion.BotonSeleccionado.getText());
                        boton.setBackground(aplicacion.BotonSeleccionado.getBackground()); 
                        boton.setIcon(aplicacion.BotonSeleccionado.getIcon());
                        
                        aplicacion.BotonSeleccionado.setText("");
                        aplicacion.BotonSeleccionado.setBackground(Color.getColor("#f9f9f8"));
                        aplicacion.BotonSeleccionado.setIcon(null);
                        
                        aplicacion.setCursor(Cursor.getDefaultCursor());    
                        aplicacion.Seleccionado_mouse=0;                        
                    }
            }   
    }
    
    
    public String StringDeLa_imagen(JButton teclaSelecionada){
        
                if(Color.red.equals(teclaSelecionada.getBackground()))
                    return "src//imagenes/Red"+teclaSelecionada.getText()+".png";                     
                
                if(Color.blue.equals(teclaSelecionada.getBackground()))
                       return "src//imagenes/Blu"+teclaSelecionada.getText()+".png";                   
               
                if(Color.yellow.equals(teclaSelecionada.getBackground()))
                    return "src//imagenes/Yel"+teclaSelecionada.getText()+".png";                

                if(Color.black.equals(teclaSelecionada.getBackground()))
                    return "src//imagenes/Blk"+teclaSelecionada.getText()+".png";  
        return "";
    }
   
}
