package br.com.miranda.loja_virtual.enums;

public enum TipoEndereco {
    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private  String descricao;

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    //char a descrição, caso precise - get

    public String getDescricao() {
        return descricao;
    }

    //Mostrar na tela
    @Override
    public String toString() {
        return this.descricao;
    }
}
