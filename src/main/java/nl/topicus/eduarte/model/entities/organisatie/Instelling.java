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
package nl.topicus.eduarte.model.entities.organisatie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Instelling = BVE instelling. Hieraan worden deelnemers en medewerkers
 * gekoppeld.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Inrichting")
public class Instelling extends Organisatie {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code", nullable = true)
	private Brin brincode;

	@Column(nullable = true, length = 300)
	private String wikiUser;

	@Column(nullable = true, length = 300)
	private String wikiPassword;

	public Brin getBrincode() {
		return brincode;
	}

	public void setBrincode(Brin brincode) {
		this.brincode = brincode;
	}

	public String getWikiPassword() {
		return wikiPassword;
	}

	public void setWikiPassword(String wikiPassword) {
		this.wikiPassword = wikiPassword;
	}
}
