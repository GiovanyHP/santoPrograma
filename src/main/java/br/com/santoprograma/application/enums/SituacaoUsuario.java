package br.com.santoprograma.application.enums;

public enum SituacaoUsuario {
    INATIVO(0, "INATIVO"),
    ATIVO(1, "ATIVO");

    private Integer codigo;
    private String descricao;

    SituacaoUsuario(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoUsuario toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (SituacaoUsuario situacaoUsuario : SituacaoUsuario.values()) {
            if (codigo.equals(situacaoUsuario.getCodigo())) {
                return situacaoUsuario;
            }
        }

        throw new IllegalArgumentException("Situação de Usuário Inválida! Código informado: " + codigo);
    }
}
