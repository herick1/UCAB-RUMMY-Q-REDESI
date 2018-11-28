/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package comunicacion;
import com.fazecast.jSerialComm.*;
import java.awt.Color;
import java.util.ArrayList;
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
        envio[1] = (byte)Short.parseShort("00111000", 2);
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
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"001", 2);
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
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"001", 2);
        String numerobit= teclaTexto(TeclaHecha.getText());
        String color = TeclaColor(TeclaHecha.getBackground());
        envio[2] = (byte)Short.parseShort("0"+color+numerobit, 2);
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
       
    public void nuevaFichaTablero(Teclas TeclaHecha, int PosicionFila, int PosicionColumna){

        byte[] envio = new byte[5];
        envio[0] = (byte)Short.parseShort(flag, 2);
        envio[1] = (byte)Short.parseShort(this.estacion+"111"+"010", 2);
        String numerobit= teclaTexto(TeclaHecha.getText());
        String color = TeclaColor(TeclaHecha.getBackground());
        envio[2] = (byte)Short.parseShort("0"+color+numerobit, 2);
        String posicionx= posicionXString(PosicionFila);
        String posiciony = posicionYString(PosicionColumna);        
        envio[3] = (byte)Short.parseShort("0"+posicionx+posiciony, 2);
        envio[4] = (byte)Short.parseShort(flag, 2);
        System.out.print("Mensaje enviado: "
                +" "+pasarByteAString(envio[0])
                +" "+pasarByteAString(envio[1])
                +" "+pasarByteAString(envio[2])
                +" "+pasarByteAString(envio[3])
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
    
    public String TeclaColor(Color colorsito){
        if(colorsito == Color.yellow) return "00";
        if(colorsito == Color.blue) return "00";
        if(colorsito == Color.red) return "00";
        if(colorsito == Color.black) return "00";        
        return "00";
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
        if(gY == 0) return "00000";
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
        return "000";
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
		Comunicacion proceso1 = new Comunicacion(puertoEntrada, puertoSalida);
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
        byte[] readBuffer = null; // Bytes para almacenar la informacion
        System.out.println("estacion:  "+estacion);
        try {
            //Espero a que algo llegue
            System.out.println("Esperando mensaje...");
            while (puertoEntrada.bytesAvailable() < 4) {
            }
            
            // Algo llego asi que lo almaceno en el buffer
            readBuffer = new byte[4];
            int numRead = puertoEntrada.readBytes(readBuffer, 4);
            
            //Comprobacion de que se envio
            System.out.print("Se encontro el mensaje:\n");
            for(int i=0; i<numRead;i++) System.out.println(" "+
                    pasarByteAString(readBuffer[i]));
             //Una vez aqui debo ver que tipo de instruccion es y decidir que hare
            String byteControl = pasarByteAString(readBuffer[1]);
            String byteInformacion = pasarByteAString(readBuffer[2]); 
            String instruccion = byteControl.substring(4); // Campo de control //quita los primeros cuatros caracteres , se queda con lso otros cuatro
            String origen = byteControl.substring(0,2); // Equipo de Origen
            String destino =  byteControl.substring(2,4); // Equipo de destino
            if (origen.equals(this.estacion)){
                if ((origen.equals(estacion))&&(byteInformacion.substring(5,6).equals("0"))){    //Se necesita Enviar el Anuncio de Cantidad de Jugadores
                     byte[] envio = new byte[4];
                     envio[0] = (byte)Short.parseShort(flag, 2);
                     envio[1] = (byte)Short.parseShort("00000000", 2);
                     envio[2] = (byte)Short.parseShort("100001"+byteInformacion.substring(6,8),2);
                     envio[3] = (byte)Short.parseShort(flag, 2);
                     System.out.print("Mensaje enviado: "
                     +" "+pasarByteAString(envio[0])
                     +" "+pasarByteAString(envio[1])
                     +" "+pasarByteAString(envio[2])
                     +" "+pasarByteAString(envio[3])
                     +"\n"); 
                     puertoSalida.writeBytes(envio, envio.length);
                     System.out.println("Ahora se envía el anuncio para notificar la cantidad de jugadores");
                     run();
                }
                else{
                    System.out.println("Se cumplió el ciclo");
                }
            }
            else{
                if (instruccion.equals("0000")){    //Empezar Partida
                    if(byteInformacion.substring(5,6).equals("0")){ 
                        this.estacion = EstacionSiguiente(byteInformacion.substring(6,8)); //Asigno el Valor de la Estación
                        byte[] envio = new byte[4];  //Reenvío Mensaje con Número de mi Estación
                        envio[0] = (byte)Short.parseShort(flag, 2);
                        envio[1] = (byte)Short.parseShort("00000000", 2);
                        envio[2] = (byte)Short.parseShort("100000"+estacion, 2);
                        envio[3] = (byte)Short.parseShort(flag, 2);
                        System.out.print("Mensaje enviado: "
                        +" "+pasarByteAString(envio[0])
                        +" "+pasarByteAString(envio[1])
                        +" "+pasarByteAString(envio[2])
                        +" "+pasarByteAString(envio[3])
                        +"\n");
                        puertoSalida.writeBytes(envio, envio.length);
                        run();
                    }
                    else{
                        puertoSalida.writeBytes(readBuffer, readBuffer.length);
                    }
                }
                if (instruccion.equals("0001")){    //Lanzar Dados
                    if (destino.equals(this.estacion)){     //Me Corresponde el Turno
                        
                    }
                    puertoSalida.writeBytes(readBuffer,readBuffer.length);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
  
  
}