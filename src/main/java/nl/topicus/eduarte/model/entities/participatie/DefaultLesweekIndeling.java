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

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.settings.OrganisatieEenheidSetting;

/**
 * Setting die aangeeft welke lesweekindeling default gebruikt moet worden per
 * organisatie-eenheid, wanneer geen rooster bekend is.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class DefaultLesweekIndeling extends OrganisatieEenheidSetting<LesweekIndeling> {

	@Basic(optional = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesweekIndeling", nullable = true)
	private LesweekIndeling lesweekIndeling;

	@Override
	public String getOmschrijving() {
		return "Default lesweekindeling per organisatie-eenheid";
	}

	@Override
	public LesweekIndeling getValue() {
		return getLesweekIndeling();
	}

	@Override
	public void setValue(LesweekIndeling value) {
		setLesweekIndeling(value);
	}

	/**
	 * @return Returns the lesweekIndeling.
	 */
	public LesweekIndeling getLesweekIndeling() {
		return lesweekIndeling;
	}

	/**
	 * @param lesweekIndeling The lesweekIndeling to set.
	 */
	public void setLesweekIndeling(LesweekIndeling lesweekIndeling) {
		this.lesweekIndeling = lesweekIndeling;
	}

}
