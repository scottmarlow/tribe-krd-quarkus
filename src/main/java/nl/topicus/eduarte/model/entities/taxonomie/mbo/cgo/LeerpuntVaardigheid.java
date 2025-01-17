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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.LandelijkEntiteit;

/**
 * Koppeltabel tussen leerpunt en vaardigheid.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Landelijk")
public class LeerpuntVaardigheid extends LandelijkEntiteit {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "leerpunt")
	private Leerpunt leerpunt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "vaardigheid")
	private Vaardigheid vaardigheid;

	public Leerpunt getLeerpunt() {
		return leerpunt;
	}

	public void setLeerpunt(Leerpunt leerpunt) {
		this.leerpunt = leerpunt;
	}

	public Vaardigheid getVaardigheid() {
		return vaardigheid;
	}

	public void setVaardigheid(Vaardigheid vaardigheid) {
		this.vaardigheid = vaardigheid;
	}
}
