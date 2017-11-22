package com.samilaruane.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samilaruane.cursomc.domain.Categoria;
import com.samilaruane.cursomc.domain.Cidade;
import com.samilaruane.cursomc.domain.Estado;
import com.samilaruane.cursomc.domain.Produto;
import com.samilaruane.cursomc.repositories.CategoriaRepository;
import com.samilaruane.cursomc.repositories.CidadeRepository;
import com.samilaruane.cursomc.repositories.EstadoRepository;
import com.samilaruane.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado e1 = new Estado (null, "São Paulo");
		Estado e2 = new Estado (null, "Minas Gerais");
		
		Cidade c1 = new Cidade (null, "Uberlândia", e2);
		Cidade c2 = new Cidade (null, "Campinas", e1);
		Cidade c3 = new Cidade (null, "São Paulo", e1);
				
		
		e1.getCidades().addAll(Arrays.asList(c2, c3));
		e2.getCidades().addAll(Arrays.asList(c1));
		
		estadoRepository.save(Arrays.asList(e1, e2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
	}
}
