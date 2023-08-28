package com.company;
import jssc.*;

public class sender {
    private SerialPort serialPort = new SerialPort("COM4");
    public void Connect() {

        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            int mask = SerialPort.MASK_RXCHAR;
            serialPort.setEventsMask(mask);
            serialPort.addEventListener(new SerialPortReader(serialPort));
        } catch (SerialPortException ex) {
            ex.printStackTrace();
        }
    }
    public void Send(String message){
        try {
            serialPort.writeString(message);
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
                UI.answer.setText(serialPort.readString());

            } catch (SerialPortException ex) {
                ex.printStackTrace();
            }
        }
    }
}
