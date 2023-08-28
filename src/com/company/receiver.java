package com.company;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class receiver {
    private SerialPort serialPort = new SerialPort("COM5");
    public void Connect() {

        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            int mask = SerialPort.MASK_RXCHAR;
            serialPort.setEventsMask(mask);
            serialPort.addEventListener(new receiver.SerialPortReader(serialPort));
        } catch (SerialPortException ex) {
            ex.printStackTrace();
        }
    }
    public void SendAnswer(String answer){
        try {
            serialPort.writeString(answer);
        } catch (SerialPortException ex) {
            ex.printStackTrace();
        }
    }

    private class SerialPortReader implements SerialPortEventListener {

        private SerialPort serialPort;

        public SerialPortReader(SerialPort serialPort) {
            this.serialPort = serialPort;
        }

        public void serialEvent(SerialPortEvent event) {

            try {
                String message =  serialPort.readString();
                UI.receiver.setText(message);
                serialPort.writeString(message.getBytes().toString());
            } catch (SerialPortException ex) {
                ex.printStackTrace();
            }
        }
    }
}