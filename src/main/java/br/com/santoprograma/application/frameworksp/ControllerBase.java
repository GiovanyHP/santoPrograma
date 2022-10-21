package br.com.santoprograma.application.frameworksp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Component
public interface ControllerBase<DTO, GETALLDTO, POSTDTO, PUTDTO> {

    ResponseEntity<DTO> findById(@PathVariable Long id);

    ResponseEntity<List<GETALLDTO>> findAll();

    ResponseEntity<DTO> create(@RequestBody @Valid POSTDTO postdto);

    ResponseEntity<DTO> update(@PathVariable Long id, @Valid @RequestBody PUTDTO putdto);

    ResponseEntity<Void> delete(@PathVariable Long id);
}
