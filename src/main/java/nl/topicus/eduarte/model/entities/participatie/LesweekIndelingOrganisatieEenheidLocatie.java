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
package nl.topicus.eduarte.model.entities.participatie;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.organisatie.IOrganisatieEenheidLocatieKoppelEntiteit;
import nl.topicus.eduarte.model.entities.organisatie.IOrganisatieEenheidLocatieKoppelbaarEntiteit;
import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;
import nl.topicus.eduarte.model.entities.organisatie.Locatie;
import nl.topicus.eduarte.model.entities.organisatie.OrganisatieEenheid;

@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@Table(name = "LesweekIndelingOrgLoc")
public class LesweekIndelingOrganisatieEenheidLocatie extends InstellingEntiteit
implements IOrganisatieEenheidLocatieKoppelEntiteit<LesweekIndelingOrganisatieEenheidLocatie> {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organisatieEenheid", nullable = false)
	private OrganisatieEenheid organisatieEenheid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locatie", nullable = true)
	private Locatie locatie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesweekIndeling", nullable = false)
	private LesweekIndeling lesweekIndeling;

	@Override
	public OrganisatieEenheid getOrganisatieEenheid() {
		return organisatieEenheid;
	}

	@Override
	public void setOrganisatieEenheid(OrganisatieEenheid organisatieEenheid) {
		this.organisatieEenheid = organisatieEenheid;
	}

	@Override
	public Locatie getLocatie() {
		return locatie;
	}

	@Override
	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}

	public LesweekIndeling getLesweekIndeling() {
		return lesweekIndeling;
	}

	public void setLesweekIndeling(LesweekIndeling lesweekIndeling) {
		this.lesweekIndeling = lesweekIndeling;
	}

	@Override
	public IOrganisatieEenheidLocatieKoppelbaarEntiteit<LesweekIndelingOrganisatieEenheidLocatie> getEntiteit() {
		// TODO Auto-generated method stub
		return null;
	}
}
