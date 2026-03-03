public class ProdutoNaoPerecivel extends Produto {

    /**
     * Construtor completo. Causa exceção em caso de valores inválidos
     * @param desc Descrição do produto (mínimo 3 caracteres)
     * @param precoCusto Preço de compra do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro para a venda (mínimo 0.01)
     * @throws IllegalArgumentException em caso dos limites acima serem desrespeitados.
     */
    public ProdutoNaoPerecivel(String descricao, double precoCusto, double margemLucro){
        super(descricao, precoCusto, margemLucro);
    }

    /**
     * Construtor com margem de lucro padrão (20%). Causa exceção em caso de valores inválidos
     * @param desc Descrição do produto (mínimo 3 caracteres)
     * @param precoCusto Preço de compra do produto (mínimo 0.01)
     * @throws IllegalArgumentException em caso dos limites acima serem desrespeitados.
     */
    public ProdutoNaoPerecivel(String descricao, double precoCusto){
        super(descricao, precoCusto);
    }

    /**
     * Retorna o valor de venda do produto, considerando seu preço de custo e margem de lucro
     * @return Valor de venda do produto (double, positivo)
     */
    public double valorDeVenda(){
        return precoCusto * (1+margemLucro);
    }

    /**
     * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas decimais.
     * @return Uma string no formato "1; descrição;preçoDeCusto;margemDeLucro"
     */
    @Override
    public String gerarDadosTexto() {
        String precoFormatado = String.format("%.2f",precoCusto).replace(",", ".");
        String margemFormatada = String.format("%.2f",margemLucro).replace(",", ".");
        return String.format("1;%s;%s;%s", descricao, precoFormatado, margemFormatada);
    }
}
