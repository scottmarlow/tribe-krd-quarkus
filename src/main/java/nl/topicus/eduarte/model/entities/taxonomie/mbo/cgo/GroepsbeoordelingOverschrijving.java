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

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Houdt uitzonderingen voor een individuele deelnemer t.o.v. een
 * Groepsbeoordeling bij. Dus alleen de gewijzigde leerpunten worden hierin
 * opgeslagen! N.b., deze overschrijving wordt standaard leeg aangemaakt voor
 * alle deelnemers op het moment dat een nieuwe GroepsBeoordeling wordt
 * aangemaakt. Voor het tonen van niet-overschreven leerpunten worden die uit de
 * GroepsBeoordeling gebruikt.
 *
 */
@Entity
public class GroepsbeoordelingOverschrijving extends Beoordeling {
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "groepsBeoordeling", nullable = true)
	private Groepsbeoordeling groepsBeoordeling;

	public Groepsbeoordeling getGroepsBeoordeling() {
		return groepsBeoordeling;
	}

	public void setGroepsBeoordeling(Groepsbeoordeling groepsBeoordeling) {
		this.groepsBeoordeling = groepsBeoordeling;
	}
}
