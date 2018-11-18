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
package de.hybris.training.storefront.controllers.cms;

import jjgpp.hybris.core.model.PromotionProductsComponentModel;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.training.facades.suggestion.SimpleSuggestionFacade;
import de.hybris.training.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**createforhtahtraining
 * Controller for CMS CartSuggestionComponent
 */
@Controller("PromotionProductsComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PromotionProductsComponent)
public class PromotionProductsComponentController extends AbstractAcceleratorCMSComponentController<PromotionProductsComponentModel>
{
	@Resource(name = "cartFacade")
	private CartFacade cartFacade;

	@Resource(name = "simpleSuggestionFacade")
	private SimpleSuggestionFacade simpleSuggestionFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PromotionProductsComponentModel component)
	{
		model.addAttribute("productName",null==component.getProduct()?null:component.getProduct().getName());
	}

//	@Override
//	protected String getView(final PromotionProductsComponentModel component)
//	{
//		return ControllerConstants.Views.Cms.ComponentPrefix + StringUtils.lowerCase(SimpleSuggestionComponentModel._TYPECODE);
//	}
}
