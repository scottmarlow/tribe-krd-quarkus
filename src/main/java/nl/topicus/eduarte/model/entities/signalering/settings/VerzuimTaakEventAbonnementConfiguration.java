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
package nl.topicus.eduarte.model.entities.signalering.settings;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.participatie.VerzuimTaakSignaalDefinitieEnEventConfiguratieKoppel;

@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@DiscriminatorValue("VerzuimTaakEventAboConf")
public class VerzuimTaakEventAbonnementConfiguration
extends AbstractEventAbonnementConfiguration<List<VerzuimTaakSignaalDefinitieEnEventConfiguratieKoppel>> {
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abonnementConfiguration")
	private List<VerzuimTaakSignaalDefinitieEnEventConfiguratieKoppel> value = new ArrayList<>();

	public List<VerzuimTaakSignaalDefinitieEnEventConfiguratieKoppel> getValue() {
		return value;
	}

	public void setValue(List<VerzuimTaakSignaalDefinitieEnEventConfiguratieKoppel> value) {
		this.value = value;
	}
}
