/**
 * 
 */
package jp.vstone.sota.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.exception.SotaRuntimeException;

/**
 * @author nobutnk
 *
 */
public class BasicHttpClient implements HttpClient {

    public BasicHttpClient(SotaConfig config) {
        boolean useProxy = config.getBoolean("http.useProxy");
        if (useProxy) {
            String host = config.getString("http.proxy.host");
            String port = config.getString("http.proxy.port");
            System.setProperty("proxySet", "true");
            System.setProperty("proxyHost", host);
            System.setProperty("proxyPort", port);

            boolean useAuthentication = config.getBoolean("http.proxy.userAuthentication");
            if (useAuthentication) {
                // プロキシのユーザ名とパスワードをセットする
                String username = config.getString("http.proxy.username");
                String password = config.getString("http.proxy.password");
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password.toCharArray());
                    }
                });
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.vstone.sota.common.HttpClient#get(java.lang.String)
     */
    public String get(String uri) throws SotaException {
        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL(uri);

            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                            StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isr)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            char ch = (char) r;
                            responseBody.append(ch);
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            throw new SotaException(e);
        }

        return responseBody.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.vstone.sota.common.HttpClient#post(java.lang.String,
     * java.util.Map)
     */
    public String post(String uri, Map<String, String> params, String charsetName) throws SotaException {
        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL(uri);

            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                
                OutputStream os = connection.getOutputStream();//POST用のOutputStreamを取得
                
                String postStr = createPostParam(params, charsetName);//POSTするデータ
                PrintStream ps = new PrintStream(os);
                ps.print(postStr);//データをPOSTする
                ps.close();

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                            StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isr)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            char ch = (char) r;
                            responseBody.append(ch);
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            throw new SotaException(e);
        }

        return responseBody.toString();
    }

    public String get(Map<String, String> headers, String uri) {
        // TODO Auto-generated method stub
        return null;
    }

    public String post(Map<String, String> headers, String uri, Map<String, String> params, String charsetName) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String createPostParam(Map<String, String> params, String charsetName) {
        if (params == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            } else {
                try {
                    value = URLEncoder.encode(value, charsetName);
                } catch (UnsupportedEncodingException e) {
                    throw new SotaRuntimeException(e);
                }
            }
            result.append(key).append("=").append(value).append("&");
        }
        
        return result.substring(0, result.length() - 1);
    }

}
