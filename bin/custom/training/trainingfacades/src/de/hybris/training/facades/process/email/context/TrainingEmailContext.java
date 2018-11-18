/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;
import de.hybris.platform.commerceservices.model.process.TrainingProcessModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;


/**
 * Velocity context for a customer email.
 */
public class TrainingEmailContext extends AbstractEmailContext<TrainingProcessModel>
{
	private Converter<UserModel, CustomerData> customerConverter;
	private CustomerData customerData;

	private String customerName;
	@Override
	public void init(final TrainingProcessModel trainingProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(trainingProcessModel, emailPageModel);
		customerData = getCustomerConverter().convert(getCustomer(trainingProcessModel));
		customerName = customerData.getFirstName();
	}

	@Override
	protected BaseSiteModel getSite(final TrainingProcessModel trainingProcessModel)
	{
		return trainingProcessModel.getSite();
	}

	@Override
	protected CustomerModel getCustomer(final TrainingProcessModel trainingProcessModel)
	{
		return trainingProcessModel.getCustomer();
	}

	protected Converter<UserModel, CustomerData> getCustomerConverter()
	{
		return customerConverter;
	}

	@Required
	public void setCustomerConverter(final Converter<UserModel, CustomerData> customerConverter)
	{
		this.customerConverter = customerConverter;
	}

	public CustomerData getCustomer()
	{
		return customerData;
	}

	@Override
	protected LanguageModel getEmailLanguage(final TrainingProcessModel trainingProcessModel)
	{
		return trainingProcessModel.getLanguage();
	}

	public CustomerData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
