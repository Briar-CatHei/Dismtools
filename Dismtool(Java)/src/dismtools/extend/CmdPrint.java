package dismtools.extend;

import java.io.*;

public class CmdPrint {
	public static String execCommand(String command)
    {
        String line = "";
        StringBuilder StrBuild = new StringBuilder();
 
        try (BufferedReader BuffRead = new BufferedReader(
                new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));)
        {
            while ((line = BuffRead.readLine()) != null)
            	StrBuild.append(line + "\r\n");
        } catch (IOException e) { return "Invalid command."; }
        
        return StrBuild.toString();
    }

}//获取cmd执行命令时的输出 并打印至IDE控制台
