/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risingsun;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author ardayigit
 */
public class HTTPHelper {
    
    	public static String[] get(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String ar[] = new String[2];
		
		ar[0] = Integer.toString(con.getResponseCode());
                ar[1] = response.toString();
		
		return ar;
		
	}

    	public static String[] post(String url, String param) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
                
                String urlParameters = param;
                
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String ar[] = new String[2];
		
		ar[0] = Integer.toString(con.getResponseCode());
        ar[1] = response.toString();
		
		return ar;
		
	}
        
    	public static String[] post(String url, String param, String content) throws Exception {
		URL obj = new URL(url+"?"+param);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
                //con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestProperty("Accept", "application/json");
                //con.setRequestProperty("Token", param);
                //String urlParameters = param;
                
                con.setDoOutput(true);
                //con.setDoInput(true);
                
                /*OutputStream os = con.getOutputStream();
                os.write(param.getBytes("UTF-8"));
                os.write(content.getBytes("UTF-8"));
                os.close();*/
            
                //InputStream in = new BufferedInputStream(con.getInputStream());
                //String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
                //JSONObject jsonObject = new JSONObject(result);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                //wr.writeBytes(urlParameters);
                wr.writeBytes(content);
                wr.flush();
                wr.close();
                //con.connect(); 
                

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String ar[] = new String[2];
		
		ar[0] = Integer.toString(con.getResponseCode());
        ar[1] = response.toString();
		
		return ar;
                //return null;
		
    }    
        
}
