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

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.codenaamactief.CodeNaamActiefInstellingEntiteit;

/**
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@javax.persistence.Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "code", "organisatie" }) })
public class RedenUitDienst extends CodeNaamActiefInstellingEntiteit implements Comparable<RedenUitDienst> {
	public RedenUitDienst() {
	}

	@Override
	public int compareTo(RedenUitDienst arg0) {
		if (arg0 == null)
			throw new NullPointerException("Kan niet vergelijken met null.");
		return getNaam().compareTo(arg0.getNaam());
	}

	@Override
	public String toString() {
		return getNaam();
	}
}
