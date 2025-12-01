package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.helper;

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import com.robinlb99.legalserviceportalapi.core.model.exception.IllegalTipoDocumentoException;
import org.springframework.stereotype.Component;

@Component
public class DocumentoHelper {

    public TipoDocumento obtenerTipoDocumento(String tipoDocumento) {
        return switch (tipoDocumento) {
            case "IDENTIFICACION_OFICIAL" -> TipoDocumento.IDENTIFICACION_OFICIAL;
            case "CURP" -> TipoDocumento.CURP;
            case "COMPROBANTE_DOMICILIO" -> TipoDocumento.COMPROBANTE_DOMICILIO;
            case "ACTA_NACIMIENTO" -> TipoDocumento.ACTA_NACIMIENTO;
            case "RFC" -> TipoDocumento.RFC;
            case "CONTRATOS" -> TipoDocumento.CONTRATOS;
            case "CORRESPONDENCIA" -> TipoDocumento.CORRESPONDENCIA;
            case "FOTOGRAFIAS_EVIDENCIA" -> TipoDocumento.FOTOGRAFIAS_EVIDENCIA;
            case "VIDEOS_GRABACIONES" -> TipoDocumento.VIDEOS_GRABACIONES;
            case "DECLARACIONES_TESTIGOS" -> TipoDocumento.DECLARACIONES_TESTIGOS;
            case "DICTAMENES_PERICIALES" -> TipoDocumento.DICTAMENES_PERICIALES;
            case "CONTRATO_ORIGINAL" -> TipoDocumento.CONTRATO_ORIGINAL;
            case "PAGARES" -> TipoDocumento.PAGARES;
            case "LETRAS_CAMBIO" -> TipoDocumento.LETRAS_CAMBIO;
            case "FACTURAS" -> TipoDocumento.FACTURAS;
            case "COMPROBANTES_PAGO" -> TipoDocumento.COMPROBANTES_PAGO;
            case "NOTIFICACIONES_EXTRAJUDICIALES" -> TipoDocumento.NOTIFICACIONES_EXTRAJUDICIALES;
            case "CORREOS_ELECTRONICOS" -> TipoDocumento.CORREOS_ELECTRONICOS;
            case "REPORTES_MEDICOS" -> TipoDocumento.REPORTES_MEDICOS;
            case "PRESUPUESTOS_REPARACION" -> TipoDocumento.PRESUPUESTOS_REPARACION;
            case "FOTOGRAFIAS_DANIO" -> TipoDocumento.FOTOGRAFIAS_DANIO;
            case "REPORTES_PERITOS" -> TipoDocumento.REPORTES_PERITOS;
            case "COMPROBANTES_GASTOS" -> TipoDocumento.COMPROBANTES_GASTOS;
            case "ACTA_MATRIMONIO" -> TipoDocumento.ACTA_MATRIMONIO;
            case "ACTAS_NACIMIENTO_HIJOS" -> TipoDocumento.ACTAS_NACIMIENTO_HIJOS;
            case "INVENTARIO_BIENES" -> TipoDocumento.INVENTARIO_BIENES;
            case "COMPROBANTES_INGRESOS" -> TipoDocumento.COMPROBANTES_INGRESOS;
            case "ACUERDOS_PRENUPCIALES" -> TipoDocumento.ACUERDOS_PRENUPCIALES;
            case "COMPROBANTES_GASTOS_MENOR" -> TipoDocumento.COMPROBANTES_GASTOS_MENOR;
            case "ESTADOS_CUENTA" -> TipoDocumento.ESTADOS_CUENTA;
            case "RECIBOS_COLEGIATURAS" -> TipoDocumento.RECIBOS_COLEGIATURAS;
            case "GASTOS_MEDICOS" -> TipoDocumento.GASTOS_MEDICOS;
            case "CONTRATO_TRABAJO" -> TipoDocumento.CONTRATO_TRABAJO;
            case "RECIBOS_NOMINA" -> TipoDocumento.RECIBOS_NOMINA;
            case "CARTAS_DESPIDO" -> TipoDocumento.CARTAS_DESPIDO;
            case "COMUNICACIONES_INTERNAS" -> TipoDocumento.COMUNICACIONES_INTERNAS;
            case "HORARIOS_ASISTENCIA" -> TipoDocumento.HORARIOS_ASISTENCIA;
            case "EVALUACIONES_DESEMPENO" -> TipoDocumento.EVALUACIONES_DESEMPENO;
            case "DENUNCIA_QUERELLA" -> TipoDocumento.DENUNCIA_QUERELLA;
            case "DECLARACIONES_MINISTERIO_PUBLICO" -> TipoDocumento.DECLARACIONES_MINISTERIO_PUBLICO;
            case "FOTOGRAFIAS_LESIONES" -> TipoDocumento.FOTOGRAFIAS_LESIONES;
            case "REPORTES_MEDICOS_PENALES" -> TipoDocumento.REPORTES_MEDICOS_PENALES;
            case "ESCRITURAS_PUBLICAS" -> TipoDocumento.ESCRITURAS_PUBLICAS;
            case "TITULOS_PROPIEDAD" -> TipoDocumento.TITULOS_PROPIEDAD;
            case "CONTRATOS_ARRENDAMIENTO" -> TipoDocumento.CONTRATOS_ARRENDAMIENTO;
            case "COMPROBANTES_PAGO_RENTA" -> TipoDocumento.COMPROBANTES_PAGO_RENTA;
            case "FOTOGRAFIAS_INMUEBLE" -> TipoDocumento.FOTOGRAFIAS_INMUEBLE;
            case "AVALUOS" -> TipoDocumento.AVALUOS;
            case "ACTA_CONSTITUTIVA" -> TipoDocumento.ACTA_CONSTITUTIVA;
            case "PODERES_NOTARIALES" -> TipoDocumento.PODERES_NOTARIALES;
            case "ESTADOS_FINANCIEROS" -> TipoDocumento.ESTADOS_FINANCIEROS;
            case "CONTRATOS_COMERCIALES" -> TipoDocumento.CONTRATOS_COMERCIALES;
            case "FACTURAS_COMERCIALES" -> TipoDocumento.FACTURAS_COMERCIALES;
            case "ORDENES_COMPRA" -> TipoDocumento.ORDENES_COMPRA;
            case "CORRESPONDENCIA_COMERCIAL" -> TipoDocumento.CORRESPONDENCIA_COMERCIAL;
            case "ESTADOS_CUENTA_BANCARIOS" -> TipoDocumento.ESTADOS_CUENTA_BANCARIOS;
            case "DECLARACIONES_FISCALES" -> TipoDocumento.DECLARACIONES_FISCALES;
            case "CONTRATOS_CREDITO" -> TipoDocumento.CONTRATOS_CREDITO;
            case "POLIZAS_SEGURO" -> TipoDocumento.POLIZAS_SEGURO;
            case "COMPROBANTES_INGRESOS_FINANCIEROS" -> TipoDocumento.COMPROBANTES_INGRESOS_FINANCIEROS;
            default -> throw new IllegalTipoDocumentoException(
                "Tipo de documento no válido: " + tipoDocumento
            );
        };
    }
}
