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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;
import nl.topicus.eduarte.model.entities.personen.Persoon;

/**
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class EigenaarTemplate extends InstellingEntiteit
{
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BegeleidingsHandelingTemplateRol rol;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon", nullable = true, foreignKey = @ForeignKey(name = "FK_EigeTempl_persoon"))
	private Persoon persoon;

	public EigenaarTemplate()
	{
	}

	public BegeleidingsHandelingTemplateRol getRol()
	{
		return rol;
	}

	public void setRol(BegeleidingsHandelingTemplateRol rol)
	{
		this.rol = rol;
	}

	public Persoon getPersoon()
	{
		return persoon;
	}

	public void setPersoon(Persoon persoon)
	{
		this.persoon = persoon;
	}
}
