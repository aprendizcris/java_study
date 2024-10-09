import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;


public class DownInclude {

	public static Date ultimaExecucao;
	public static int intervaloHoras = 24;
	public static String usuario = "tp.cristiam.ar";
	public static String senha = "Toronto@2027!;";
	public static String pastaIncludes = "c:\\includes\\";

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {

		lerConfig();

		if ( executa() ) {
			if ( baixarInclude() ) {
				atualizarPasta();
				salvarConfig();
			}
		}
	}

	static void lerConfig() {
		try {
			FileReader arquivo = new FileReader("DownInclude.json");
			char[] parser = new char[100];
			arquivo.read( parser );
			JSONObject json = new JSONObject( String.valueOf(parser) );
			arquivo.close();

			ultimaExecucao = sdf.parse( (String) json.get("ultimaExecucao") );
			intervaloHoras = json.getInt("intervaloHoras");
			usuario        = json.getString("usuario");
			senha          = json.getString("senha");
			pastaIncludes  = json.getString("pastaIncludes");
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

	static void salvarConfig() {
		JSONObject jsonObject = new JSONObject();
		FileWriter writeFile;

		jsonObject.put("ultimaExecucao", sdf.format( new Date() ) );
		jsonObject.put("intervaloHoras", intervaloHoras);
		jsonObject.put("usuario"       , usuario);
		jsonObject.put("senha"         , senha);
		jsonObject.put("pastaIncludes" , pastaIncludes);

		try{
			writeFile = new FileWriter("DownInclude.json");

			writeFile.write(jsonObject.toString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	static boolean executa() {
		Date now = new Date();

		if ( ultimaExecucao == null ) return true;

		long diffInHours = now.getTime() - ultimaExecucao.getTime();

		int diffExec = (int) diffInHours / (1000 * 60 * 60 );
		
		if ( diffExec >= 24 ) return true;

		return false;
	}

	@SuppressWarnings("rawtypes")
	static boolean baixarInclude() {
/*
        try {
//        	String caminho = "https://arte.engpro.totvs.com.br/engenharia/includes/12/latest/includes.zip" + ":" + usuario + "@" + senha;
        	String caminho = "https://"+usuario+":"+senha+"@"+"arte.engpro.totvs.com.br/engenharia/includes/12/latest/includes.zip";
            URL url = new URL(caminho);
            File file = new File("includes.zip");
            FileUtils.copyURLToFile(url, file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
*/
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpUriRequest httpUriRequest = new HttpGet("https://arte.engpro.totvs.com.br/engenharia/includes/12/latest/includes.zip");
		CloseableHttpResponse response = client.execute(httpUriRequest);
		

        try {
	        String url = "https://arte.engpro.totvs.com.br/engenharia/includes/12/latest/includes.zip";
	        HttpResponse res;
	        DefaultHttpClient httpclient = new DefaultHttpClient();
	        String authorizationString = "Basic " + Base64.encodeToString((usuario+":"+senha).getBytes(), Base64.NO_WRAP);
	        authorizationString.replace("\n", "");
	        try {
	            HttpGet request = new HttpGet(URI.create(url));
	            request.addHeader("Authentication",authorizationString);
	            res = httpclient.execute(request);
	            return new MjpegInputStream(res.getEntity().getContent());              
	        } catch (ClientProtocolException e) {
	        	e.printStackTrace();
	        }
        } catch (IOException e) {
        	e.printStackTrace();
        }

	}

	
	static void atualizarPasta() {
		String destino = pastaIncludes;
		File pasta = new File( destino );
		if ( ! pasta.exists() ) pasta.mkdir();

		File file = new File("includes.zip");
		
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
			ZipInputStream zipStream = new ZipInputStream(bis);
			ZipEntry ze;
			byte buff[] = new byte[16384];
			int readBytes;
	
			while((ze = zipStream.getNextEntry()) != null) {
			    String fileName = destino + ze.getName();
			    if(ze.isDirectory()) {
			        Files.createDirectories(Paths.get(fileName));
			        continue;
			    }
			    zipStream.readAllBytes();
			    FileOutputStream outFile = new FileOutputStream(fileName);
			    while((readBytes = zipStream.read(buff)) != -1) {
			        outFile.write(buff, 0, readBytes);
			    }
			    outFile.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
