/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/

package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * slf4j-osgi implementation of org.slf4j.impl.StaticLoggerBinder.
 *
 * @author $Id$
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

	private static final StaticLoggerBinder SINGLETON;
	/**
	 * Declare the version of the SLF4J API this implementation is compiled
	 * against. The value of this field is modified with each major release.
	 */
	public static final String REQUESTED_API_VERSION;

	static {
		SINGLETON = new StaticLoggerBinder();
		REQUESTED_API_VERSION = "1.7.0";
	}

	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	private StaticLoggerBinder() {}

	@Override
	public ILoggerFactory getLoggerFactory() {
		return SLF4JLoggerFactory.getSLF4JLoggerFactory();
	}

	@Override
	public String getLoggerFactoryClassStr() {
		return getLoggerFactory().getClass()
			.getName();
	}
}
