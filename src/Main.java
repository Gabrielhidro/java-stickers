import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
        public static void main(String[] args) throws Exception {
                // Criar requisição HTTP
                String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
                URI address = URI.create(url);
                var client = HttpClient.newHttpClient();
                var request = HttpRequest.newBuilder(address).GET().build();
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                String body = response.body();
                System.out.println(body);

                //Extrair dados necessários
                var parser = new JsonParser();
                List<Map<String, String>> listaFilmes = parser.parse(body);

                //Exibir e manipular
                for (Map<String, String> filme : listaFilmes){
                        System.out.println(filme.get("title"));
                }
        }
}