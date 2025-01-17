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
package nl.topicus.eduarte.model.entities.dbs.bijlagen;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ForeignKey;

import nl.topicus.eduarte.model.entities.bijlage.IBijlageKoppelEntiteit;
import nl.topicus.eduarte.model.entities.dbs.trajecten.Traject;
import nl.topicus.eduarte.model.entities.personen.DeelnemerBijlage;

@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class TrajectBijlage extends DeelnemerBijlage
{
	@ManyToOne(fetch = FetchType.LAZY)
	@Basic(optional = false)
	@JoinColumn(nullable = true, name = "traject")
	@ForeignKey(name = "FK_TestBijlage_traject")
	private Traject traject;

	public TrajectBijlage()
	{
	}

	public Traject getTraject()
	{
		return traject;
	}

	public void setTraject(Traject traject)
	{
		this.traject = traject;
	}

	@Override
	public IBijlageKoppelEntiteit<TrajectBijlage> getEntiteit()
	{
		return getTraject();
	}
}
