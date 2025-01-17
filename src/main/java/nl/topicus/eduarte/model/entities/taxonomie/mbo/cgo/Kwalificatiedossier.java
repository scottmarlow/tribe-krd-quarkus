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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Kwalificatiedossiers voor het CGO.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Landelijk")
public class Kwalificatiedossier extends CompetentieMatrix {
	@Column(nullable = true)
	private Integer nummer;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dossier")
	private Set<Vaardigheid> vaardigheden = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dossier")
	private List<Uitstroom> uitstromen = new ArrayList<>();

	public Integer getNummer() {
		return nummer;
	}

	public void setNummer(Integer nummer) {
		this.nummer = nummer;
	}

	public Set<Vaardigheid> getVaardigheden() {
		return vaardigheden;
	}

	public void setVaardigheden(Set<Vaardigheid> vaardigheden) {
		this.vaardigheden = vaardigheden;
	}

	public List<Uitstroom> getUitstromen() {
		return uitstromen;
	}

	public void setUitstromen(List<Uitstroom> uitstromen) {
		this.uitstromen = uitstromen;
	}

	@Override
	public String getType() {
		return null;
	}
}
