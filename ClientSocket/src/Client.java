import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
   private static final String port = "band.91xxt.com";
    // private static final String port = "localhost";
    private static Map<String,String> map;
    static{
        Client.map = new HashMap<String,String>();
        Client.map.put("1","[3G*3926628230*000C*LK,7777,0,96]");
        Client.map.put("2","[3G*3926628230*00CD*UD,180916,025723,A,22.570733,N,113.8626083,E,0.00,249.5,0.0,6,100, 60,0,0,00000010,7,255,460,1,9529,21809,158,9529,63555,133,9529,63554,129,9529,21405,1 26,9529,21242,124,9529,21151,120,9529,63556,119,0,40.7]");
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(port,18089);
        new Thread(){
            @Override
            public void run() {
                try {
                    InputStream in = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(in);
                    BufferedReader bf = new BufferedReader(inputStreamReader);
                    String c = null;
                    while((c=bf.readLine())!=null){
                        System.out.println("接收到指令为:");
                        System.out.println(c);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入指令:");
        String in = sc.next();
        if(in.substring(0,1).equals("/")){
            in = map.get(in.substring(1,2));
        }
        System.out.println("输入指令为: " + in);
        OutputStream ou = socket.getOutputStream();
        ou.write(in.getBytes());
        ou.flush();
    }
}
