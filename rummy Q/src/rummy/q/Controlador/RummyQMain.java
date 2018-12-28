/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummy.q.Controlador;

import rummy.q.Modelo.TableroVirtual;
import rummy.q.Vista.AplicacionUsuario;
/**
 *
 * @author herick
 */
public class RummyQMain {
    
        public RummyQMain() {

        ////initialize MODEL and VIEW////////////////
        ////MODEL//////////////////////////////////////
        //try to initialize wordlist from text file
       /* try {
            this.wordList = new WordList();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Scrabble.class.getName()).log(Level.SEVERE, null, ex);
        }//end try/catch*/


        ////VIEW//////////////////////////////////////
        AplicacionUsuario boardWindow= new AplicacionUsuario();
        boardWindow.setVisible(true);

        
    }//end instructions    
    
}
