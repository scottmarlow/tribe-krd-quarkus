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
package nl.topicus.eduarte.model.entities.groep;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.IsViewWhenOnNoise;
import nl.topicus.eduarte.model.entities.begineinddatum.BeginEinddatumInstellingEntiteit;
import nl.topicus.eduarte.model.entities.personen.Deelnemer;

/**
 * Deelname aan een groep door een deelnemer.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@IsViewWhenOnNoise
public class Groepsdeelname extends BeginEinddatumInstellingEntiteit{
	/**
	 * Nullable = true omdat er subclasses (persoonlijkeGroepDeelnemer) zijn waarbij
	 * deelnemer niet verplicht is.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deelnemer", nullable = true)
	private Deelnemer deelnemer;

	/**
	 * Nullable = true omdat er subclasses (Plaatsing) zijn waarbij groep niet
	 * verplicht is.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groep", nullable = true)
	protected Groep groep;

	public Deelnemer getDeelnemer() {
		return deelnemer;
	}

	public void setDeelnemer(Deelnemer deelnemer) {
		this.deelnemer = deelnemer;
	}

	public Groep getGroep() {
		return groep;
	}

	public void setGroep(Groep groep) {
		this.groep = groep;
	}
}
