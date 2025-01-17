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
package nl.topicus.eduarte.model.entities.personen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Comment;

import nl.topicus.eduarte.model.entities.IsViewWhenOnNoise;
import nl.topicus.eduarte.model.entities.codenaamactief.CodeNaamActiefInstellingEntiteit;

/**
 *
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@javax.persistence.Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "code", "organisatie" }) })
@IsViewWhenOnNoise
public class RelatieSoort extends CodeNaamActiefInstellingEntiteit {
	@Column(nullable = false)
	@Comment("Selecteer dit wanneer  de Relatiesoort gebruikt kan worden bij een persoon")
	private boolean persoonOpname;

	@Column(nullable = false)
	@Comment("Selecteer dit wanneer de Relatiesoort gebruikt kan worden bij een organisatie")
	private boolean organisatieOpname;

	public RelatieSoort() {
	}

	public boolean isPersoonOpname() {
		return persoonOpname;
	}

	public void setPersoonOpname(boolean persoonOpname) {
		this.persoonOpname = persoonOpname;
	}

	public boolean isOrganisatieOpname() {
		return organisatieOpname;
	}

	public void setOrganisatieOpname(boolean organisatieOpname) {
		this.organisatieOpname = organisatieOpname;
	}

	@Override
	public String toString() {
		return getNaam();
	}
}
