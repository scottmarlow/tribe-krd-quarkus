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
package nl.topicus.eduarte.model.entities.begineinddatum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import nl.topicus.eduarte.model.entities.organisatie.LandelijkOfInstellingEntiteit;

/**
 * Basisentiteit voor alle nullable instellingsentiteiten die een begin- en einddatum
 * hebben. Begindatum is not-nullable en einddatum is nullable.
 * 
 */
@MappedSuperclass()
public abstract class BeginEinddatumLandelijkOfInstellingEntiteit extends
		LandelijkOfInstellingEntiteit implements IBeginEinddatumEntiteit
{
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date begindatum;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date einddatum;

	/**
	 * Dit property wordt automatisch bijgehouden bij het setten van de echte einddatum,
	 * en wordt gebruikt bij zoekacties. Het is namelijk veel sneller om te zoeken op een
	 * not null datum dan op een mogelijke null-waarde.
	 */
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date einddatumNotNull = MAX_DATE;

	public Date getBegindatum() {
		return begindatum;
	}

	public void setBegindatum(Date begindatum) {
		this.begindatum = begindatum;
	}

	public Date getEinddatum() {
		return einddatum;
	}

	public void setEinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}

	public Date getEinddatumNotNull() {
		return einddatumNotNull;
	}

	public void setEinddatumNotNull(Date einddatumNotNull) {
		this.einddatumNotNull = einddatumNotNull;
	}
}
