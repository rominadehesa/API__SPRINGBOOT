package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Compra {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column
	private LocalDate fecha;
	@OneToMany(cascade={CascadeType.MERGE})
	
	private List<Item> items;
	
	public Compra() {
		
	}
	
	public Compra(LocalDate fecha) {
		this.fecha = fecha;
		this.items = new ArrayList<>();
	}

	public void addItem(Item i) {
		this.items.add(i);
	}

	public ArrayList<Item> getItems() {
		return new ArrayList<Item>(this.items);
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public void setId(int id) {
		this.id=id;
	}
	public LocalDate getFechaVenta() {
		return this.fecha;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fecha = fechaVenta;
	}

	public float getTotal() {
		float total = 0;
		for (Item i: items) {
			total+= i.getTotal();
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Compra [items=" + items + "]";
	}
	
	
}
