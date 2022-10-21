package br.com.santoprograma.application.frameworksp;

import java.util.List;

public interface ConverterBase<E, DTO, PostDTO, PutDTO> {

    DTO mapEntityForDTO(E ent);

    List<DTO> mapEntityForDTOGetAll(List<E> list);

    E mapDTOForInsert(PostDTO dto);

    E mapDTOForUpdate(E ent, PutDTO dto);
}
