package com.digital.library.app.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPedido;

	private Long clienteId;
	
	private String clienteRazonSocial;

	private String glosa;

	private String fechaRegistro;

	private Double total;
/*
*    "idPedido": 6,
        "clienteId": 10,
        "clienteRazonSocial": "CLARO EMPRESAS 11",
        "glosa": "Pedido demo 6",
        "fechaRegistro": "07/09/2022",
        "total": 52000.0
* */
}
