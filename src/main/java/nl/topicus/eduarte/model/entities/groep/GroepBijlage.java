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

import nl.topicus.eduarte.model.entities.bijlage.BijlageEntiteit;
import nl.topicus.eduarte.model.entities.bijlage.IBijlageKoppelEntiteit;

/**
 * Koppeltabel tussen groep en bijlage
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class GroepBijlage extends BijlageEntiteit {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "groep")
	private Groep groep;

	public GroepBijlage() {
	}

	public Groep getGroep() {
		return groep;
	}

	public void setGroep(Groep groep) {
		this.groep = groep;
	}

	@Override
	public IBijlageKoppelEntiteit<GroepBijlage> getEntiteit() {
		return getGroep();
	}
}
