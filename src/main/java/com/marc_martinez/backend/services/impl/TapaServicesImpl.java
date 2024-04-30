package com.marc_martinez.backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.marc_martinez.backend.model.Tapa;
import com.marc_martinez.backend.services.TapaServices;

@Service
public class TapaServicesImpl implements TapaServices{
	
	private final TreeMap<Long, Tapa> TAPAS = new TreeMap<>();
	
	public TapaServicesImpl() {
		init();
	}

	@Override
	public Long create(Tapa tapa) {
		Long id = TAPAS.lastKey() + 1;
		
		tapa.setId(id);
		
		TAPAS.put(tapa.getId(), tapa);
		
		return id;
	}

	@Override
	public Optional<Tapa> read(Long id) {
		return Optional.ofNullable(TAPAS.get(id));
	}

	@Override
	public List<Tapa> getAll() {
		return new ArrayList<>(TAPAS.values());
	}
	
	private void init() {
		Tapa t1 = new Tapa();
		Tapa t2 = new Tapa();
		Tapa t3 = new Tapa();
		
		t1.setId(1L);
		t1.setNombre("Croquetas");
		t1.setDescripcion("Croquetas de jamon");
		t1.setPrecio(2.50);
		t1.setTipo("Salada");
		t1.setEnCarta(true);
		
		t2.setId(2L);
		t2.setNombre("Patatas");
		t2.setDescripcion("Patatas bravas");
		t2.setPrecio(3.50);
		t2.setTipo("Salada");
		t2.setEnCarta(true);
		
		t3.setId(3L);
		t3.setNombre("Olivas");
		t3.setDescripcion("Olivas negras");
		t3.setPrecio(1.00);
		t3.setTipo("Salada");
		t3.setEnCarta(true);
		
		TAPAS.put(t1.getId(), t1);
		TAPAS.put(t2.getId(), t2);
		TAPAS.put(t3.getId(), t3);
	}

}
