package ProjetoEstacionamento;

public class ListaEncadeada {
    private No inicio;
    private int tamanho;
    
  
    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }
    
    
    public void inserirInicio(Veiculo veiculo) {
        No novo = new No(veiculo);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    
        System.out.println("Veículo inserido no início!");
    }
    
    
    public void inserirFim(Veiculo veiculo) {
        No novo = new No(veiculo);
    
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
    
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
    
            atual.proximo = novo;
        }
    
        tamanho++;
        System.out.println("Veículo inserido no fim!");
    }
    
    
    public void inserirPosicao(Veiculo veiculo, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }
    
        if (posicao == 0) {
            inserirInicio(veiculo);
            return;
        }
    
        if (posicao == tamanho) {
            inserirFim(veiculo);
            return;
        }
    
        No novo = new No(veiculo);
        No atual = inicio;
    
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
    
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;
    
        System.out.println("Veículo inserido na posição " + posicao + "!");
    }
    
    
    public void removerInicio() {
        if (inicio == null) {
            System.out.println("Estacionamento vazio!");
            return;
        }
    
        System.out.println("Veículo removido: " + inicio.veiculo);
        inicio = inicio.proximo;
        tamanho--;
    }
    
    
    public void removerFim() {
        if (inicio == null) {
            System.out.println("Estacionamento vazio!");
            return;
        }
    
        if (inicio.proximo == null) {
            System.out.println("Veículo removido: " + inicio.veiculo);
            inicio = null;
        } else {
            No atual = inicio;
    
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
    
            System.out.println("Veículo removido: " + atual.proximo.veiculo);
            atual.proximo = null;
        }
    
        tamanho--;
    }
    
    
    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida!");
            return;
        }
    
        if (posicao == 0) {
            removerInicio();
            return;
        }
    
        No atual = inicio;
    
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
    
        System.out.println("Veículo removido: " + atual.proximo.veiculo);
    
        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }
    
    
    public void verificarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida!");
            return;
        }
    
        No atual = inicio;
    
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
    
        System.out.println("Veículo na posição " + posicao + ":");
        System.out.println(atual.veiculo);
    }
    
    
    public void listar() {
        if (inicio == null) {
            System.out.println("Nenhum veículo estacionado!");
            return;
        }
    
        No atual = inicio;
        int posicao = 0;
    
        System.out.println("\n===== VEÍCULOS ESTACIONADOS =====");
    
        while (atual != null) {
            System.out.println("Posição " + posicao + ": " + atual.veiculo);
            atual = atual.proximo;
            posicao++;
        }
    
        System.out.println("Total de veículos: " + tamanho);
    }
    
    
    public void pesquisar(String placa) {
        No atual = inicio;
        int posicao = 0;
    
        while (atual != null) {
            if (atual.veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veículo encontrado!");
                System.out.println("Posição: " + posicao);
                System.out.println(atual.veiculo);
                return;
            }
    
            atual = atual.proximo;
            posicao++;
        }
    
        System.out.println("Veículo não encontrado!");
    }
    
    
    public int getTamanho() {
        return tamanho;
    }
   
    
    }
    