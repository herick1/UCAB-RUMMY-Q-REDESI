/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package comunicacion;
import com.fazecast.jSerialComm.*;
import java.awt.Color;
import java.util.ArrayList;
import rummy.q.Modelo.TableroVirtual;
import rummy.q.Modelo.Teclas;
/**
 *
 * @author HERICK
 *
 * 
 */
public class Comunicacion implements Runnable{
    SerialPort puertoEntrada;
    SerialPort puertoSalida;
    String flag = "01111110";
    String estacion;   
    private TableroVirtual MiTablero;
    
    public Comunicacion(int entrada, int salida){
        puertoEntrada = SerialPort.getCommPorts()[entrada];
        puertoEntrada.setComPortParameters(2400, 8, 0, 1);
        //puertoEntrada.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 1, 1);
        puertoEntrada.openPort();
        if(entrada!=salida){
            // Los puertos de salida y entrada son diferentes(para realizar pruebas en una sola maquina)
            puertoSalida = SerialPort.getCommPorts()[salida];
            puertoSalida.setComPortParameters(2400, 8, 0, 1);
            //puertoSalida.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 1, 1);
            puertoSalida.openPort(); 
        }
        else{
            // COnfiguracion real en el laboratorio
            puertoSalida=puertoEntrada;
        }       
    }
    
