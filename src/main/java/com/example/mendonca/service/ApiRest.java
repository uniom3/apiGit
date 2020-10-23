package com.example.mendonca.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiRest {
	
	public static String getJSON(String url) {
        HttpsURLConnection con = null;
        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
	
	
	public void resultado() {
	
		String json = getJSON("https://api.github.com/users#repos:>9");
		
		   try {
			   int io = json.indexOf("[");
			   json = json.substring(io);
			   System.out.println(json);
			   JSONObject 
		         obj = new JSONObject(json.trim());
			   System.out.println(obj);
		         JSONArray results_arr = obj.getJSONArray("result");
		          int n = results_arr.length();
		            for (int i = 0; i < n; ++i) {
		                String place_id = results_arr.getJSONObject(i).getString("place_id");
		                System.out.println(place_id);
		            }
					


		   }catch (Exception e) {
		e.getMessage();
		}
	}
}
	/*	  private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }

		  public static void main(String[] args) throws IOException, JSONException {
		    JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
		    System.out.println(json.toString());
		    System.out.println(json.get("id"));
		  }
		}
}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public void Teste()  {
		
		  //public static void main(String[] args) throws IOException, JSONException {
			    JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
			    System.out.println(json.toString());
			    System.out.println(json.get("id"));
			//  }
		//ObjectMapper mapper = new ObjectMapper();
		//GitDto g = mapper.readValue(new File("https://api.github.com/users#repos:>9"), GitDto.class);
		
		/*		URL url;
		try {
			url = new URL("https://api.github.com/users#repos:>9");
			Reader br = new InputStreamReader(url.openStream());
			

			JSONParser parser = new JSONParser();
			JSONObject jsonObjeto = (JSONObject) parser.parse(br);

			System.out.println(jsonObjeto);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    

  
 
	}
}*/