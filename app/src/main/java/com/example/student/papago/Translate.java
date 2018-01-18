package com.example.student.papago;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static android.content.ContentValues.TAG;

/**
 * Created by student on 2018-01-18.
 */

//echMKoKhU_Ch1NR3Ea1v
//Mu0puZi05V
public class Translate {
    String sentence,inputline,str;
    String id = "echMKoKhU_Ch1NR3Ea1v";
    String pw = "Mu0puZi05V";
    public Translate(){
        Log.d("RCMsg", "생성");
    }
    public String Tanslatego() {
        String clientId = "echMKoKhU_Ch1NR3Ea1v";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "Mu0puZi05V";//애플리케이션 클라이언트 시크릿값";
        try {
            Log.d("RCMsg", "메소드 호출1");
            String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            Log.d("RCMsg", "메소드 호출2");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            Log.w("RCMsg", "메소드 호출3");
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            Log.d("RCMsg", "메소드 호출4");
            con.setDoOutput(true);
            Log.d("RCMsg", "메소드 호출4");
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                Log.d("RCMsg", "메소드1 정상");
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                Log.d("RCMsg", "메소드1 비정상");
            }
            String inputLine;

            StringBuffer response = new StringBuffer();
            Log.d("RCMsg", "받기 성공");
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
                Log.d("RCMsg", "이상무");
            }
            br.close();
            System.out.println(response.toString());
            Log.d("RCMsg", "이상무");

        } catch (Exception e) {
            System.out.println(e);
        }
            return "메로나";
    }

}
