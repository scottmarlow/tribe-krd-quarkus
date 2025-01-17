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
package nl.topicus.eduarte.model.entities.productregel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.onderwijsproduct.Onderwijsproduct;
import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;

/**
 * Koppeltabel tussen productregel en onderwijsproduct waarmee aangegeven wordt
 * welke onderwijsproducten toegestaan zijn voor een bepaalde productregel.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class ToegestaanOnderwijsproduct extends InstellingEntiteit {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productregel", nullable = false)
	private Productregel productregel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "onderwijsproduct", nullable = false)
	private Onderwijsproduct onderwijsproduct;

	public ToegestaanOnderwijsproduct() {
	}

	public Productregel getProductregel() {
		return productregel;
	}

	public void setProductregel(Productregel productregel) {
		this.productregel = productregel;
	}

	public Onderwijsproduct getOnderwijsproduct() {
		return onderwijsproduct;
	}

	public void setOnderwijsproduct(Onderwijsproduct onderwijsproduct) {
		this.onderwijsproduct = onderwijsproduct;
	}
}
