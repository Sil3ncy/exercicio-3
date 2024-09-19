package service;

import spark.Request;
import spark.Response;
import java.util.HashMap;
import java.util.Map;

import model.Produto;

public class ProdutoService {
    private Map<Integer, Produto> produtos = new HashMap<>();
    private int currentId = 1;

    //  para inserir um produto
    public String insert(Request request, Response response) {
        String nome = request.queryParams("nome");
        double preco = Double.parseDouble(request.queryParams("preco"));
        
        Produto produto = new Produto();
        produtos.put(currentId, produto);
        currentId++;

        response.status(201); // HTTP Status: Created
        return "Produto inserido com sucesso!";
    }

    // Método para obter um produto por ID
    public String get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Produto produto = produtos.get(id);
        
        if (produto != null) {
            return produto.toString();
        } else {
            response.status(404); // HTTP Status: Not Found
            return "Produto não encontrado";
        }
    }

    // listar todos os produtos com ordenação
    public String getAll(Request request, Response response) {
        String orderby = request.params(":orderby");
        //  ordenar por nome ou preço, dependendo do parâmetro
      
        return produtos.values().toString();
    }

    //  atualizar um produto por ID
    public String update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Produto produto = produtos.get(id);

        if (produto != null) {
            String novoNome = request.queryParams("nome");
            double novoPreco = Double.parseDouble(request.queryParams("preco"));
            
            //produto.setNome(novoNome);
            produto.setPreco(novoPreco);

            return "Produto atualizado com sucesso!";
        } else {
            response.status(404); // HTTP Status: Not Found
            return "Produto não encontrado";
        }
    }

    // Método para deletar um produto por ID
    public String delete(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Produto produto = produtos.remove(id);

        if (produto != null) {
            return "Produto removido com sucesso!";
        } else {
            response.status(404); // HTTP Status: Not Found
            return "Produto não encontrado";
        }
    }
}
