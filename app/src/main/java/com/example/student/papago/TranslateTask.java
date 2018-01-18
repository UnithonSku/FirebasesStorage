package com.example.student.papago;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by student on 2018-01-18.
 */

public class TranslateTask extends AsyncTask<String ,String>{

    String text;
    String receiveMsg;
    public TranslateTask(String text){
        this.text = text;
    }
    public TranslateTask(){}
    @Override
    protected String doInBackground(String... strings) {
        String clientId = "echMKoKhU_Ch1NR3Ea1v";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "Mu0puZi05V";//애플리케이션 클라이언트 시크릿값";
        try {

            String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            // post request
            String postParams = "source=ko&target=en&text=" + text;

            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

            }
            String inputLine;

            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);

            }
            br.close();
            System.out.println(response.toString());


        } catch (Exception e) {
            System.out.println(e);
        }
        return "메로나";
    }
}
