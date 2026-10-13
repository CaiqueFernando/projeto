package ProjetoEstacionamento;

public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
    private String proprietario;
    
 
    public Veiculo(String placa, String modelo, String cor, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.proprietario = proprietario;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public String getCor() {
        return cor;
    }
    
    public String getProprietario() {
        return proprietario;
    }
    
    @Override
    public String toString() {
        return "Placa: " + placa
                + " | Modelo: " + modelo
                + " | Cor: " + cor
                + " | Proprietário: " + proprietario;
    }
    
    
    }
    
