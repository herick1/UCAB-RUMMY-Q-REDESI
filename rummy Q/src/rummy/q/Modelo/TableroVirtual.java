/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummy.q.Modelo;

import java.awt.Color;
import java.awt.Image;
import static java.lang.System.exit;
import static javafx.application.Platform.exit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import rummy.q.Vista.AplicacionUsuario;

/**
 *
 * @author herick
 */
public class TableroVirtual {
      
    private Teclas[] FichasRestantes;
    private Teclas aleatorio;
    private int k;
    private Teclas[][] Tablero_antes_de_jugarMesa ;   
    private Teclas[] Tablero_antes_de_jugarJugador ;   
    
    public TableroVirtual(){
        FichasRestantes = new Teclas[110];
        Tablero_antes_de_jugarMesa = new Teclas[8][16]; 
        Tablero_antes_de_jugarJugador = new Teclas[20]; 
        String[] tipo = new String[4];
        tipo[0]= "negro";
        tipo[1]= "azul";
        tipo[2]= "rojo";
        tipo[3]= "amarillo";
        k=0;
                  
        for (int i=0 ; i<4; i++ ){
            for (int j=0 ; j<=13; j++ ){
//estos if y else corresponde para que solo se llenen los dos comodines y no 4                 
                if((i==1)&&(j==0)){
                 //soy un mal comodin asi que no hago nada
                }else{
                    if((i==3)&&(j==0)){
                    //soy un mal comodin asi que no hago nada
                    }else{
                        Teclas nuevaTecla = new Teclas();
                        nuevaTecla.numero= Integer.toString(j);
                        nuevaTecla.color= tipo[i];

                        FichasRestantes[k]= nuevaTecla;
                        k++;  
                    }
                }                      
            }
        }
        //las fichas faltantes pero sin los comodines
        for (int i=0 ; i<4; i++ ){
            for (int j=1 ; j<=13; j++ ){
                Teclas nuevaTecla = new Teclas();
                nuevaTecla.numero= Integer.toString(j);
                nuevaTecla.color= tipo[i];
                FichasRestantes[k]= nuevaTecla;
                k++;  
            }                      
        }
    }
      
   public Teclas AgarrarFicha(){        
       int salida=0;
       int numeroAleatorio = (int) (Math.random() * k);
       do{                     
            aleatorio = new Teclas();
            aleatorio= FichasRestantes[numeroAleatorio];   
            if(FichasRestantes[numeroAleatorio] == null){
                numeroAleatorio = (int) (Math.random() * k);                
                salida =1;
            }
            else salida =0;          
        }while(salida != 0);     
        FichasRestantes[numeroAleatorio] = null;
        return aleatorio;
    } 
 
  
   public void Revisar_tableroVirtual(AplicacionUsuario aplicacion_actual){
       
       Teclas[][] teclasJugo = PasarBotonesAMatrizJuegoMesa(aplicacion_actual);     
       if(seCumplieronLasNormas(teclasJugo)){
           //comunicacion.Enviar_posiciones(teclasJugo);
       }else {
            volverAlaPosicionInicial(aplicacion_actual);
       }
   }
   
