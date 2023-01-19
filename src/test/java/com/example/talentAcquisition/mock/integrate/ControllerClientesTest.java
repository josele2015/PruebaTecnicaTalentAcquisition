package com.example.talentAcquisition.mock.integrate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.controller.ControllerClientes;
//import com.example.TalentAcquisition;
import com.example.repo.IClienteRepo;
import com.example.repo.IPersonaRepo;
import com.example.service.ClienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ControllerClientesTest {
	@Value(value="${local.server.port}")
	private int port;
	@Mock 
	private IClienteRepo iClienteRepo;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
    private ObjectMapper objectMapper;
	private ClienteServiceImpl clienteServiceImpl;
	
	//Comprobar que la cantidad de clientes sea mayor cero
	@Test
	public void getTestMostrarCliente()  throws Exception{
		System.out.println("Hola")	;
		this.mockMvc.perform(get("/clientes/getClientes")).andExpect(status().isOk());
//		this.mockMvc.perform(get("/clientes/getClientes")
//			      .contentType(MediaType.APPLICATION_JSON))
//	      .andExpect(status().isOk())
//	      .andExpect(content()
//	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
