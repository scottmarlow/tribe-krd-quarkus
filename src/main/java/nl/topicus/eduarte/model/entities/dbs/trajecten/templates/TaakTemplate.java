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
package nl.topicus.eduarte.model.entities.dbs.trajecten.templates;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ForeignKey;

import nl.topicus.eduarte.model.entities.dbs.trajecten.TaakSoort;

/**
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class TaakTemplate extends BegeleidingsHandelingTemplate
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "taakSoort", nullable = true)
	@Basic(optional = false)
	@ForeignKey(name = "FK_TaakTempl_soort")
	private TaakSoort taakSoort;

	public TaakSoort getTaakSoort() {
		return taakSoort;
	}

	public void setTaakSoort(TaakSoort taakSoort) {
		this.taakSoort = taakSoort;
	}
}
