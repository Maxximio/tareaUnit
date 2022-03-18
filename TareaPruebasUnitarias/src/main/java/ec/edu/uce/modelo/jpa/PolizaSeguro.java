package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="poliza_seguro")
public class PolizaSeguro {

	@Id
	@Column(name="poli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_poli")
	@SequenceGenerator(name="seq_poli",sequenceName = "seq_poli",allocationSize = 1)
	private Integer id;
	
	@Column(name="poli_numero")
	private String numero;
	
	@Column(name="poli_valor")
	private BigDecimal valor;
	
	@Column(name="poli_descripcion")
	private String descripcion;
	
	@Column(name="poli_fecha_emision")
	private LocalDateTime fechaEmision;
	
	@Column(name="poli_fecha_vigencia")
	private LocalDateTime fechaVigencia;
	
	@Column(name="poli_estado")
	private String estado;
	
	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(LocalDateTime fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
