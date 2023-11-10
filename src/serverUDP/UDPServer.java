package serverUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServer {

    public static void main(String[] args) {
        try {
            // Création d'une socket UDP liée au port 1234
            DatagramSocket serverSocket = new DatagramSocket(new InetSocketAddress(1234));

            System.out.println("Serveur UDP en attente sur le port 1234...");

            while (true) {
                // Réception d'un paquet
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Extraction des données du paquet
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Affichage du message reçu
                System.out.println("Message reçu : " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
