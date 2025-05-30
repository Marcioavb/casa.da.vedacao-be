package com.marcio.casa.da.vedacao.reparo.apllication.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reparo")
@Tag(name = "reparo", description = "Endpoints para cadastrar reparo.")
public interface ReparoApi {

    @PostMapping
    @Operation(summary = "Cadastra um novo reparo")
    @ResponseStatus(HttpStatus.CREATED)
    ReparoResponse cadastraReparo(@RequestBody ReparoRequest salaoRequest);

    @GetMapping("/codigo/{codigo}")
    @Operation(summary = "Busca reparo por código")
    @ResponseStatus(HttpStatus.OK)
    ReparoResponse buscaPorCodigo(@PathVariable String codigo);

    @GetMapping("/medidas")
    @Operation(summary = "Busca reparos por medidas")
    @ResponseStatus(HttpStatus.OK)
    List<ReparoResponse> buscaPorMedidas(@RequestParam String medidas);

    @PatchMapping("/codigo/{codigo}")
    @Operation(summary = "Atualiza um reparo pelo código")
    @ResponseStatus(HttpStatus.OK)
    ReparoResponse atualizaReparoPorCodigo(
            @PathVariable String codigo,
            @RequestBody ReparoUpdateRequest reparoUpdateRequest);

    @DeleteMapping("/codigo/{codigo}")
    @Operation(summary = "Remove um reparo pelo código")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaReparoPorCodigo(@PathVariable String codigo);
}
