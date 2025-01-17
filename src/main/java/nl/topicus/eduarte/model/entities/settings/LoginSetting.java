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
package nl.topicus.eduarte.model.entities.settings;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Houd per organisatie bij of en hoevaak een gebruiker foutief kan inloggen
 * voordat zijn account geblokkerd word.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class LoginSetting extends OrganisatieSetting<LoginConfiguration> {
	@Embedded
	private LoginConfiguration value;

	public LoginSetting() {
		value = new LoginConfiguration();
	}

	@Override
	public String getOmschrijving() {
		return "Maximum aantal keren foutief inloggen";
	}

	@Override
	public LoginConfiguration getValue() {
		return value;
	}

	@Override
	public void setValue(LoginConfiguration value) {
		this.value = value;
	}
}
