package com.fatec.sp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.sp.model.Cliente;

@RestController
public class Controle {

	@GetMapping("/alo-mundo")
	public String aloMundo() {
		return "Alo mundo!!";
	}

	@GetMapping("/clientes")
	public Cliente getCliente() {
		Cliente umCliente = new Cliente(1, "Jose", "Av. Aguia de Haia");
		return umCliente;
	}

	@GetMapping("/clientes_all")
	public List<Cliente> getAll() {
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente(1, "Jose", "Av. Aguia de Haia"));
		lista.add(new Cliente(2, "Silva", "Av. Paulista"));
		lista.add(new Cliente(3, "Maria", "Av. Martins Fontes"));
		return lista;
	}

	@GetMapping("/clientes/{id}")
	public Cliente getClientePorId(@PathVariable("id") int id) {
		return new Cliente(id, "Souza", "Av. Martins Fonteas");
	}

//	@GetMapping("/clientes/{nome}")
//	public Cliente getClientePorId(@PathVariable("nome") String nome) {
//		return new Cliente(1, nome, "Av. Martins Fonteas");
//	}

	@PostMapping("/clientes")
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente(cliente.getId(), cliente.getNome(), cliente.getEndereco()));
		return lista.get(0);
	}

	@PutMapping("/clientes/{id}")
	public Cliente atualizarCliente(@RequestBody Cliente cliente, @PathVariable("id") int id) {
		Cliente clienteAtualizado = new Cliente(id, cliente.getNome(), cliente.getEndereco());
		return clienteAtualizado;
	}

	@DeleteMapping("/clientes{id}")
	public String excluirCliente(@PathVariable("id") int id) {
		return "Cliente " + id + " excluido";
	}
}
