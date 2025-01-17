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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.organisatie.LandelijkOfInstellingEntiteit;

/**
 * Vaardigheden behorende bij een kwalificatiedossier.
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Landelijk")
public class Vaardigheid extends LandelijkOfInstellingEntiteit {
	@Column(nullable = false)
	private int nummer;

	@Column(length = 256, nullable = false)
	private String titel;

	@ManyToOne(optional = true)
	@JoinColumn(name = "dossier", nullable = true)
	private Kwalificatiedossier dossier;

	public int getNummer() {
		return nummer;
	}

	public String getTitel() {
		return titel;
	}

	@Override
	public String toString() {
		return nummer + " " + titel;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Kwalificatiedossier getDossier() {
		return dossier;
	}

	public void setDossier(Kwalificatiedossier dossier) {
		this.dossier = dossier;
	}
}
