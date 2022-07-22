import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author KFY4VGJ
 */
public class CalculatorClient {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ){

            out.println("+ 3 5");
            out.println("done");
            //out.flush();
            //out.close();

            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("done")) {
                    break;
                }
                //stringBuilder.append(inputLine);
                System.out.println("result: " + stringBuilder.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
