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
package nl.topicus.eduarte.model.entities.bpv;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import nl.topicus.eduarte.model.entities.opleiding.Opleiding;
import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;


@Entity
public class BPVPlaatsOpleiding extends InstellingEntiteit
{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opleiding", nullable = false)
	private Opleiding opleiding;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bpvPlaats", nullable = false)
	private BPVPlaats bpvPlaats;

	public BPVPlaatsOpleiding()
	{

	}

	public BPVPlaatsOpleiding(BPVPlaats bpvPlaats)
	{
		setBpvPlaats(bpvPlaats);
	}

	public void setOpleiding(Opleiding opleiding)
	{
		this.opleiding = opleiding;
	}

	public Opleiding getOpleiding()
	{
		return opleiding;
	}

	public void setBpvPlaats(BPVPlaats bpvPlaats)
	{
		this.bpvPlaats = bpvPlaats;
	}

	public BPVPlaats getBpvPlaats()
	{
		return bpvPlaats;
	}

	@Override
	public String toString()
	{
		return getOpleiding().toString();
	}

}