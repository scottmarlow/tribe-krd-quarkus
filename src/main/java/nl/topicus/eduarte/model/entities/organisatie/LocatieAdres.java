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
package nl.topicus.eduarte.model.entities.organisatie;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.adres.AdresEntiteit;

/**
 * Koppeltabel tussen locatie en adres.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class LocatieAdres extends AdresEntiteit<LocatieAdres> {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locatie", nullable = true)
	@Basic(optional = false)
	private Locatie locatie;

	/**
	 * Gebruik newAdres() van bijbehorende Adresseerbaar entiteit.
	 */
	public LocatieAdres() {
	}

	/**
	 * @return Returns the persoon.
	 */
	public Locatie getLocatie() {
		return locatie;
	}

	/**
	 * @param locatie The locatie to set.
	 */
	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}
}
