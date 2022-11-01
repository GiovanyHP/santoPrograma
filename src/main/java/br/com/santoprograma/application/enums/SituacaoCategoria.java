package br.com.santoprograma.application.enums;

public enum SituacaoCategoria {

    INATIVO(0, "CANCELADO"), ATIVO(1, "ATIVO");

    private Integer codigo;
    private String descricao;

    SituacaoCategoria(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoCategoria toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (SituacaoCategoria SituacaoCategoria : SituacaoCategoria.values()) {
            if (codigo.equals(SituacaoCategoria.getCodigo())) {
                return SituacaoCategoria;
            }
        }

        throw new IllegalArgumentException("Situação da Categoria Inválida! Código: " + codigo);
    }
}
