/*
 * Copyright 2022 Topicus Onderwijs Eduarte B.V..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.topicus.eduarte.model.entities.taxonomie.mbo.cgo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.LandelijkEntiteit;

/**
 * Competentie in het CGO.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Landelijk")
@jakarta.persistence.Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
public class Competentie extends LandelijkEntiteit implements Comparable<Competentie> {
	/** de titel van de competentie. */
	@Column(length = 128, nullable = false)
	private String titel;

	/** de code voor de competentie ('a'-'z') */
	@Column(length = 1, nullable = false)
	private String code;

	/** referentie nummer in document */
	@Column(nullable = false)
	private int nummer;

	/** de componenten voor deze competentie. */
	@OneToMany(mappedBy = "competentie")
	private List<CompetentieComponent> componenten = new ArrayList<>();

	/**
	 * Constructor.
	 */
	public Competentie() {
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Zet de code van de competentie. De code is een uppercase letter.
	 *
	 * @param code de code die gezet moet worden
	 */
	public void setCode(String code) {
		var c = code.toUpperCase().charAt(0);
		if (!('A' <= c && c <= 'Y')) {
			throw new IllegalArgumentException(
					"Competentie code " + code + " is geen valide code (moet tussen 'A' en 'Y' liggen)");
		}
		this.code = code.substring(0, 1).toUpperCase();
	}

	/**
	 * Geeft een readonly lijst van de competentie componenten terug.
	 *
	 * @return een readonly lijst van de competentie componenten
	 */
	public List<CompetentieComponent> getComponenten() {
		return componenten;
	}

	/**
	 * @return the nummer
	 */
	public int getNummer() {
		return nummer;
	}

	/**
	 * Zet het nummer.
	 *
	 * @param nummer
	 */
	public void setNummer(Integer nummer) {
		this.nummer = nummer;
	}

	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * Zet de titel.
	 *
	 * @param titel
	 */
	public void setTitel(String titel) {
		this.titel = titel.substring(0, Math.min(128, titel.length()));
	}

	/**
	 * Voegt een competentie component toe.
	 *
	 * @param component
	 */
	public void addComponent(CompetentieComponent component) {
		component.setCompetentie(this);
		getComponenten().add(component);
	}

	/**
	 * @param componentNummer
	 */
	public CompetentieComponent getComponent(int componentNummer) {
		for (CompetentieComponent component : getComponenten()) {
			if (component.getNummer() == componentNummer)
				return component;
		}
		throw new IllegalArgumentException(
				"Component met nummer " + componentNummer + " bestaat niet in competentie " + getCode() + ".");
	}

	@Override
	public int compareTo(Competentie o) {
		return getCode().compareTo(o.getCode());
	}

	/**
	 * @param nummer The nummer to set.
	 */
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	/**
	 * @param componenten The componenten to set.
	 */
	public void setComponenten(List<CompetentieComponent> componenten) {
		this.componenten = componenten;
	}

}