    public String getEstacion() {
        return estacion;
    }
    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }
    
    public void TableroVirtual ( TableroVirtual MiTablero1){
        MiTablero=MiTablero1;
    }
    
    public static String pasarByteAString(byte b){
        String retorno = Integer.toBinaryString(b & 0xFF);
        //Para asegurar que sean 8 caracteres(llenar de ceros a la izquierda)
        while(retorno.length()<8) retorno = "0" + retorno;
        return retorno;
    }
    public void IniciarPartida(){
        setEstacion("00");
        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(this.flag, 2);
        envio[1] = (byte)Short.parseShort(estacion+"111000", 2);
        envio[2] = (byte)Short.parseShort("00000000", 2);
        envio[3] = (byte)Short.parseShort("00000000", 2);
        envio[4] = (byte)Short.parseShort(this.flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
                +" "+pasarByteAString(envio[4])
                +"\n");
        this.puertoSalida.writeBytes(envio, envio.length);
    }
    
    // genera la lista de los puertos disponibles
    public static ArrayList<String> listaPuertos(){
        ArrayList<String> puertos = new ArrayList<String>();
        SerialPort[] comPort = SerialPort.getCommPorts();
        for (int i=0; i<comPort.length; i++){
            puertos.add(comPort[i].getDescriptivePortName());
        }
        return puertos;
    }
     
    public void TerminarTurno(){

        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(flag, 2);
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"011", 2);
        envio[2] = (byte)Short.parseShort("00000000", 2);
        envio[3] = (byte)Short.parseShort("00000000", 2);
        envio[4] = (byte)Short.parseShort(flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
                +"\n");
        puertoSalida.writeBytes(envio, envio.length);
    }

    public void FinPartida(){
        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(flag, 2);
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"111", 2);
        envio[2] = (byte)Short.parseShort("00000000", 2);
        envio[3] = (byte)Short.parseShort("00000000", 2);
        envio[4] = (byte)Short.parseShort(flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
                +"\n");
        puertoSalida.writeBytes(envio, envio.length);
    }
    
    public void nuevaFichaMano(Teclas TeclaHecha){

        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(flag, 2);
        envio[1] = (byte)Short.parseShort(estacion+"111"+"001", 2);
        String numerobit= teclaTexto(TeclaHecha.numero);
        String color = TeclaColor(TeclaHecha.color);
        envio[2] = (byte)Short.parseShort("00"+color+numerobit, 2);
        envio[3] = (byte)Short.parseShort("00000000", 2);
        envio[4] = (byte)Short.parseShort(flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
                +" "+pasarByteAString(envio[4])
                +"\n");
        puertoSalida.writeBytes(envio, envio.length);
    }
       
    public void nuevaFichaTablero(Teclas TeclaHecha, int PosicionFila, int PosicionColumna){

        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(flag, 2);
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"010", 2);
        String numerobit= teclaTexto(TeclaHecha.getText());
        String color = TeclaColor(TeclaHecha.getBackground());
        envio[2] = (byte)Short.parseShort("00"+color+numerobit, 2);
        String posicionx= posicionXString(PosicionFila);
        String posiciony = posicionYString(PosicionColumna);        
        envio[3] = (byte)Short.parseShort("0"+posicionx+posiciony, 2);
        envio[4] = (byte)Short.parseShort(flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
                +" "+pasarByteAString(envio[4])
                +"\n");
        puertoSalida.writeBytes(envio, envio.length);
    }    
    
    
    public String teclaTexto(String Texto){
        if("0".equals(Texto)) return "0000";
        if("1".equals(Texto)) return "0001";
        if("2".equals(Texto)) return "0010";
        if("3".equals(Texto)) return "0011";
        if("4".equals(Texto)) return "0100";
        if("5".equals(Texto)) return "0101";
        if("6".equals(Texto)) return "0110";
        if("7".equals(Texto)) return "0111";
        if("8".equals(Texto)) return "1000";
        if("9".equals(Texto)) return "1001";
        if("10".equals(Texto)) return "1010";
        if("11".equals(Texto)) return "1011";
        if("12".equals(Texto)) return "1100";
        if("13".equals(Texto)) return "1101";       
        return "0000";
    }
    
    public String TeclaColor(String colorsito){
        if("amarillo".equals(colorsito)) return "00";
        if("azul".equals(colorsito)) return "01";
        if("rojo".equals(colorsito)) return "10";
        if("negro".equals(colorsito)) return "11";        
        return "00";
    }

    public String TeclaColor(Color colorsito){
        if(colorsito == Color.yellow) return "00";
        if(colorsito == Color.blue) return "01";
        if(colorsito == Color.red) return "10";
        if(colorsito == Color.black) return "11";        
        return "00";
    }
    public String ByteATexto(String bytee){
        if("0000".equals(bytee)) return "0";
        if("0001".equals(bytee)) return "1";
        if("0010".equals(bytee)) return "2";
        if("0011".equals(bytee)) return "3";
        if("0100".equals(bytee)) return "4";
        if("0101".equals(bytee)) return "5";
        if("0110".equals(bytee)) return "6";
        if("0111".equals(bytee)) return "7";
        if("1000".equals(bytee)) return "8";
        if("1001".equals(bytee)) return "9";
        if("1010".equals(bytee)) return "10";
        if("1011".equals(bytee)) return "11";
        if("1100".equals(bytee)) return "12";
        if("1101".equals(bytee)) return "13";       
        return "0";
    }

    public String ByteATeclaColor(String bytee){
        if("00".equals(bytee)) return "amarillo";
        if("01".equals(bytee)) return "azul";
        if("10".equals(bytee)) return "rojo";
        if("11".equals(bytee)) return "negro";        
        return "";
    }
    
    public String posicionXString( int gX){
        if(gX == 0) return "000";
        if(gX == 1) return "001";
        if(gX == 2) return "010";
        if(gX == 3) return "011";
        if(gX == 4) return "100";
        if(gX == 5) return "101";
        if(gX == 6) return "110";
        if(gX == 7) return "111";
        return "000";
    }

    public String posicionYString( int gY){
        if(gY == 0) return "0000";
        if(gY == 1) return "0001";
        if(gY == 2) return "0010";
        if(gY == 3) return "0011";
        if(gY == 4) return "0100";
        if(gY == 5) return "0101";
        if(gY == 6) return "0110";
        if(gY == 7) return "0111";
        if(gY == 8) return "1000";
        if(gY == 9) return "1001";
        if(gY == 10) return "1010";
        if(gY == 11) return "1011";
        if(gY == 12) return "1100";
        if(gY == 13) return "1101";
        if(gY == 14) return "1110";
        if(gY == 15) return "1111";
        return "0000";
    }    

        public int BytePosicionX ( String gX){
        if("000".equals(gX)) return 0;
        if("001".equals(gX)) return 1;
        if("010".equals(gX)) return 2;
        if("011".equals(gX)) return 3;
        if("100".equals(gX)) return 4;
        if("101".equals(gX)) return 5;
        if("110".equals(gX)) return 6;
        if("111".equals(gX)) return 7;
        return 0;
    }

    public int BytePosicionY(String gY){
        if("0000".equals(gY)) return 0;
        if("0001".equals(gY)) return 1;
        if("0010".equals(gY)) return 2;
        if("0011".equals(gY)) return 3;
        if("0100".equals(gY)) return 4;
        if("0101".equals(gY)) return 5;
        if("0110".equals(gY)) return 6;
        if("0111".equals(gY))  return 7;
        if("1000".equals(gY)) return 8;
        if("1001".equals(gY)) return 9;
        if("1010".equals(gY)) return 10;
        if("1011".equals(gY) ) return 11;
        if("1100".equals(gY)) return 12;
        if("1101".equals(gY)) return 13;
        if("1110".equals(gY) ) return 14;
        if("1111".equals(gY)) return 15;
        return 0;
    }    
  
    
    
    private String EstacionSiguiente(String estacion){
        if (estacion.equals("00"))
           return "01";
        if (estacion.equals("01"))
           return "10";
        if (estacion.equals("10"))
            return "11";
        
        return "00";     
    }
     
    //este metodo permite que se ejecute el nuevo hilo atraves del run 
    public void RecibirTrama(){
		Comunicacion proceso1 = this;
		new Thread(proceso1).start();
    }  
  
    public Comunicacion(SerialPort puertoEntrada1, SerialPort puertoSalida1 ){
      puertoEntrada= puertoEntrada1;
      puertoSalida=puertoSalida1;
    }
    
  //metodo que ejecuta para que siempre este recibiendo alun mensaje atraves d eun hilo 
  //diferente
    @Override
    public void run() {
        
        boolean No_Se_han_Enviado_ninguna_ficha=true;
        do{
            byte[] readBuffer = null; // Bytes para almacenar la informacion
            System.out.println("estacion:  "+estacion);
            try{
                //Espero a que algo llegue
                System.out.println("Esperando mensaje...");
                while (puertoEntrada.bytesAvailable() < 5) {
                }
            
                // Algo llego asi que lo almaceno en el buffer
                readBuffer = new byte[5];
                int numRead = puertoEntrada.readBytes(readBuffer, 5);
            
                //Comprobacion de que se recibio
                System.out.print("Se encontro el mensaje:\n");
                for(int i=0; i<numRead;i++) System.out.println(" "+
                   pasarByteAString(readBuffer[i]));
            
                //Una vez aqui debo ver que tipo de instruccion es y decidir que hare
                String byteControl = pasarByteAString(readBuffer[1]);
                String byteInformacion = pasarByteAString(readBuffer[2]); 
                String byteInformacion1 = pasarByteAString(readBuffer[3]);
                String instruccion = byteControl.substring(5); // Campo de control //quita los primeros cinco caracteres , se queda con los otros tres            
                String origen = byteControl.substring(0,2); // Equipo de Origen son dos bits
                String destino =  byteControl.substring(2,5); // Equipo de destino son tres bits 
                            
                switch(instruccion){
                    case "000": //caso de empezar partida
                        //es decir alguien ya es la primera maquina y por ende esta
                        //diciendo que todas las demas maquinas esten preparadas
                    
                        //primero pregunto si esta estacion es la 00 de la trama 
                        //esto puede pasar al momento de que se haya cumplido el anillo
                        //y entonces en ese caso se acabaria el ciclo de la trama
                        if(estacion == null){
                               
                            this.estacion = EstacionSiguiente(origen); //Asigno el Valor de la Estación
                            byte[] envio = new byte[5];  //Reenvío Mensaje con Número de mi Estación
                            envio[0] = (byte)Short.parseShort(flag, 2);
                            envio[1] = (byte)Short.parseShort(estacion+"111000", 2);
                            envio[2] = (byte)Short.parseShort(byteInformacion, 2);
                            envio[3] = (byte)Short.parseShort(byteInformacion1, 2);
                            envio[4] = (byte)Short.parseShort(flag, 2);
                            System.out.print("Mensaje enviado: "
                            +" "+pasarByteAString(envio[0])
                            +" "+pasarByteAString(envio[1])
                            +" "+pasarByteAString(envio[2])
                            +" "+pasarByteAString(envio[3])
                            +" "+pasarByteAString(envio[4])
                            +"\n");
                            
                            //se reenvia porque 
                            //es para todas las maquinas
                            if("111".equals(destino)){
                                MiTablero.intruccionEmpezarPartida(this.estacion);
                                puertoSalida.writeBytes(envio, envio.length);
                            }else  {System.out.println("No se cumplió el ciclo y algo ocurrio mal");}
                     
                        }else { 
                            //Este es el primer caso y ya que se completo el ciclo 
                            //se tienen que llenar las fichas
                            System.out.println("Se cumplió el ciclo de empezar");
                            MiTablero.intruccionAgarrarFichasIniciales(this);
                            MiTablero.ActivarFuncionesDeTurno();
                        }
                    break; 
                case "011":
                    //esto es en el caso de que ya alguien haya acabado su turno y 
                    //te toque a ti 
                    //se vuelve a habilitar el panel de la matriz
                    //y se hace una nueva posicion inicial
                    MiTablero.ActivarFuncionesDeTurno();
                    System.out.println("Se acabo el turno de:" + origen );
                break;
                case "001":
                    //siempre y cuando este no sea el que envio la tecla a remover
                    if(!estacion.equals(origen)){
                        //esto solo es en el primer caso que hay que enviar 
                        //las primeras 14 fichas
                        if(No_Se_han_Enviado_ninguna_ficha && estacion != "00"){                    
                            MiTablero.ActivarBotonDE14Fichas(); 
                            MiTablero.enableComponents(true);
                            No_Se_han_Enviado_ninguna_ficha=false;                       
                        }
                        Teclas Tecla= new Teclas();
                        String numero=ByteATexto(byteInformacion.substring(4,8));
                        String color=ByteATeclaColor(byteInformacion.substring(2,4));
                        Tecla.numero= numero;
                        Tecla.color=color;
                        MiTablero.QuitarFicha(Tecla); 
                        
                        byte[] envio = new byte[5];  //Reenvío Mensaje con Número de mi Estación
                        envio[0] = (byte)Short.parseShort(flag, 2);
                        envio[1] = (byte)Short.parseShort(byteControl, 2);
                        envio[2] = (byte)Short.parseShort(byteInformacion, 2);
                        envio[3] = (byte)Short.parseShort(byteInformacion1, 2);
                        envio[4] = (byte)Short.parseShort(flag, 2);
                        System.out.print("Mensaje enviado: "
                        +" "+pasarByteAString(envio[0])
                        +" "+pasarByteAString(envio[1])
                        +" "+pasarByteAString(envio[2])
                        +" "+pasarByteAString(envio[3])
                        +" "+pasarByteAString(envio[4])
                        +"\n");                        
                        
                        //se reenvia porque 
                        //es para todas las maquinas
                        if("111".equals(destino)){
                                puertoSalida.writeBytes(envio, envio.length);
                        }else  {System.out.println("No se cumplió el ciclo y algo ocurrio mal");}
                        
                    }else{
                          System.out.println("Se cumplió el ciclo");
                    }
                   
                break;                
                
                case "010":
                    //este if ocurre porque de alguno manera aveces
                    //se pasa por error el "0000000" en el campo de informacion
                    //es un error de comparacion en la matriz cuando se c ompara en 
                    //tableroVirtual
                    //sin embargo esto se soluciona rapidamente ya que esa fica no existe
                    //entonces si no existe no se tienen que tomar en cuenta
                    //este es cuando revise la intruccion de moner una fica en la matriz 
                    if(!estacion.equals(origen)){             
                        Teclas Tecla= new Teclas();
                        String numero=ByteATexto(byteInformacion.substring(4,8));
                        String color=ByteATeclaColor(byteInformacion.substring(2,4));
                        int x= BytePosicionX(byteInformacion1.substring(1,4));
                        int y= BytePosicionY(byteInformacion1.substring(4,8));                       
                        Tecla.numero= numero;
                        Tecla.color=color;
                        
                        MiTablero.PonerEnLaMatrizTecla(Tecla, x,y); 
                        byte[] envio = new byte[5];  //Reenvío Mensaje con Número de mi Estación
                        envio[0] = (byte)Short.parseShort(flag, 2);
                        envio[1] = (byte)Short.parseShort(byteControl, 2);
                        envio[2] = (byte)Short.parseShort(byteInformacion, 2);
                        envio[3] = (byte)Short.parseShort(byteInformacion1, 2);
                        envio[4] = (byte)Short.parseShort(flag, 2);
                        System.out.print("Mensaje enviado: "
                        +" "+pasarByteAString(envio[0])
                        +" "+pasarByteAString(envio[1])
                        +" "+pasarByteAString(envio[2])
                        +" "+pasarByteAString(envio[3])
                        +" "+pasarByteAString(envio[4])
                        +"\n"); 
                        //se reenvia porque 
                        //es para todas las maquinas
                        if("111".equals(destino)){
                                puertoSalida.writeBytes(envio, envio.length);
                        }else  {System.out.println("No se cumplió el ciclo y algo ocurrio mal");}
                    
                    }else{
                          System.out.println("Se cumplió el ciclo");
                    }
                   break;
                default: break;                   
            }

            }catch (Exception e) {
                e.printStackTrace();
            }   
        } while (1==1); //ciclo infinito :)
    }    
}