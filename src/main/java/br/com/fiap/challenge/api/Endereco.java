package br.com.fiap.challenge.api;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String erro; // ViaCEP returns 'erro' when not found

    public Endereco() {}

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getErro() { return erro; }
    public void setErro(String erro) { this.erro = erro; }

    @Override
    public String toString() {
        if (erro != null && (erro.equals("true") || erro.equals("true\""))) {
            return "CEP não encontrado.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CEP: ").append(cep).append("\n");
        sb.append("Logradouro: ").append(logradouro).append("\n");
        sb.append("Complemento: ").append(complemento).append("\n");
        sb.append("Bairro: ").append(bairro).append("\n");
        sb.append("Cidade: ").append(localidade).append("\n");
        sb.append("Estado: ").append(uf);
        return sb.toString();
    }
}
