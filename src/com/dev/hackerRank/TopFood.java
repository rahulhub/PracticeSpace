package com.dev.hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

class Result
{

    /*
     * Complete the 'getTopRatedFoodOutlets' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>
     *
     * The function is expected to return an array of strings.
     * 
     * The function accepts only city argument (String).
     */
     
    static CloseableHttpClient httpclient = HttpClients.createDefault();


    public static List<String> getTopRatedFoodOutlets(String city)
    {
            
            HttpClient httpclient = new HttpClient();
  GetMethod httpget = new GetMethod("https://www.verisign.com/"); 
  try { 
    httpclient.executeMethod(httpget);
    System.out.println(httpget.getStatusLine());
  } catch(Exception e){
      e.printStackTrace();
  }
  finally {
    httpget.releaseConnection();
  }
       
        return null;
    }

}

public class TopFood {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String city = bufferedReader.readLine();
  
        List<String> result = Result.getTopRatedFoodOutlets(city);
        
        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
