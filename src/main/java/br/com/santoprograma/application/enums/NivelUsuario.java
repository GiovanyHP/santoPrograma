package br.com.santoprograma.application.enums;

public enum NivelUsuario {
    ADMINISTRADOR(0, "ADMINISTRADOR"),
    PADRAO(1, "PADRAO"),
    OBREIRO(2, "OBREIRO");

    private Integer codigo;
    private String descricao;

    NivelUsuario(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NivelUsuario toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (NivelUsuario nivelUsuario : NivelUsuario.values()) {
            if (codigo.equals(nivelUsuario.getCodigo())) {
                return nivelUsuario;
            }
        }

        throw new IllegalArgumentException("Nivel de Usuário Inválido! Código informado: " + codigo);
    }
}
