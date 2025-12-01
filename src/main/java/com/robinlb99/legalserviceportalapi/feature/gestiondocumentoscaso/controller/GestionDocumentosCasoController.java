package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.controller;

import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.service.GestionDocumentoCasoImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/casos/documento")
public class GestionDocumentosCasoController {

    private final GestionDocumentoCasoImpl gestionDocumentoCaso;

    public GestionDocumentosCasoController(GestionDocumentoCasoImpl gestionDocumentoCaso) {
        this.gestionDocumentoCaso = gestionDocumentoCaso;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ABOGADO')")
    public ResponseEntity<DocumentoResponseDTO> saveDocumentoCaso(
            @ModelAttribute DocumentoRequestDTO request
    ) {
        DocumentoResponseDTO responseDTO =
                gestionDocumentoCaso.adjuntarDocumentoAlCaso(request.casoId(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ABOGADO')")
//    public ResponseEntity<Void> deleteDocumentoCaso(
//            @PathVariable Long id
//    ) {
//
//        return null;
//    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ABOGADO', 'CLIENTE', 'ADMIN')")
    public ResponseEntity<DocumentoResponseDTO> getDocumentoCaso(
            @PathVariable Long id
    ) {
        DocumentoResponseDTO responseDTO = gestionDocumentoCaso.obtenerDocumentoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
