/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummy.q.Modelo;

import comunicacion.Comunicacion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
    private AplicacionUsuario vistaDeUsuario;
    private Movimiento miMovimiento;
    
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
        }while(salida != 0);  //sale del ciclo cuando es cero
                              //esto quiere decir que es una tecla valida
        FichasRestantes[numeroAleatorio] = null;
        return aleatorio;
    } 
 
   public void PonerFichaEnMano(Comunicacion Comunica){
            vistaDeUsuario.ArrayBotonesPrincipales();
            if(miMovimiento.espaciosVacioParaFichas(vistaDeUsuario.botonesPrincipales)){
                Teclas aleatori = AgarrarFicha();
                miMovimiento.PonerFichas(vistaDeUsuario.botonesPrincipales,aleatori);
                vistaDeUsuario.ArrayBotonesPrincipalesInverso();
                Comunica.nuevaFichaMano(aleatori);
            }
   }
  
   public void Revisar_tableroVirtual(AplicacionUsuario aplicacion_actual){
       
       Teclas[][] teclasJugo = PasarBotonesAMatrizJuegoMesa(aplicacion_actual);     
       
       if(seCumplieronLasNormas(teclasJugo)){
            //si en el tablero se complieron las reglas del juego entonces
            //lo que queda es hacer es uuna comparacion entre las piezas viejas y las 
            //nuevas y esas posciones nuevas mandarlas 
            //ningun cambio significa que si en la matriz no hubo ningun cambio 
            //entonces si se cumplieron las normas entro por el if
            //pero tecnicamente el jugador deberia es de tomar una ficha
            int ningunCambio=0;
            for(int i=0; i<8; i++){
                for(int j=0; j<16; j++){
                    aplicacion_actual.comuni.nuevaFichaTablero(teclasJugo[i][j], i, j);
                     ningunCambio++; 

                            
                    
                }
            }
            if(ningunCambio==0){
                PonerFichaEnMano(aplicacion_actual.comuni);
            }
            System.out.println(ningunCambio);            
       }else {
           //cuando se le da a fin del turno y no se cumplieron las normas 
           //entonces se vuele a la poscicion que estaba antes del turno
           //y se se tiene que agarrar una nueva ficha (ficha de agarre)
           //y se manda un termina el turno
           //ademas que se hace que el panel no se pueda modificar 
            volverAlaPosicionInicial(aplicacion_actual);
            PonerFichaEnMano(aplicacion_actual.comuni);
       }
        enableComponents(false);
        aplicacion_actual.comuni.TerminarTurno();
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

  
    public void PonerEnLaMatrizTecla (Teclas teclaAponer , int x , int y ){
        
       JButton teclasSeleccionada = BuscarBotonSeleccionado(x,y);
       System.out.println(teclaAponer.numero);
       
       teclasSeleccionada.setText(teclaAponer.numero);
                
        if("rojo".equals(teclaAponer.color)){
            teclasSeleccionada.setBackground(Color.red);
            ImageIcon img = new ImageIcon("src//imagenes/Red"+teclaAponer.numero+".png");                    
            teclasSeleccionada.setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
        }    
               
        if("azul".equals(teclaAponer.color)){
            teclasSeleccionada.setBackground(Color.blue);
            ImageIcon img = new ImageIcon("src//imagenes/Blu"+teclaAponer.numero+".png");                   
            teclasSeleccionada.setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                                 
        }  
                
        if("amarillo".equals(teclaAponer.color)){
            // esto es en el caso de ser vacio 
            //esto pasa cuando habia algo y se quiero poner sin nada alli
            if ("0".equals(teclaAponer.numero)){
                    JButton aux = new JButton();
                     teclasSeleccionada.setText(aux.getText());
                     teclasSeleccionada.setBackground(aux.getBackground());
                     teclasSeleccionada.setIcon(aux.getIcon());                
        
            }else{
                teclasSeleccionada.setBackground(Color.yellow);
                ImageIcon img = new ImageIcon("src//imagenes/Yel"+teclaAponer.numero+".png");                
                teclasSeleccionada.setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
             
            }
       }  
        if("negro".equals(teclaAponer.color)){
            teclasSeleccionada.setBackground(Color.black);  
            ImageIcon img = new ImageIcon("src//imagenes/Blk"+teclaAponer.numero+".png");               
            teclasSeleccionada.setIcon(new ImageIcon(img.getImage().getScaledInstance(62, -1, Image.SCALE_DEFAULT)));                
        }
    }
    
    public void ActivarFuncionesDeTurno(){
        TeclasAlEmpiezarElTurno(vistaDeUsuario);
        enableComponents(true);
        vistaDeUsuario.EndTurn.setEnabled(true);
    }
    
    public String colorString(Color colorsito){
        if(colorsito == Color.yellow) return "amarillo";
        if(colorsito == Color.blue) return "azul";
        if(colorsito == Color.red) return "rojo";
        if(colorsito == Color.black) return "negro";        
        return "";
    }

    public Color colorFormatoColor(String colorsito){
        if("amarillo".equals(colorsito)) return Color.yellow;
        if("azul".equals(colorsito)) return Color.blue;
        if("rojo".equals(colorsito)) return Color.red;
        if("negro".equals(colorsito) ) return Color.black;        
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
   
   public void setAplicacionUsuario(AplicacionUsuario aplicacion_actual, Movimiento miMov){
       this.vistaDeUsuario= aplicacion_actual;
       miMovimiento = miMov;
   }
   
   public void intruccionEmpezarPartida(String Estacion){
        vistaDeUsuario.challengeButton2.setEnabled(false);
        vistaDeUsuario.LabelNumeroMaquina.setText(Estacion);
   }
           
    public void intruccionAgarrarFichasIniciales(Comunicacion Comunica){

        for(int i=0;i<14; i++){
            vistaDeUsuario.ArrayBotonesPrincipales();
            if(miMovimiento.espaciosVacioParaFichas(vistaDeUsuario.botonesPrincipales)){
                Teclas aleatori = AgarrarFicha();
                miMovimiento.PonerFichas(vistaDeUsuario.botonesPrincipales,aleatori);
                vistaDeUsuario.ArrayBotonesPrincipalesInverso();
                Comunica.nuevaFichaMano(aleatori);
            }
        }
    }  
    public void ActivarBotonDE14Fichas(){
        vistaDeUsuario.challengeButton.setEnabled(true);
    }
    
    public void QuitarFicha(Teclas TeclaSeleccionada){
        int salida=0;
        for(int i=0; i!=k ;i++){
               
            if(FichasRestantes[i] != null){
                if(FichasRestantes[i].numero.equals(TeclaSeleccionada.numero))
                    if(FichasRestantes[i].color.equals(TeclaSeleccionada.color))
                        salida=i; 
            }
        }
        FichasRestantes[salida] = null;
    }
    
    public JButton BuscarBotonSeleccionado(int i, int j){
             //llenado de la matriz de todos los botones
     if ( i== 0  && j==  0) return vistaDeUsuario.rackButton20;
     if ( i== 0  && j==  1) return vistaDeUsuario.rackButton21;
     if ( i== 0  && j==  2) return vistaDeUsuario.rackButton22;
     if ( i== 0  && j==  3) return vistaDeUsuario.rackButton23;
     if ( i== 0  && j==  4) return vistaDeUsuario.rackButton24;
     if ( i== 0  && j==  5) return vistaDeUsuario.rackButton25;
     if ( i== 0  && j==  6) return vistaDeUsuario.rackButton26;
     if ( i== 0  && j==  7) return vistaDeUsuario.rackButton27;
     if ( i== 0  && j==  8) return vistaDeUsuario.rackButton28;
     if ( i== 0  && j==  9) return vistaDeUsuario.rackButton29;
     if ( i== 0  && j==  10) return vistaDeUsuario.rackButton30;
     if ( i== 0  && j==  11) return vistaDeUsuario.rackButton31;
     if ( i== 0  && j==  12) return vistaDeUsuario.rackButton32;
     if ( i== 0  && j==  13) return vistaDeUsuario.rackButton33;
     if ( i== 0  && j==  14) return vistaDeUsuario.rackButton34;
     if ( i== 0  && j==  15) return vistaDeUsuario.rackButton35;

     //fila 2
     if ( i== 1  && j==  0) return vistaDeUsuario.rackButton36;
     if ( i== 1  && j==  1) return vistaDeUsuario.rackButton37;
     if ( i== 1  && j==  2) return vistaDeUsuario.rackButton38;
     if ( i== 1  && j==  3) return vistaDeUsuario.rackButton39;
     if ( i== 1  && j==  4) return vistaDeUsuario.rackButton40;
     if ( i== 1  && j==  5) return vistaDeUsuario.rackButton41;
     if ( i== 1  && j==  6) return vistaDeUsuario.rackButton42;
     if ( i== 1  && j==  7) return vistaDeUsuario.rackButton43;
     if ( i== 1  && j==  8) return vistaDeUsuario.rackButton44;
     if ( i== 1  && j==  9) return vistaDeUsuario.rackButton45;
     if ( i== 1  && j==  10) return vistaDeUsuario.rackButton46;
     if ( i== 1  && j==  11) return vistaDeUsuario.rackButton47;
     if ( i== 1  && j==  12) return vistaDeUsuario.rackButton48;
     if ( i== 1  && j==  13) return vistaDeUsuario.rackButton49;
     if ( i== 1  && j==  14) return vistaDeUsuario.rackButton50;
     if ( i== 1  && j==  15) return vistaDeUsuario.rackButton51;

     //fila 3
     if ( i== 2  && j==  0) return vistaDeUsuario.rackButton52;
     if ( i== 2  && j==  1) return vistaDeUsuario.rackButton53;
     if ( i== 2  && j==  2) return vistaDeUsuario.rackButton54;
     if ( i== 2  && j==  3) return vistaDeUsuario.rackButton55;
     if ( i== 2  && j==  4) return vistaDeUsuario.rackButton56;
     if ( i== 2  && j==  5) return vistaDeUsuario.rackButton57;
     if ( i== 2  && j==  6) return vistaDeUsuario.rackButton58;
     if ( i== 2  && j==  7) return vistaDeUsuario.rackButton59;
     if ( i== 2  && j==  8) return vistaDeUsuario.rackButton60;
     if ( i== 2  && j==  9) return vistaDeUsuario.rackButton61;
     if ( i== 2  && j==  10) return vistaDeUsuario.rackButton62;
     if ( i== 2  && j==  11) return vistaDeUsuario.rackButton63;
     if ( i== 2  && j==  12) return vistaDeUsuario.rackButton64;
     if ( i== 2  && j==  13) return vistaDeUsuario.rackButton65;
     if ( i== 2  && j==  14) return vistaDeUsuario.rackButton66;
     if ( i== 2  && j==  15) return vistaDeUsuario.rackButton67;

             //fila 4
     if ( i== 3  && j==  0) return vistaDeUsuario.rackButton68;
     if ( i== 3  && j==  1) return vistaDeUsuario.rackButton69;
     if ( i== 3  && j==  2) return vistaDeUsuario.rackButton70;
     if ( i== 3  && j==  3) return vistaDeUsuario.rackButton71;
     if ( i== 3  && j==  4) return vistaDeUsuario.rackButton72;
     if ( i== 3  && j==  5) return vistaDeUsuario.rackButton73;
     if ( i== 3  && j==  6) return vistaDeUsuario.rackButton74;
     if ( i== 3  && j==  7) return vistaDeUsuario.rackButton75;
     if ( i== 3  && j==  8) return vistaDeUsuario.rackButton76;
     if ( i== 3  && j==  9) return vistaDeUsuario.rackButton77;
     if ( i== 3  && j==  10) return vistaDeUsuario.rackButton78;
     if ( i== 3  && j==  11) return vistaDeUsuario.rackButton79;
     if ( i== 3  && j==  12) return vistaDeUsuario.rackButton80;
     if ( i== 3  && j==  13) return vistaDeUsuario.rackButton81;
     if ( i== 3  && j==  14) return vistaDeUsuario.rackButton82;
     if ( i== 3  && j==  15) return vistaDeUsuario.rackButton83;
 
     //fila 5
     if ( i== 4  && j==  0) return vistaDeUsuario.rackButton84;
     if ( i== 4  && j==  1) return vistaDeUsuario.rackButton85;
     if ( i== 4  && j==  2) return vistaDeUsuario.rackButton86;
     if ( i== 4  && j==  3) return vistaDeUsuario.rackButton87;
     if ( i== 4  && j==  4) return vistaDeUsuario.rackButton88;
     if ( i== 4  && j==  5) return vistaDeUsuario.rackButton89;
     if ( i== 4  && j==  6) return vistaDeUsuario.rackButton90;
     if ( i== 4  && j==  7) return vistaDeUsuario.rackButton91;
     if ( i== 4  && j==  8) return vistaDeUsuario.rackButton92;
     if ( i== 4  && j==  9) return vistaDeUsuario.rackButton93;
     if ( i== 4  && j==  10) return vistaDeUsuario.rackButton94;
     if ( i== 4  && j==  11) return vistaDeUsuario.rackButton95;
     if ( i== 4  && j==  12) return vistaDeUsuario.rackButton96;
     if ( i== 4  && j==  13) return vistaDeUsuario.rackButton97;
     if ( i== 4  && j==  14) return vistaDeUsuario.rackButton98;
     if ( i== 4  && j==  15) return vistaDeUsuario.rackButton99;

     //fila 6
     if ( i== 5  && j==  0) return vistaDeUsuario.rackButton100;
     if ( i== 5  && j==  1) return vistaDeUsuario.rackButton101;
     if ( i== 5  && j==  2) return vistaDeUsuario.rackButton102;
     if ( i== 5  && j==  3) return vistaDeUsuario.rackButton103;
     if ( i== 5  && j==  4) return vistaDeUsuario.rackButton104;
     if ( i== 5  && j==  5) return vistaDeUsuario.rackButton105;
     if ( i== 5  && j==  6) return vistaDeUsuario.rackButton106;
     if ( i== 5  && j==  7) return vistaDeUsuario.rackButton107;
     if ( i== 5  && j==  8) return vistaDeUsuario.rackButton108;
     if ( i== 5  && j==  9) return vistaDeUsuario.rackButton109;
     if ( i== 5  && j==  10) return vistaDeUsuario.rackButton110;
     if ( i== 5  && j==  11) return vistaDeUsuario.rackButton111;
     if ( i== 5  && j==  12) return vistaDeUsuario.rackButton112;
     if ( i== 5  && j==  13) return vistaDeUsuario.rackButton113;
     if ( i== 5  && j==  14) return vistaDeUsuario.rackButton114;
     if ( i== 5  && j==  15) return vistaDeUsuario.rackButton115;
     
     
     //fila 6
     if ( i== 6  && j==  0) return vistaDeUsuario.rackButton116;
     if ( i== 6  && j==  1) return vistaDeUsuario.rackButton117;
     if ( i== 6  && j==  2) return vistaDeUsuario.rackButton118;
     if ( i== 6  && j==  3) return vistaDeUsuario.rackButton119;
     if ( i== 6  && j==  4) return vistaDeUsuario.rackButton120;
     if ( i== 6  && j==  5) return vistaDeUsuario.rackButton121;
     if ( i== 6  && j==  6) return vistaDeUsuario.rackButton122;
     if ( i== 6  && j==  7) return vistaDeUsuario.rackButton123;
     if ( i== 6  && j==  8) return vistaDeUsuario.rackButton124;
     if ( i== 6  && j==  9) return vistaDeUsuario.rackButton125;
     if ( i== 6  && j==  10) return vistaDeUsuario.rackButton126;
     if ( i== 6  && j==  11) return vistaDeUsuario.rackButton127;
     if ( i== 6  && j==  12) return vistaDeUsuario.rackButton128;
     if ( i== 6  && j==  13) return vistaDeUsuario.rackButton129;
     if ( i== 6  && j==  14) return vistaDeUsuario.rackButton130;
     if ( i== 6  && j==  15) return vistaDeUsuario.rackButton131;  

     
     //fila 7
     if ( i== 7  && j==  0) return vistaDeUsuario.rackButton132;
     if ( i== 7  && j==  1) return vistaDeUsuario.rackButton133;
     if ( i== 7  && j==  2) return vistaDeUsuario.rackButton134;
     if ( i== 7  && j==  3) return vistaDeUsuario.rackButton135;
     if ( i== 7  && j==  4) return vistaDeUsuario.rackButton136;
     if ( i== 7  && j==  5) return vistaDeUsuario.rackButton137;
     if ( i== 7  && j==  6) return vistaDeUsuario.rackButton138;
     if ( i== 7  && j==  7) return vistaDeUsuario.rackButton139;
     if ( i== 7  && j==  8) return vistaDeUsuario.rackButton140;
     if ( i== 7  && j==  9) return vistaDeUsuario.rackButton141;
     if ( i== 7  && j==  10) return vistaDeUsuario.rackButton142;
     if ( i== 7  && j==  11) return vistaDeUsuario.rackButton143;
     if ( i== 7  && j==  12) return vistaDeUsuario.rackButton144;
     if ( i== 7  && j==  13) return vistaDeUsuario.rackButton145;
     if ( i== 7  && j==  14) return vistaDeUsuario.rackButton146;
     if ( i== 7  && j==  15) return vistaDeUsuario.rackButton147;
     
     vistaDeUsuario.rackButton147.setDisabledIcon(vistaDeUsuario.rackButton147.getIcon());
        return null;
    }
    
    
    public void enableComponents(boolean enable) {
      //fila 1 
      vistaDeUsuario.rackButton20.setDisabledIcon(vistaDeUsuario.rackButton20.getIcon());
      vistaDeUsuario.rackButton21.setDisabledIcon(vistaDeUsuario.rackButton21.getIcon());
      vistaDeUsuario.rackButton22.setDisabledIcon(vistaDeUsuario.rackButton22.getIcon());
      vistaDeUsuario.rackButton23.setDisabledIcon(vistaDeUsuario.rackButton23.getIcon());
      vistaDeUsuario.rackButton24.setDisabledIcon(vistaDeUsuario.rackButton24.getIcon());
      vistaDeUsuario.rackButton25.setDisabledIcon(vistaDeUsuario.rackButton25.getIcon());
      vistaDeUsuario.rackButton26.setDisabledIcon(vistaDeUsuario.rackButton26.getIcon());
      vistaDeUsuario.rackButton27.setDisabledIcon(vistaDeUsuario.rackButton27.getIcon());
      vistaDeUsuario.rackButton28.setDisabledIcon(vistaDeUsuario.rackButton28.getIcon());
      vistaDeUsuario.rackButton29.setDisabledIcon(vistaDeUsuario.rackButton29.getIcon());
      vistaDeUsuario.rackButton30.setDisabledIcon(vistaDeUsuario.rackButton30.getIcon());
      vistaDeUsuario.rackButton31.setDisabledIcon(vistaDeUsuario.rackButton31.getIcon());
      vistaDeUsuario.rackButton32.setDisabledIcon(vistaDeUsuario.rackButton32.getIcon());
      vistaDeUsuario.rackButton33.setDisabledIcon(vistaDeUsuario.rackButton33.getIcon());
      vistaDeUsuario.rackButton34.setDisabledIcon(vistaDeUsuario.rackButton34.getIcon());
      vistaDeUsuario.rackButton35.setDisabledIcon(vistaDeUsuario.rackButton35.getIcon());

      //fila 2
      vistaDeUsuario.rackButton36.setDisabledIcon(vistaDeUsuario.rackButton36.getIcon());
      vistaDeUsuario.rackButton37.setDisabledIcon(vistaDeUsuario.rackButton37.getIcon());
      vistaDeUsuario.rackButton38.setDisabledIcon(vistaDeUsuario.rackButton38.getIcon());
      vistaDeUsuario.rackButton39.setDisabledIcon(vistaDeUsuario.rackButton39.getIcon());
      vistaDeUsuario.rackButton40.setDisabledIcon(vistaDeUsuario.rackButton40.getIcon());
      vistaDeUsuario.rackButton41.setDisabledIcon(vistaDeUsuario.rackButton41.getIcon());
      vistaDeUsuario.rackButton42.setDisabledIcon(vistaDeUsuario.rackButton42.getIcon());
      vistaDeUsuario.rackButton43.setDisabledIcon(vistaDeUsuario.rackButton43.getIcon());
      vistaDeUsuario.rackButton44.setDisabledIcon(vistaDeUsuario.rackButton44.getIcon());
      vistaDeUsuario.rackButton45.setDisabledIcon(vistaDeUsuario.rackButton45.getIcon());
      vistaDeUsuario.rackButton46.setDisabledIcon(vistaDeUsuario.rackButton46.getIcon());
      vistaDeUsuario.rackButton47.setDisabledIcon(vistaDeUsuario.rackButton47.getIcon());
      vistaDeUsuario.rackButton48.setDisabledIcon(vistaDeUsuario.rackButton48.getIcon());
      vistaDeUsuario.rackButton49.setDisabledIcon(vistaDeUsuario.rackButton49.getIcon());
      vistaDeUsuario.rackButton50.setDisabledIcon(vistaDeUsuario.rackButton50.getIcon());
      vistaDeUsuario.rackButton51.setDisabledIcon(vistaDeUsuario.rackButton51.getIcon());

      //fila 3
      vistaDeUsuario.rackButton52.setDisabledIcon(vistaDeUsuario.rackButton52.getIcon());
      vistaDeUsuario.rackButton53.setDisabledIcon(vistaDeUsuario.rackButton53.getIcon());
      vistaDeUsuario.rackButton54.setDisabledIcon(vistaDeUsuario.rackButton54.getIcon());
      vistaDeUsuario.rackButton55.setDisabledIcon(vistaDeUsuario.rackButton55.getIcon());
      vistaDeUsuario.rackButton56.setDisabledIcon(vistaDeUsuario.rackButton56.getIcon());
      vistaDeUsuario.rackButton57.setDisabledIcon(vistaDeUsuario.rackButton57.getIcon());
      vistaDeUsuario.rackButton58.setDisabledIcon(vistaDeUsuario.rackButton58.getIcon());
      vistaDeUsuario.rackButton59.setDisabledIcon(vistaDeUsuario.rackButton59.getIcon());
      vistaDeUsuario.rackButton60.setDisabledIcon(vistaDeUsuario.rackButton60.getIcon());
      vistaDeUsuario.rackButton61.setDisabledIcon(vistaDeUsuario.rackButton61.getIcon());
      vistaDeUsuario.rackButton62.setDisabledIcon(vistaDeUsuario.rackButton62.getIcon());
      vistaDeUsuario.rackButton63.setDisabledIcon(vistaDeUsuario.rackButton63.getIcon());
      vistaDeUsuario.rackButton64.setDisabledIcon(vistaDeUsuario.rackButton64.getIcon());
      vistaDeUsuario.rackButton65.setDisabledIcon(vistaDeUsuario.rackButton65.getIcon());
      vistaDeUsuario.rackButton66.setDisabledIcon(vistaDeUsuario.rackButton66.getIcon());
      vistaDeUsuario.rackButton67.setDisabledIcon(vistaDeUsuario.rackButton67.getIcon());

              //fila 4
      vistaDeUsuario.rackButton68.setDisabledIcon(vistaDeUsuario.rackButton68.getIcon());
      vistaDeUsuario.rackButton69.setDisabledIcon(vistaDeUsuario.rackButton69.getIcon());
      vistaDeUsuario.rackButton70.setDisabledIcon(vistaDeUsuario.rackButton70.getIcon());
      vistaDeUsuario.rackButton71.setDisabledIcon(vistaDeUsuario.rackButton71.getIcon());
      vistaDeUsuario.rackButton72.setDisabledIcon(vistaDeUsuario.rackButton72.getIcon());
      vistaDeUsuario.rackButton73.setDisabledIcon(vistaDeUsuario.rackButton73.getIcon());
      vistaDeUsuario.rackButton74.setDisabledIcon(vistaDeUsuario.rackButton74.getIcon());
      vistaDeUsuario.rackButton75.setDisabledIcon(vistaDeUsuario.rackButton75.getIcon());
      vistaDeUsuario.rackButton76.setDisabledIcon(vistaDeUsuario.rackButton76.getIcon());
      vistaDeUsuario.rackButton77.setDisabledIcon(vistaDeUsuario.rackButton77.getIcon());
      vistaDeUsuario.rackButton78.setDisabledIcon(vistaDeUsuario.rackButton78.getIcon());
      vistaDeUsuario.rackButton79.setDisabledIcon(vistaDeUsuario.rackButton79.getIcon());
      vistaDeUsuario.rackButton80.setDisabledIcon(vistaDeUsuario.rackButton80.getIcon());
      vistaDeUsuario.rackButton81.setDisabledIcon(vistaDeUsuario.rackButton81.getIcon());
      vistaDeUsuario.rackButton82.setDisabledIcon(vistaDeUsuario.rackButton82.getIcon());
      vistaDeUsuario.rackButton83.setDisabledIcon(vistaDeUsuario.rackButton83.getIcon());

      //fila 5
      vistaDeUsuario.rackButton84.setDisabledIcon(vistaDeUsuario.rackButton84.getIcon());
      vistaDeUsuario.rackButton85.setDisabledIcon(vistaDeUsuario.rackButton85.getIcon());
      vistaDeUsuario.rackButton86.setDisabledIcon(vistaDeUsuario.rackButton86.getIcon());
      vistaDeUsuario.rackButton87.setDisabledIcon(vistaDeUsuario.rackButton87.getIcon());
      vistaDeUsuario.rackButton88.setDisabledIcon(vistaDeUsuario.rackButton88.getIcon());
      vistaDeUsuario.rackButton89.setDisabledIcon(vistaDeUsuario.rackButton89.getIcon());
      vistaDeUsuario.rackButton90.setDisabledIcon(vistaDeUsuario.rackButton90.getIcon());
      vistaDeUsuario.rackButton91.setDisabledIcon(vistaDeUsuario.rackButton91.getIcon());
      vistaDeUsuario.rackButton92.setDisabledIcon(vistaDeUsuario.rackButton92.getIcon());
      vistaDeUsuario.rackButton93.setDisabledIcon(vistaDeUsuario.rackButton93.getIcon());
      vistaDeUsuario.rackButton94.setDisabledIcon(vistaDeUsuario.rackButton94.getIcon());
      vistaDeUsuario.rackButton95.setDisabledIcon(vistaDeUsuario.rackButton95.getIcon());
      vistaDeUsuario.rackButton96.setDisabledIcon(vistaDeUsuario.rackButton96.getIcon());
      vistaDeUsuario.rackButton97.setDisabledIcon(vistaDeUsuario.rackButton97.getIcon());
      vistaDeUsuario.rackButton98.setDisabledIcon(vistaDeUsuario.rackButton98.getIcon());
      vistaDeUsuario.rackButton99.setDisabledIcon(vistaDeUsuario.rackButton99.getIcon());

      //fila 6
      vistaDeUsuario.rackButton100.setDisabledIcon(vistaDeUsuario.rackButton100.getIcon());
      vistaDeUsuario.rackButton101.setDisabledIcon(vistaDeUsuario.rackButton101.getIcon());
      vistaDeUsuario.rackButton102.setDisabledIcon(vistaDeUsuario.rackButton102.getIcon());
      vistaDeUsuario.rackButton103.setDisabledIcon(vistaDeUsuario.rackButton103.getIcon());
      vistaDeUsuario.rackButton104.setDisabledIcon(vistaDeUsuario.rackButton104.getIcon());
      vistaDeUsuario.rackButton105.setDisabledIcon(vistaDeUsuario.rackButton105.getIcon());
      vistaDeUsuario.rackButton106.setDisabledIcon(vistaDeUsuario.rackButton106.getIcon());
      vistaDeUsuario.rackButton107.setDisabledIcon(vistaDeUsuario.rackButton107.getIcon());
      vistaDeUsuario.rackButton108.setDisabledIcon(vistaDeUsuario.rackButton108.getIcon());
      vistaDeUsuario.rackButton109.setDisabledIcon(vistaDeUsuario.rackButton109.getIcon());
      vistaDeUsuario.rackButton110.setDisabledIcon(vistaDeUsuario.rackButton110.getIcon());
      vistaDeUsuario.rackButton111.setDisabledIcon(vistaDeUsuario.rackButton111.getIcon());
      vistaDeUsuario.rackButton112.setDisabledIcon(vistaDeUsuario.rackButton112.getIcon());
      vistaDeUsuario.rackButton113.setDisabledIcon(vistaDeUsuario.rackButton113.getIcon());
      vistaDeUsuario.rackButton114.setDisabledIcon(vistaDeUsuario.rackButton114.getIcon());
      vistaDeUsuario.rackButton115.setDisabledIcon(vistaDeUsuario.rackButton115.getIcon());


      //fila 6
      vistaDeUsuario.rackButton116.setDisabledIcon(vistaDeUsuario.rackButton116.getIcon());
      vistaDeUsuario.rackButton117.setDisabledIcon(vistaDeUsuario.rackButton117.getIcon());
      vistaDeUsuario.rackButton118.setDisabledIcon(vistaDeUsuario.rackButton118.getIcon());
      vistaDeUsuario.rackButton119.setDisabledIcon(vistaDeUsuario.rackButton119.getIcon());
      vistaDeUsuario.rackButton120.setDisabledIcon(vistaDeUsuario.rackButton120.getIcon());
      vistaDeUsuario.rackButton121.setDisabledIcon(vistaDeUsuario.rackButton121.getIcon());
      vistaDeUsuario.rackButton122.setDisabledIcon(vistaDeUsuario.rackButton122.getIcon());
      vistaDeUsuario.rackButton123.setDisabledIcon(vistaDeUsuario.rackButton123.getIcon());
      vistaDeUsuario.rackButton124.setDisabledIcon(vistaDeUsuario.rackButton124.getIcon());
      vistaDeUsuario.rackButton125.setDisabledIcon(vistaDeUsuario.rackButton125.getIcon());
      vistaDeUsuario.rackButton126.setDisabledIcon(vistaDeUsuario.rackButton126.getIcon());
      vistaDeUsuario.rackButton127.setDisabledIcon(vistaDeUsuario.rackButton127.getIcon());
      vistaDeUsuario.rackButton128.setDisabledIcon(vistaDeUsuario.rackButton128.getIcon());
      vistaDeUsuario.rackButton129.setDisabledIcon(vistaDeUsuario.rackButton129.getIcon());
      vistaDeUsuario.rackButton130.setDisabledIcon(vistaDeUsuario.rackButton130.getIcon());
      vistaDeUsuario.rackButton131.setDisabledIcon(vistaDeUsuario.rackButton131.getIcon());  


      //fila 7
      vistaDeUsuario.rackButton132.setDisabledIcon(vistaDeUsuario.rackButton132.getIcon());
      vistaDeUsuario.rackButton133.setDisabledIcon(vistaDeUsuario.rackButton133.getIcon());
      vistaDeUsuario.rackButton134.setDisabledIcon(vistaDeUsuario.rackButton134.getIcon());
      vistaDeUsuario.rackButton135.setDisabledIcon(vistaDeUsuario.rackButton135.getIcon());
      vistaDeUsuario.rackButton136.setDisabledIcon(vistaDeUsuario.rackButton136.getIcon());
      vistaDeUsuario.rackButton137.setDisabledIcon(vistaDeUsuario.rackButton137.getIcon());
      vistaDeUsuario.rackButton138.setDisabledIcon(vistaDeUsuario.rackButton138.getIcon());
      vistaDeUsuario.rackButton139.setDisabledIcon(vistaDeUsuario.rackButton139.getIcon());
      vistaDeUsuario.rackButton140.setDisabledIcon(vistaDeUsuario.rackButton140.getIcon());
      vistaDeUsuario.rackButton141.setDisabledIcon(vistaDeUsuario.rackButton141.getIcon());
      vistaDeUsuario.rackButton142.setDisabledIcon(vistaDeUsuario.rackButton142.getIcon());
      vistaDeUsuario.rackButton143.setDisabledIcon(vistaDeUsuario.rackButton143.getIcon());
      vistaDeUsuario.rackButton144.setDisabledIcon(vistaDeUsuario.rackButton144.getIcon());
      vistaDeUsuario.rackButton145.setDisabledIcon(vistaDeUsuario.rackButton145.getIcon());
      vistaDeUsuario.rackButton146.setDisabledIcon(vistaDeUsuario.rackButton146.getIcon());
      vistaDeUsuario.rackButton147.setDisabledIcon(vistaDeUsuario.rackButton147.getIcon());
      
     vistaDeUsuario.rackButton20.setEnabled(enable);
     vistaDeUsuario.rackButton21.setEnabled(enable);
     vistaDeUsuario.rackButton22.setEnabled(enable);
     vistaDeUsuario.rackButton23.setEnabled(enable);
     vistaDeUsuario.rackButton24.setEnabled(enable);
     vistaDeUsuario.rackButton25.setEnabled(enable);
     vistaDeUsuario.rackButton26.setEnabled(enable);
     vistaDeUsuario.rackButton27.setEnabled(enable);
     vistaDeUsuario.rackButton28.setEnabled(enable);
     vistaDeUsuario.rackButton29.setEnabled(enable);
     vistaDeUsuario.rackButton30.setEnabled(enable);
     vistaDeUsuario.rackButton31.setEnabled(enable);
     vistaDeUsuario.rackButton32.setEnabled(enable);
     vistaDeUsuario.rackButton33.setEnabled(enable);
     vistaDeUsuario.rackButton34.setEnabled(enable);
     vistaDeUsuario.rackButton35.setEnabled(enable);

     //fila 2
     vistaDeUsuario.rackButton36.setEnabled(enable);
     vistaDeUsuario.rackButton37.setEnabled(enable);
     vistaDeUsuario.rackButton38.setEnabled(enable);
     vistaDeUsuario.rackButton39.setEnabled(enable);
     vistaDeUsuario.rackButton40.setEnabled(enable);
     vistaDeUsuario.rackButton41.setEnabled(enable);
     vistaDeUsuario.rackButton42.setEnabled(enable);
     vistaDeUsuario.rackButton43.setEnabled(enable);
     vistaDeUsuario.rackButton44.setEnabled(enable);
     vistaDeUsuario.rackButton45.setEnabled(enable);
     vistaDeUsuario.rackButton46.setEnabled(enable);
     vistaDeUsuario.rackButton47.setEnabled(enable);
     vistaDeUsuario.rackButton48.setEnabled(enable);
     vistaDeUsuario.rackButton49.setEnabled(enable);
     vistaDeUsuario.rackButton50.setEnabled(enable);
     vistaDeUsuario.rackButton51.setEnabled(enable);

     //fila 3
     vistaDeUsuario.rackButton52.setEnabled(enable);
     vistaDeUsuario.rackButton53.setEnabled(enable);
     vistaDeUsuario.rackButton54.setEnabled(enable);
     vistaDeUsuario.rackButton55.setEnabled(enable);
     vistaDeUsuario.rackButton56.setEnabled(enable);
     vistaDeUsuario.rackButton57.setEnabled(enable);
     vistaDeUsuario.rackButton58.setEnabled(enable);
     vistaDeUsuario.rackButton59.setEnabled(enable);
     vistaDeUsuario.rackButton60.setEnabled(enable);
     vistaDeUsuario.rackButton61.setEnabled(enable);
     vistaDeUsuario.rackButton62.setEnabled(enable);
     vistaDeUsuario.rackButton63.setEnabled(enable);
     vistaDeUsuario.rackButton64.setEnabled(enable);
     vistaDeUsuario.rackButton65.setEnabled(enable);
     vistaDeUsuario.rackButton66.setEnabled(enable);
     vistaDeUsuario.rackButton67.setEnabled(enable);

             //fila 4
     vistaDeUsuario.rackButton68.setEnabled(enable);
     vistaDeUsuario.rackButton69.setEnabled(enable);
     vistaDeUsuario.rackButton70.setEnabled(enable);
     vistaDeUsuario.rackButton71.setEnabled(enable);
     vistaDeUsuario.rackButton72.setEnabled(enable);
     vistaDeUsuario.rackButton73.setEnabled(enable);
     vistaDeUsuario.rackButton74.setEnabled(enable);
     vistaDeUsuario.rackButton75.setEnabled(enable);
     vistaDeUsuario.rackButton76.setEnabled(enable);
     vistaDeUsuario.rackButton77.setEnabled(enable);
     vistaDeUsuario.rackButton78.setEnabled(enable);
     vistaDeUsuario.rackButton79.setEnabled(enable);
     vistaDeUsuario.rackButton80.setEnabled(enable);
     vistaDeUsuario.rackButton81.setEnabled(enable);
     vistaDeUsuario.rackButton82.setEnabled(enable);
     vistaDeUsuario.rackButton83.setEnabled(enable);
 
     //fila 5
     vistaDeUsuario.rackButton84.setEnabled(enable);
     vistaDeUsuario.rackButton85.setEnabled(enable);
     vistaDeUsuario.rackButton86.setEnabled(enable);
     vistaDeUsuario.rackButton87.setEnabled(enable);
     vistaDeUsuario.rackButton88.setEnabled(enable);
     vistaDeUsuario.rackButton89.setEnabled(enable);
     vistaDeUsuario.rackButton90.setEnabled(enable);
     vistaDeUsuario.rackButton91.setEnabled(enable);
     vistaDeUsuario.rackButton92.setEnabled(enable);
     vistaDeUsuario.rackButton93.setEnabled(enable);
     vistaDeUsuario.rackButton94.setEnabled(enable);
     vistaDeUsuario.rackButton95.setEnabled(enable);
     vistaDeUsuario.rackButton96.setEnabled(enable);
     vistaDeUsuario.rackButton97.setEnabled(enable);
     vistaDeUsuario.rackButton98.setEnabled(enable);
     vistaDeUsuario.rackButton99.setEnabled(enable);

     //fila 6
     vistaDeUsuario.rackButton100.setEnabled(enable);
     vistaDeUsuario.rackButton101.setEnabled(enable);
     vistaDeUsuario.rackButton102.setEnabled(enable);
     vistaDeUsuario.rackButton103.setEnabled(enable);
     vistaDeUsuario.rackButton104.setEnabled(enable);
     vistaDeUsuario.rackButton105.setEnabled(enable);
     vistaDeUsuario.rackButton106.setEnabled(enable);
     vistaDeUsuario.rackButton107.setEnabled(enable);
     vistaDeUsuario.rackButton108.setEnabled(enable);
     vistaDeUsuario.rackButton109.setEnabled(enable);
     vistaDeUsuario.rackButton110.setEnabled(enable);
     vistaDeUsuario.rackButton111.setEnabled(enable);
     vistaDeUsuario.rackButton112.setEnabled(enable);
     vistaDeUsuario.rackButton113.setEnabled(enable);
     vistaDeUsuario.rackButton114.setEnabled(enable);
     vistaDeUsuario.rackButton115.setEnabled(enable);
     
     
     //fila 6
     vistaDeUsuario.rackButton116.setEnabled(enable);
     vistaDeUsuario.rackButton117.setEnabled(enable);
     vistaDeUsuario.rackButton118.setEnabled(enable);
     vistaDeUsuario.rackButton119.setEnabled(enable);
     vistaDeUsuario.rackButton120.setEnabled(enable);
     vistaDeUsuario.rackButton121.setEnabled(enable);
     vistaDeUsuario.rackButton122.setEnabled(enable);
     vistaDeUsuario.rackButton123.setEnabled(enable);
     vistaDeUsuario.rackButton124.setEnabled(enable);
     vistaDeUsuario.rackButton125.setEnabled(enable);
     vistaDeUsuario.rackButton126.setEnabled(enable);
     vistaDeUsuario.rackButton127.setEnabled(enable);
     vistaDeUsuario.rackButton128.setEnabled(enable);
     vistaDeUsuario.rackButton129.setEnabled(enable);
     vistaDeUsuario.rackButton130.setEnabled(enable);
     vistaDeUsuario.rackButton131.setEnabled(enable);  

     
     //fila 7
     vistaDeUsuario.rackButton132.setEnabled(enable);
     vistaDeUsuario.rackButton133.setEnabled(enable);
     vistaDeUsuario.rackButton134.setEnabled(enable);
     vistaDeUsuario.rackButton135.setEnabled(enable);
     vistaDeUsuario.rackButton136.setEnabled(enable);
     vistaDeUsuario.rackButton137.setEnabled(enable);
     vistaDeUsuario.rackButton138.setEnabled(enable);
     vistaDeUsuario.rackButton139.setEnabled(enable);
     vistaDeUsuario.rackButton140.setEnabled(enable);
     vistaDeUsuario.rackButton141.setEnabled(enable);
     vistaDeUsuario.rackButton142.setEnabled(enable);
     vistaDeUsuario.rackButton143.setEnabled(enable);
     vistaDeUsuario.rackButton144.setEnabled(enable);
     vistaDeUsuario.rackButton145.setEnabled(enable);
     vistaDeUsuario.rackButton146.setEnabled(enable);
     vistaDeUsuario.rackButton147.setEnabled(enable);
    }
}
