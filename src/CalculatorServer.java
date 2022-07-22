import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	public static final int ERROR_CODE = 9999;

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter operand 1: ");
		//int a = scanner.nextInt();
		//System.out.println("Please enter operand 2: ");
		//int b = scanner.nextInt();
		//scanner.nextLine();
		//System.out.println("Please enter operator: ");
		//String operator = scanner.nextLine();

		String inputLine="", outputLine;
		int portNumber = 8080;

		try (
				ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out =
						new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
		) {



			// Initiate conversation with client
		//	outputLine = "greeting";
		//	out.println(outputLine);

			StringBuilder stringBuilder = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				//outputLine = "greeting";
				//out.println(outputLine);
				//if (outputLine.equals("Bye."))
				//	break;
				if (inputLine.equals("done")) {
					break;
				}
				stringBuilder.append(inputLine);

				String[] tokens = stringBuilder.toString().split("\\s+");
				int a = Integer.parseInt(tokens[1]);
				int b = Integer.parseInt(tokens[2]);
				String operator = tokens[0];


				CalculatorService calculatorService = new CalculatorService();

				float result = calculatorService.getResult(a, b, operator);
				//	 	args[3] = result+"";
				out.println(result);
				out.println("done");
			}


			out.close();
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port "
					+ portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}


}

