package domain;

import java.util.Date;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
public class Mugimenduak {
	@Id 
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer mugimenduId;
	private Double dirualdaketa;
	private Date Data;
	private Integer mugimenduMota;//0 dirua sartu, 1 diru aldaketa(irabazi/galdu)

	
	public Integer getMugimenduMota() {
		return mugimenduMota;
	}
	public void setMugimenduMota(Integer mugimenduMota) {
		this.mugimenduMota = mugimenduMota;
	}
	public Mugimenduak(Double dirualdaeta, Date data, Integer mugimendu) {
		super();
		this.dirualdaketa = dirualdaeta;
		Data = data;
		this.mugimenduMota=mugimendu;
	}
	public Mugimenduak() {
		super();
	}
	public Integer getMugimenduId() {
		return mugimenduId;
	}
	public void setMugimenduId(Integer mugimenduId) {
		this.mugimenduId = mugimenduId;
	}
	public Double getDirualdaketa() {
		return dirualdaketa;
	}
	public void setDirualdaketa(Double dirualdaeta) {
		this.dirualdaketa = dirualdaeta;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	
}
