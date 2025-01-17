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
package nl.topicus.eduarte.model.entities.onderwijsproduct;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;

/**
 * Samenstelling van onderwijsproducten, dwz dat het parent onderwijsproduct het child
 * onderwijsproduct bevat.
 * 
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@javax.persistence.Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"parent", "child"})})
public class OnderwijsproductSamenstelling extends InstellingEntiteit
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "parent")
	private Onderwijsproduct parent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "child")
	private Onderwijsproduct child;

	public OnderwijsproductSamenstelling()
	{
	}

	public OnderwijsproductSamenstelling(Onderwijsproduct parent, Onderwijsproduct child)
	{
		setParent(parent);
		setChild(child);
	}

	public Onderwijsproduct getParent()
	{
		return parent;
	}

	public void setParent(Onderwijsproduct parent)
	{
		this.parent = parent;
	}

	public Onderwijsproduct getChild()
	{
		return child;
	}

	public void setChild(Onderwijsproduct child)
	{
		this.child = child;
	}

}
