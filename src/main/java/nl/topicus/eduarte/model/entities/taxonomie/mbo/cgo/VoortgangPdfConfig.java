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
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Table;

import nl.topicus.eduarte.model.entities.begineinddatum.BeginEinddatumInstellingEntiteit;

@Entity
@Table(appliesTo = "VoortgangPdfConfig")
public class VoortgangPdfConfig extends BeginEinddatumInstellingEntiteit implements
IRapportageTemplateIJkpuntenProvider
{
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private GraphType graphType;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CategoryProperty categoryProperty;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CategoryAggregation categoryAggregation;

	@Column(nullable = false)
	private boolean includeEvcEvk;

	@Column(nullable = false)
	private boolean includeInvidueleIJkpunten;

	@Column(nullable = false)
	private int aantalBeoordelingen;

	@OneToMany(mappedBy = "configPdf", cascade = jakarta.persistence.CascadeType.REMOVE)
	@Cascade( {CascadeType.REMOVE})
	private List<RapportageTemplateIJkpunt> ijkpunten = new ArrayList<>();

	@Override
	public List<RapportageTemplateIJkpunt> getIjkpunten()
	{
		return ijkpunten;
	}

	public void setIjkpunten(List<RapportageTemplateIJkpunt> ijkpunten)
	{
		this.ijkpunten = ijkpunten;
	}

	public VoortgangPdfConfig()
	{

	}

	public GraphType getGraphType()
	{
		return graphType;
	}

	public void setGraphType(GraphType graphType)
	{
		this.graphType = graphType;
	}

	public CategoryProperty getCategoryProperty()
	{
		return categoryProperty;
	}

	public void setCategoryProperty(CategoryProperty categoryProperty)
	{
		this.categoryProperty = categoryProperty;
	}

	public boolean isIncludeEvcEvk()
	{
		return includeEvcEvk;
	}

	public void setIncludeEvcEvk(boolean includeEvcEvk)
	{
		this.includeEvcEvk = includeEvcEvk;
	}

	public boolean isIncludeInvidueleIJkpunten()
	{
		return includeInvidueleIJkpunten;
	}

	public void setIncludeInvidueleIJkpunten(boolean includeInvidueleIJkpunten)
	{
		this.includeInvidueleIJkpunten = includeInvidueleIJkpunten;
	}

	public int getAantalBeoordelingen()
	{
		return aantalBeoordelingen;
	}

	public void setAantalBeoordelingen(int aantalBeoordelingen)
	{
		this.aantalBeoordelingen = aantalBeoordelingen;
	}

	public CategoryAggregation getCategoryAggregation()
	{
		return categoryAggregation;
	}

	public void setCategoryAggregation(CategoryAggregation categoryAggregation)
	{
		this.categoryAggregation = categoryAggregation;
	}
}
