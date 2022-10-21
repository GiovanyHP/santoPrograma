package br.com.santoprograma.application.enums;

public enum SituacaoOracao {

    CANCELADO(0, "CANCELADO"), ATIVO(1, "ATIVO"), LIDO(2, "LIDO");

    private Integer codigo;
    private String descricao;

    SituacaoOracao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoOracao toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (SituacaoOracao SituacaoOracao : SituacaoOracao.values()) {
            if (codigo.equals(SituacaoOracao.getCodigo())) {
                return SituacaoOracao;
            }
        }

        throw new IllegalArgumentException("Situação de Oração Inválida! Código: " + codigo);
    }
}