    public boolean seCumplieronLasNormas ( Teclas[][] teclasJugo){       
    
        for (int i=0;i<8; i++){
            for(int j=0; j<16; j++){ 
                
                //primero vemos cual es la primera casilla de esa fila que no sea nula 
                //entonces veremos que haya minimo tres que cumplan con las condiciones minima 
                if(!"".equals(teclasJugo[i][j].getText()) &&teclasJugo[i][j].getText()!= null){                    
                
                    //tipo es cero si no hay tipo , 1 si es conjunto y 2 si es escalera
                    int tipo=0;
                    
                    int correcto=0;
                    int comodin=0;
                    int Posicioncomodin=0; //si es 1 el comodin se encuentra en la primera posicion
                                           //si es 2 se encuentra en la segunda posicion
                    
                      
                    Teclas aux = teclasJugo[i][j];
                    //creo un vector auxiliar para el control de las posiciones 
                    //de la fila en la que estoy analizando
                    Teclas[] vector_correct = new Teclas[16];
                    for(int ola=0; ola<16; ola++) vector_correct[ola] = new Teclas();
                    
                    //preguntamos si el primero es un comodin
                    //ya que desde antes sabemos que es una ficha valida y no un espacio vacio
                    if("0".equals(aux.getText() )){
                        correcto++; 
                        vector_correct[0].numero="0";
                        vector_correct[0].color=""; 
                        comodin=1;
                        Posicioncomodin=1;
                        //preguntamos si la proxima tecla es nula
                        if(!"".equals(teclasJugo[i][j+1].getText()) &&teclasJugo[i][j+1].getText()!= null){
                            //preguntamos si el siguiente tambien es un comodin
                            //ya que sabemos que es una ficha valida
                            if("0".equals(teclasJugo[i][j+1].getText())){
                                correcto++; 
                                vector_correct[1].numero="0";
                                vector_correct[1].color="";
                                comodin=2;
                            }else{
                                //entonces sino es un comodin el sigueinte es un numero 
                                correcto++;
                                vector_correct[1].numero=teclasJugo[i][j+1].getText();
                                vector_correct[1].color=colorString(teclasJugo[i][j+1].getBackground());                                              
                            }
                        //en caso de que la segunda posicion sea nula
                        }else return false;
                    }else{
                    //si no es un comodin el primero entonces aux es un numero 
                        correcto++;
                        vector_correct[0].numero=teclasJugo[i][j].getText();
                        vector_correct[0].color=colorString(teclasJugo[i][j].getBackground());                       
                        
                        //preguntamos si la proxima tecla es nula
                        //ya que sabemos que hay una tecla valida
                        if(!"".equals(teclasJugo[i][j+1].getText()) && teclasJugo[i][j+1].getText()!= null){
                            //preguntamos si el siguiente tambien es un comodin
                            if("0".equals(teclasJugo[i][j+1].getText())){
                                correcto++; 
                                vector_correct[1].numero="0";
                                vector_correct[1].color="";
                                comodin=1;
                                Posicioncomodin=2; 
                            }else{
                            //ya sabemos que el segundo no es un comodin
                            //ademas que el primero tampoco es un comodin
                            
                                //preguntamos si la siguiente es conjunto
                                //del primero 
                                if(aux.getText().equals(teclasJugo[i][j+1].getText())){
                                    //preguntamos que esta siguiente no sea del mismo color a aux
                                    if(aux.getBackground() != teclasJugo[i][j+1].getBackground()){
                                        correcto++;
                                        vector_correct[1].numero=teclasJugo[i][j+1].getText();
                                        vector_correct[1].color=colorString(teclasJugo[i][j+1].getBackground());
                                        tipo=1;
                                    // si es del mismo color entonces retorna falso
                                    }else return false; 
                                }else{
                                    //preguntamos si el siguiente es escalera
                                    //hay que primero preguntar si es del mismo color
                                    if(aux.getBackground() == teclasJugo[i][j+1].getBackground()){
                                        //hay que ver si el siguiente es un numero consecutivo
                                        try{
                                            String numero = teclasJugo[i][j].getText();
                                            int numEntero = Integer.parseInt(numero);
                                            String numeroSiguiente = teclasJugo[i][j+1].getText();
                                            int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                            //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                            if(numEntero + 1 == numEnteroSiguiente){
                                                correcto++;
                                                vector_correct[1].numero=teclasJugo[i][j+1].getText();
                                                vector_correct[1].color=colorString(teclasJugo[i][j+1].getBackground());                                                
                                                tipo=2;
                                            //no es un numero consecutico por ente retorna falso
                                            }else return false;
                                        }catch(Exception e){return false;}            
                                        
                                    //no son del mismo color entonces retornaria falso
                                    }else return false;
                                }                                
                            }                       
                        //en caso de que el segundo no sea nada 
                        //entonces retorna falso
                        }else return false;            
                    }
                    
                    int sindecicion=0; //1 es que no se puede decidir
                    
                    //ahora ya que hay dos fichas que cumplen el patron se verifica la tercera
                    if((correcto == 2) && (!"".equals(teclasJugo[i][j+2].getText()) && teclasJugo[i][j+2].getText()!= null)){
                    
                        switch (comodin) {
                            case 2:
                                //entonces es una tecla que se puede poner 
                                //ya que hay dos comodines antes 
                                correcto++;
                                vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());
                                sindecicion=1;
                                break;
                            case 1:
                                //ya sabemos que no es el caso de tener dos comodines 
                                //entonces este es el caso en el que hay un comodin 
                                
                                //preguntamos si la tercera tambien es un comodin
                                if("0".equals(teclasJugo[i][j+2].getText())){
                                    correcto++; 
                                    vector_correct[2].numero="0";
                                    vector_correct[2].color="";
                                    comodin=2;
                                    sindecicion=1;
                                }else{
                                   //ysa sabemos que no son 2 comodines, que solo hay uno pero tenemos que saber cual es la 
                                   //posicion del comodin anterior para ver como comparar las dos fichas que quedan
                                    switch(Posicioncomodin){
                                        case 1:    
                                            //preguntamos si el tercero es un conjunto con respecto 
                                            //al segundo 
                                            if(teclasJugo[i][j+1].getText().equals(teclasJugo[i][j+2].getText())){
                                                //preguntamos que esta siguiente no sea del mismo color al otro
                                                if(teclasJugo[i][j+1].getBackground() != teclasJugo[i][j+2].getBackground()){
                                                    correcto++;
                                                    vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                    vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());
                                                    tipo=1;
                                                // si es del mismo color entonces retorna falso
                                                }else return false; 
                                            }else{
                                                //preguntamos si el siguiente es escalera
                                                //hay que primero preguntar si es del mismo color
                                                if(teclasJugo[i][j+1].getBackground() == teclasJugo[i][j+2].getBackground()){
                                                    //hay que ver si el siguiente es un numero consecutivo
                                                    try{
                                                        String numero = teclasJugo[i][j+1].getText();
                                                        int numEntero = Integer.parseInt(numero);
                                                        String numeroSiguiente = teclasJugo[i][j+2].getText();
                                                        int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                                        //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                                        if(numEntero + 1 == numEnteroSiguiente){
                                                            correcto++;
                                                            vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                            vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());                                                
                                                            tipo=2;
                                                        //no es un numero consecutico por ente retorna falso
                                                        }else return false;
                                                    }catch(Exception e){return false;}            
                                                //no son del mismo color entonces retornaria falso
                                                }else return false;
                                            }
                                            break;
                                        case 2:
                                            //preguntamos si el tercero es un conjunto con respecto 
                                            //al primero 
                                            if(teclasJugo[i][j].getText().equals(teclasJugo[i][j+2].getText())){
                                                //preguntamos que este siguiente no sea del mismo color al otro
                                                if(teclasJugo[i][j].getBackground() != teclasJugo[i][j+2].getBackground()){
                                                    correcto++;
                                                    vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                    vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());
                                                    tipo=1;
                                                // si es del mismo color entonces retorna falso
                                                }else return false; 
                                            }else{
                                                //preguntamos si el siguiente es escalera
                                                //hay que primero preguntar si es del mismo color
                                                if(teclasJugo[i][j].getBackground() == teclasJugo[i][j+2].getBackground()){
                                                    //hay que ver si el siguiente es un numero consecutivo
                                                    try{
                                                        String numero = teclasJugo[i][j].getText();
                                                        int numEntero = Integer.parseInt(numero);
                                                        String numeroSiguiente = teclasJugo[i][j+2].getText();
                                                        int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                                        //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                                        if(numEntero + 2 == numEnteroSiguiente){
                                                            correcto++;
                                                            vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                            vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());                                                
                                                            tipo=2;
                                                        //no es un numero consecutico por ente retorna falso
                                                        }else return false;
                                                    }catch(Exception e){return false;}            
                                                //no son del mismo color entonces retornaria falso
                                                }else return false;
                                            }
                                            break;
                                        default: return false;
                                    }                                   
                                }
                                break;
                            case 0:
                                //ya se completaron el caso de que sea dos o un solo comodin 
                                //preguntamos si la tercera es un comodin   
                                
                                //preguntamos si la tercera tambien es un comodin
                                if("0".equals(teclasJugo[i][j+2].getText())){
                                    correcto++; 
                                    vector_correct[2].numero="0";
                                    vector_correct[2].color="";
                                    comodin=2;
                                    sindecicion=1;
                                }else{
                                    //preguntamos si el tercero es un conjunto con respecto 
                                    //al segundo 
                                    if(teclasJugo[i][j+1].getText().equals(teclasJugo[i][j+2].getText())){
                                        //preguntamos que este siguiente no sea del mismo color al otro
                                        if(teclasJugo[i][j+1].getBackground() != teclasJugo[i][j+2].getBackground()){
                                            
                                            //sin embargo en este caso tambien hay que preguntar que este tercero sea de diferente color al primero
                                            //preguntamos que el primero no sea del mismo color que el tercero
                                            if(teclasJugo[i][j].getBackground() != teclasJugo[i][j+2].getBackground()){                                                                   
                                                correcto++;
                                                vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());
                                                tipo=1;
                                            // si es del mismo color entonces retorna falso
                                            }else return false;
                                        // si es del mismo color entonces retorna falso
                                        }else return false; 
                                    }else{
                                        //preguntamos si el siguiente es escalera
                                        //hay que primero preguntar si es del mismo color
                                        if(teclasJugo[i][j+1].getBackground() == teclasJugo[i][j+2].getBackground()){
                                            //hay que ver si el siguiente es un numero consecutivo
                                            try{
                                                String numero = teclasJugo[i][j+1].getText();
                                                int numEntero = Integer.parseInt(numero);
                                                String numeroSiguiente = teclasJugo[i][j+2].getText();
                                                int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                               //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                                if(numEntero + 1 == numEnteroSiguiente){
                                                    correcto++;
                                                    vector_correct[2].numero=teclasJugo[i][j+2].getText();
                                                    vector_correct[2].color=colorString(teclasJugo[i][j+2].getBackground());                                                
                                                    tipo=2;
                                                //no es un numero consecutico por ente retorna falso
                                                }else return false;
                                            }catch(Exception e){return false;}            
                                        //no son del mismo color entonces retornaria falso
                                        }else return false;
                                    }
                                }                             
                                break;
                            default: return false;
                        }                     
                    //en caso de que el tercero sea nulo o algo haya pasado antes mal
                    //con los dos primero
                    }else return false;    
                    
                    //ya se analizaron las siguientes dos teclas por eso se pone a j+2
                    j=j+2;
                    int exit=0;
                    int posicionesCoreect=3;
                    //ahora comprobamos que ya que hay 3 si hay una cuarta o mas teclas 
                    //que cumplan con las normas de conjunto o de escalera
                    for(int a=j+1; a<16 && exit == 0; a++){
                        //este ciclo se cumple hasta que haya un vacio o no haya una tecla
                        aux= teclasJugo[i][a];
                        
                        //esto es para el caso de que haya una consecutiva
                        //entonces hay que analizar dicha ficha
                        if(!"".equals(aux.getText()) && aux.getText()!= null){  
                            
                            //este es el caso en que la nueva ficha que se esta poniendo
                            //sea un comodin y por ende se incluye directamente
                            if("0".equals(aux.getText())){  
                                    correcto++; 
                                    vector_correct[posicionesCoreect].numero="0";
                                    vector_correct[posicionesCoreect].color="";
                                    posicionesCoreect++;
                            }else{
                                //si estamos en este else es decir que 
                                //la siguiente tecla no es vacia,no es un comodin
                                //pero si es una ficha con un numero 
                                
                                //se hace este for para agarrar la ficha validas entre las 3 o mas agregadas qe ya 
                                //estaban analizadas
                                for(int PoscionFichaValida=0; (PoscionFichaValida< posicionesCoreect); PoscionFichaValida++){
                                   Teclas auxRebizado=vector_correct[PoscionFichaValida];
                                   auxRebizado.setText(auxRebizado.numero);
                                   auxRebizado.setBackground(colorFormatoColor(auxRebizado.color));
                                   
                                   System.out.println("estoy aqui ? ");
                                   //vamos a recorrer el vector correcto es decir el vector con la linea
                                   //que se esta analizando y comparar con el aux que es la nueva ficha incorparada
                                   //obviamente si la ficha que estaba en el vector es un comodin el aux no se eberia comparar con
                                   //dicho comodin ya que el comodin ya fue analizado 
                                  
                                   if(!"0".equals(auxRebizado.numero)){

                                       switch(sindecicion){
                                           case 1:
                                               
                                               System.out.println("estoy aqui ? 00000 ");
                                               //esto quiere decir que hay dos comodines antes y que este cuarta ficha debe hacer 
                                               //un conjunto o una escalera
                                               
                                               //aux debe tener el mismo texto para que sea conjunto
                                               if(aux.getText().equals(auxRebizado.getText())){
                                                   //preguntamos que esta siguiente no sea del 
                                                   //mismo color al otro
                                                   
                                                   System.out.println("soy conjunto valida:"+PoscionFichaValida );
                                                   
                                                   if(aux.getBackground() != auxRebizado.getBackground()){
                                                       correcto++;
                                                       vector_correct[posicionesCoreect].numero=aux.getText();
                                                       vector_correct[posicionesCoreect].color=colorString(aux.getBackground());
                                                       posicionesCoreect++;
                                                       tipo=1;
                                                       sindecicion=0;
                                                       
                                                       //esto sigueinte es como parada del ciclo
                                                       //del vector correcto ya que si se entro aqui y se analizo esta ficha
                                                       //ajuro esta ficha tiene que ser la cuarta y por ente se tiene que salir 
                                                       //del ciclo
                                                       PoscionFichaValida= posicionesCoreect+1;
                                                       
                                                       
                                                   // si es del mismo color entonces retorna falso
                                                   }else return false; 
                                               }else {
                                                   //preguntamos si el siguiente es escalera
                                                   //hay que primero preguntar si es del mismo color
                                                   if(aux.getBackground() == auxRebizado.getBackground()){
                                                       //hay que ver si es un numero consecutivo
                                                       try{
                                                           String numero = auxRebizado.getText();
                                                           int numEntero = Integer.parseInt(numero);
                                                           String numeroSiguiente = aux.getText();
                                                           int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                                           //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                                           
                                                           System.out.println("soy escalera valida: "+PoscionFichaValida );
                                                           if(numEntero + (posicionesCoreect-PoscionFichaValida) == numEnteroSiguiente){
                                                               correcto++;
                                                               vector_correct[posicionesCoreect].numero=aux.getText();
                                                               vector_correct[posicionesCoreect].color=colorString(aux.getBackground());                                                
                                                               tipo=2;
                                                               sindecicion=0;
                                                               posicionesCoreect++;
                                                               
                                                                //esto sigueinte es como parada del ciclo
                                                                //del vector correcto ya que si se entro aqui y se analizo esta ficha
                                                                //ajuro esta ficha tiene que ser la cuarta y por ente se tiene que salir 
                                                                //del ciclo
                                                                PoscionFichaValida= posicionesCoreect+1;

                                                           //no es un numero consecutico por ente retorna falso
                                                           }else return false;
                                                       }catch(Exception e){return false;}            
                                                   //no son del mismo color entonces retornaria falso
                                                   }else return false;   
                                               }
                                            break;
                                            
                                            //esta es la opcion comun de que no hay dos comodines 
                                            //en las 3 primeras posiciones
                                           case 0:
                                               
                                   System.out.println("estoy aqui 14? ");
                                               //si estamos aqui es porque ya hay un patron de que si es conjunto
                                               //o es una escalera, por eso el siguiente switch
                                               switch(tipo){
                                                   // si tipo es de tipo 1 es un conjunto
                                                   case 1:
                                                        //aux debe tener el mismo texto
                                                       if(aux.getText().equals(auxRebizado.getText())){
                                                           System.out.println("");
                                                           //preguntamos que esta siguiente no sea del 
                                                           //mismo color al otro
                                                           if(aux.getBackground() != auxRebizado.getBackground()){
                                                               
                                                               //como estamos analizando el aux (nueva posicion) con 
                                                               //el arreglo correcto (ficha por ficha), la unica forma de agregar
                                                               //a la nueva ficha es que la misma ya se haya comparado con todo el vector
                                                               //por eso el siguiente if (que estes en la ultima pocicion del arreglo)
                                                               if(PoscionFichaValida+1 == posicionesCoreect){
                                                                    correcto++;
                                                                    vector_correct[posicionesCoreect].numero=aux.getText();
                                                                    vector_correct[posicionesCoreect].color=colorString(aux.getBackground());
                                                                    posicionesCoreect++;
                                                                    //esto sigueinte es como parada del ciclo
                                                                    //del vector correcto ya que si se entro aqui y se analizo esta ficha
                                                                    //ajuro esta ficha tiene que ser la ultima y por ente se tiene que salir 
                                                                    //del ciclo
                                                                    PoscionFichaValida= posicionesCoreect+1;
                                                               }                                                               
                                                           // si es del mismo color entonces retorna falso
                                                           }else return false; 
                                                       }else return false;

                                                       break;
                                                   case 2:
                                
                                            //preguntamos si el siguiente es escalera
                                                       //hay que primero preguntar si es del mismo color
                                                       if(aux.getBackground() == auxRebizado.getBackground()){
                                                           //hay que ver si es un numero consecutivo
                                                           try{
                                                               String numero = auxRebizado.getText();
                                                               int numEntero = Integer.parseInt(numero);
                                                               String numeroSiguiente = aux.getText();
                                                               int numEnteroSiguiente = Integer.parseInt(numeroSiguiente);                                  
                                                               //se compara qe ademas de ser el mismo color debe ser uno consectivo en numero
                                                               if(numEntero + (posicionesCoreect-PoscionFichaValida) == numEnteroSiguiente){
                                                                 
                                                                    //como estamos analizando el aux (nueva posicion) con 
                                                                    //el arreglo correcto (ficha por ficha), la unica forma de agregar
                                                                    //a la nueva ficha es que la misma ya se haya comparado con todo el vector
                                                                    //por eso el siguiente if (que estes en la ultima pocicion del arreglo)
                                                                    if(PoscionFichaValida+1 == posicionesCoreect){
                                                                        correcto++;
                                                                        vector_correct[posicionesCoreect].numero=aux.getText();
                                                                        vector_correct[posicionesCoreect].color=colorString(aux.getBackground());                                                
                                                                        posicionesCoreect++;
                                                                        //esto sigueinte es como parada del ciclo
                                                                        //del vector correcto ya que si se entro aqui y se analizo esta ficha
                                                                        //ajuro esta ficha tiene que ser la ultima y por ente se tiene que salir 
                                                                        //del ciclo
                                                                        PoscionFichaValida= posicionesCoreect+1;
                                                                    }
                                                                //no es un numero consecutico por ente retorna falso
                                                                }else return false;
                                                            }catch(Exception e){return false;}            
                                                       //no son del mismo color entonces retornaria falso
                                                       }else return false;

                                                       break;
                                                   default: return false;
                                               }

                                            break;
                                           default: return false;
                                       }
                                   }

                               }
                            }                         
                        }else{
                          j=a;
                          exit=1;
                        }                        
                    }
                }
            }
        }
     return true;
    }

    
    public String colorString(Color colorsito){
        if(colorsito == Color.yellow) return "amarillo";
        if(colorsito == Color.blue) return "azul";
        if(colorsito == Color.red) return "rojo";
        if(colorsito == Color.black) return "negro";        
        return "";
    }

    public Color colorFormatoColor(String colorsito){
        if(colorsito == "amarillo") return Color.yellow;
        if(colorsito == "azul") return Color.blue;
        if(colorsito == "rojo") return Color.red;
        if(colorsito == "negro" ) return Color.black;        
        return Color.white;
    }
    //ejecutar cuando empiece el turno para que pueda regresar a la posicion original en caso de que no cumpla 
    //las reglas
    public void TeclasAlEmpiezarElTurno(AplicacionUsuario aplicacion_actual){
        Tablero_antes_de_jugarMesa= PasarBotonesAMatrizJuegoMesa(aplicacion_actual);
        Tablero_antes_de_jugarJugador= PasarBotonesAMatrizJuegoJugador(aplicacion_actual);       
    }
    
   
   public Teclas[][] PasarBotonesAMatrizJuegoMesa (AplicacionUsuario aplicacion_actual){
             
       Teclas teclasMesa[][] = new Teclas[8][16];       

       //inicializar cada tecla
       for(int i=0; i<8; i++)
            for(int j=0; j<16; j++)
                teclasMesa[i][j] = new Teclas();

       
     //llenado de la matriz de todos los botones
     PasarBotonATecla(teclasMesa[0][0],aplicacion_actual.rackButton20);
     PasarBotonATecla(teclasMesa[0][1],aplicacion_actual.rackButton21);
     PasarBotonATecla(teclasMesa[0][2],aplicacion_actual.rackButton22);
     PasarBotonATecla(teclasMesa[0][3],aplicacion_actual.rackButton23);
     PasarBotonATecla(teclasMesa[0][4],aplicacion_actual.rackButton24);
     PasarBotonATecla(teclasMesa[0][5],aplicacion_actual.rackButton25);
     PasarBotonATecla(teclasMesa[0][6],aplicacion_actual.rackButton26);
     PasarBotonATecla(teclasMesa[0][7],aplicacion_actual.rackButton27);
     PasarBotonATecla(teclasMesa[0][8],aplicacion_actual.rackButton28);
     PasarBotonATecla(teclasMesa[0][9],aplicacion_actual.rackButton29);
     PasarBotonATecla(teclasMesa[0][10],aplicacion_actual.rackButton30);
     PasarBotonATecla(teclasMesa[0][11],aplicacion_actual.rackButton31);
     PasarBotonATecla(teclasMesa[0][12],aplicacion_actual.rackButton32);
     PasarBotonATecla(teclasMesa[0][13],aplicacion_actual.rackButton33);
     PasarBotonATecla(teclasMesa[0][14],aplicacion_actual.rackButton34);
     PasarBotonATecla(teclasMesa[0][15],aplicacion_actual.rackButton35);

     //fila 2
     PasarBotonATecla(teclasMesa[1][0],aplicacion_actual.rackButton36);
     PasarBotonATecla(teclasMesa[1][1],aplicacion_actual.rackButton37);
     PasarBotonATecla(teclasMesa[1][2],aplicacion_actual.rackButton38);
     PasarBotonATecla(teclasMesa[1][3],aplicacion_actual.rackButton39);
     PasarBotonATecla(teclasMesa[1][4],aplicacion_actual.rackButton40);
     PasarBotonATecla(teclasMesa[1][5],aplicacion_actual.rackButton41);
     PasarBotonATecla(teclasMesa[1][6],aplicacion_actual.rackButton42);
     PasarBotonATecla(teclasMesa[1][7],aplicacion_actual.rackButton43);
     PasarBotonATecla(teclasMesa[1][8],aplicacion_actual.rackButton44);
     PasarBotonATecla(teclasMesa[1][9],aplicacion_actual.rackButton45);
     PasarBotonATecla(teclasMesa[1][10],aplicacion_actual.rackButton46);
     PasarBotonATecla(teclasMesa[1][11],aplicacion_actual.rackButton47);
     PasarBotonATecla(teclasMesa[1][12],aplicacion_actual.rackButton48);
     PasarBotonATecla(teclasMesa[1][13],aplicacion_actual.rackButton49);
     PasarBotonATecla(teclasMesa[1][14],aplicacion_actual.rackButton50);
     PasarBotonATecla(teclasMesa[1][15],aplicacion_actual.rackButton51);

     //fila 3
     PasarBotonATecla(teclasMesa[2][0],aplicacion_actual.rackButton52);
     PasarBotonATecla(teclasMesa[2][1],aplicacion_actual.rackButton53);
     PasarBotonATecla(teclasMesa[2][2],aplicacion_actual.rackButton54);
     PasarBotonATecla(teclasMesa[2][3],aplicacion_actual.rackButton55);
     PasarBotonATecla(teclasMesa[2][4],aplicacion_actual.rackButton56);
     PasarBotonATecla(teclasMesa[2][5],aplicacion_actual.rackButton57);
     PasarBotonATecla(teclasMesa[2][6],aplicacion_actual.rackButton58);
     PasarBotonATecla(teclasMesa[2][7],aplicacion_actual.rackButton59);
     PasarBotonATecla(teclasMesa[2][8],aplicacion_actual.rackButton60);
     PasarBotonATecla(teclasMesa[2][9],aplicacion_actual.rackButton61);
     PasarBotonATecla(teclasMesa[2][10],aplicacion_actual.rackButton62);
     PasarBotonATecla(teclasMesa[2][11],aplicacion_actual.rackButton63);
     PasarBotonATecla(teclasMesa[2][12],aplicacion_actual.rackButton64);
     PasarBotonATecla(teclasMesa[2][13],aplicacion_actual.rackButton65);
     PasarBotonATecla(teclasMesa[2][14],aplicacion_actual.rackButton66);
     PasarBotonATecla(teclasMesa[2][15],aplicacion_actual.rackButton67);

             //fila 4
     PasarBotonATecla(teclasMesa[3][0],aplicacion_actual.rackButton68);
     PasarBotonATecla(teclasMesa[3][1],aplicacion_actual.rackButton69);
     PasarBotonATecla(teclasMesa[3][2],aplicacion_actual.rackButton70);
     PasarBotonATecla(teclasMesa[3][3],aplicacion_actual.rackButton71);
     PasarBotonATecla(teclasMesa[3][4],aplicacion_actual.rackButton72);
     PasarBotonATecla(teclasMesa[3][5],aplicacion_actual.rackButton73);
     PasarBotonATecla(teclasMesa[3][6],aplicacion_actual.rackButton74);
     PasarBotonATecla(teclasMesa[3][7],aplicacion_actual.rackButton75);
     PasarBotonATecla(teclasMesa[3][8],aplicacion_actual.rackButton76);
     PasarBotonATecla(teclasMesa[3][9],aplicacion_actual.rackButton77);
     PasarBotonATecla(teclasMesa[3][10],aplicacion_actual.rackButton78);
     PasarBotonATecla(teclasMesa[3][11],aplicacion_actual.rackButton79);
     PasarBotonATecla(teclasMesa[3][12],aplicacion_actual.rackButton80);
     PasarBotonATecla(teclasMesa[3][13],aplicacion_actual.rackButton81);
     PasarBotonATecla(teclasMesa[3][14],aplicacion_actual.rackButton82);
     PasarBotonATecla(teclasMesa[3][15],aplicacion_actual.rackButton83);
 
     //fila 5
     PasarBotonATecla(teclasMesa[4][0],aplicacion_actual.rackButton84);
     PasarBotonATecla(teclasMesa[4][1],aplicacion_actual.rackButton85);
     PasarBotonATecla(teclasMesa[4][2],aplicacion_actual.rackButton86);
     PasarBotonATecla(teclasMesa[4][3],aplicacion_actual.rackButton87);
     PasarBotonATecla(teclasMesa[4][4],aplicacion_actual.rackButton88);
     PasarBotonATecla(teclasMesa[4][5],aplicacion_actual.rackButton89);
     PasarBotonATecla(teclasMesa[4][6],aplicacion_actual.rackButton90);
     PasarBotonATecla(teclasMesa[4][7],aplicacion_actual.rackButton91);
     PasarBotonATecla(teclasMesa[4][8],aplicacion_actual.rackButton92);
     PasarBotonATecla(teclasMesa[4][9],aplicacion_actual.rackButton93);
     PasarBotonATecla(teclasMesa[4][10],aplicacion_actual.rackButton94);
     PasarBotonATecla(teclasMesa[4][11],aplicacion_actual.rackButton95);
     PasarBotonATecla(teclasMesa[4][12],aplicacion_actual.rackButton96);
     PasarBotonATecla(teclasMesa[4][13],aplicacion_actual.rackButton97);
     PasarBotonATecla(teclasMesa[4][14],aplicacion_actual.rackButton98);
     PasarBotonATecla(teclasMesa[4][15],aplicacion_actual.rackButton99);

     //fila 6
     PasarBotonATecla(teclasMesa[5][0],aplicacion_actual.rackButton100);
     PasarBotonATecla(teclasMesa[5][1],aplicacion_actual.rackButton101);
     PasarBotonATecla(teclasMesa[5][2],aplicacion_actual.rackButton102);
     PasarBotonATecla(teclasMesa[5][3],aplicacion_actual.rackButton103);
     PasarBotonATecla(teclasMesa[5][4],aplicacion_actual.rackButton104);
     PasarBotonATecla(teclasMesa[5][5],aplicacion_actual.rackButton105);
     PasarBotonATecla(teclasMesa[5][6],aplicacion_actual.rackButton106);
     PasarBotonATecla(teclasMesa[5][7],aplicacion_actual.rackButton107);
     PasarBotonATecla(teclasMesa[5][8],aplicacion_actual.rackButton108);
     PasarBotonATecla(teclasMesa[5][9],aplicacion_actual.rackButton109);
     PasarBotonATecla(teclasMesa[5][10],aplicacion_actual.rackButton110);
     PasarBotonATecla(teclasMesa[5][11],aplicacion_actual.rackButton111);
     PasarBotonATecla(teclasMesa[5][12],aplicacion_actual.rackButton112);
     PasarBotonATecla(teclasMesa[5][13],aplicacion_actual.rackButton113);
     PasarBotonATecla(teclasMesa[5][14],aplicacion_actual.rackButton114);
     PasarBotonATecla(teclasMesa[5][15],aplicacion_actual.rackButton115);
     
     
     //fila 6
     PasarBotonATecla(teclasMesa[6][0],aplicacion_actual.rackButton116);
     PasarBotonATecla(teclasMesa[6][1],aplicacion_actual.rackButton117);
     PasarBotonATecla(teclasMesa[6][2],aplicacion_actual.rackButton118);
     PasarBotonATecla(teclasMesa[6][3],aplicacion_actual.rackButton119);
     PasarBotonATecla(teclasMesa[6][4],aplicacion_actual.rackButton120);
     PasarBotonATecla(teclasMesa[6][5],aplicacion_actual.rackButton121);
     PasarBotonATecla(teclasMesa[6][6],aplicacion_actual.rackButton122);
     PasarBotonATecla(teclasMesa[6][7],aplicacion_actual.rackButton123);
     PasarBotonATecla(teclasMesa[6][8],aplicacion_actual.rackButton124);
     PasarBotonATecla(teclasMesa[6][9],aplicacion_actual.rackButton125);
     PasarBotonATecla(teclasMesa[6][10],aplicacion_actual.rackButton126);
     PasarBotonATecla(teclasMesa[6][11],aplicacion_actual.rackButton127);
     PasarBotonATecla(teclasMesa[6][12],aplicacion_actual.rackButton128);
     PasarBotonATecla(teclasMesa[6][13],aplicacion_actual.rackButton129);
     PasarBotonATecla(teclasMesa[6][14],aplicacion_actual.rackButton130);
     PasarBotonATecla(teclasMesa[6][15],aplicacion_actual.rackButton131);  

     
     //fila 7
     PasarBotonATecla(teclasMesa[7][0],aplicacion_actual.rackButton132);
     PasarBotonATecla(teclasMesa[7][1],aplicacion_actual.rackButton133);
     PasarBotonATecla(teclasMesa[7][2],aplicacion_actual.rackButton134);
     PasarBotonATecla(teclasMesa[7][3],aplicacion_actual.rackButton135);
     PasarBotonATecla(teclasMesa[7][4],aplicacion_actual.rackButton136);
     PasarBotonATecla(teclasMesa[7][5],aplicacion_actual.rackButton137);
     PasarBotonATecla(teclasMesa[7][6],aplicacion_actual.rackButton138);
     PasarBotonATecla(teclasMesa[7][7],aplicacion_actual.rackButton139);
     PasarBotonATecla(teclasMesa[7][8],aplicacion_actual.rackButton140);
     PasarBotonATecla(teclasMesa[7][9],aplicacion_actual.rackButton141);
     PasarBotonATecla(teclasMesa[7][10],aplicacion_actual.rackButton142);
     PasarBotonATecla(teclasMesa[7][11],aplicacion_actual.rackButton143);
     PasarBotonATecla(teclasMesa[7][12],aplicacion_actual.rackButton144);
     PasarBotonATecla(teclasMesa[7][13],aplicacion_actual.rackButton145);
     PasarBotonATecla(teclasMesa[7][14],aplicacion_actual.rackButton146);
     PasarBotonATecla(teclasMesa[7][15],aplicacion_actual.rackButton147);
     
       return teclasMesa;
   }
   
    
   public Teclas[] PasarBotonesAMatrizJuegoJugador (AplicacionUsuario aplicacion_actual){
        Teclas teclasJugador[] = new Teclas[20]; 
        for(int i=0; i<20; i++)
                teclasJugador[i]= new Teclas();
       
        PasarBotonATecla(teclasJugador[0],aplicacion_actual.rackButton1);          
        PasarBotonATecla(teclasJugador[1],aplicacion_actual.rackButton2); 
        PasarBotonATecla(teclasJugador[2],aplicacion_actual.rackButton3); 
        PasarBotonATecla(teclasJugador[3],aplicacion_actual.rackButton4); 
        PasarBotonATecla(teclasJugador[4],aplicacion_actual.rackButton5); 
        PasarBotonATecla(teclasJugador[5],aplicacion_actual.rackButton6); 
        PasarBotonATecla(teclasJugador[6],aplicacion_actual.rackButton7); 
        PasarBotonATecla(teclasJugador[7],aplicacion_actual.rackButton8); 
        PasarBotonATecla(teclasJugador[8],aplicacion_actual.rackButton9); 
        PasarBotonATecla(teclasJugador[9],aplicacion_actual.rackButton10);
        PasarBotonATecla(teclasJugador[10],aplicacion_actual.rackButton11);  
        PasarBotonATecla(teclasJugador[11],aplicacion_actual.rackButton12); 
        PasarBotonATecla(teclasJugador[12],aplicacion_actual.rackButton13); 
        PasarBotonATecla(teclasJugador[13],aplicacion_actual.rackButton14);
        PasarBotonATecla(teclasJugador[14],aplicacion_actual.rackButton15);
        PasarBotonATecla(teclasJugador[15],aplicacion_actual.rackButton16);
        PasarBotonATecla(teclasJugador[16],aplicacion_actual.rackButton17);
        PasarBotonATecla(teclasJugador[17],aplicacion_actual.rackButton18);
        PasarBotonATecla(teclasJugador[18],aplicacion_actual.rackButton19); 
        return teclasJugador;  
   }
    
   public void volverAlaPosicionInicial(AplicacionUsuario aplicacion_actual){

    //fila1
    PasarTeclaABoton(aplicacion_actual.rackButton20,Tablero_antes_de_jugarMesa[0][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton21,Tablero_antes_de_jugarMesa[0][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton22,Tablero_antes_de_jugarMesa[0][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton23,Tablero_antes_de_jugarMesa[0][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton24,Tablero_antes_de_jugarMesa[0][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton25,Tablero_antes_de_jugarMesa[0][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton26,Tablero_antes_de_jugarMesa[0][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton27,Tablero_antes_de_jugarMesa[0][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton28,Tablero_antes_de_jugarMesa[0][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton29,Tablero_antes_de_jugarMesa[0][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton30,Tablero_antes_de_jugarMesa[0][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton31,Tablero_antes_de_jugarMesa[0][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton32,Tablero_antes_de_jugarMesa[0][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton33,Tablero_antes_de_jugarMesa[0][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton34,Tablero_antes_de_jugarMesa[0][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton35,Tablero_antes_de_jugarMesa[0][15]);

    //fila 2
    PasarTeclaABoton(aplicacion_actual.rackButton36,Tablero_antes_de_jugarMesa[1][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton37,Tablero_antes_de_jugarMesa[1][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton38,Tablero_antes_de_jugarMesa[1][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton39,Tablero_antes_de_jugarMesa[1][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton40,Tablero_antes_de_jugarMesa[1][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton41,Tablero_antes_de_jugarMesa[1][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton42,Tablero_antes_de_jugarMesa[1][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton43,Tablero_antes_de_jugarMesa[1][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton44,Tablero_antes_de_jugarMesa[1][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton45,Tablero_antes_de_jugarMesa[1][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton46,Tablero_antes_de_jugarMesa[1][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton47,Tablero_antes_de_jugarMesa[1][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton48,Tablero_antes_de_jugarMesa[1][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton49,Tablero_antes_de_jugarMesa[1][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton50,Tablero_antes_de_jugarMesa[1][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton51,Tablero_antes_de_jugarMesa[1][15]);
    
    //fila 3
    PasarTeclaABoton(aplicacion_actual.rackButton52,Tablero_antes_de_jugarMesa[2][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton53,Tablero_antes_de_jugarMesa[2][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton54,Tablero_antes_de_jugarMesa[2][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton55,Tablero_antes_de_jugarMesa[2][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton56,Tablero_antes_de_jugarMesa[2][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton57,Tablero_antes_de_jugarMesa[2][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton58,Tablero_antes_de_jugarMesa[2][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton59,Tablero_antes_de_jugarMesa[2][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton60,Tablero_antes_de_jugarMesa[2][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton61,Tablero_antes_de_jugarMesa[2][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton62,Tablero_antes_de_jugarMesa[2][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton63,Tablero_antes_de_jugarMesa[2][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton64,Tablero_antes_de_jugarMesa[2][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton65,Tablero_antes_de_jugarMesa[2][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton66,Tablero_antes_de_jugarMesa[2][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton67,Tablero_antes_de_jugarMesa[2][15]);
   
    //fila 4
    PasarTeclaABoton(aplicacion_actual.rackButton68,Tablero_antes_de_jugarMesa[3][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton69,Tablero_antes_de_jugarMesa[3][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton70,Tablero_antes_de_jugarMesa[3][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton71,Tablero_antes_de_jugarMesa[3][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton72,Tablero_antes_de_jugarMesa[3][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton73,Tablero_antes_de_jugarMesa[3][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton74,Tablero_antes_de_jugarMesa[3][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton75,Tablero_antes_de_jugarMesa[3][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton76,Tablero_antes_de_jugarMesa[3][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton77,Tablero_antes_de_jugarMesa[3][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton78,Tablero_antes_de_jugarMesa[3][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton79,Tablero_antes_de_jugarMesa[3][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton80,Tablero_antes_de_jugarMesa[3][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton81,Tablero_antes_de_jugarMesa[3][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton82,Tablero_antes_de_jugarMesa[3][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton83,Tablero_antes_de_jugarMesa[3][15]);
    
    //fila 5 
    PasarTeclaABoton(aplicacion_actual.rackButton84,Tablero_antes_de_jugarMesa[4][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton85,Tablero_antes_de_jugarMesa[4][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton86,Tablero_antes_de_jugarMesa[4][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton87,Tablero_antes_de_jugarMesa[4][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton88,Tablero_antes_de_jugarMesa[4][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton89,Tablero_antes_de_jugarMesa[4][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton90,Tablero_antes_de_jugarMesa[4][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton91,Tablero_antes_de_jugarMesa[4][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton92,Tablero_antes_de_jugarMesa[4][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton93,Tablero_antes_de_jugarMesa[4][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton94,Tablero_antes_de_jugarMesa[4][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton95,Tablero_antes_de_jugarMesa[4][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton96,Tablero_antes_de_jugarMesa[4][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton97,Tablero_antes_de_jugarMesa[4][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton98,Tablero_antes_de_jugarMesa[4][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton99,Tablero_antes_de_jugarMesa[4][15]);
    
    //fila 6 
    PasarTeclaABoton(aplicacion_actual.rackButton100,Tablero_antes_de_jugarMesa[5][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton101,Tablero_antes_de_jugarMesa[5][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton102,Tablero_antes_de_jugarMesa[5][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton103,Tablero_antes_de_jugarMesa[5][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton104,Tablero_antes_de_jugarMesa[5][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton105,Tablero_antes_de_jugarMesa[5][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton106,Tablero_antes_de_jugarMesa[5][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton107,Tablero_antes_de_jugarMesa[5][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton108,Tablero_antes_de_jugarMesa[5][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton109,Tablero_antes_de_jugarMesa[5][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton110,Tablero_antes_de_jugarMesa[5][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton111,Tablero_antes_de_jugarMesa[5][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton112,Tablero_antes_de_jugarMesa[5][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton113,Tablero_antes_de_jugarMesa[5][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton114,Tablero_antes_de_jugarMesa[5][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton115,Tablero_antes_de_jugarMesa[5][15]);
    
    //fila 7 
    PasarTeclaABoton(aplicacion_actual.rackButton116,Tablero_antes_de_jugarMesa[6][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton117,Tablero_antes_de_jugarMesa[6][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton118,Tablero_antes_de_jugarMesa[6][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton119,Tablero_antes_de_jugarMesa[6][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton120,Tablero_antes_de_jugarMesa[6][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton121,Tablero_antes_de_jugarMesa[6][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton122,Tablero_antes_de_jugarMesa[6][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton123,Tablero_antes_de_jugarMesa[6][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton124,Tablero_antes_de_jugarMesa[6][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton125,Tablero_antes_de_jugarMesa[6][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton126,Tablero_antes_de_jugarMesa[6][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton127,Tablero_antes_de_jugarMesa[6][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton128,Tablero_antes_de_jugarMesa[6][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton129,Tablero_antes_de_jugarMesa[6][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton130,Tablero_antes_de_jugarMesa[6][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton131,Tablero_antes_de_jugarMesa[6][15]);
    
    //fila 8
    PasarTeclaABoton(aplicacion_actual.rackButton132,Tablero_antes_de_jugarMesa[7][0]);
    PasarTeclaABoton(aplicacion_actual.rackButton133,Tablero_antes_de_jugarMesa[7][1]);
    PasarTeclaABoton(aplicacion_actual.rackButton134,Tablero_antes_de_jugarMesa[7][2]);
    PasarTeclaABoton(aplicacion_actual.rackButton135,Tablero_antes_de_jugarMesa[7][3]);
    PasarTeclaABoton(aplicacion_actual.rackButton136,Tablero_antes_de_jugarMesa[7][4]);
    PasarTeclaABoton(aplicacion_actual.rackButton137,Tablero_antes_de_jugarMesa[7][5]);
    PasarTeclaABoton(aplicacion_actual.rackButton138,Tablero_antes_de_jugarMesa[7][6]);
    PasarTeclaABoton(aplicacion_actual.rackButton139,Tablero_antes_de_jugarMesa[7][7]);
    PasarTeclaABoton(aplicacion_actual.rackButton140,Tablero_antes_de_jugarMesa[7][8]);
    PasarTeclaABoton(aplicacion_actual.rackButton141,Tablero_antes_de_jugarMesa[7][9]);
    PasarTeclaABoton(aplicacion_actual.rackButton142,Tablero_antes_de_jugarMesa[7][10]);
    PasarTeclaABoton(aplicacion_actual.rackButton143,Tablero_antes_de_jugarMesa[7][11]);
    PasarTeclaABoton(aplicacion_actual.rackButton144,Tablero_antes_de_jugarMesa[7][12]);
    PasarTeclaABoton(aplicacion_actual.rackButton145,Tablero_antes_de_jugarMesa[7][13]);
    PasarTeclaABoton(aplicacion_actual.rackButton146,Tablero_antes_de_jugarMesa[7][14]);
    PasarTeclaABoton(aplicacion_actual.rackButton147,Tablero_antes_de_jugarMesa[7][15]);
    
    
    //Jugador
    PasarTeclaABoton(aplicacion_actual.rackButton1,Tablero_antes_de_jugarJugador[0]);
    PasarTeclaABoton(aplicacion_actual.rackButton2,Tablero_antes_de_jugarJugador[1]);
    PasarTeclaABoton(aplicacion_actual.rackButton3,Tablero_antes_de_jugarJugador[2]);
    PasarTeclaABoton(aplicacion_actual.rackButton4,Tablero_antes_de_jugarJugador[3]);
    PasarTeclaABoton(aplicacion_actual.rackButton5,Tablero_antes_de_jugarJugador[4]);
    PasarTeclaABoton(aplicacion_actual.rackButton6,Tablero_antes_de_jugarJugador[5]);
    PasarTeclaABoton(aplicacion_actual.rackButton7,Tablero_antes_de_jugarJugador[6]);
    PasarTeclaABoton(aplicacion_actual.rackButton8,Tablero_antes_de_jugarJugador[7]);
    PasarTeclaABoton(aplicacion_actual.rackButton9,Tablero_antes_de_jugarJugador[8]);
    PasarTeclaABoton(aplicacion_actual.rackButton10,Tablero_antes_de_jugarJugador[9]);
    PasarTeclaABoton(aplicacion_actual.rackButton11,Tablero_antes_de_jugarJugador[10]);
    PasarTeclaABoton(aplicacion_actual.rackButton12,Tablero_antes_de_jugarJugador[11]);
    PasarTeclaABoton(aplicacion_actual.rackButton13,Tablero_antes_de_jugarJugador[12]);
    PasarTeclaABoton(aplicacion_actual.rackButton14,Tablero_antes_de_jugarJugador[13]);
    PasarTeclaABoton(aplicacion_actual.rackButton15,Tablero_antes_de_jugarJugador[14]);
    PasarTeclaABoton(aplicacion_actual.rackButton16,Tablero_antes_de_jugarJugador[15]);
    PasarTeclaABoton(aplicacion_actual.rackButton17,Tablero_antes_de_jugarJugador[16]);
    PasarTeclaABoton(aplicacion_actual.rackButton18,Tablero_antes_de_jugarJugador[17]);
    PasarTeclaABoton(aplicacion_actual.rackButton19,Tablero_antes_de_jugarJugador[18]); 
   }
   
   
   public void PasarTeclaABoton(JButton boton , Teclas teclaSeleccionada){           
        boton.setText(teclaSeleccionada.getText());
        boton.setBackground(teclaSeleccionada.getBackground());    
        boton.setIcon(teclaSeleccionada.getIcon());                   
    }
   
   public void PasarBotonATecla(Teclas teclaSeleccionada,JButton boton ){
       teclaSeleccionada.setBackground(boton.getBackground());
       teclaSeleccionada.setText(boton.getText());
       teclaSeleccionada.setIcon(boton.getIcon());
   }
   
}
