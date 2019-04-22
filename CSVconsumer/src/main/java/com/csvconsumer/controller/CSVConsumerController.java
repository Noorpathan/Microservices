/*
 * package com.csvconsumer.controller;
 * 
 * import java.io.BufferedReader; import java.io.InputStreamReader; import
 * java.net.HttpURLConnection; import java.net.URL;
 * 
 * import org.apache.tomcat.util.json.JSONParser; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class CSVConsumerController {
 * 
 * @GetMapping("/getdetails") public void details() { try {
 * 
 * URL url = new URL("http://localhost:8011/csvServices"); HttpURLConnection
 * conn = (HttpURLConnection) url.openConnection();
 * conn.setRequestMethod("GET"); conn.setRequestProperty("Accept",
 * "application/json"); if (conn.getResponseCode() != 200) { throw new
 * RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode()); }
 * InputStreamReader in = new InputStreamReader(conn.getInputStream());
 * BufferedReader br = new BufferedReader(in); String output; StringBuffer
 * response = new StringBuffer(); String modified = null; while ((output =
 * br.readLine()) != null) { //modified = output.replace("[", "").replace("]",
 * ""); response.append(output);
 * 
 * } br.close(); conn.disconnect(); System.out.println(response.toString());
 * //JSONParser parser = new JSONParser();
 * 
 * 
 * } catch (Exception e) { System.out.println("Exception in NetClientGet:- " +
 * e); } }
 * 
 * }
 */