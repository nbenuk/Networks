import java.io.*;
import java.net.*;
import java.util.Arrays;
public class Coursework1
{
	public static void main( String[] args )
	{
	   
	    try{
			//Single hostname
			if (args.length == 1) {//****error handling for invalid address...
				String host = args[0];
				
				InetAddress address = InetAddress.getByName(host);
				System.out.println("Hostname and Address: " + address);

				boolean isIPv4 = false;
				String str = address.toString();
				String subStrings[] = str.split("/",2);
				String ipAddress = subStrings[1];

				isIPv4 = (address instanceof Inet4Address) && address.getHostAddress().equals(ipAddress);
				System.out.println("The address is IPv4: " + isIPv4);
				System.out.println("The address is IPv6: " + !isIPv4);
			}

			//Two hostnames
			if (args.length == 2){
				String host1 = args[0];
				String host2 = args[1];

				boolean isHost1iPv4 = false;
				boolean isHost2iPv4 = false;

				InetAddress address1 = InetAddress.getByName(host1);
				InetAddress address2 = InetAddress.getByName(host2);

				String str = address1.toString();
				String subString1[] = str.split("/",2);
				String ipAddress1 = subString1[1];

				str = address2.toString();
				String subString2[] = str.split("/",2);
				String ipAddress2 = subString2[1];

				isHost1iPv4 = (address1 instanceof Inet4Address) && address1.getHostAddress().equals(ipAddress1);
				isHost2iPv4 = (address2 instanceof Inet4Address) && address2.getHostAddress().equals(ipAddress2);

				if (isHost1iPv4 && isHost2iPv4){
					System.out.println(ipAddress1 + " " + ipAddress2);
					if (ipAddress1.equals(ipAddress2)) {
						System.out.println(ipAddress1);
					}
					else {
						String bytes1[] = ipAddress1.split("\\.");	
						String bytes2[] = ipAddress2.split("\\.");

						if (bytes1[0].equals(bytes2[0])){
							if (bytes1[1].equals(bytes2[1])){
								if (bytes1[2].equals(bytes2[2])){
									if (bytes1[3].equals(bytes2[3])){
										System.out.println(ipAddress1);
									}
									else {
										System.out.println(bytes1[0]+"."+bytes1[1]+"."+bytes1[2]+".*");
									}
								}	
								else {
									System.out.println(bytes1[0]+"."+bytes1[1]+".*.*");
								}
							}
							else {
								System.out.println(bytes1[0]+".*.*.*");
							}
						}
						else{
							System.out.println("*.*.*.*");
						}
					}
				}
				else{
					System.out.println("Invalid hostnames - only use IPv4");
				}

			}
			else{
				System.out.println("Error: Only enter one hostname or two IPv4 hostnames");
			} 
			
	    }
	    catch(UnknownHostException e) {
	        e.printStackTrace();
	    }
	}
}

